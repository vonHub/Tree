/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tree;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Christopher Von Hoene
 */
public class Tree<T> {

    Node root = new Node(null);
    static Random randy = new Random();
    
    public Tree() {
        
    }
    
    public Node find(T in) {
        Node n = root;
        while (n.getFirst() != null && 
                ((Comparable)in).compareTo(n.getFirst()) != 0) {
            
            if (((Comparable)in).compareTo(n.getFirst()) < 0) {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        
        }
        if (n.getFirst() == null) return null;
        return n;
    }
    
    public void insert(T[] in) {
        for (T item: in) {
            insert(item);
        }
    }
    
    public void insert(T in) {
        insert(in, root, null);
    }
    
    public void insert(T in, Node s, Node p) {
        if (s.getFirst() == null) {
            s.setFirst(in);
            s.setParent(p);
            Node left = new Node(null);
            Node right = new Node(null);
            s.setLeft(left);
            s.setRight(right);
            left.setParent(s);
            right.setParent(s);
        } else {
            if (((Comparable)in).compareTo(s.getFirst()) < 0) {
                insert(in, s.getLeft(), s);
            } else if (((Comparable)in).compareTo(s.getFirst()) > 0) {
                insert(in, s.getRight(), s);
            } else {
                // Error: node already in tree
            }
        }
    }
    
    public void remove(T[] in) {
        for (T item: in) {
            remove(item);
        }
    }
    
    public void remove(T in) {
        Node n = find(in);
        if (n == null) return;
        n.setFirst(null);
        rebalanceTree(n);
    }
    
    /**
     * @param n node with null contents
    */
    public void rebalanceTree(Node<T> n) {
        Node l = n.getLeft();
        Node r = n.getRight();
        if (l == null && r == null) return;
        if (l == null || randy.nextBoolean()) {
            if (r.isEmpty()) {  // Dead leaf--only one layer of these
                n.setRight(null);
            }
            n.setFirst((T)(r.getFirst()));
            n.setSecond((T)(r.getSecond()));            
            r.setFirst(null);
            r.setSecond(null);
            rebalanceTree(r);
        } else {
            if (l.isEmpty()) {  // Dead leaf--only one layer of these
                n.setLeft(null);
            }
            n.setFirst((T)(l.getFirst()));
            n.setSecond((T)(l.getSecond()));
            l.setFirst(null);
            l.setSecond(null);
            rebalanceTree(l);
        }
    }
    
    public ArrayList<Node> getChildren(ArrayList<Node> a) {
        ArrayList<Node> children = new ArrayList();
        for (Node n: a) {
            Node l = n.getLeft();
            Node c = n.getCenter();
            Node r = n.getRight();
            if (l != null && !l.isEmpty() && !children.contains(l)) {
                children.add(l);
            }
            if (c != null && !c.isEmpty() && !children.contains(c)) {
                children.add(c);
            }
            if (r != null && !r.isEmpty() && !children.contains(r)) {
                children.add(r);
            }
        }
        return children;
    }
    
    public void print() {
        ArrayList<Node> layer = new ArrayList();
        layer.add(root);
        while (!layer.isEmpty()) {
            for (Node n: layer) {
                if (n.getFirst() != null) {
                    System.out.print(n.getFirst() + " ");
                }
            }
            System.out.println();
            layer = getChildren(layer);
        }
    }
    
    public static void main(String[] args) {
        Tree<Integer> t = new Tree();
        Integer[] items = {3, 1, 2, 0, 5, 4, 6};
        t.insert(items);
        Integer[] removed = {2, 4};
        t.remove(removed);
        t.insert(13);
        t.print();
    }
    
}
