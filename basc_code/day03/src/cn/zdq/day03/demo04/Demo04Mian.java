package cn.zdq.day03.demo04;

public class Demo04Mian {
    public static void main(String[] args) {
        /*
       1, collections: 顶层接口,单列集合
       2, List 和 Set
       List: 有序,有索引，可以重复元素
       Set: 无序，无索引，不能有重复元素
       List:
        ArrayList 和 LinkedList 对比：
         ArrayList（动态数组），删除慢，遍历快
        LinkedList（链表）, 删除快，遍历慢

       ArrayList 和 Vector
       ArrayList是线程不安全的，Vector是线程安全的。
        2.Vector的性能比ArrayList差。

        * */

        /*
        HashSet: 哈希表，查找快，无序, 底层是HashMap ，只用了 HashMap  的key
        TreeSet： 树结构，通常用于排序
        LinkedHashSet: HashSet 的子类，但是有序的，底层是通过链表来保证元素顺序的，性能比HashSet 差点，
        当经常插入排序或使用删除、插入及遍历操作时，使用LinkedHashSet。
        * */
    }
}
