package inf112.skeleton.app.utilities;

import java.io.*;
import java.util.Scanner;

public class CsvReader {
    String[] countryNames;
    int[] yearNum;
    double[][] tables;

    public CsvReader(String filename) throws FileNotFoundException{ 
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        scan.nextLine(); //Skip the header line

        //Read the int on the next line to allocate arrays
        String numLine = scan.nextLine();
        final int n = Integer.parseInt(numLine.split(",")[1]); //Number is the string portion after the first comma

        //Allocate arrays with length n
        countryNames = new String[n];
        tables = new double[n][];

        //Read in the header line of years, parse and copy into yearNum
        String[] yearHeaders = scan.nextLine().split(",");
        final int m = yearHeaders.length - 1;
        yearNum = new int[m];
        for(int i = 0; i < m; i++){
            yearNum[i] = Integer.parseInt(yearHeaders[i+1]); //i+1 to skip the first entry in the string arr
        }

        //Now read until we run out of lines - put the first in country names and the rest in the table
        int c = 0;
        while(scan.hasNext()){
            String[] inputArr = scan.nextLine().split(",");
            countryNames[c] = inputArr[0];
            tables[c] = new double[m];
            for(int i = 0; i < m; i++){
                tables[c][i] = Double.parseDouble(inputArr[i+1]);
            }
            c++;
        }
        scan.close();
    }

    public String[] getCountryNames(){
        return countryNames;
    }
    public int[] getYearLabels(){
        return yearNum;
    }
    public double[][] getParsedTable(){
        return tables;
    }
}
