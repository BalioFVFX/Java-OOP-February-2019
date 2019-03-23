import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Set<Method> getterMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setterMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));

        for (int i = 0; i < methods.length; i++) {
            if (isGetter(methods[i])) {
                getterMethods.add(methods[i]);
            } else if (isSetter(methods[i])) {
                setterMethods.add(methods[i]);
            }
        }

        fields.addAll(Arrays.stream(Reflection.class.getDeclaredFields()).collect(Collectors.toList()));

        System.out.println("Fields:");
        fields.stream().filter(field -> !Modifier.isPrivate(field.getModifiers())).forEach(field -> {
            System.out.printf("%s must be private!%n", field.getName());
        });
        System.out.println("Getters:");
        getterMethods.stream().filter(method -> !Modifier.isPublic(method.getModifiers())).forEach(method -> {
            System.out.printf("%s have to be public!%n", method.getName());
        });
        System.out.println("Setters:");
        setterMethods.stream().filter(method -> !Modifier.isPrivate(method.getModifiers())).forEach(method -> {
            System.out.printf("%s have to be private!%n", method.getName());
        });

    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterCount() == 0 && method.getReturnType() != void.class;
    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") && method.getParameterCount() == 1 && method.getReturnType() == void.class;
    }

}