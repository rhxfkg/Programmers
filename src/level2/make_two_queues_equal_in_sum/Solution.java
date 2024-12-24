package level2.make_two_queues_equal_in_sum;

public class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        //합이 같아질 수도 있고 없을 수도 있다. -> 다 해서 알아봐야 할끼? -> queue길이 300000이하 -> 시간초과 날 것 같음
        //합만 같으면 됨 길이가 같을 필요 없음
        //3 2 7 2 (기준) 4 6 5 1 -> 한 줄로 세우고 쪼갰을 때 앞 뒤의 합의 값이 같으면 될 듯 -> 횟수는 어떻게 카운트하지?
        //1 2 1 2 (기준) 1 10 1 2
        int[] mergeQueue = new int[queue1.length + queue2.length];
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            mergeQueue[i] = queue1[i];
            sum1 += queue1[i];
            mergeQueue[i + queue1.length] = queue2[i];
            sum2 += queue2[i];
        }
        long sum = sum1 + sum2;
        int start = 0, end = queue1.length;
        long subSum = sum1;
        int moveCount = 0;
        int length = mergeQueue.length;
        while (start < length && end < 2* length) {
            if (subSum == sum / 2) {
                return moveCount;
            } else if (subSum < sum / 2) {
                subSum += mergeQueue[end % length];
                end++;
            } else {
                subSum -= mergeQueue[start % length];
                start++;
            }
            moveCount++;
        }

        return -1;
    }
}
