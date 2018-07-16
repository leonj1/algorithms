package com.jose.algos.models.btree;

import java.util.Stack;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class Tree {
    private Node root;
    private String delimiter;

    public Tree() {
        this.root = new Node("/");
        this.delimiter = "/";
    }

    public boolean mkdir(String path) {
        return this.root.mkdir(toStack(path));
    }

    public boolean mkdirs(String path) {
        return this.root.mkdirs(toStack(path));
    }

    public boolean removePath(String path) {
        return this.root.removePath(toStack(path));
    }

    public boolean exists(String path) {
        return this.root.exists(toStack(path));
    }

    public Node getPath(String path) {
        if("/".equals(path)) {
            return this.root;
        }
        return this.root.getPath(toStack(path));
    }

    public boolean rename(String path, String name) {
        Node n = getPath(path);
        if (null == n) {
            return false;
        }
        n.name(name);
        return true;
    }

    // privates

    public Stack<String> toStack(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<String>();
        // starting with 1 since I expect split("/") to make the first element blank
        for(int i=arr.length-1; i>0; i--) {
            stack.push(arr[i]);
        }
        return stack;
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
