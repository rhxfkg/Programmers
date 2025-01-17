package level2.truck_crossing_bridge;

import java.util.Scanner;

public class Input {
    public static int getBridgeLength() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getWeight() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] getTruckWeights() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] truck_weights = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            truck_weights[i] = Integer.parseInt(input[i]);
        }

        return truck_weights;
    }
}
