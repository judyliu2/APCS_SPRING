/* Team JDK -- Judy Liu, David Frid, Karina Ionkina
   APCS2 pd05
   Lab 02 -- Synecdoche
   2017- 04- 03 */

/*------------------------Deque Class------------------------
** Implementation to a double ended queue. It uses a 
** doubly linked nodes as its container 
  -----------------------------------------------------------*/


public class DLLDeque<T>{

    private DLLNode<T> _front;
    private DLLNode<T> _end;
    private int _size;
    
    public DLLDeque(){
	_size = 0;
	_front = null;
	_end = null;
    }

//~~~~~~~~~~~~~ methods for Front of Deque ~~~~~~~~~~~~                                        

    /*------------------------addFront-----------------------
    **Adds element to the front by linking a new node to the
    **front of the list.                  
    -------------------------------------------------------*/
    public void addFront(T x){
	if(isEmpty()){
	    _front = new DLLNode<T>(x, null, null);
	    _end = _front;
	 	}
	else {
	    DLLNode bob = new DLLNode<T>(x, null,_front);
	    _front = bob;
	}
	_size++;
    }
/*------------------------------removeFront------------------
    **Removes element from the front by setting the _front to
    **_front.getNext() and setting the previous of the node 
    ** ahead to null
    -------------------------------------------------------*/

    public T removeFront(){
	if(isEmpty()){
	    return null;
	}
	T ret = _front.getCargo();
	_front = _front.getNext();
	_front.setPrev(null);
	_size --;
	return ret;
    }

    public T peekFront(){
	return _front.getCargo();
    }


    //~~~~~~~~~~~~ methods for the End of Deque ~~~~~~~~~~~                                         

    /*------------------------addEnd-------------------------
    **Adds element to the end by linking a last node to 
    ** a new node whose cargo is x. 
    -------------------------------------------------------*/

    public void addEnd(T x){
	if (isEmpty()){
	    _end = new DLLNode<T>(x,null, null);
	    _front = _end;
	}
	else{
	    DLLNode<T> bob = new DLLNode<T>(x, _end,null);
	    _end = bob;
	    _end.getPrev().setNext(_end);
	}
	_size ++;
    }

    /*---------------------removeEnd------------------------
    ** The second to last element's getNext is set to null
    ** and _end points to that element.
    -------------------------------------------------------*/
  
  public T removeEnd(){
	if (isEmpty()){
	    return null;
	}
	else{
	    T ret = _end.getCargo();
	    _end = _end.getPrev();
	    _end.setNext(null);
	    _size --;
	    return ret;
	}
    }

    public T peekEnd(){
	return _end.getCargo();
    }
	
    public int size(){
	    return _size;
    }


    public boolean isEmpty(){
	return _front == null;
    }
    public String toString(){
	String retStr = "";
	DLLNode node = _front;
	while(node != null){
	    retStr += node.toString() + "  ";
	    node = node.getNext();
	}
	return retStr;
	
    }
    public static void main(String[] args){
	/*	DLLDeque<String> test = new DLLDeque<String>();
	test.addEnd("boop");
	System.out.println(test.peekEnd());
	test.addFront("hello4");
	System.out.println(test);
	test.addFront("hello3");
	//System.out.println(
	System.out.println(test);
	//test.removeFront();
	test.addEnd("hello5");
	System.out.println(test);
	test.addEnd("oops");
	System.out.println(test);
	test.addFront("hello2");
	System.out.println(test);
	test.addFront("hello1");
	test.removeEnd();
	System.out.println(test.peekEnd()); */
    }

}
