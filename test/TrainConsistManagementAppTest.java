import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal")
        );

        boolean isSafe = bogies.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(isSafe); //
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );

        boolean isSafe = bogies.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertFalse(isSafe); //
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> emptyList = new ArrayList<>();
        boolean isSafe = emptyList.stream().allMatch(b -> true);

        assertTrue(isSafe); //
    }
}