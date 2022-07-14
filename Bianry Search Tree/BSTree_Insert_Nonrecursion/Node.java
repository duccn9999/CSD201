/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author bbbvv
 */
public class Node {

    int info;
    Node left, right;

    public Node(int x) {
        this.info = x;
        left = right = null;
    }

}
