/*****************************************************
 * Judy Liu
 * APCS2 pd5
 * HW28 -- Now Let's Consider You Lot At Fake Terry's
 * 2017-03-30
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _front = _end = null;
	}


    public void enqueue( T enQVal ) 
    {
	LLNode<T> newNode = new LLNode<T>(enQVal, null);
	if (isEmpty()){
	    _front = newNode;
	    _end = _front;
	}
	else{
	    _end.setNext(newNode);
	    _end = newNode;
	    _end.setNext(_front);
	}
	_size ++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
        T retT = _front.getValue();
	_front =_front.getNext();
	sample();
        _end.setNext(_front);
	_size --;
	return retT;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	if (isEmpty()){
	    return null;
	}
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * Uses Math.random() to choose random number of times to iterate through the Queue.
     * 
     ******************************************/
    public void sample () 
    {
	int i = (int) Math.random() * _size;
	while (i > 0){
	    _front = _front.getNext();
	    i--;
	}
    }//O(n)


    public boolean isEmpty() 
    { 
	return _size == 0;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "";
	int a = _size;
	LLNode<T> current = _front;
	while (current != null  && a > 0){
	    retStr += current.getValue() + " ";
	    current = current.getNext();
	    a --;
	}
	return retStr;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
