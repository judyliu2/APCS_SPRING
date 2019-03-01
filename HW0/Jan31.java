public class Jan31{

    //Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

    public static int factorial (int n){
	if (n == 1){
	    return 1;
	}
	else{
	    return n* factorial (n-1);
	}
    }

    //We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

    public static int bunnyEars(int bunnies){
	if (bunnies == 0 ){
	    return 0;
	}
	else{
	    return 2 + bunnyEars(bunnies -1);
	}
    }

    //The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.

    public static int fibonacci(int n){
	if (n < 1){
	    return 0;
	}
	else if (n == 1){
	    return 1;
	}
	else{
	    return fibonacci(n-1) + fibonacci(n-2);
	}
    }

    //We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

    public static bunnyEars2(int bunnies){
        if (bunnies == 0){
	    return 0;
	}
	else if (bunnies % 2 == 1){
	    return 2 + bunnyEars2(bunnies -1);
	}
	else
	    return 3 + bunnyEars(bunnies -1);
	}
    }
    public static void main (String[] args){
	/*System.out.println(factorial(1));
	System.out.println(factorial(2));
	System.out.println(factorial(3));
	System.out.println(bunnyEars(0));
	System.out.println(bunnyEars(1));
	System.out.println(bunnyEars(2));*/
	System.out.println(fibonacci(0));
    }
}
