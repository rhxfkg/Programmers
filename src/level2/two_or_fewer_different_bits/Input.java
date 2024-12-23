package level2.two_or_fewer_different_bits;

import java.util.Scanner;

public class Input {
    public static long[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",");
        long[] numbers = new long[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        return numbers;
    }
}
