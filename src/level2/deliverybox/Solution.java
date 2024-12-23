package level2.deliverybox;

import java.util.Deque;
import java.util.LinkedList;

//List의 remove함수 때문에 시간초과 걸렸다가 Deque로 바꾼 후 해결
public class Solution {
    public static int solution(int[] order) {
        //4 3 1 2 5 순으로 넣어야 함 -> 보조: 1,2,3 / 4번을 담고 3번을 보조에서 담고 -> 보조: 1,2 / 5 남음
        //order: 4 3 1 2 5
        //container: 1 2 3 4 5
        //auxContainer:
        //auxContainer의 마지막 값과 container의 처음 값 중에 현재 순서의 order값이 있는지 확인
        //있으면 answer++, 다음 순서 count++
        //없으면 container 처음 값 auxContainer로 추가 but container값이 없고 auxContainer의 마지막 값이 현재 order값이 아니라면 종료
        int answer = 0;
        int boxAmount = order.length;
        Deque<Integer> container = new LinkedList<>();
        Deque<Integer> auxContainer = new LinkedList<>();

        for (int i = 0; i < boxAmount; i++) {
            container.add(i + 1);
        }

        int count = 0;
        while (true) {
            if (!container.isEmpty() && container.getFirst() == order[count]) {
                answer++;
                count++;
                container.removeFirst();
            } else if (!auxContainer.isEmpty() && auxContainer.getLast() == order[count]) {
                answer++;
                count++;
                auxContainer.removeLast();
            } else {
                if (container.isEmpty() && (auxContainer.isEmpty() || auxContainer.getLast() != order[count])) {
                    return answer;
                } else {
                    auxContainer.add(container.getFirst());
                    container.removeFirst();
                }
            }
        }
    }
}
