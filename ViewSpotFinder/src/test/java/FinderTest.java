import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class FinderTest {

    String smallTestString = """
            [
              {element_id: 2, value: 110.0}
            ]""";

    String smallTestTwoViewSpotsString = """
            [
              {element_id: 2, value: 110.0},
              {element_id: 4, value: 20.0}
            ]""";

    String sameHeightString = """
            [
              {element_id: 0, value: 17.345}
            ]""";

    String attachmentString = """
            [
              {element_id: 153, value: 5.994129},
              {element_id: 141, value: 5.5967307},
              {element_id: 99, value: 3.7165792},
              {element_id: 87, value: 3.6258426},
              {element_id: 185, value: 2.0353928},
              {element_id: 33, value: 1.3083863},
              {element_id: 21, value: 1.214219},
              {element_id: 18, value: -0.23535144}
            ]""";

    @Test
    public void testSimple() throws IOException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshSmall.json"))));
        assertEquals(smallTestString, Finder.findViewPoints(j, 1));
    }

    @Test
    public void testSimpleTwoViewSpots() throws IOException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshSmallTwoViewSpots.json"))));
        assertEquals(smallTestTwoViewSpotsString, Finder.findViewPoints(j, 2));
    }

    @Test
    public void testSameHeight() throws IOException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshSameHeight.json"))));
        assertEquals(sameHeightString, Finder.findViewPoints(j, 5));
    }

    @Test
    public void testAttachment() throws IOException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshAttached.json"))));
        assertEquals(attachmentString, Finder.findViewPoints(j, 8));
    }

    @Test
    public void testExecutionTime10000() throws IOException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshAttached10000.json"))));
        assertTimeout(Duration.ofMillis(500), () -> Finder.findViewPoints(j, 1000));
    }

    @Test
    public void testExecutionTime20000() throws IOException, InterruptedException {
        JSONObject j = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/java/TestFiles/meshAttached20000.json"))));
        assertTimeout(Duration.ofMillis(1500), () -> Finder.findViewPoints(j, 1000));
    }


}
