package level2.biggest_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String solution(int[] numbers) {
        //x+y <-> y+x 비교 후 더 큰 값을 기준으로 정렬
        String answer = "";
        List<String> numbersStr = new ArrayList<>();

        for (int number : numbers) {
            numbersStr.add(Integer.toString(number));
        }
        for (int i = 0; i < numbersStr.size(); i++) {
            for (int j = i + 1; j < numbersStr.size(); j++) {
                String x = numbersStr.get(i);
                String y = numbersStr.get(j);
                if ((x + y).compareTo(y + x) < 0) {
                    numbersStr.set(i, y);
                    numbersStr.set(j, x);
                }
            }
        }
        for (String s : numbersStr) {
            answer += s;
        }

        return answer;
    }
}
