import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String command = bufferedReader.readLine();

        while (!command.equals("HARVEST")) {

            String output = generateOutputForCommand(command, RichSoilLand.class);

            System.out.println(output);

            command = bufferedReader.readLine();
        }

    }

    private static String generateOutputForCommand(String command, Class<?> cl) {
        switch (command) {
            case "private":
                return getPrivateFields(cl);
            case "protected":
                return getProtectedFields(cl);
            case "public":
                return getPublicFields(cl);
            case "all":
                return getAllFields(cl);
            default:
                return null;
        }
    }

    private static String getPrivateFields(Class<?> cl){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cl.getDeclaredFields()).filter(field -> Modifier.isPrivate(field.getModifiers())).forEach(field -> {
            stringBuilder.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append("\n");
        });
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }

    private static String getProtectedFields(Class<?> cl){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cl.getDeclaredFields()).filter(field -> Modifier.isProtected(field.getModifiers())).forEach(field -> {
            stringBuilder.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append("\n");
        });
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }

    private static String getPublicFields(Class<?> cl){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cl.getDeclaredFields()).filter(field -> Modifier.isPublic(field.getModifiers())).forEach(field -> {
            stringBuilder.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append("\n");
        });
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }

    private static String getAllFields(Class<?> cl){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cl.getDeclaredFields()).forEach(field -> {
            stringBuilder.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append("\n");
        });

        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }
}
