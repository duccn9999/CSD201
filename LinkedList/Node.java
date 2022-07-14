/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author bbbvv
 */
public class Node {

    Person info;
    Node next;

    public Node() {
    }

    public Node(Person x, Node q) {
        info = x;
        next = q;
    }

    public Node(Person x) {
        this(x, null);
    }

}
