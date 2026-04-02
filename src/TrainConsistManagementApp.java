import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("==========================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("==========================================\n");

        // HashMap stores data in key -> value format
        // Key: Bogie Name (String), Value: Capacity (Integer)
        Map<String, Integer> capacityMap = new HashMap<>();

        // ---- Insert bogie capacities ----
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");

        // Iterating through the map to display keys and values
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}