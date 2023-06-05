package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public class Plain {
    public static String format(List<Map<String, Object>> diff) {
        StringBuilder build = new StringBuilder();
        for (Map<String, Object> x : diff) {
            String str = (String) x.get("type");
            switch (str) {
                case ("deleted") ->
                        build.append("Property '").append(x.get("key")).append("' was removed").append("\n");
                case ("added") -> build.append("Property '").append(x.get("key")).append("' was added with value: ")
                        .append(check(x.get("value2"))).append("\n");
                case ("changed") -> build.append("Property '").append(x.get("key")).append("' was updated. From ")
                        .append(check(x.get("value1"))).append(" to ")
                        .append(check(x.get("value2"))).append("\n");
                default -> build.append("");
            }
        }
        return build.toString().trim();
    }
    public static String check(Object obj) {
        if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        } else if (obj == null) {
            return null;
        } else if (obj instanceof String) {
            return "'" + obj + "'";
        } else {
            return obj.toString();
        }
    }
}
