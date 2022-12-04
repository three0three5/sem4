import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIterator implements Iterator, AutoCloseable {
    private BufferedReader reader;
    private String currentString;
    public FileIterator(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        currentString = reader.readLine();
    }
    @Override
    public boolean hasNext() {
        return currentString != null;
    }

    @Override
    public String next() {
        String nextString = currentString;
        if (currentString == null) {
            throw new NoSuchElementException();
        }
        try {
            currentString = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nextString;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
