package app.mortage.handler;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DataManagerTest {

    @Test
    void testAddMortage() {
        String[] testData = {"Juha", "1000.2", "1.24", "2"};
        DataManager testManager = new DataManager();

        assertEquals(0, testManager.mapSize());
        testManager.addMortage(testData);
        assertEquals(1, testManager.mapSize());
    }

    @Test
    void testInitDataFetch() {
        DataManager testManager = new DataManager();
        Path path = Path.of(System.getProperty("user.dir") + "/src/test/java/app/mortage/handler/test_prospects.txt");
        testManager.initDataFetch(path);
        assertEquals(2, testManager.mapSize());
    }
}