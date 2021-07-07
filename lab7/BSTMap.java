
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;
    private Set<K> keySet;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BSTMap() {
        keySet = new HashSet<>();
    }

    @Override
    public void clear() {
        this.root.size = 0;
        this.root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node n, K key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (n == null) return null;
        int cmp = key.compareTo(n.key);
        if (cmp < 0) return get(n.left, key);
        else if (cmp > 0) return get(n.right, key);
        else return n.value;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) return 0;
        return n.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        this.root = put(root, key, value);
    }

    private Node put(Node n, K key, V val) {
        if (n == null) {
            keySet.add(key);
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) n.left = put(n.left, key, val);
        else if (cmp > 0) n.right = put(n.right, key, val);
        else n.value = val;
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }



    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }


    public void printInOrder() {

    }

    private class BSTMapIterator implements Iterator<K> {
        private int pointer;

        public BSTMapIterator() {
            pointer = 0;
        }

        @Override
        public boolean hasNext() {
            return pointer < size();
        }

        @Override
        public K next() {
            K toReturn = ;
            pointer ++;
            return toReturn;
        }
    }
}
