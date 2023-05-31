package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;

public class Plain {
    private static final String UPDATED = "' was updated. From ";
    private static final String REMOVED = "' was removed";
    private static final String ADDED = "' was added with value: ";
    private static final String COMPLEX = "[complex value]";
    private static final List<String> LIST_WORDS_WITHOUT_MARK = List.of("true", "false", "null");

    public static String format(Map<String, Map<String, String>> resultMapValue) throws JsonProcessingException {
        Set<String> keys = new TreeSet<>();
        keys.addAll(resultMapValue.keySet());
        StringBuilder builder = new StringBuilder();
        keys.addAll(resultMapValue.keySet());
        for (var key : keys) {
            for (var e : resultMapValue.get(key).entrySet()) {
                String value;
                String valueBefore;
                String valueAfter;
                if (e.getKey().equals(" ")) {
                    break;
                } else if (e.getKey().equals("+")) {

                    if (e.getValue().contains("[") || e.getValue().contains("{")) {
                        value = COMPLEX;
                    } else {
                        String v = e.getValue().replace(":", "").trim();
                        if (StringUtils.isNumeric(v) || LIST_WORDS_WITHOUT_MARK.contains(v)) {
                            value = v;
                        } else {
                            value = "'" + v + "'";
                        }
                    }
                    builder.append("Property '").append(key).append(ADDED).append(value).append("\n");
                } else {
                    if (resultMapValue.get(key).size() > 1) {
                        if (resultMapValue.get(key).get("-").contains("[") || resultMapValue.get(key).get("-")
                                .contains("]")) {
                            valueBefore = COMPLEX + " to";
                        } else {
                            String v = (resultMapValue.get(key).get("-")).replace(":", "").trim();
                            if (StringUtils.isNumeric(v) || LIST_WORDS_WITHOUT_MARK.contains(v)) {
                                valueBefore = v + " to";
                            } else {
                                valueBefore = "'" + v + "' to";
                            }
                        }
                        if (resultMapValue.get(key).get("+").contains("[") || resultMapValue.get(key).get("+")
                                .contains("]")) {
                            valueAfter = " " + COMPLEX;
                        } else {
                            String v = (resultMapValue.get(key).get("+")).replace(":", "").trim();
                            if (StringUtils.isNumeric(v) || LIST_WORDS_WITHOUT_MARK.contains(v)) {
                                valueAfter = " " + v;
                            } else {
                                valueAfter = " '" + v + "'";
                            }
                        }
                        builder.append("Property '").append(key).append(UPDATED).append(valueBefore).append(valueAfter)
                                .append("\n");
                    } else if (resultMapValue.get(key).size() == 1) {
                        builder.append("Property '").append(key).append(REMOVED).append("\n");
                    }
                    break;
                }
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();

    }
}
