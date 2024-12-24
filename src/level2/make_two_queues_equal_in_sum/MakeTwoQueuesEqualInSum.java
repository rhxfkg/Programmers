package level2.make_two_queues_equal_in_sum;

public class MakeTwoQueuesEqualInSum {
    public static void main(String[] args) {
        int[] queue1 = Input.getInput();
        int[] queue2 = Input.getInput();
        System.out.println(Solution.solution(queue1, queue2));
    }
}
