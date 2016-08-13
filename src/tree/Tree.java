/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tree;

import java.util.Random;

/**
 *
 * @author Christopher
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
    
    // TODO finish this method
    public void remove(T in) {
        Node n = find(in);
        if (n == null) return;
        Node p = n.getParent();
        Node l = n.getLeft();
        Node r = n.getRight();
        if (p == null) {    // root node
            root = l;
        } else {
            // Connect nodes beneath n to parent node
            /*
            Left node deleted:
            go one left
            go all the way to the right
            last node to the right is the one to replace
            just hoist up any tree connected to it to previously
            occupied spot
            */
            if (n.compareTo(p) < 0) {   // n is left of parent
                
            } else {    // node is right of parent
                
            }
        }
    }
    
    /**
     * @param n node with null contents
    */
    public void rebalanceTree(Node<T> n) {
        Node l = n.getLeft();
        Node r = n.getRight();
        if (l == null && r == null) return;
        if (l == null || randy.nextBoolean()) {
            n.setFirst((T)(r.getFirst()));
            n.setSecond((T)(r.getSecond()));
            r.setFirst(null);
            r.setSecond(null);
            rebalanceTree(r);
        } else {
            n.setFirst((T)(l.getFirst()));
            n.setSecond((T)(l.getSecond()));
            l.setFirst(null);
            l.setSecond(null);
            rebalanceTree(l);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Tree<Integer> t = new Tree();
        t.insert(3);
        t.insert(5);
        t.insert(1);
    }
    
}
