package sudoku;

//This thread will check through a square to see if it hold 1-9
public class CheckSquare implements Runnable {
	//holds the entire solution to the sudoku puzzle
    private int[][] solutionArray = new int[9][9];
    //holds the numbers from one row to check
    private int[] checkArray = new int[9];
    //indicates if an error was found (set to true as default)
    private int isValid;
    private int rowStart, rowEnd; 
    private int colStart, colEnd;

    public CheckSquare(int[][] dataArray, int rS, int rE, int cS, int cE) {
    	//initialize solutionArray
		this.solutionArray = dataArray;
		this.isValid = 1;
		this.rowStart = rS;
		this.rowEnd = rE;
		this.colStart = cS;
		this.colEnd = cE;

        int i = 0;
        //set all check array values to false (default)
        for (i = 0; i < 9; i++) {
			checkArray[i] = 0;
		}
    }

    public void run() {
    	int j = colStart;
    	int i = rowStart;
    	int count = 0;
        int[] currentLine = new int[9];
        while (j <= colEnd) {
	        while (i <= rowEnd) {
	        	//place current column data into the currentLine array
	            currentLine[count] = solutionArray[i][j];
	            i++;
	            count++;
       		}
       		i = rowStart;
       		j++;
       	}
        //use a switch statement to check if array holds all numbers 1-9
        for (i = 0; i < 9; i++) {
			switch (currentLine[i]) {
				case 1: checkArray[0] = 1;
					break;
				case 2: checkArray[1] = 1;
					break;
				case 3: checkArray[2] = 1;
					break;
				case 4: checkArray[3] = 1;
					break;
				case 5: checkArray[4] = 1;
					break;
				case 6: checkArray[5] = 1;
					break;
				case 7: checkArray[6] = 1;
					break;
				case 8: checkArray[7] = 1;
					break;
				case 9: checkArray[8] = 1;
					break;
				default:isValid = 0;
					break;
			}
        }
        //check to see if checkArray holds any values other than 1
		for (i = 0; i < 9; i++) {
			if (checkArray[i] != 1) {
				isValid = 0;
			} 
		}
		if (isValid == 0) {
			System.out.println("There is an Error in Square " + rowStart + " - " + colStart);
		}
		else {
			System.out.println("Square " + rowStart + " - " + colStart + " is Valid.");
		}        
    }
}