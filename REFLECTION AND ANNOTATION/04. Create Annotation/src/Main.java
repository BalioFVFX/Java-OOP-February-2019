import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = TestClass.class.getAnnotations();

        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].annotationType().getSimpleName());
            Arrays.stream(annotations[i].annotationType().getDeclaredMethods()).forEach(field -> System.out.println(field.getName()));
        }

        System.out.println(TestClass.class.getAnnotation(Subject.class).categories()[0]);
        System.out.println(TestClass.class.getAnnotation(Subject.class).categories()[1]);
    }
}
