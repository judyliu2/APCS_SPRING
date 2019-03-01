public interface PriorityQueue<T>{
   
    //adds item to this priority queue
    public void add(T x);

    //returns whether or not the PQ is empty
    public boolean isEmpty();

    //Returns the smallest item in the PQ
    public T peekMin();

    //Removes and returns the smallest item 
    public T removeMin();


}
