package hexlet.code;


import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.io.IOException;
import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "1.0", header = "",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable {
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    public static String file1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    public static String file2;

    @Option(names = {"-h", "--help"}, usageHelp = true,
            description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionHelpRequested;

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]",
            defaultValue = "stylish")
    public String format;


    public static void main(String... args) {
        CommandLine.call(new App(), System.err, args);
    }

    @Override
    public Object call() throws IOException {
        System.out.println(Differ.generate(file1, file2, format));
        return null;
    }
}




