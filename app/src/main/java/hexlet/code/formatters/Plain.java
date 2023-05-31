package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

public class Plain {
    private static final String updated = "' was updated. From ";
    private static final String removed = "' was removed";
    private static final String added = "' was added with value: ";
    private static final String complex = "[complex value]";
    private static final List<String> listWordsWithoutMark = List.of("true", "false", "null");

    public static String format(Map<String, Map<String, String>> resultMapValue) throws JsonProcessingException {
        Set<String> keys = new TreeSet<>();
        keys.addAll(resultMapValue.keySet());
        StringBuilder builder = new StringBuilder();
        keys.addAll(resultMapValue.keySet());
        for (var key : keys) {
            for (var e : resultMapValue.get(key).entrySet()) {
                String value;
                String value_before;
                String value_after;
                if (e.getKey().equals(" ")) {
                    break;
                } else if (e.getKey().equals("+")) {

                    if (e.getValue().contains("[") || e.getValue().contains("{")) {
                        value = complex;
                    } else {
                        String v = e.getValue().replace(":", "").trim();
                        if (StringUtils.isNumeric(v) || listWordsWithoutMark.contains(v))
                            value = v;
                        else value = "'" + v + "'";
                    }
                    builder.append("Property '").append(key).append(added).append(value).append("\n");
                } else {
                    if (resultMapValue.get(key).size() > 1) {
                        if (resultMapValue.get(key).get("-").contains("[") || resultMapValue.get(key).get("-").contains("]")) {
                            value_before = complex + " to";
                        } else {
                            String v = (resultMapValue.get(key).get("-")).replace(":", "").trim();
                            if (StringUtils.isNumeric(v) || listWordsWithoutMark.contains(v))
                                value_before = v + " to";
                            else
                                value_before = "'" + v + "' to";
                        }
                        if (resultMapValue.get(key).get("+").contains("[") || resultMapValue.get(key).get("+").contains("]")) {
                            value_after = " " + complex;
                        } else {
                            String v = (resultMapValue.get(key).get("+")).replace(":", "").trim();
                            if (StringUtils.isNumeric(v) || listWordsWithoutMark.contains(v))
                                value_after = " " + v;
                            else
                                value_after = " '" + v + "'";
                        }
                        builder.append("Property '").append(key).append(updated).append(value_before).append(value_after).append("\n");
                    } else if (resultMapValue.get(key).size() == 1) {
                        builder.append("Property '").append(key).append(removed).append("\n");
                    }
                    break;
                }
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();

    }
}
