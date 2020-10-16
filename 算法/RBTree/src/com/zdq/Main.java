package com.zdq;
import com.zdq.printer.BinaryTrees;
import com.zdq.tree.AVLTree;
import com.zdq.tree.BST;
import com.zdq.tree.BinaryTree;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		test2();
	}

	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BST<Integer> bst = new BST<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		bst.remove(7);
		
		BinaryTrees.println(bst);
	}

	static void test2() {
		Integer data[] = new Integer[] {
				67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
		};

		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.println(avl);
	}
	
}
