package app;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase12TrainConsistMgmntTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistApp.GoodsBogie("Open", "Coal"));

        assertTrue(TrainConsistApp.isSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistApp.isSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.GoodsBogie("Open", "Coal"));
        list.add(new TrainConsistApp.GoodsBogie("Box", "Grain"));

        assertTrue(TrainConsistApp.isSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistApp.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistApp.isSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistApp.GoodsBogie> list = new ArrayList<>();
        assertTrue(TrainConsistApp.isSafe(list));
    }
}