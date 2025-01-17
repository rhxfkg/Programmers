package level2.truck_crossing_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> bridge = new LinkedList<>();

        //7,4,5,6
        //7 -> 2초
        //4,5 -> 2초+1초 = 3초
        //6 -> 2초
        //2+3+2+1 = 8

        //10
        //100초 + 1초

        //10,10,10,10,10,10,10,10,10,10
        //100초 + 9초 + 1초 = 110초

        //먼저 큐에 bridge_length 이하까지 담은 것을 하나로 취급하고 length만큼 시간을 추가함
        //구성 요소 - 1만큼 시간 초를 추가하고 기본 1초를 추가함
        for (int i = 0; i < truck_weights.length; i++) {
            if (bridge.isEmpty()) {
                bridge.offer(truck_weights[i]);
            } else if (weightsOnBridge(bridge) + truck_weights[i] <= weight) {
                bridge.offer(truck_weights[i]);
            } else {
                answer += bridge_length + bridge.size() - 1;
                bridge.clear();
                bridge.offer(truck_weights[i]);
            }
        }
        answer += bridge_length + bridge.size() - 1;

        return answer;
    }

    private static int weightsOnBridge(Queue<Integer> bridge) {
        int sum = 0;
        for (Integer i : bridge) {
            sum += i;
        }

        return sum;
    }
}
