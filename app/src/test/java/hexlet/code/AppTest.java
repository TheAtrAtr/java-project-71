package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class AppTest {
    @Test
    public void testJsonToStylish() throws IOException {
        String diff = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

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
        String diff = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

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
        String diff = "{\"chars1\":{\" \":\": [a, b, c]\"},\"chars2\":{\"-\":\": [d, e, f]\",\"+\":\": false\"},"
                + "\"checked\":{\"-\":\": false\",\"+\":\": true\"},\"default\":{\"-\":\": null\",\"+\":\": "
                + "[value1, value2]\"},\"id\":{\"-\":\": 45\",\"+\":\": null\"},\"key1\":{\"-\":\": value1\"},"
                + "\"key2\":{\"+\":\": value2\"},\"numbers1\":{\" \":\": [1, 2, 3, 4]\"},\"numbers2\":{\"-\":\": "
                + "[2, 3, 4, 5]\",\"+\":\": [22, 33, 44, 55]\"},\"numbers3\":{\"-\":\": [3, 4, 5]\"},\"numbers4\":"
                + "{\"+\":\": [4, 5, 6]\"},\"obj1\":{\"+\":\": {nestedKey=value, isNested=true}\"},\"setting1\":"
                + "{\"-\":\": Some value\",\"+\":\": Another value\"},\"setting2\":{\"-\":\": 200\",\"+\":\": 300\"},"
                + "\"setting3\":{\"-\":\": true\",\"+\":\": none\"}}";

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
        String diff = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

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
        String diff = """
                Property 'follow' was removed
                Property 'proxy' was removed
                Property 'timeout' was updated. From 50 to 20
                Property 'verbose' was added with value: true""";

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
        String diff = "{\"follow\":{\"-\":\": false\"},\"host\":{\" \":\": hexlet.io\"},\"proxy\":{\"-\":\": "
                + "123.234.53.22\"},\"timeout\":{\"-\":\": 50\",\"+\":\": 20\"},\"verbose\":{\"+\":\": true\"}}";
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
