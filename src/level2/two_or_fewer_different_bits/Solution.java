package level2.two_or_fewer_different_bits;

public class Solution {
    //시간초과 -> 짝수, 홀수에 따른 규칙 적용으로 해결
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else answer[i] = function(numbers[i]);
        }

        return answer;
    }

    //f(x) -> x보다 크고 x와 비트가 1~2개 다른 수들 중에서 가장 작은 수
    //홀수인 경우 가장 빨리 나오는 0을 1로 그 다음 자리를 1로 바꾸면 됨
    private static long function(long number) {
        StringBuilder changeResult = new StringBuilder(Long.toBinaryString(number));
        for (int i = changeResult.length() - 1; i >= 0; i--) {
            if (changeResult.charAt(i) == '0') {
                changeResult.setCharAt(i, '1');
                if (i == 0) {
                    changeResult.append('0');
                } else {
                    changeResult.setCharAt(i + 1, '0');
                }
                break;
            }
        }
        //이진수에 0이 존재하지 않은 경우
        if (Long.toBinaryString(number).contentEquals(changeResult)) {
            changeResult.setCharAt(0, '0');
            changeResult.insert(0, '1');
        }

        return Long.parseLong(changeResult.toString(), 2);
    }
}
