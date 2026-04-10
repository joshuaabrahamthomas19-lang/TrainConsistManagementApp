import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(128, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> emptyList = new ArrayList<>();
        int total = emptyList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));

        bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(1, bogies.size());
    }
}