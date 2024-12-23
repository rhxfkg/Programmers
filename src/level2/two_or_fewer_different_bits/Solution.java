package level2.two_or_fewer_different_bits;

public class Solution {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = function(numbers[i]);
        }

        return answer;
    }

    //f(x) -> x보다 크고 x와 비트가 1~2개 다른 수들 중에서 가장 작은 수
    //x보다 바로 큰 수부터 확인하는데 1~2개 다른다는 것은 xor연산 시 1의 개수 1~2개라는 것
    private static long function(long number) {
        for (long i = number + 1; ; i++) {
            String changeResult = Integer.toBinaryString((int) (number ^ i));
            if (compareAndCount(changeResult) <= 2) {
                return i;
            }
        }
    }

    private static long compareAndCount(String xorResult) {
        long count = 0;
        for (int i = 0; i < xorResult.length(); i++) {
            if (xorResult.charAt(i) == '1') count++;
        }

        return count;
    }
}
