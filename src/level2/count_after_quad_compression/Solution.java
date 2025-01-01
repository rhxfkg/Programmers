package level2.count_after_quad_compression;

public class Solution {
    static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[] {0, 0};

        quad(arr, 0, 0, arr.length);

        return answer;
    }

    private static void quad(int[][] arr, int x, int y, int size) {
        if (canCompress(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
        } else {
            quad(arr, x, y, size / 2);
            quad(arr, x, y + size / 2, size / 2);
            quad(arr, x + size / 2, y, size / 2);
            quad(arr, x + size / 2, y + size / 2, size / 2);
        }
    }

    private static boolean canCompress(int[][] arr, int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
