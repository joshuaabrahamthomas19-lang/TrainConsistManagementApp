import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> bogieList;

    @BeforeEach
    void setUp() {
        bogieList = new ArrayList<>();
        bogieList.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogieList.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogieList.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogieList.add(new TrainConsistManagementApp.Bogie("General", 90));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result = bogieList.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        // Sleeper (72) and General (90) should be present
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Checking threshold exactly at 72
        List<TrainConsistManagementApp.Bogie> result = bogieList.stream()
                .filter(b -> b.capacity > 72)
                .collect(Collectors.toList());

        // Only General (90) is > 72. Sleeper (72) is excluded.
        assertEquals(1, result.size());
        assertEquals("General", result.get(0).name);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result = bogieList.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty(), "List should be empty for impossible threshold");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        int initialSize = bogieList.size();

        bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(initialSize, bogieList.size(), "Stream should not modify the original list");
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> emptyList = new ArrayList<>();
        List<TrainConsistManagementApp.Bogie> result = emptyList.stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }
}