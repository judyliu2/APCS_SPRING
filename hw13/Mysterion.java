/*
Judy Liu
APCS2 pd5
HW13 -- We Be Dem
2017-03-06

Summary: Mysterion returns the number of intergers less than the interger at index c of the given segment or subset of an  array. Int a represents the number that starts that segment of the array and b - 1 is the number that ends the array. Int a, b, c have to be in the index of the given array otherwise this doesn't work.
 */

public class Mysterion{
    public static int numofnumbelowc (int[] ar, int a, int b, int c){
	int v = ar[c];
	ar[c]= ar[b];
	ar[b]= v;
	int s = a;
	for ( int i = a; i < b; i++){
	    if (ar[i] < v){
		int temp = ar[s];
		ar[s] = ar[i];
		ar[i] = ar[s];
		s++;
	    }
	}
	int w = ar[b];
	ar[b]= ar[s];
	ar[s]= w;
	for (int d : ar){
	    System.out.println(d);
	}
	return s;
    }

    public static void main(String[] arg){
	int a = 0;
	int b = 1;
	int c = 4;
	int[] arr = {3,0,16,599,1024};
	System.out.println( numofnumbelowc(arr,a,b,c) );
    }
}
