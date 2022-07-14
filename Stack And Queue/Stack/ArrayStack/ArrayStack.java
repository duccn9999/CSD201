/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraystack;

import java.util.*;

/**
 *
 * @author bbbvv
 */
public class ArrayStack {

    protected Object[] a;
    int top, max;

    public ArrayStack() {
        this(50);
    }

    public ArrayStack(int max1) {
        max = max1;
        a = new Object[max];
        top = -1;
    }

    protected boolean grow() {
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return (false);
        }
        for (int i = 0; i <= top; i++) {
            a1[i] = a[i];
        }
        a = a1;
        return (true);
    }

    public boolean isEmpty() { //Check to see if the stack is empty
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void clear() { //Clear the stack
        top = -1;
    }

    public void push(Object x) { //Put the element "el" on the top of the stack
        if (isFull() && !grow()) {
            return;
        }
        a[++top] = x;
    }

    Object top() throws EmptyStackException { //Return the topmost element in the stack without removing it
        if (isEmpty()) throw new EmptyStackException();
        return (a[top]);
    }

    public Object pop() throws EmptyStackException { //Take the topmost element from the stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = a[top];
        top--;
        return x;
    }
    
    public void displayAll(){
        System.out.println("Elements in the list are:");
        for (int i = 0; i <= top; i++) System.out.print(a[i]+" ");
        System.out.println();
    }
}


    
