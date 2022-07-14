/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal.algorithm;

import java.util.LinkedList;

/**
 *
 * @author bbbvv
 */
public class MyStack {

    LinkedList<Integer> t;

    public MyStack() {
        t = new LinkedList<Integer>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return t.isEmpty();
    }

    void push(Integer x) {
        t.addFirst(x);
    }

    Integer pop() {
        if (isEmpty()) {
            return null;
        }
        return t.removeFirst();
    }

    Integer top() {
        if (isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
}
