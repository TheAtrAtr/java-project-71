package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Objects;

public class Differ {
    public static String generate(String f1, String f2, String format) throws IOException {
        String body1 = Files.readString(Path.of(f1));
        String body2 = Files.readString(Path.of(f2));
        Map<String, Object> file1 = Parser.parse(f1, body1);
        Map<String, Object> file2 = Parser.parse(f2, body2);
        Map<String, Map<String, String>> resultMapValue = new TreeMap<>();
        List<Map<String, Object>> commonList = new ArrayList<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        for (String key : keys) {
            Map<String, Object> diff = new TreeMap<>();
            var valueA = file1.get(key);
            var valueB = file2.get(key);

            if (file1.containsKey(key) && !file2.containsKey(key)) {
                diff.put("key", key);
                diff.put("type", "deleted");
                diff.put("value1", valueA);
            } else if (!file1.containsKey(key) && file2.containsKey(key)) {
                diff.put("key", key);
                diff.put("type", "added");
                diff.put("value2", valueB);
            } else if (file1.containsKey(key) && file2.containsKey(key) && Objects.equals(valueA, valueB)) {
                diff.put("key", key);
                diff.put("type", "unchanged");
                diff.put("value1", valueA);
            } else if (file1.containsKey(key) && file2.containsKey(key) && !Objects.equals(valueA, valueB)) {
                diff.put("key", key);
                diff.put("type", "changed");
                diff.put("value1", valueA);
                diff.put("value2", valueB);
            }
            commonList.add(diff);
        }
        System.out.println(commonList);
        return Formatter.format(commonList, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}

