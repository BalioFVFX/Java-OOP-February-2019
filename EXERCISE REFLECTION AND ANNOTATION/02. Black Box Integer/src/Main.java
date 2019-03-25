import com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		Constructor<?> constructor = BlackBoxInt.class.getDeclaredConstructors()[0];
		constructor.setAccessible(true);
		BlackBoxInt blackBoxInt = (BlackBoxInt)constructor.newInstance(0);

		String input = bufferedReader.readLine();


		while (!input.equals("END")){
			String[] lines = input.split("_");
			String command  = lines[0];
			int value = Integer.parseInt(lines[1]);

			runCommand(command, value, blackBoxInt);
			printValueOfBlackBox(blackBoxInt);

			input = bufferedReader.readLine();
		}

	}



	private static void runCommand(String command, int value, BlackBoxInt blackBoxInt) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = blackBoxInt.getClass().getDeclaredMethod(command, int.class);
		method.setAccessible(true);
		method.invoke(blackBoxInt, value);
	}




	private static void printValueOfBlackBox(BlackBoxInt blackBoxInt) throws NoSuchFieldException, IllegalAccessException {
		Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
		field.setAccessible(true);
		Integer val = field.getInt(blackBoxInt);
		System.out.println(val);
	}
}
