package level2.count_after_quad_compression;

import java.util.Scanner;

public class Input {
    public static int[][] getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",");
        int length = (int) Math.sqrt(inputs.length);
        int arr[][] = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = Integer.parseInt(inputs[i * length + j]);
            }
        }

        return arr;
    }
}
