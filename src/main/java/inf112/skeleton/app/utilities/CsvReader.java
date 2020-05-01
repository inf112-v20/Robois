package inf112.skeleton.app.utilities;

import java.io.*;
import java.util.Scanner;

public class CsvReader {
    private int[][] boardids;
    private String directory = "src/main/java/inf112/skeleton/app/assets/boards/";

    private final int width;
    private final int height;
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
        this.width = Integer.parseInt(numLine.split(",")[0]);
        this.height = Integer.parseInt(numLine.split(",")[1]);

        // Allocate arrays with length n
        boardids = new int[height][width];

        for (int y = 0; y < height; y++){
            String[] inputArr = scan.nextLine().split(",");
            for (int x = 0; x < width; x++){
                boardids[y][x] = Integer.parseInt(inputArr[x]);
            }
        }
        scan.close();
    }

    public int[][] getBoardIds() {
        return this.boardids;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}
