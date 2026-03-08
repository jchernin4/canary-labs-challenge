import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import operations.FilterOperation;
import operations.SelectOperation;
import operations.SortOperation;

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
                        if (respSplit.length != 2) {
                            System.out.println("Invalid select command. Usage: select header1,header2,...");
                            break;
                        }

                        SelectOperation so = new SelectOperation(respSplit[1].split(","));
                        String[][] selectResp = so.execute(headers, values);
                        print2dArray(selectResp);
                        break;

                    case "sort":
                        if (respSplit.length != 3 || !Arrays.asList("asc","desc").contains(respSplit[2])) {
                            System.out.println("Invalid sort command. Usage: sort header asc|desc");
                            break;
                        }

                        SortOperation sortOp = new SortOperation(respSplit[1], respSplit[2]);
                        String[][] sortResp = sortOp.execute(headers, values);
                        print2dArray(sortResp);
                        break;

                    case "filter":
                        if (respSplit.length != 4 || !Arrays.asList("<", ">", "=").contains(respSplit[2])) {
                            System.out.println("Invalid filter command. Usage: filter header <|>|= value");
                            break;
                        }
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