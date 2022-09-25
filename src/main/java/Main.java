import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            Finder.findViewPoints(new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])))), Integer.parseInt(args[1]));
        } catch (IOException ignored) {}
    }
}
