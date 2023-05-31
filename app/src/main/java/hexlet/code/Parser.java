package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    static Map<String, String> getMap(String path) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper yamlMapper = new YAMLMapper();
        Map<String, Object> x;
        Map<String, String> y = new HashMap<>();
        if (path.endsWith("json")) {
            x = jsonMapper.readValue(new File(path), new TypeReference<>() {
            });

        } else {
            x = yamlMapper.readValue(new File(path), new TypeReference<>() {
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
