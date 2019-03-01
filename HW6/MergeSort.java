//Judy Liu
//APCS pd5
//HW07 - Step 1: Split, Step 2: ?, Step 3: Sorted!
//2017-02-11

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  If the given array of integers is greater than 1, split the array into halves until they have a length of 1. After this, create a new array with the length both of the given arrays in merge method. The first integer in the array will the smallest interger of both arrays. Continue combining until there is only 1 array left.  

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int [] c = new int[ a.length + b.length ];
	int aindex = 0;
	int bindex = 0;
	for (int cindex = 0; cindex < c.length; cindex++){
	    if (aindex >= a.length){ //if finished iterating through array a, add the rest of elements of b to array c
		c[cindex] = b[bindex++];
	    }
	    else if (bindex >= b.length){ //if finished interating through array b, add the rest of elements of a to array c
		c[cindex] = a[aindex++];
	    }
	    else if ( a[aindex] > b[bindex] ){
		c[cindex] = b[bindex ++];
	    }
	    else{
		c[cindex] = a[aindex ++];
	    }
	}
	return c;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int len = arr.length;
	if (len <= 1){
	    return arr;
	}
	else {
	    int[] newarr1 = new int [ len/2 ]; //new array with length of len/2
	    int[] newarr2 = new int [len - len/2];// new array with remaining length thats not used in newarr1
	    for (int i = 0; i < newarr1.length; i++){ //filling in newarr1 with all numbers from indexes less than len/2
		newarr1[i] = arr[i]; 
	    }
	    for (int j = 0; j < newarr2.length; j++){
		newarr2[j] = arr[j + len/2]; //filling in newarr2, + len/2 is required because that index len/2 more than j
	    }
	
	return merge( sort (newarr1), sort (newarr2));
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );

    }//end main()

}//end class MergeSort

