import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIterator iterator = new FileIterator("src/test.txt");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(iterator.next());
    }
}
