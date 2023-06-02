package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(String f1, String f2, String format) throws IOException {
        String body1 = Files.readString(Path.of(f1));
        String body2 = Files.readString(Path.of(f2));
        Map<String, String> file1 = Parser.parse(f1, body1);
        Map<String, String> file2 = Parser.parse(f2, body2);
        Map<String, Map<String, String>> resultMapValue = new TreeMap<>();
        Map<String, String> commonMap = new HashMap<>();
        commonMap.putAll(file1);
        commonMap.putAll(file2);
        for (var enry : commonMap.entrySet()) {
            String key = enry.getKey();
            String value1 = file1.get(key);
            String value2 = file2.get(key);
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (value1.equals(value2)) {
                    Map<String, String> map = new LinkedHashMap<>();
                    map.put(" ", ": " + value1);
                    resultMapValue.put(key, map);
                } else {
                    Map<String, String> map = new LinkedHashMap<>();
                    map.put("-", ": " + value1);
                    map.put("+", ": " + value2);
                    resultMapValue.put(key, map);
                }
            } else if (file1.containsKey(key) && !file2.containsKey(key)) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("-", ": " + value1);
                resultMapValue.put(key, map);
            } else {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("+", ": " + value2);
                resultMapValue.put(key, map);
            }
        }
        return Formatter.format(resultMapValue, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}

