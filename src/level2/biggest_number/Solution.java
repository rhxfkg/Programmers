package level2.biggest_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static String solution(int[] numbers) {
        //앞 자리 숫자 큰 순서대로 정렬해서 나열하면 될 듯
        String answer = "";
        List<String> listNumbers = new ArrayList<>();
        for (int number : numbers) {
            listNumbers.add(Integer.toString(number));
        }
        listNumbers.sort(Comparator.reverseOrder());
        //9 5 34 30 3 -> 9 5 34 3 30
        for (int i = 0; i < listNumbers.size() - 1; i++) {
            if ((listNumbers.get(i) + listNumbers.get(i + 1)).compareTo(listNumbers.get(i + 1) + listNumbers.get(i)) < 0) {
                String temp = listNumbers.get(i);
                listNumbers.set(i, listNumbers.get(i + 1));
                listNumbers.set(i + 1, temp);
            }
        }

        for (String listNumber : listNumbers) {
            answer += listNumber;
        }

        return answer;
    }
}
