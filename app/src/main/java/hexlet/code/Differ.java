package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Set;

public class Differ {
    static String generate(String f1, String f2, String format) throws IOException {
        Map<String, String> file1 = Parser.getMap(f1);
        Map<String, String> file2 = Parser.getMap(f2);
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
}

