package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

    private static String getString(String path) throws IOException {
        Path p = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(p).trim();
    }

    @Test
    public void testJsonToStylish() throws IOException {
        String diff = getString("./src/test/resources/trueAnswer/JsonToStylish.txt");
        String path1 = "src/test/resources/1.json";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.json";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2, "stylish");
        assertEquals(diff, diff2);
    }

    @Test
    public void testJsonToPlain() throws IOException {
        String diff = getString("./src/test/resources/trueAnswer/JsonToPlain.txt");
        String path1 = "src/test/resources/1.json";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.json";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2, "plain");
        assertEquals(diff, diff2);
    }

    @Test
    public void testJsonToJson() throws IOException {
        String diff = getString("./src/test/resources/trueAnswer/JsonToJson.txt");
        String path1 = "src/test/resources/1.json";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.json";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2, "json");
        assertEquals(diff, diff2);
    }

    @Test
    public void testYmlToSylish() throws Exception {
        String diff = getString("./src/test/resources/trueAnswer/YmlToStylish.txt");
        String path1 = "src/test/resources/1.yml";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.yml";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2);
        assertEquals(diff, diff2);
    }

    @Test
    public void testYmlToPlain() throws IOException {
        String diff = getString("./src/test/resources/trueAnswer/YmlToPlain.txt");
        String path1 = "src/test/resources/1.yml";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.yml";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2, "plain");
        assertEquals(diff, diff2);
    }

    @Test
    public void testYmlToJson() throws IOException {
        String diff = getString("./src/test/resources/trueAnswer/YmlToJson.txt");
        String path1 = "src/test/resources/1.yml";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.yml";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String diff2 = Differ.generate(absolutePath1, absolutePath2, "json");
        assertEquals(diff, diff2);
    }
}
