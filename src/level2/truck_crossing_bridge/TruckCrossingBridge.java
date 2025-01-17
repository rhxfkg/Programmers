package level2.truck_crossing_bridge;

public class TruckCrossingBridge {
    public static void main(String[] args) {
        int bridge_length = Input.getBridgeLength();
        int weight = Input.getWeight();
        int[] truck_weights = Input.getTruckWeights();

        System.out.println(Solution.solution(bridge_length, weight, truck_weights));
    }
}
