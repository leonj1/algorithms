package com.jose.algos.models.tree;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isBalanced(Node n) {
        return balancedHeight(n) > -1;
    }

    public int balancedHeight(Node n) {
        if(n == null) return 0;
        int h1 = balancedHeight(n.left);
        int h2 = balancedHeight(n.right);

        if (h1 == -1 || h2 == -1) return -1;
        if(Math.abs(h1 - h2) > 1) return -1;
        if (h1 > h2) return h1 + 1;
        return h2 + 1;
    }

    // getters + setters

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
