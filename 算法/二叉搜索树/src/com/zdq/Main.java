package com.zdq;
import com.zdq.printer.BinaryTrees;
import com.zdq.BinarySearchTree.Visitor;

public class Main {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1,6,10,20,25,33
        };

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        BinaryTrees.println(bst1);
        System.out.println("---------------------");
        bst1.postorderTraversal(new Visitor<Person>() {
            @Override
            boolean visitor(Person element) {
                System.out.print(element + ",");
                return false;
            }
        });
        System.out.println();
        System.out.println("---------------------");
        bst1.levelOrder(new Visitor<Person>() {
            @Override
            boolean visitor(Person element) {
                System.out.print(element + ",");
                if (element.getAge() == 8) return true;
                return false;
            }
        });
        System.out.println("---------------------");
        System.out.println(bst1.height());
        System.out.println(bst1.height2());
    }
}
