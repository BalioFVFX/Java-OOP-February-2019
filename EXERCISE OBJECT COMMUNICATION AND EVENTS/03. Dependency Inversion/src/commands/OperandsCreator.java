package commands;

import java.util.Arrays;

public class OperandsCreator {
    public static int[] createFrom(String input){
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
