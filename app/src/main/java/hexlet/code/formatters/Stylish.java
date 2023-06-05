package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> resultMapValue) {
        StringBuilder build = new StringBuilder("{");
        for (Map<String, Object> x : resultMapValue) {
            build.append("\n").append("  ");
            String str = (String) x.get("type");
            switch (str) {
                case ("deleted") -> build.append("- ").append(x.get("key")).append(": ").append(x.get("value1"));
                case ("added") -> build.append("+ ").append(x.get("key")).append(": ").append(x.get("value2"));
                case ("unchanged") -> build.append("  ").append(x.get("key")).append(": ").append(x.get("value1"));
                case ("changed") -> {
                    build.append("- ").append(x.get("key")).append(": ").append(x.get("value1")).append("\n");
                    build.append("  ").append("+ ").append(x.get("key")).append(": ").append(x.get("value2"));
                }
                default -> throw new RuntimeException("");
            }
        }
        build.append("\n}");
        return build.toString();
    }
}
