package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Objects;

public class DiffBuilder {
    public static List<Map<String, Object>> diff(Map<String, Object> f1, Map<String, Object> f2, Set<String> keys) {
        List<Map<String, Object>> commonList = new ArrayList<>();
        for (String key : keys) {
            Map<String, Object> diff = new TreeMap<>();
            var valueA = f1.get(key);
            var valueB = f2.get(key);
            if (f1.containsKey(key) && !f2.containsKey(key)) {
                diff.put("key", key);
                diff.put("type", "deleted");
                diff.put("value1", valueA);
            } else if (!f1.containsKey(key) && f2.containsKey(key)) {
                diff.put("key", key);
                diff.put("type", "added");
                diff.put("value2", valueB);
            } else if (f1.containsKey(key) && f2.containsKey(key) && Objects.equals(valueA, valueB)) {
                diff.put("key", key);
                diff.put("type", "unchanged");
                diff.put("value1", valueA);
            } else if (f1.containsKey(key) && f2.containsKey(key) && !Objects.equals(valueA, valueB)) {
                diff.put("key", key);
                diff.put("type", "changed");
                diff.put("value1", valueA);
                diff.put("value2", valueB);
            }
            commonList.add(diff);
        }
        return commonList;
    }
}
