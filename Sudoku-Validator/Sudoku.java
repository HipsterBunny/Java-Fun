import sudoku.*;
import java.io.*;
import java.util.*;

public class Sudoku {
    
    public static void main(String[] args) {
	ReadFile read = new ReadFile();
	int[][] sudokuSolution = new int[9][9];
	int[] arrayData = read.getArray();
	BufferedReader reader;
       
	try {
		//read in the file that holds the sudoku solution
		reader = new BufferedReader(new FileReader("solution.txt"));
		String line = null;
		int j = 0; //current row you are accessing
		int i = 0; //current column you are accessing
		while ((line = reader.readLine()) != null) {
			read.setArray(line);
			arrayData = read.getArray();
    		//read in the solution data to the sudokuSolution array	
			for (i = 0; i < 9 ; i++) {
        			sudokuSolution[j][i] = arrayData[i];
        		}
        		j++;
	        }
	    //create threads for checking rows, columns and each square inside
		Runnable rowCheck = new CheckRow(sudokuSolution);
		Runnable colCheck = new CheckColumn(sudokuSolution);
		Runnable checkSquare0 = new CheckSquare(sudokuSolution,0,2,0,2);
		Runnable checkSquare1 = new CheckSquare(sudokuSolution,0,2,3,5);
		Runnable checkSquare2 = new CheckSquare(sudokuSolution,0,2,6,8);
		Runnable checkSquare3 = new CheckSquare(sudokuSolution,3,5,0,2);
		Runnable checkSquare4 = new CheckSquare(sudokuSolution,3,5,3,5);
		Runnable checkSquare5 = new CheckSquare(sudokuSolution,3,5,6,8);
		Runnable checkSquare6 = new CheckSquare(sudokuSolution,6,8,0,2);
		Runnable checkSquare7 = new CheckSquare(sudokuSolution,6,8,3,5);
		Runnable checkSquare8 = new CheckSquare(sudokuSolution,6,8,6,8);

        //start all threads here
		new Thread(rowCheck).start();
		new Thread(colCheck).start();
		new Thread(checkSquare0).start();
		new Thread(checkSquare1).start();
		new Thread(checkSquare2).start();
		new Thread(checkSquare3).start();
		new Thread(checkSquare4).start();
		new Thread(checkSquare5).start();
		new Thread(checkSquare6).start();
		new Thread(checkSquare7).start();
		new Thread(checkSquare8).start();
	}
	catch(IOException ex) {
		System.out.println("There has been an IO error.");
	}
    }
}
