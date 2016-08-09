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
    public void setLeft(Node in) {left = in;}
    public void setCenter(Node in) {center = in;}
    public void setRight(Node in) {right = in;}
    public void setParent(Node in) {parent = in;}
    
    
    public Node(T in) {
        first = in;
    }
    
}
