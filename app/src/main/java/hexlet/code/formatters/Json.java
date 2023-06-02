package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.TreeSet;

public class Json {
//    private static final String UPDATED = "updated";
//    private static final String REMOVED = "removed";
//    private static final String ADDED = "added";
//    private static final String UNCHANGED = "sameValuesInBothFiles";

    public static String format(Map<String, Map<String, String>> resultMapValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, String> jsonMap = new TreeMap<>();
//        Set<String> keys = new TreeSet<>(resultMapValue.keySet());
//        for (var key : keys) {
//            for (var e : resultMapValue.get(key).entrySet()) {
//                if (e.getKey().equals(" ")) {
//                    jsonMap.put(key, UNCHANGED);
//                    break;
//                } else if (e.getKey().equals("+")) {
//                    jsonMap.put(key, ADDED);
//                    break;
//                } else {
//                    if (resultMapValue.get(key).size() > 1) {
//                        jsonMap.put(key, UPDATED);
//                    } else if (resultMapValue.get(key).size() == 1) {
//                        jsonMap.put(key, REMOVED);
//                    }
//                    break;
//                }
//            }
//        }
        return objectMapper.writeValueAsString(resultMapValue);
    }
}
