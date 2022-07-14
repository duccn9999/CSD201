/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EulerCycle;

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

    void push(int x) {
        t.addLast(x);
    }

    Integer pop() {
        if (isEmpty()) {
            return null;
        }
        return t.removeLast();
    }

    Integer top() {
        if (isEmpty()) {
            return null;
        }
        return t.getLast();
    }
}
