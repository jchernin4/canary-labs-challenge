package operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectOperationTest {
    private final String[] headers = {"FirstName", "LastName", "GPA", "StudentId"};
    private final String[][] values = {
            {"Jeremy", "Chernin", "3.5", "1234"},
            {"John", "Smith", "2.8", "0987"},
            {"Patrick", "Johnson", "3.9", "5678"},
            {"Emily", "Davis", "3.2", "4321"}
    };

    @Test
    void select() {
        String[][] result = new SelectOperation(new String[]{"FirstName", "LastName"}).execute(headers, values);
        assertEquals("Jeremy", result[0][0]);
        assertEquals("Chernin", result[0][1]);
        assertEquals("John", result[1][0]);
        assertEquals("Smith", result[1][1]);
        assertEquals("Patrick", result[2][0]);
        assertEquals("Johnson", result[2][1]);
        assertEquals("Emily", result[3][0]);
        assertEquals("Davis", result[3][1]);
    }

}
