package com.zdq;

import java.util.Comparator;

import com.zdq.file.Files;
import com.zdq.printer.BinaryTreeInfo;
import com.zdq.printer.BinaryTrees;
import com.zdq.tree.BST;
import com.zdq.tree.BinaryTree;
import com.zdq.tree.BinaryTree.Visitor;

@SuppressWarnings("unused")
public class Main {

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
	
	public static void main(String[] args) {
		test1();
	}
}
