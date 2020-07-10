package com.zdq;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ZTwoCycleLinkedList<Integer> list = new ZTwoCycleLinkedList<>();
        for (int i = 1; i < 9; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("---------------");
        list.reset();
        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }

    static void test() {
        ZList<Integer> list = new ZLinkedList<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        System.out.print(list);
    }
//    链表反转
    static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

//    1,2,3,4,5,6,7; m = 2; n = 6
    public void reverseList(ListNode head,int m, int n) {

        for (int i = m; i < n; i++) {
        }

    }

    public boolean listHasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return  true;
        }
        return false;
    }

    //获取相遇节点
    public ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return  null;
    }
    //获取环的入口节点
    public ListNode getEntrance(ListNode head) {
        if (head == null) return null;
        ListNode node = getIntersect(head);//相遇点
        if (node == null) return null;
        ListNode left = head;
        ListNode right = node;
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

}