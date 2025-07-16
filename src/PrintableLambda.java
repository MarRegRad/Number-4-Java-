@FunctionalInterface
interface Printable {
    void print();
}

public class PrintableLambda {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Hello from Printable!");
        printable.print();
    }
}