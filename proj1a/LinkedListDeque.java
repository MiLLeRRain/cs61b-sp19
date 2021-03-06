public class LinkedListDeque<T> {
    private int size;
    private TNode sentinel;

    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T i, TNode p, TNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

//    Invariants:
//    1. 每个Node都含有item 两端均有指针
//    2. 初始field size为0 每增加一个+1 每减少一个-1
//    3. 1stNode是sentinel的next lastNode是sentinel的prev


    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, sentinel, sentinel);
        size = 0;
    }

    /**
     * Creates a deep copy of 'other'.
     * @param other
     */
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new TNode(null, sentinel, sentinel);

        for (int i = 0; i < other.size; i++){
            addLast((T) other.get(i));
        }
    }

    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index){
        if (index < 0 || index > size-1) return null;
        return getRecursive(index, sentinel.next);
    }

    public T getRecursive(int toTarget, TNode t){
        if (toTarget > 0) {
            toTarget--;
            return getRecursive(toTarget, t.next);
        }
        return t.item;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item){
        TNode first;

        if (isEmpty()) {
            first = new TNode(item, sentinel, sentinel);
            sentinel.prev = first;
        }

        else {
            first = new TNode(item, sentinel, sentinel.next);
            sentinel.next.prev = first;
        }
        sentinel.next = first;

        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item){
        TNode last;

        if (isEmpty()) {
            last = new TNode(item, sentinel, sentinel);
            sentinel.prev = last;
            sentinel.next = last;
        }

        else {
            last = new TNode(item, sentinel.prev, sentinel);
            sentinel.prev.next = last;
            sentinel.prev = last;
        }

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
        if (size == 0){
            System.out.println("Size is 0. Nothing to print.");
        }
        TNode toPrint = sentinel.next;
        while (toPrint.item!=null){
            System.out.print(toPrint.item.toString()+" ");
            toPrint = toPrint.next;
        }
        System.out.println("- End of List.");
        System.out.println("--------------");
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeFirst(){
        T toReturn = sentinel.next.item;
        if (toReturn!=null){
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return toReturn;
        }
        return null;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeLast(){
        T toReturn = sentinel.prev.item;
        if (toReturn!=null){
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return toReturn;
        }
        return null;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index){
        if (size == 0){
            System.out.println("Size is 0. Noting to return.");
            return null;
        }
        if (index < 0 || index > size-1) return null;

        TNode toReturn = sentinel.next;
        for (int i = 0; i < size; i++){
            if (i == index){
                break;
            }
            toReturn = toReturn.next;
        }
        return toReturn.item;
    }
}
