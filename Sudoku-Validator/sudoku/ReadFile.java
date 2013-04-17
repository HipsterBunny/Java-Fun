package sudoku;

//used for reading in data 
public class ReadFile {
    private String currentLine;
    private static int[] arrayOfLineData = new int[9];

    public ReadFile() {
	this.currentLine = "";
        int i = 0;
        for (i = 0; i < 9; i++) {
            arrayOfLineData[i] = i + 1;
        }
    }

    private void setCurrentLine (String inputLine) {
        currentLine = inputLine;
    }
    
    public void setArray (String inputLine) {
        this.setCurrentLine (inputLine);
        String[] parts = currentLine.split(",");
	int i = 0;
	Integer numVal = 0;

	for (i = 0; i < 9; i++) {
	    numVal = Integer.valueOf(parts[i]);
	    arrayOfLineData[i] = numVal;	    	    
	}
    }

    public static int[] getArray() {
        return arrayOfLineData;
    }
}
