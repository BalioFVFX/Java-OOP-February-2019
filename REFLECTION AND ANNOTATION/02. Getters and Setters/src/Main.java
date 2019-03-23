import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Set<Method> getterMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setterMethods = new TreeSet<>(Comparator.comparing(Method::getName));


        for (int i = 0; i < methods.length; i++) {
            if (isGetter(methods[i])) {
                getterMethods.add(methods[i]);
            } else if (isSetter(methods[i])) {
                setterMethods.add(methods[i]);
            }
        }

        System.out.println("Getters:");
        getterMethods.forEach(method -> System.out.printf("%s will return %s%n", method.getName(), method.getReturnType().getSimpleName()));
        System.out.println("Setters:");
        setterMethods.forEach(method -> System.out.printf("%s and will set field of %s%n", method.getName(), method.getParameters()[0].getType().getSimpleName()));
    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterCount() == 0 && method.getReturnType() != void.class;
    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") && method.getParameterCount() == 1 && method.getReturnType() == void.class;
    }

}
