package operations;
import java.util.Arrays;
import java.util.List;

public class SortOperation implements CsvOperation {
    private String sortHeader;
    private String order;

    public SortOperation(String sortHeader, String order) {
        this.sortHeader = sortHeader;
        this.order = order;
    }

    public String[][] execute(String[] headers, String[][] values) {
        List<String> headerList = Arrays.asList(headers);
        if (!headerList.contains(sortHeader)) {
            throw new IllegalArgumentException("Unknown column: " + sortHeader);
        }

        int headerIndex = headerList.indexOf(sortHeader);

        String[][] result = Arrays.copyOf(values, values.length);
        Arrays.sort(result, (a, b) -> order.equals("desc")
                ? b[headerIndex].compareTo(a[headerIndex])
                : a[headerIndex].compareTo(b[headerIndex]));
        return result;
    }
}
