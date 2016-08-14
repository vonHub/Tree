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
public class Node<T> {
    
    private T first = null;
    private T second = null;
    
    private Node left = null;
    private Node center = null;
    private Node right = null;
    private Node parent = null;
    
    public T getFirst() {return first;}
    public T getSecond() {return second;}
    public Node getLeft() {return left;}
    public Node getCenter() {return center;}
    public Node getRight() {return right;}
    public Node getParent() {return parent;}
    
    public void setFirst(T in) {first = in;}
    public void setSecond(T in) {second = in;}
    public void setLeft(Node<T> in) {left = in;}
    public void setCenter(Node<T> in) {center = in;}
    public void setRight(Node<T> in) {right = in;}
    public void setParent(Node<T> in) {parent = in;}
    
    
    public Node(T in) {
        first = in;
    }
    
    public boolean isThreeNode() {
        return second != null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int compareTo(Node<T> n) {
        if (((Comparable)getFirst()).compareTo(n.getFirst()) < 0) return -1;
        if (((Comparable)getFirst()).compareTo(n.getFirst()) == 0) return 0;
        if (n.getSecond() != null) {
            if (((Comparable)getFirst()).compareTo(n.getSecond()) == 0) return 0;
            if (((Comparable)getFirst()).compareTo(n.getFirst()) > 0 &&
                    ((Comparable)getFirst()).compareTo(n.getSecond()) < 0) return 0;
        }
        return 1;
    }
    
    public boolean equals(Node<T> n) {
        
        // Checks to see if parent is the same node
        if (getParent() != n.getParent()) return false;
        
        // Checks if contents are both null or both not null
        if (getFirst() != null && n.getFirst() == null ||
                getFirst() == null && n.getFirst() != null) {
            return false;
        }
        if (getSecond() != null && n.getSecond() == null ||
                getSecond() == null && n.getSecond() != null) {
            return false;
        }
        
        // Compares contents
        if (getFirst() != null) {
            T mine = getFirst();
            T other = n.getFirst();
            if (((Comparable)mine).compareTo(other) != 0) return false;
            
        }
        if (getSecond() != null) {
            T mine = getSecond();
            T other = n.getSecond();
            if (((Comparable)mine).compareTo(other) != 0) return false;
        }
        
        return true;
    }
    
}
