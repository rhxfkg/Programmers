package level2.deliverybox;

import static level2.deliverybox.Input.getInput;

public class DeliveryBox {
    public static void main(String[] args) {
        int[] order = getInput();
        System.out.println(Solution.solution(order));
    }
}
