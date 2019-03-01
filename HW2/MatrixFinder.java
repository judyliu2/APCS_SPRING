/*Piotr Milewski, Judy Liu
  Team Name: Pajamas (PJs)
  APCS2 pd5
  HW02 -- I Am Still Searching
  2017-02-02*/

public class MatrixFinder{

    //Checks if the current position is equal to the number you are searching for
    //If it's true, then the program returns the position of the number
    //If it's false, then compare the number to the number in the position
    //If it's greater, then you go to the next column
    //If it's less, then you go up a row
    //If it's not found then you return (-1,-1)
    public static String findNum(int[][] matrix, int search){
	int row = matrix.length-1;
	int column = 0;
	while (row > -1 && column < matrix[0].length){
	    if (matrix[row][column] == search){
		return "(" + row + "," + column + ")";
	    }
	    else{
		if (matrix[row][column] > search){
		    row--;
		}
		else{
		    column++;
		}
	    }
	}
	return "(-1,-1)";
    }

    public static void main(String[] args){
	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 5, 12, 15 },
	};
	System.out.println(findNum(bey,8));
	int[][] test = {
	    {1, 5, 8, 10, 13},
	    {3, 7, 9, 11, 15},
	    {6, 12, 13, 16, 17},
	    {11, 13, 15, 19, 21},
	    {14, 17, 18, 22, 30}
	};
	System.out.println(findNum(test,11));
	int[][] testarray ={
	    {1, 20, 30, 40},
	    {2, 22, 32, 42},
	    {3, 23, 33, 43},
	    {4, 24, 34, 44}
	};
	System.out.println(findNum(testarray,44));
	int[][] CRy = {{}};
	System.out.println(findNum(CRy,801234));
	int[][] a1 = new int[][]{
	    { 1,  3,  5 },
	    { 2,  4,  6 },
	    { 5, 12, 15 }
	};
	System.out.println(findNum(a1,4));
	System.out.println(findNum(a1,400));
	int [][] pessimist  = {
	    {-100, -80, -13, -6, 0},
	    {-99, -79, -10, 0, 16},
	    {-75, -1, 0, 53, 62},
	    {-70, 1, 3, 245, 1421},
	    {-10, 2, 3, 365, 1441}
	};
	System.out.println(findNum(pessimist,53));	
	System.out.println(findNum(pessimist,-100));
	System.out.println(findNum(pessimist,1441));
    }
}

