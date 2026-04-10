import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TrainConsistManagementApp {

        // Inner Bogie class (Reused from UC7)
        public static class Bogie {
                public String name;
                public int capacity;

                public Bogie(String name, int capacity) {
                        this.name = name;
                        this.capacity = capacity;
                }

                @Override
                public String toString() {
                        return name + " (Capacity: " + capacity + ")";
                }
        }

        public static void main(String[] args) {

                // Display welcome banner
                System.out.println("==========================================");
                System.out.println(" UC8 - Filter Passenger Bogies (Streams) ");
                System.out.println("==========================================\n");

                // 1. Setup Initial Bogie List
                List<Bogie> allBogies = new ArrayList<>();
                allBogies.add(new Bogie("Sleeper", 72));
                allBogies.add(new Bogie("AC Chair", 56));
                allBogies.add(new Bogie("First Class", 24));
                allBogies.add(new Bogie("General", 90));

                System.out.println("All Available Bogies:");
                allBogies.forEach(System.out::println);

                // 2. Stream Pipeline: Filter capacity > 60
                // stream() -> filter -> collect
                List<Bogie> highCapacityBogies = allBogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

                // 3. Display Results
                System.out.println("\nFiltered Bogies (Capacity > 60):");
                if (highCapacityBogies.isEmpty()) {
                        System.out.println("No bogies match the criteria.");
                } else {
                        highCapacityBogies.forEach(System.out::println);
                }

                System.out.println("\nOriginal List Size: " + allBogies.size() + " (Integrity Maintained)");
                System.out.println("UC8 filtering operations completed...");
        }
}