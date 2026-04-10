import java.util.*;

public class TrainConsistManagementApp {

        // Model for Goods Bogies as per UC12 requirements
        static class GoodsBogie {
                String type;
                String cargo;

                GoodsBogie(String type, String cargo) {
                        this.type = type;
                        this.cargo = cargo;
                }

                @Override
                public String toString() {
                        return type + " -> " + cargo;
                }
        }

        public static void main(String[] args) {
                System.out.println("==========================================");
                System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
                System.out.println("==========================================\n");

                // 1. Create a list of goods bogies
                List<GoodsBogie> goodsBogies = new ArrayList<>();
                goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
                goodsBogies.add(new GoodsBogie("Open", "Coal"));
                goodsBogies.add(new GoodsBogie("Box", "Grain"));
                goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // This violates the safety rule

                System.out.println("Goods Bogies in Train:");
                goodsBogies.forEach(System.out::println);

                // 2. APPLY SAFETY VALIDATION RULE
                // Rule: If type is "Cylindrical", cargo must be "Petroleum"
                boolean isSafe = goodsBogies.stream().allMatch(b -> {
                        if (b.type.equals("Cylindrical")) {
                                return b.cargo.equals("Petroleum");
                        }
                        return true; // Other types are considered safe regardless of cargo here
                });

                // 3. DISPLAY RESULTS
                System.out.println("\nSafety Compliance Status: " + isSafe);
                if (isSafe) {
                        System.out.println("Train formation is SAFE.");
                } else {
                        System.out.println("Train formation is NOT SAFE.");
                }

                System.out.println("\nUC12 safety validation completed...");
        }
}