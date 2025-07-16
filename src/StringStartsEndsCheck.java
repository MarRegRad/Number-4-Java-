import java.util.function.Predicate;

public class StringStartsEndsCheck {
    public static void main(String[] args) {
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");
        Predicate<String> combined = startsWithJorN.and(endsWithA);

        System.out.println(combined.test("Java"));
        System.out.println(combined.test("JavaA"));
        System.out.println(combined.test("NovaA"));
        System.out.println(combined.test("Python"));
    }
}