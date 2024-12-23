package level2.deliverybox;

import java.util.Scanner;

public class Input {
    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        String[] tempOrder = temp.split(" ");
        int[] order = new int[tempOrder.length];
        for (int i = 0; i < tempOrder.length; i++) {
            order[i] = Integer.parseInt(tempOrder[i]);
        }

        return order;
    }
}
