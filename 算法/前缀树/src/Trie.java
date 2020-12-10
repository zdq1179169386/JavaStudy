import java.util.HashMap;

public class Trie<V> {
    private int size;
    private Node<V> root;

    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        size = 0;
    }
    public V get(String key) {
        return null;
    }
    public boolean contains(String key) {
        return false;
    }
    public V add(String key,V value) {
        return null;
    }
    public V remove(String key) {
        return null;
    }
    public boolean startsWith(String prefix) {
        return false;
    }
    //节点
    private static class Node<V> {
        HashMap<Character,Node<V>> children;
        V value;
        boolean word;//是否为单词的结尾
    }
}
