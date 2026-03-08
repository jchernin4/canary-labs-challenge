package operations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterOperation extends CsvOperation {
    private String comparison;
    private double value;
    private String header;

    public FilterOperation(String header, String comparison, double value) {
        this.header = header;
        this.comparison = comparison;
        this.value = value;
    }

    public String[][] execute(String[] headers, String[][] values) {
        List<String> headerList = Arrays.asList(headers);
        if (!headerList.contains(header)) {
            throw new IllegalArgumentException("Unknown column: " + header);
        }

        ArrayList<String[]> result = new ArrayList<>();
        int headerIndex = headerList.indexOf(header);

        for (int i = 0; i < values.length; i++) {
            double cur = Double.parseDouble(values[i][headerIndex]);
            switch (comparison) {
                case "<":
                    if (cur < value) {
                        result.add(values[i]);
                    }
                    break;

                case ">":
                    if (cur > value) {
                        result.add(values[i]);
                    }
                    break;

                case "=":
                    if (cur == value) {
                        result.add(values[i]);
                    }
                    break;
            }
        }

        return result.toArray(new String[0][]);
    }
}
