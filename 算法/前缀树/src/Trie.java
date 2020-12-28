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
        root = null;
    }
    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.word ? node.value : null;
    }
    public boolean contains(String key) {
        Node<V> node = node(key);
        return node != null && node.word;
    }
    public V add(String key,V value) {
        keyCheck(key);
        if (root == null) {
            root = new Node<>(null);
        }
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            //子节点
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);
            if (childNode == null) {
                //子节点为空，创建新的子节点，添加到父节点的 map 中去
                childNode = new Node<>(node);
                childNode.character = c;
                node.children = emptyChildren ? new HashMap<>() : node.children;
                node.children.put(c,childNode);
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
        Node<V> node = node(key);
        if (node == null || !node.word) return  null;
        size--;
        V old = node.value;
        //如果有子节点
        if (node.children != null && !node.children.isEmpty()){
            node.word = false;
            node.value = null;
            return old;
        }
        //如果没有子节点
        Node<V> parent = null;
        while ((parent = node.parent) != null) {
            parent.children.remove(node.character);
            if (parent.word || !parent.children.isEmpty()) break;
            node = parent;
        }
        return old;
    }
    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }
    //根据 key 获取节点
    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) return null;
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }
    // key 是否为空
    private void keyCheck(String key) {
        if (key == null || key.length() == 0){
            throw new IllegalArgumentException("key must not be empty");
        }
    }
    //节点
    private static class Node<V> {
        Node<V> parent;//父节点
        Character character;//对应的字符
        HashMap<Character,Node<V>> children;
        V value;
        boolean word;//是否为单词的结尾

        public Node(Node<V> parent) {
            this.parent = parent;
        }
    }
}
