package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    static Map<String, String> parse(String fileName, String body) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper yamlMapper = new YAMLMapper();
        Map<String, Object> x;
        Map<String, String> y = new HashMap<>();
        if (fileName.endsWith("json")) {
            x = jsonMapper.readValue(body, new TypeReference<>() {
            });

        } else {
            x = yamlMapper.readValue(body, new TypeReference<>() {
            });
        }
        for (var entry : x.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue() == null ? "null" : entry.getValue().toString();
            y.put(key, value);
        }
        return y;
    }
}
