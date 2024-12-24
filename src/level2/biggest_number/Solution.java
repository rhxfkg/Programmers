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
        //정렬 후 0밖에 없는 경우 추가해서 해결
        if (numbersStr.get(0).equals("0")) {
            return "0";
        }
        for (String s : numbersStr) {
            answer += s;
        }

        return answer;
    }
}
