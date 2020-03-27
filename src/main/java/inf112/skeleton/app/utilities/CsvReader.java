package inf112.skeleton.app.utilities;

import java.io.*;
import java.util.Scanner;

public class CsvReader {
    private int[][] boardids;
    private String directory = "src/main/java/inf112/skeleton/app/assets/boards/";

    /**
     * A CsvReader to read boards
     * 
     * @param filename filename of the board csv file, eg. b1.csv
     * @throws FileNotFoundException
     */
    public CsvReader(String filename) throws FileNotFoundException {
        File file = new File(directory + filename);
        Scanner scan = new Scanner(file);

        String numLine = scan.nextLine();
        final int n = Integer.parseInt(numLine.split(",")[0]);
        final int m = Integer.parseInt(numLine.split(",")[1]);

        // Allocate arrays with length n
        boardids = new int[n][m];

        int y = 0;
        while (scan.hasNext()) {
            String[] inputArr = scan.nextLine().split(",");
            for (int x = 0; x < n; x++) {
                boardids[y][x] = Integer.parseInt(inputArr[x]);
            }
            if (y >= m)
                break;
            y++;
        }
        scan.close();
    }

    public int[][] getBoardIds() {
        return this.boardids;
    }
}
