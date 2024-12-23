package level2.biggest_number;

import java.util.Scanner;

public class Input {
    //numbers <= 100000 -> 전부 다해보면 시간 초과 날듯
    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        return numbers;
    }
}
