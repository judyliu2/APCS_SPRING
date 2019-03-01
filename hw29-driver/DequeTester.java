/*
Team JDK- Judy Liu, David Frid, Karina Ionkina
APCS2 pd5
HW29 -- Stress is the Best
2017-04-04
 */

public class DequeTester{
    public static void main(String[] args){
	DLLDeque<String> test = new DLLDeque<String>();
	
	System.out.println("Expected: an empty deque");
	System.out.println("Result: "+test);
	System.out.println();

	System.out.println("Expected: true");
	System.out.println("Result: "+test.isEmpty());
	System.out.println();

	//tests exceptions and robustness when the DLLDeque is null

	System.out.println("Testing peek");
	System.out.println("Front: "+test.peekFirst());
	System.out.println("End: " +test.peekLast());
	System.out.println();

	//resting remove methods on a null DLLDeque
	test.removeFirst();
	test.removeLast();


	test.addFirst("Third");
	test.addFirst("Second");
	test.addFirst("First");
	System.out.println("Expected: First Second Third");
	System.out.println("Result: " + test);
	System.out.println();
	
	test.addLast("Fourth");
	System.out.println("Expected: First Second Third Fourth");
	System.out.println("Result: " + test);
	System.out.println();

	System.out.println("Testing peek");
	System.out.println("Front: "+test.peekFront());
	System.out.println("End: " +test.peekEnd());
	System.out.println();
	
	test.removeLast();
	test.removeFirst();
	System.out.println("Second Third");
	System.out.println("Result: "+test);

	System.out.println("Expected: Empty or null");
	test.removeFirst();
	test.removeFirst();
	System.out.println("Result: "+test);

    }
}
