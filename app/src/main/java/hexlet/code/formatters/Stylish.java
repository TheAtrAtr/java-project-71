package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Stylish {
    public static String format(Map<String, Map<String, String>> resultMapValue) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(resultMapValue.keySet());
        StringBuilder builder = new StringBuilder("{\n");
        for (var key : keys) {
            for (var e : resultMapValue.get(key).entrySet()) {
                builder.append("  ").append(e.getKey()).append(" ").append(key).append(e.getValue()).append("\n");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
