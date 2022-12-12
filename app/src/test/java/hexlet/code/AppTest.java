package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class AppTest {
    @Test
    public void testApp() throws IOException {
        String diff = "{\n"
                + "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n"
                + "}";

        String path1 = "src/test/resources/1.txt";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/test/resources/2.txt";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();

        String diff2 = Differ.generate(absolutePath1, absolutePath2);
        System.out.println(diff2);
        assertEquals(diff, diff2);
    }
}
