package com.zdq;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(2);
        ListNode head6 = new ListNode(1);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

//        ListNode temp = head;
//        while (temp != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
        ListNode temp = removeDuplicateNodes(head);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    //删除链表中重复的元素，并保证链表顺序
    static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode temp = head;
        while (temp.next != null){
            if (set.add(temp.next.val)) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        temp.next = null;
        return  head;
    }
}
