package com.zdq;
import com.zdq.printer.BinaryTrees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Test {
    public static void main(String[] args) {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree1<Integer> bst1 = new BinarySearchTree1<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(data[i]);
        }

        BinaryTrees.println(bst1);
        System.out.println("---------------------");
        System.out.println(bst1.inorderTraversal());
    }
//    前序遍历
    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return arrayList;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                arrayList.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return arrayList;
    }
//    中序遍历
    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }
//    后序遍历

}
