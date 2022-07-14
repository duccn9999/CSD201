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
public class BSTree_Insert_Nonrecursion {

    public static void main(String[] args) {
        BSTree t = new BSTree();
        System.out.println("\n After inserting 3, 5, 1, 5, 9, 8, 10: ");
        int[] a = {3, 5, 1, 5, 9, 8, 10};
        t.addArray(a);
        System.out.println("\nPre-Order tranverse:");
        t.preOrder(t.root);
        System.out.println("\nIn-Order tranverse:");
        t.inOrder(t.root);
        System.out.println("\nPost-Order tranverse:");
        t.postOrder(t.root);
        System.out.println();
    }
}
