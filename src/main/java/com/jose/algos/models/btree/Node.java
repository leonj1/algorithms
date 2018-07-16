package com.jose.algos.models.btree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class Node {
    private String name;
    private String contents;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Node(String name, String contents) {
        this(name);
        this.contents = contents;
    }

    public boolean mkdir(Stack<String> path) {
        return mkdir(path, false);
    }

    public boolean mkdirs(Stack<String> path) {
        return mkdir(path, true);
    }

    private boolean mkdir(Stack<String> path, boolean create) {
        if(path.size() == 0) {
            return false;
        }
        String line = path.pop();
        if(line.equals(this.name)) {
            return mkdir(path);
        }
        if(!create && path.size() > 0) {
            // this means current node is not the expected folder, and there are more folders
            // in the path, therefore the path is invalid
            // and since this is mkdir, we are not going to recursively create paths
            return false;
        }
        Node created = new Node(line);
        this.children.add(created);
        if(path.size() == 0) {
            return true;
        }
        return created.mkdir(path, create);
    }

    public boolean removePath(Stack<String> path) {
        if(path.size() == 0) {
            return false;
        }
        String line = path.pop();
        Iterator<Node> itr = this.children.iterator();
        while(itr.hasNext()) {
            Node child = itr.next();
            if(child.name.equals(line)) {
                if(path.size() == 0) {
                    itr.remove();
                    return true;
                } else {
                    return child.removePath(path);
                }
            }
        }
        return false;
    }

    public boolean exists(Stack<String> path) {
        if(path.size() == 0) {
            return false;
        }
        String line = path.pop();
        for (Node child : this.children) {
            if (child.name.equals(line)) {
                if (path.size() == 0) {
                    return true;
                } else {
                    return child.exists(path);
                }
            }
        }
        return false;
    }

    public Node getPath(Stack<String> path) {
        if(path.size() == 0) {
            return null;
        }
        String line = path.pop();
        for (Node child : this.children) {
            if (child.name.equals(line)) {
                if (path.size() == 0) {
                    return child;
                } else {
                    return child.getPath(path);
                }
            }
        }
        return null;
    }

    //getters + setters

    public List<Node> children() {
        return this.children;
    }

    public String name() {
        return this.name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String contents() {
        return this.contents;
    }

    public void contents(String contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(contents, node.contents) &&
                Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contents, children);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for(Node n : children) {
            sj.add(n.toString());
        }
        StringJoiner main = new StringJoiner(",");
        if(name != null) {
            main.add("\"name\" : \"" + name + "\"");
        }
        if(contents != null) {
            main.add("\"contents\" : \"" + contents + "\"");
        }
        main.add("\"children\" : [" + sj.toString() + "]");
        return "{" + main.toString() + "}";
    }
}
