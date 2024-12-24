package level2.make_two_queues_equal_in_sum;

import java.util.Scanner;

public class Input {
    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",");
        int[] input = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            input[i] = Integer.parseInt(inputs[i]);
        }

        return input;
    }
}
