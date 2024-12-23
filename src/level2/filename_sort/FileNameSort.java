package level2.filename_sort;

import java.util.Arrays;

public class FileNameSort {
    public static void main(String[] args) {
        String[] files = Input.getInput();
        System.out.println(Arrays.toString(Solution.solution(files)));
    }
}
