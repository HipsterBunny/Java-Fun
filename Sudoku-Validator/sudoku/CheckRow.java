package sudoku;

//This thread will check through all rows to see if they hold 1-9
public class CheckRow implements Runnable {
	//holds the entire solution to the sudoku puzzle
    private int[][] solutionArray = new int[9][9];
    //holds the numbers from one row to check
    private int[] checkArray = new int[9];
    //indicates if an error was found (set to true as default)
    private int isValid; //flag for if an array is or is not valid
    private int errorFound; //makes sure correct errors are sent

//constuct
    public CheckRow(int[][] dataArray) {
    	//initialize solutionArray
		this.solutionArray = dataArray;
		this.isValid = 1;
		this.errorFound = 0;
        int i = 0;
        for (i = 0; i < 9; i++) {
			checkArray[i] = 0;
		}
    }

    public void run() {
		int i = 0; //iterate through row elements
        int j = 0; //indicate current observed row
        int[] currentLine = new int[9];
        while (j < 9) {
	        for (i = 0; i < 9; i++) {
	        	//assign data to 'currentLine' so we can check for 
	        	//numbers 1-9
	            currentLine[i] = solutionArray[j][i];
       		}
            //use a switch statement to indicate if each number (1-9) was found
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
        //if the array holds a 0 in it, there is a number missing
        //and an error in that current row (assign 0 to isValid)
		for (i = 0; i < 9; i++) {
			if (checkArray[i] != 1) {
				isValid = 0;
			} 
		}
		//print error message and inicate current row
		if (isValid == 0) {
			System.out.println("There is an Error in Row " + (j+1));
			errorFound = 1;
		}
		//only prints if no errors have been found in any row
		else if (j == 8 && isValid == 1 && errorFound == 0) {
			System.out.println("There are no errors in your rows.");
		}

        j++; //move to the next row
		isValid = 1; //reinitialize the data
		for (i = 0; i < 9; i++) {
          	      checkArray[i] = 0;
  	        }
	}
    }
}
