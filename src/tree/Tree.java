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
    
    public void insert(T in) {
        insert(in, root);
    }
    
    public void insert(T in, Node s) {
        if (s.getFirst() == null) {
            s.setFirst(in);
            Node left = new Node(null);
            Node right = new Node(null);
            s.setLeft(left);
            s.setRight(right);
            left.setParent(s);
            right.setParent(s);
        } else {
            if (((Comparable)in).compareTo(s.getFirst()) < 0) {
                insert(in, s.getLeft());
            } else if (((Comparable)in).compareTo(s.getFirst()) > 0) {
                insert(in, s.getRight());
            } else {
                // Error: node already in tree
            }
        }
    }
    
    public void remove(T in) {
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Tree<Integer> t = new Tree();
        t.insert(3);
        t.insert(5);
        t.insert(1);
    }
    
}
