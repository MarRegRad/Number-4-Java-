import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface DeprecatedEx {
    String message();
}

@DeprecatedEx(message = "Используйте NewService вместо этого")
class OldService {
    @DeprecatedEx(message = "Замените на newProcess()")
    public void process() {}
}

class NewService {}

public class CustomAnnotationDeprecatedEx {
    public static void main(String[] args) {
        processAnnotations(OldService.class);
    }

    private static void processAnnotations(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.printf("Внимание: класс '%s' устарел. Альтернатива: '%s'\n",
                    clazz.getSimpleName(), annotation.message());
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("Внимание: метод '%s' устарел. Альтернатива: '%s'\n",
                        method.getName(), annotation.message());
            }
        }
    }
}