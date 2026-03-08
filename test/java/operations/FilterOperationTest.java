package operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterOperationTest {
    private final String[] headers = {"FirstName", "LastName", "GPA", "StudentId"};
    private final String[][] values = {
        {"Jeremy", "Chernin", "3.5", "1234"},
        {"John", "Smith", "2.8", "0987"},
        {"Patrick", "Johnson", "3.9", "5678"},
        {"Emily", "Davis", "3.2", "4321"}
    };

    @Test
    void gt() {
        String[][] result = new FilterOperation("GPA", ">", 3.25).execute(headers, values);
        assertEquals("Jeremy", result[0][0]);
        assertEquals("Patrick", result[1][0]);
    }

    @Test
    void lt() {
        String[][] result = new FilterOperation("GPA", "<", 3.25).execute(headers, values);
        assertEquals("John", result[0][0]);
        assertEquals("Emily", result[1][0]);
    }

    @Test
    void eq() {
        String[][] result = new FilterOperation("GPA", "=", 2.8).execute(headers, values);
        assertEquals("John", result[0][0]);
    }
}
