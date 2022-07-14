/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balancing_Insertion;

import Balancing_Insertion.AVLTree;

/**
 *
 * @author bbbvv
 */
public class AVLinsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AVLTree t = new AVLTree();
        int[] a = {4, 3, 1, 11, 5, 8, 2, 6, 15, 12};
        t.addArray(a);
        System.out.println("\nPre-Order traverse: ");
        t.preOrder(t.root);
        System.out.println("\nIn-Order traverse: ");
        t.inOrder(t.root);
        System.out.println("\nBreadth first traverse: ");
        t.breadthTraverse();
        System.out.println();
    }

}
