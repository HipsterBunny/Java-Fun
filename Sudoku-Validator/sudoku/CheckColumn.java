package sudoku;

//This thread will check through all columns to see if they hold 1-9
public class CheckColumn implements Runnable {
	//holds the entire solution to the sudoku puzzle
    private int[][] solutionArray = new int[9][9];
    //holds the numbers from one row to check
    private int[] checkArray = new int[9];
    //indicates if an error was found (set to true as default)
    private int isValid; //flag for if an array is or is not valid
    private int errorFound; //makes sure correct errors are sent

//constuct
    public CheckColumn(int[][] dataArray) {
    	//initialize solutionArray
		this.solutionArray = dataArray;
		this.isValid = 1;
		this.errorFound = 0; 
        int i = 0;
        //set all check array values to false (default)
        for (i = 0; i < 9; i++) {
			checkArray[i] = 0;
		}
    }

    public void run() {
		int i = 0; //iterates throuth row 
        int j = 0; //iterates through current observed column
        int[] currentLine = new int[9];
        while (j < 9) {
	        for (i = 0; i < 9; i++) {
	        	//place current column data into the currentLine array
	            currentLine[i] = solutionArray[i][j];
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
			System.out.println("There is an Error in Column " + (j+1));
			errorFound = 1;
		}
		//only printed if not errors have been found in any column
		else if (j == 8 && isValid == 1 && errorFound == 0) {
			System.out.println("There are no errors in your Columns.");
		}
        j++; //move one column to the right
		isValid = 1;
		for (i = 0; i < 9; i++) {
          	      checkArray[i] = 0;
  	        }
		}
    }
}
