import java.util.HashMap;

public class Trie<V> {
    private int size;
    private Node<V> root = new Node<>();

    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        size = 0;
        root.getChildren().clear();
    }
    public V get(String key) {
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }
    public boolean contains(String key) {
        return node(key) != null;
    }
    public V add(String key,V value) {
        keyCheck(key);

        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            //子节点
            Node<V> childNode = node.getChildren().get(key);
            if (childNode == null) {
                //子节点为空，创建新的子节点，添加到父节点的 map 中去
                childNode = new Node<>();
                node.getChildren().put(c,childNode);
            }
            node = childNode;
        }
        if (node.word){
            //已经存在这个单词
            V old = node.value;
            node.value = value;
            return old;
        }
        //新增一个单词
        node.word = true;
        node.value = value;
        return null;
    }
    public V remove(String key) {
        return null;
    }
    public boolean startsWith(String prefix) {
        keyCheck(prefix);

        Node<V> node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            node = node.getChildren().get(c);
            if (node == null) return false;
        }
        return true;
    }
    //根据 key 获取节点
    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            node = node.getChildren().get(c);
            if (node == null) return null;
        }
        //是否是一个完整的单词
        return node.word ? node : null;
    }
    // key 是否为空
    private void keyCheck(String key) {
        if (key == null || key.length() == 0){
            throw new IllegalArgumentException("key must not be empty");
        }
    }
    //节点
    private static class Node<V> {
        HashMap<Character,Node<V>> children;
        V value;
        boolean word;//是否为单词的结尾
        //防止 children 为空
        public HashMap<Character,Node<V>> getChildren() {
            return children == null ? (children = new HashMap<>()) : children;
        }
    }
}
