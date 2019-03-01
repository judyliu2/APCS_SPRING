public interface Deque<T>{

    //~~~~~~~~~~~~~ methods for Front of Deque ~~~~~~~~~~~~
    //adds element to the front
    public void addFront(T x);

    public T removeFront();

    public T peekFront();


    //~~~~~~~~~~~~ methods for the End of Deque ~~~~~~~~~~~

    public void addEnd(T x);

    public T removeEnd();

    public T peekEnd();
    
    public int size();

    
    public boolean isEmpty();
    
 
}
