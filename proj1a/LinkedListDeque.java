public class LinkedListDeque<T> {
    private int size;
    private TNode sentinel;
//    private int index; put in Node class?

    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;
        public int index;
    }

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque(){

    }

    /**
     * Creates a deep copy of 'other'.
     * @param other
     */
    public LinkedListDeque(LinkedListDeque other){

    }

    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index){

    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item){

    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item){

    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * Returns the numbers of items in the deque.
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque(){

    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeFirst(){

    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeLast(){

    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index){

    }
}
