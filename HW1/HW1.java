//Judy Liu
//APCS2 pd5
//HW01: Speaking In Pseudocode
//2017-02-01
//Two Musicians: Piotr Milewski, Judy Liu

public class HW1{
    public static String linSearch(int[][] mat, int search){
	//Starts at bottom left corner so that you either go up a row if search number is less than number at a certain index and if search is higher than that number, it down the row. 
	int row = mat.length-1;
	int col = 0;
	while ( row > -1 && col < mat[0].length){
	    if (mat[row][col] == search){
		return search + " is found at row " + row + ", column " + col + ".";
	    }
	    //if int at mat[row][col] is greater than search, go to next row
	    else if(mat[row][col] > search){
		row --;
	    }
	    //if int at mat[row][col] is less than search, go down the row
	    else{
		col++;
	    }
	}
	return "The number you are searching for is not found";
    }

    public static void main(String[] args){
	int[][] test = {{1,2,7,8}, {3,6,8,9},{5,8,10,12},{10,11,12,13}};
	System.out.println( linSearch (test, 9));
    }
}
