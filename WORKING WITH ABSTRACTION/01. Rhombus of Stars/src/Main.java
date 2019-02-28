import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rowsCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < rowsCount - 1; i++) {
            System.out.print(createRow(rowsCount - 2 - i, " "));
            System.out.print(createRow(i + 1, " *"));
            System.out.println();
        }

        System.out.println(createRow(rowsCount, "* ").trim());

        for (int i = rowsCount - 1; i > 0; i--) {
            System.out.print(createRow((rowsCount - 1) - i, " "));
            System.out.println(createRow(i, " *"));
        }
    }

    private static String createRow(int count, String txt) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(txt);
        }

        return stringBuilder.toString();
    }
}
