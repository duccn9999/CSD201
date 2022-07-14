/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamilton.cycle;

import java.util.LinkedList;

/**
 *
 * @author bbbvv
 */
public class MyStack {
    LinkedList a;

    public MyStack() {
        a = new LinkedList();
    }
    boolean isEmpty(){
        return a.isEmpty();
    }
    
    void push(Object x){
        a.add(x);
    }
    
    Object pop(){
        if(isEmpty()){
            return null;
        }
        return a.removeLast();
    }
    
    Object viewTop(){
        if(isEmpty()){
            return null;
        }
        return a.getLast();
    }
}
