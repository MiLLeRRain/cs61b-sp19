public class LinkedListDeque<T> {
    private int size;
    private TNode sentinel;

    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;
//        public int index;

        public TNode(T i, TNode p, TNode n){
            item = i;
            prev = p;
            next = n;
//            index = idx;
        }
    }

//    private int index; put in Node class?
//    Invariants:
//    1. 每个Node都含有item 两端均有指针
//    2. 初始field size为0 每增加一个+1 每减少一个-1
//    3. 1stNode是sentinel的next lastNode是sentinel的prev


    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        size = 0;
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
//    public T getRecursive(int index){
//
//    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty(){
        if (size == 0) return true;
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
        TNode toReturn = sentinel.next;
        if (toReturn.item!=null){
            sentinel.next = sentinel.next.next;
            size--;
            return toReturn.item;
        }
        return null;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeLast(){
        TNode toReturn = sentinel.prev;
        if (toReturn.item!=null){
            sentinel.prev = sentinel.prev.prev;
            size--;
            return toReturn.item;
        }
        return null;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
//    public T get(int index){
//
//    }
}
