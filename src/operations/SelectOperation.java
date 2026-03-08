package operations;
import java.util.Arrays;
import java.util.List;

public class SelectOperation implements CsvOperation {
    private String[] toSelect;

    public SelectOperation(String[] toSelect) {
        this.toSelect = toSelect;
    }

    public String[][] execute(String[] headers, String[][] values) {
        List<String> headerList = Arrays.asList(headers);
        for (String col : toSelect) {
            if (!headerList.contains(col)) {
                throw new IllegalArgumentException("Unknown column: " + col);
            }
        }
        String[][] result = new String[values.length][toSelect.length];

        int[] headerIndexes = new int[toSelect.length];
        int foundCount = 0;
        for (int i = 0; i < headers.length; i++) {
            if (Arrays.asList(toSelect).contains(headers[i])) {
                headerIndexes[foundCount] = i;
                foundCount++;
            }
        }

        for (int i = 0; i < values.length; i++) {
            String[] cur = new String[headerIndexes.length];
            for (int j = 0; j < headerIndexes.length; j++) {
                cur[j] = values[i][headerIndexes[j]];
            }

            result[i] = cur;
        }

        return result;
    }
}
