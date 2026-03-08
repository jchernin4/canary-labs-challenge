package operations;
import java.util.Arrays;

public class SortOperation extends CsvOperation {
    private String sortHeader;
    private String order;

    public SortOperation(String sortHeader, String order) {
        this.sortHeader = sortHeader;
        this.order = order;
    }

    public String[][] execute(String[] headers, String[][] values) {
        int headerIndex = Arrays.asList(headers).indexOf(sortHeader);

        String[][] result = Arrays.copyOf(values, values.length);
        Arrays.sort(result, (a, b) -> order.equals("desc")
                ? b[headerIndex].compareTo(a[headerIndex])
                : a[headerIndex].compareTo(b[headerIndex]));
        return result;
    }
}
