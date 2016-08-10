/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tree;

/**
 *
 * @author Christopher
 */
public class Tree<T> {

    Node root = new Node(null);
    
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
