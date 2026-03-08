import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CsvParser {
    private File file;

    public CsvParser(File file) {
        this.file = file;
    }

    public String readFile() {
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
