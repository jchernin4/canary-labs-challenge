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
        final int finalIndex = headerIndex;
        Arrays.sort(result, (a, b) -> order.equals("desc")
                ? b[finalIndex].compareTo(a[finalIndex])
                : a[finalIndex].compareTo(b[finalIndex]));
        return result;
    }
}
