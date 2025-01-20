package level2.truck_crossing_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> bridge = new LinkedList<>();

        int[] count = new int[truck_weights.length];
        int start = 0;
        int index = 0;
        int sum = 0;
        while (true) {
            answer++;
            if (bridge.isEmpty()) {
                bridge.offer(truck_weights[index]);
                sum += truck_weights[index];
                count[index]++;
                index++;
            } else {
                if (index < truck_weights.length && sum + truck_weights[index] <= weight) {
                    bridge.offer(truck_weights[index]);
                    sum += truck_weights[index];
                    index++;
                    for (int i = start; i < index; i++) {
                        count[i]++;
                        if (count[i] == bridge_length) {
                            sum -= bridge.peek();
                            bridge.poll();
                            start++;
                        }
                    }
                } else {
                    for (int i = start; i < index; i++) {
                        count[i]++;
                        if (count[i] == bridge_length) {
                            sum -= bridge.peek();
                            bridge.poll();
                            start++;
                        }
                    }
                }
            }
            if (index == truck_weights.length && bridge.isEmpty()) break;
        }

        return answer;
    }
}
