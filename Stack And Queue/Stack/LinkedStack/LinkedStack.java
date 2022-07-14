/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedstack;

import java.util.EmptyStackException;

/**
 *
 * @author bbbvv
 */
public class LinkedStack {
    
    protected Node head;

    public LinkedStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    public Object top() throws EmptyStackException { //Take the topmost element from the stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (head.info);
    }
    
    public Object pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        
        Object x = head.info;
        head = head.next;
        return x;
    }
    
    public void displayAll(){
        System.out.println("Elements in the list are:");
        for(Node p = head; p != null; p=p.next){
            System.out.print(p.info+" ");
        }
        System.out.println();
    }

}
