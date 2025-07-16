import java.util.function.Function;

public class NumberClassifierFunction {
    public static void main(String[] args) {
        Function<Integer, String> classifier = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            return "Ноль";
        };

        System.out.println(classifier.apply(10));
        System.out.println(classifier.apply(-5));
        System.out.println(classifier.apply(0));
    }
}