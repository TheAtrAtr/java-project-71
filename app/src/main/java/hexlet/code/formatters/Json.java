package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {
    private static final String UPDATED = "updated";
    private static final String REMOVED = "removed";
    private static final String ADDED = "added";
    private static final String UNCHANGED = "sameValuesInBothFiles";

    public static String format(Map<String, Map<String, String>> resultMapValue) throws JsonProcessingException {
        Set<String> keys = new TreeSet<>();
        Map<String, String> commonMap = new TreeMap<>();
        keys.addAll(resultMapValue.keySet());
        keys.addAll(resultMapValue.keySet());
        ObjectMapper objectMapper = new ObjectMapper();
        for (var key : keys) {
            for (var e : resultMapValue.get(key).entrySet()) {
                if (e.getKey().equals(" ")) {
                    commonMap.put(key, UNCHANGED);
                    break;
                } else if (e.getKey().equals("+")) {
                    commonMap.put(key, ADDED);
                    break;
                } else {
                    if (resultMapValue.get(key).size() > 1) {
                        commonMap.put(key, UPDATED);
                    } else if (resultMapValue.get(key).size() == 1) {
                        commonMap.put(key, REMOVED);
                    }
                    break;
                }
            }
        }
        return objectMapper.writeValueAsString(commonMap);
    }
}
