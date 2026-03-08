package operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortOperationTest {
    private final String[] headers = {"FirstName", "LastName", "GPA", "StudentId"};
    private final String[][] values = {
            {"Jeremy", "Chernin", "3.5", "1234"},
            {"John", "Smith", "2.8", "0987"},
            {"Patrick", "Johnson", "3.9", "5678"},
            {"Emily", "Davis", "3.2", "4321"}
    };

    @Test
    void sortAsc() {
        String[][] result = new SortOperation("FirstName", "asc").execute(headers, values);
        assertEquals("Emily", result[0][0]);
        assertEquals("Jeremy", result[1][0]);
        assertEquals("John", result[2][0]);
        assertEquals("Patrick", result[3][0]);
    }

    @Test
    void sortDesc() {
        String[][] result = new SortOperation("FirstName", "desc").execute(headers, values);
        assertEquals("Patrick", result[0][0]);
        assertEquals("John", result[1][0]);
        assertEquals("Jeremy", result[2][0]);
        assertEquals("Emily", result[3][0]);
    }
}
