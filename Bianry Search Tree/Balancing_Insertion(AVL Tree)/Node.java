/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balancing_Insertion;

/**
 *
 * @author bbbvv
 */
public class Node {
    int infor;
    int bal;
    Node left;
    Node right;

    public Node(int x) {
        infor = x;
        left = right = null;
        bal = 0;
    }
    
    
}
