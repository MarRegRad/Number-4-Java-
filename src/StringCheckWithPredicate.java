import java.util.function.Predicate;

public class StringCheckWithPredicate {
    public static void main(String[] args) {
        Predicate<String> notNull = s -> s != null;
        Predicate<String> notEmpty = s -> !s.isEmpty();
        Predicate<String> validString = notNull.and(notEmpty);

        System.out.println(validString.test("Hello"));
        System.out.println(validString.test(""));
        System.out.println(validString.test(null));
    }
}