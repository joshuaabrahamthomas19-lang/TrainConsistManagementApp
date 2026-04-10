import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Verify keys exist
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));

        // Verify group sizes
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> emptyList = new ArrayList<>();
        Map<String, List<TrainConsistManagementApp.Bogie>> result = emptyList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        int initialSize = bogies.size();
        bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        assertEquals(initialSize, bogies.size(), "Original list should not be modified");
    }
}