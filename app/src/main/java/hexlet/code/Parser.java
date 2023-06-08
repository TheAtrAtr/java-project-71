package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    static Map<String, Object> parse(String formatType, String content) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper yamlMapper = new YAMLMapper();
        Map<String, Object> x;
        switch (formatType) {
            case ("json"):
                x = jsonMapper.readValue(content, new TypeReference<>() {
                });
                break;
            case ("yml"):
                x = yamlMapper.readValue(content, new TypeReference<>() {
                });
                break;
            default:
                throw new RuntimeException("Formatfile is not support");
        }

        return x;
    }
}
