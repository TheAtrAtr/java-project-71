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
        String diff = "[{\"key\":\"chars1\",\"type\":\"unchanged\",\"value1\":[\"a\",\"b\",\"c\"]},{\"key\":\"chars2"
                + "\",\"type\":\"changed\",\"value1\":[\"d\",\"e\",\"f\"],\"value2\":false},{\"key\":\"checked\",\"type"
                + "\":\"changed\",\"value1\":false,\"value2\":true},{\"key\":\"default\",\"type\":\"changed\",\"value1"
                + "\":null,\"value2\":[\"value1\",\"value2\"]},{\"key\":\"id\",\"type\":\"changed\",\"value1\":45,"
                + "\"value2\":null},{\"key\":\"key1\",\"type\":\"deleted\",\"value1\":\"value1\"},{\"key\":\"key2\","
                + "\"type\":\"added\",\"value2\":\"value2\"},{\"key\":\"numbers1\",\"type\":\"unchanged\",\"value1\""
                + ":[1,2,3,4]},{\"key\":\"numbers2\",\"type\":\"changed\",\"value1\":[2,3,4,5],\"value2\":[22,33,44,55]"
                + "},{\"key\":\"numbers3\",\"type\":\"deleted\",\"value1\":[3,4,5]},{\"key\":\"numbers4\",\"type\":\""
                + "added\",\"value2\":[4,5,6]},{\"key\":\"obj1\",\"type\":\"added\",\"value2\":{\"nestedKey\":\"value"
                + "\",\"isNested\":true}},{\"key\":\"setting1\",\"type\":\"changed\",\"value1\":\"Some value\",\"value2"
                + "\":\"Another value\"},{\"key\":\"setting2\",\"type\":\"changed\",\"value1\":200,\"value2\":300},{\""
                + "key\":\"setting3\",\"type\":\"changed\",\"value1\":true,\"value2\":\"none\"}]";

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
        String diff = "[{\"key\":\"follow\",\"type\":\"deleted\",\"value1\":false},{\"key\":\"host\",\"type\":"
                + "\"unchanged\",\"value1\":\"hexlet.io\"},{\"key\":\"proxy\",\"type\":\"deleted\",\"value1\":\""
                + "123.234.53.22\"},{\"key\":\"timeout\",\"type\":\"changed\",\"value1\":50,\"value2\":20},{\"key"
                + "\":\"verbose\",\"type\":\"added\",\"value2\":true}]";
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
