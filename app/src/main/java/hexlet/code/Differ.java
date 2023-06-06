package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;

public class Differ {
    public static String generate(String f1, String f2, String format) throws IOException {
        String body1 = Files.readString(Path.of(f1));
        String body2 = Files.readString(Path.of(f2));
        Map<String, Object> file1 = Parser.parse(f1, body1);
        Map<String, Object> file2 = Parser.parse(f2, body2);
        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        List<Map<String, Object>> commonList = DiffBuilder.diff(file1, file2, keys);
        return Formatter.format(commonList, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}

