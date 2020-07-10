package com.zdq;

//反转链表
class Solution {
    private boolean stop;
    private ListNode left;
    private int count;

    private ListNode successor;

    public void recurseAndReverse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;
        if (m > 1) {
            this.left = this.left.next;
        }
        this.recurseAndReverse(right, m - 1, n - 1);

        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if (!this.stop) {
            System.out.println("第"+ count +"次;"+ "left:" + left.val + ",right:" + right.val);
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }
        count++;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
            // Empty list
            if (head == null) {
                return null;
            }
            ListNode cur = head, prev = null;
            while (m > 1) {
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }
            ListNode con = prev, tail = cur;
            ListNode third = null;
            while (n > 0) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
                n--;
            }

            ListNode temp = prev;
            while (temp != null){
                System.out.println(temp.val);
                temp = temp.next;
            }

            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }

            tail.next = cur;
            return head;
        }


    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween3(head.next, m - 1, n - 1);
        return head;
    }
    // 第四种解法,头插法
    public ListNode reverseBetween4(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}

