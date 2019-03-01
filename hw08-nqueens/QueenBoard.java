//Judy Liu
//APCS2 p5
//HW08:Queens
//2017-02-25



/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * [...]
     */
    public boolean solve()
    {
	for (int c = 0 ; c < _board.length; c++){
	     solveH(c);
	}
	return false;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	for (int r = 0; r < _board.length; r++){
	    if (_board[r][col] == 0){
	     return addQueen(r,col);
	    }
	}
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] > 0){
		    ans += "Q" +"\t";
		}
		else{
		    ans += "_" + "\t";
		}
	    }
	    ans += "\n";
	}
	System.out.println( ans);;
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: If given spot has the value of 0
     * postcondition: Return false if given spot has a value other than 0. 
     */
    private boolean addQueen(int row, int col)
    {
	// Checks if given spot is available
	if(_board[row][col] != 0){
	    return false;
	}

	// Queen is added
	_board[row][col] = 1;

	// increment
	int offset = 1;

	// eliminates available spots in horizontal and diagonal directions of queens vision
	while(col+offset < _board[row].length) {
	    // eliminates horizontally to right
	    _board[row][col+offset]--;

	    // eliminates diagonally to the right
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // increases increment
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: Given spot is location of queen
     * postcondition: Removes queen and neutralizes
     */
    private boolean removeQueen(int row, int col)
    {
	// Checks if given location has queen
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// removes queen
	int offset = 1;	        // increment

	// adds 1 to value diagonally or horizontally to the left
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: a Queen board is present
     * postcondition: makes a string of the given board
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.solve();
	System.out.println(b);
	/*b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
	*/
	b.printSolution();
	
    }//end main()
    
}//end class
