import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UC11: Validate Train ID and Cargo Codes (Regex)
 * Description: Uses Regular Expressions to enforce strict format rules.
 */
public class TrainConsistManagementApp {

        public static void main(String[] args) {
                System.out.println("==========================================");
                System.out.println(" UC11 - Validate Train ID and Cargo Code ");
                System.out.println("==========================================\n");

                Scanner scanner = new Scanner(System.in);

                // 1. Accept user input
                System.out.print("Enter Train ID (Format: TRN-1234): ");
                String trainId = scanner.nextLine();

                System.out.print("Enter Cargo Code (Format: PET-AB): ");
                String cargoCode = scanner.nextLine();

                // 2. DEFINE REGEX RULES
                // TRN- followed by exactly 4 digits
                String trainIdRegex = "TRN-\\d{4}";
                // PET- followed by exactly 2 uppercase letters
                String cargoCodeRegex = "PET-[A-Z]{2}";

                // 3. APPLY VALIDATION
                boolean isTrainIdValid = validateInput(trainId, trainIdRegex);
                boolean isCargoCodeValid = validateInput(cargoCode, cargoCodeRegex);

                // 4. DISPLAY RESULTS
                System.out.println("\nValidation Results:");
                System.out.println("Train ID Valid: " + isTrainIdValid);
                System.out.println("Cargo Code Valid: " + isCargoCodeValid);

                System.out.println("\nUC11 validation completed...");
                scanner.close();
        }

        /**
         * Utility method to compile pattern and match input
         */
        public static boolean validateInput(String input, String regex) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                return matcher.matches();
        }
}