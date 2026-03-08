import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CsvParser parser = new CsvParser(new File("./src/data.csv"));

        String fileText = parser.readFile();

        String[] lineSplit = fileText.split("\\r?\\n");

        String[] headers = lineSplit[0].split(",");

        String[][] values = new String[lineSplit.length - 1][];
        for (int i = 1; i < lineSplit.length; i++) {
            values[i - 1] = lineSplit[i].split(",");
        }

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter a command: ");

                String resp = sc.nextLine();

                String[] respSplit = resp.split(" ");
                switch (respSplit[0]) {
                    case "select":
                        SelectOperation so = new SelectOperation(respSplit[1].split(","));
                        String[][] selectResp = so.execute(headers, values);
                        print2dArray(selectResp);
                        break;

                    case "sort":
                        SortOperation sortOp = new SortOperation(respSplit[1], respSplit[2]);
                        String[][] sortResp = sortOp.execute(headers, values);
                        print2dArray(sortResp);
                        break;

                    case "filter":
                        FilterOperation filterOp = new FilterOperation(respSplit[1], respSplit[2],
                                Double.parseDouble(respSplit[3]));
                        String[][] filterResp = filterOp.execute(headers, values);
                        print2dArray(filterResp);
                        break;
                }
            }
        }
    }

    static void print2dArray(String[][] arr) {
        for (String[] row : arr) {
            System.out.println("[" + String.join(",", row) + "]");
        }
    }
}