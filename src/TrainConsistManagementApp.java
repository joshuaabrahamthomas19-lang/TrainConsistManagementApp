import java.util.*;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 * Description: Organizes flat bogie data into a categorized Map structure.
 */
public class TrainConsistManagementApp {

        // Internal Bogie model
        static class Bogie {
                String name;
                int capacity;

                Bogie(String name, int capacity) {
                        this.name = name;
                        this.capacity = capacity;
                }

                @Override
                public String toString() {
                        return "Capacity -> " + capacity;
                }
        }

        public static void main(String[] args) {
                System.out.println("==========================================");
                System.out.println(" UC9 - Group Bogies by Type ");
                System.out.println("==========================================\n");

                // 1. Create list of bogies with duplicate types
                List<Bogie> bogies = new ArrayList<>();
                bogies.add(new Bogie("Sleeper", 72));
                bogies.add(new Bogie("AC Chair", 56));
                bogies.add(new Bogie("First Class", 24));
                bogies.add(new Bogie("Sleeper", 70));
                bogies.add(new Bogie("AC Chair", 60));

                // Display input
                System.out.println("All Bogies:");
                for (Bogie b : bogies) {
                        System.out.println(b.name + " -> " + b.capacity);
                }

                // 2. GROUPING LOGIC (The Core of UC9)
                Map<String, List<Bogie>> groupedBogies = bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

                // 3. Display grouped structure
                System.out.println("\nGrouped Bogies:");
                for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
                        System.out.println("\nBogie Type: " + entry.getKey());
                        for (Bogie b : entry.getValue()) {
                                System.out.println(b);
                        }
                }

                System.out.println("\nUC9 grouping completed...");
        }
}