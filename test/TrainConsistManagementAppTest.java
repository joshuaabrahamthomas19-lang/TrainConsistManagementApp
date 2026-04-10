import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.validateInput("TRN-1234", "TRN-\\d{4}"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Test wrong prefix, letters in digits, and wrong structure
        assertFalse(TrainConsistManagementApp.validateInput("TRAIN-1234", "TRN-\\d{4}"));
        assertFalse(TrainConsistManagementApp.validateInput("TRN-123A", "TRN-\\d{4}"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.validateInput("PET-AB", "PET-[A-Z]{2}"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Test lowercase and wrong number of letters
        assertFalse(TrainConsistManagementApp.validateInput("PET-ab", "PET-[A-Z]{2}"));
        assertFalse(TrainConsistManagementApp.validateInput("PET-ABC", "PET-[A-Z]{2}"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Exactly 4 digits required
        assertFalse(TrainConsistManagementApp.validateInput("TRN-123", "TRN-\\d{4}"));
        assertFalse(TrainConsistManagementApp.validateInput("TRN-12345", "TRN-\\d{4}"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.validateInput("", "TRN-\\d{4}"));
    }
}