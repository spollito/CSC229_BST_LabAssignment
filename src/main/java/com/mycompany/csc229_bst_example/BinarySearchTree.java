package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */

import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {
        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal
        if (root != null) {
            doInOrder(root.getLeft()); // visit the left subtree
            System.out.print(root.getData() + " "); // go through current nodes data
            doInOrder(root.getRight()); // visit the right subtree
        }
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order traversal .
    }
        // visits the root first then the left subtree followed by the right subtree
    private void doPreOrder(BstNode root) {
        if (root != null) {
            System.out.print(root.getData() + " "); // current nodes data
            doPreOrder(root.getLeft()); // visit left subtree
            doPreOrder(root.getRight()); // visit right subtree
        }
    }

    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        return getHeight(this.root);
    }

    private Integer getHeight(BstNode root) {
        if (root == null) {
            return -1; // The height of an empty tree is -1
        }
        // returning plus 1 the max height of the left and right subtree
        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public int getDepth(BstNode node) {
        // ToDo 4: complete getDepth of a node
        return findDepth(this.root, node, 0);
    }

    private int findDepth(BstNode root, BstNode node, int depth) {
        if (root == null) return -1;
        if (root == node) return depth;

        int left = findDepth(root.getLeft(), node, depth + 1);
        if (left != -1) return left;

        return findDepth(root.getRight(), node, depth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        printTree("", this.root, false);
        // ToDo 5: complete the print of the BST
    }

    private void printTree(String prefix, BstNode node, boolean isRight) {
        if (node != null) {
            System.out.println(prefix + (isRight ? "├── " : "└── ") + node.getData());
            // print right subtree with updated prefix
            printTree(prefix + (isRight ? "│   " : "    "), node.getRight(), true);
            // print left subtree with updated prefix
            printTree(prefix + (isRight ? "│   " : "    "), node.getLeft(), false);
        }
    }
}



