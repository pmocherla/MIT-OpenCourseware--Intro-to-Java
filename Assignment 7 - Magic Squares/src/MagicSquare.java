/* MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 7: Magic square
 * This file is a is a class that validates magic squares
 * The Mercury.txt and Luna.txt both contain valid magic squares.
 * Star.txt is a negative test case that has been created from Mercury.txt
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
//import java.lang.String;

public class MagicSquare {
    private FileReader file;
    private BufferedReader br;
    private int[][] square = null;
    private String line = null;
    private int matrixSize = 0;

    public MagicSquare(String filename) throws FileNotFoundException{
        file = new FileReader(filename);
        br = new BufferedReader(file);
    }

    //Convert the text file into an integer matrix
    public void fileToArray() throws IOException {

        //Create a row counter to fill up the matrix
        int j = 0;

        //init square
        while ((line = br.readLine()) != null) {
            if (line.length() == 0) {
                continue;
            }
            //Split the line into the numbers only
            String[] splitString = line.split("\t", 0);

            //If the matrix size hasnt been set yet then set it and init te square
            if (matrixSize == 0) {
                matrixSize = splitString.length;
                square = new int[matrixSize][matrixSize];
            }

            //fill the square up with values
            for (int i = 0; i < matrixSize; i++) {
                square[j][i] = Integer.parseInt(splitString[i]);
            }
            j++;
        }
    }

    public boolean checkSquare() {
        //Check the square that all the following sum to the same value.
        if (!checkRows() || !checkColumns() || !checkDiags()) {
            return false;
        }

        return true;
    }

    public boolean checkRows() {
        //Check the rows of the square to see that they all add to the same value
        int previousSum = 0;
        int currentSum;

        for (int row = 0; row < matrixSize; row++) {
            currentSum = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (col == 0) {
                    currentSum = square[row][col];
                } else {
                    currentSum += square[row][col];
                }
            }

            //If the current rows sum is not equal to the previous
            // row then return false
            if (row == 0) {
                previousSum = currentSum;
                continue;
            } else if (previousSum != currentSum) {
                return false;
            } else {
                previousSum = currentSum;
            }
        }

        return true;
    }

    public boolean checkColumns() {
        //Sum up the columns and compare them to see if they are equal
        int previousSum = 0;
        int currentSum;

        for (int col = 0; col < matrixSize; col++) {
            currentSum = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (row == 0) {
                    currentSum = square[row][col];
                } else {
                    currentSum += square[row][col];
                }
            }

            //If the current cols sum is not equal to the previous
            // row then return false
            if (col == 0) {
                previousSum = currentSum;
                continue;
            } else if (previousSum != currentSum) {
                return false;
            } else {
                previousSum = currentSum;
            }
        }

        return true;
    }

    private boolean checkDiags() {
        //Checks the diagonal elements of the square
        int diag1 = 0;
        int diag2 = 0;

        for (int row = 0; row < matrixSize; row++){
            diag1 += square[row][row];
            diag2 += square[row][matrixSize-row-1];
        }

        //If the diags arent equal then return false
        if (diag1 != diag2) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] arguments) throws IOException {
        MagicSquare square = new MagicSquare("Data/Star.txt");
        square.fileToArray();
        if (square.checkSquare()) {
            System.out.println("This is a magic square! :D");
        }
        else {
            System.out.println("This is not a magic square. :(");
        }
    }
}
