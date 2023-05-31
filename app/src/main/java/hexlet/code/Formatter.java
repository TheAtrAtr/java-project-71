package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    static String format(Map<String, Map<String, String>> diff, String form) throws JsonProcessingException {
        if (form.equals("plain")) {
            return Plain.format(diff);
        } else if (form.equals("json")) {
            return Json.format(diff);
        } else {
            return Stylish.format(diff);
        }
    }

}
