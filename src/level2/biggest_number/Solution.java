package level2.biggest_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static String solution(int[] numbers) {
        //x+y <-> y+x 비교 후 더 큰 값을 기준으로 정렬
        String answer = "";
        List<String> numbersStr = new ArrayList<>();

        for (int number : numbers) {
            numbersStr.add(Integer.toString(number));
        }
        Collections.sort(numbersStr, (x, y) -> (y + x).compareTo(x + y));

        for (String s : numbersStr) {
            answer += s;
        }

        return answer;
    }
}
