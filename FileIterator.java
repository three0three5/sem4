import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIterator implements Iterator, AutoCloseable {
    private final BufferedReader reader;
    private final FileReader fr;
    private String currentString;
    public FileIterator(String fileName) {
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        reader = new BufferedReader(fr);
        try {
            currentString = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        fr.close();
    }
}
