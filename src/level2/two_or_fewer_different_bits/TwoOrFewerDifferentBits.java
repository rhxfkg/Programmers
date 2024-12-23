package level2.two_or_fewer_different_bits;

import java.util.Arrays;

public class TwoOrFewerDifferentBits {
    public static void main(String[] args) {
        long[] numbers = Input.getInput();
        System.out.println(Arrays.toString(Solution.solution(numbers)));
    }
}
