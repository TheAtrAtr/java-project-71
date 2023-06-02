package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    static String format(Map<String, Map<String, String>> diff, String form) throws JsonProcessingException {
        switch (form) {
            case ("plain"):
                return Plain.format(diff);
            case ("json"):
                return Json.format(diff);
            case ("stylish"):
                return Stylish.format(diff);
            default:
                throw new RuntimeException("Формат " + form + " не поддерживается");
        }
    }

}
