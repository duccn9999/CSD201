package bst_insert_recursion;

/**
 *
 * @author bbbvv
 */
public class BST_Insert_Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree t = new BSTree();
        System.out.println("\n After inserting 3, 5, 1, 5, 9, 8, 10: ");
        int[] a = { 3, 5, 1, 5, 9, 8, 10 };
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
