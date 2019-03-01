//Team Name : JJ
//Jason Lam, Judy Liu
//APCS pd5
//HW4
//2017-02-05

/* Loop 1: For each integer in the array, take the index of array of that number minus 1 and negate the value if the integer in that index isn't already negative.
Loop 2: Go through the array until an integer that's not negative is found. Return the index of that number plus 1.
 */
public class MissingNum{
    public static int missing(int[] array){
	for (int a : array){
	    int place = Math.abs(a) -1;
	    if (array[place] > 0){
		array[place] *= -1;
	    }
	}
	for (int index = 0; index < array.length ; index++){
	    if (array[index] > 0){
		return index +1;
	    }
	}
	return -1;
    }
    public static void main(String[] args){
	int[] carmen = {2,1,2,4};
	int[] TomatoCale={6,3,5,4,5,2};
	System.out.print(missing(carmen));
	System.out.println(missing(TomatoCale));
    }
}
