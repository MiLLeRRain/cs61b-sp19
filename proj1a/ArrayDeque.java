// 25% usage factor for length >= 16
// no usage limit for length < 16
// starting length 8
// resize up and down
// 添加时，添加前进行检查是否需要up size ×2
// 删除时，删除后进行检查是否需要down size /2

public class ArrayDeque<T> {
    private int size;
    private int nextFirst = 7;
    private int nextLast = 0;
    private T[] items;
    private double usageRate;

    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    /**
     * Creates a deep copy of 'other'.
     * @param other
     */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        nextFirst = minusByOne(other.nextLast);
        for (int i = other.size-1; i >= 0; i--) {
            addFirst((T) other.get(i));
        }
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
    }

    /**
     * 每次add前检查resizeCheck()，每次remove后检查resizeCheck()
     * resize时需要将nextFirst和nextLast重置，分upsize和downsize两种情况
     */
    public void resizeCheck(){
        usageRate = (double)size/items.length;
        if (items.length > 16 && usageRate == 0.25) {downsize();}
        else if (usageRate == 1) {upsize();}
    }

    /**
     * Upsize by length*2
     * 继承上一个items的size和所有item，用deep copy？
     * Update nextFirst and nextLast pointer
     * nextFirst = items.length-1; //放置于新array的尾部
     * nextLast = items.length/2; //放置于新array的中间部位
     */
    private void upsize() {
        T[] temp = (T[]) new Object[size*2];
        for (int i = 0; i < size; i++) {
            temp[i] = get(i);
        }
        items = temp;
        nextFirst = items.length-1;
        nextLast = items.length/2;
    }

    /**
     * Downsize by length/2
     * Update nextFirst and nextLast pointer
     * nextFirst = items.length-1; place at the end of this array.
     * nextLast = items.length/2; place at the mid of this array.
     */
    private void downsize() {
        T[] temp = (T[]) new Object[items.length/2];
        int i = 0;
        int indexToAdd = nextFirst+1;
        while (i < size) {
            if (indexToAdd == items.length) {
                indexToAdd = 0;
            }
            temp[i] = items[indexToAdd];;
            indexToAdd++;
            i++;
        }
        items = temp;
        nextFirst = items.length-1;
        nextLast = items.length/2;
    }

    private int plusByOne(int index){
        index++;
        if (index == items.length) index = 0;
        return index;
    }

    private int minusByOne(int index){
        index--;
        if (index < 0) index = items.length;
        return index;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item) {
        resizeCheck();
        items[nextFirst] = item;
        nextFirst = minusByOne(nextFirst);
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item) {
        resizeCheck();
        items[nextLast] = item;
        nextLast = plusByOne(nextLast);
        size++;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {
        if (!isEmpty()) {
            T toReturn;
            int idxToRemove = plusByOne(nextFirst);
            toReturn = items[idxToRemove];
            nextFirst = idxToRemove;
            items[idxToRemove] = null;
            size--;
            resizeCheck();
            return toReturn;
        }
        return null;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeLast() {
        if (!isEmpty()) {
            T toReturn;
            int idxToRemove = minusByOne(nextLast);
            toReturn = items[idxToRemove];
            nextLast = idxToRemove;
            items[idxToRemove] = null;
            size--;
            resizeCheck();
            return toReturn;
        }
        return null;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    /**
     * Returns the numbers of items in the deque.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int i = 0;
        while (i<size) {
            System.out.print(this.get(i)+" ");
            i++;
        }
        System.out.println("- End of Array.");
        System.out.println("--------------");
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * 需要注意是否为resize之后的index, 此时的0位应该是nextFirst指针+1, 但是需要换位到array[0]
     * @param index
     * @return
     */
    public T get(int index) {
        if (isEmpty() || index < 0 || index > size-1) return null;
        T toReturn;
        int idxToReturn = nextFirst+1+index;
        if (idxToReturn > items.length - 1){
            idxToReturn = idxToReturn - items.length;
        }
        toReturn = items[idxToReturn];
        return toReturn;
    }

    public T[] getItems(){
        return items;
    }

}
