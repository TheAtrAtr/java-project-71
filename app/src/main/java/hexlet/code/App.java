package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "1.0", header = "",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable {

    @Option(names = {"-h", "--help"}, usageHelp = true,
            description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionHelpRequested;


    public static void main(String... args) {
        CommandLine.call(new App(), System.err, args);
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
