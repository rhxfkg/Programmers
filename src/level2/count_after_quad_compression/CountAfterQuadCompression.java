package level2.count_after_quad_compression;

import java.util.Arrays;

public class CountAfterQuadCompression {
    public static void main(String[] args) {
        int[][] arr = Input.getInput();
        System.out.println(Arrays.toString(Solution.solution(arr)));
    }
}
