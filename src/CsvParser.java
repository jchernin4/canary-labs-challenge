import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvParser {
    private FileReader fileReader;

    public CsvParser(File file) {
        try {
            fileReader = new FileReader(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFile() {
        char[] buf = new char[4096];
        int bytesRead;

        try {
            bytesRead = fileReader.read(buf);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return String.valueOf(buf).substring(0, bytesRead);
    }
}
