package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Json {
    private static final String updated = "updated";
    private static final String removed = "removed";
    private static final String added = "added";
    private static final String unchanged = "sameValuesInBothFiles";

    public static String format(Map<String, Map<String, String>> resultMapValue) throws JsonProcessingException {
        Set<String> keys = new TreeSet<>();
        Map<String, String> commonMap = new TreeMap<>();
        keys.addAll(resultMapValue.keySet());
        keys.addAll(resultMapValue.keySet());
        ObjectMapper objectMapper = new ObjectMapper();
        for (var key : keys) {
            for (var e : resultMapValue.get(key).entrySet()) {
                if (e.getKey().equals(" ")) {
                    commonMap.put(key, unchanged);
                    break;
                } else if (e.getKey().equals("+")) {
                    commonMap.put(key, added);
                    break;
                } else {
                    if (resultMapValue.get(key).size() > 1) {
                        commonMap.put(key, updated);
                    } else if (resultMapValue.get(key).size() == 1) {
                        commonMap.put(key, removed);
                    }
                    break;
                }
            }
        }
        return objectMapper.writeValueAsString(commonMap);
    }
}
