
public class Main {
    public static void main(String[] args) {
        try (FileIterator iterator = new FileIterator("src/test.txt")) {
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println(iterator.next());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
