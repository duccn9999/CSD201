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
public class BSTree {

    /**
     * @param args the command line arguments
     */
    Node root;

    public BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    Node Search(Node p, int x) { // tim dia chi node co noi dung la x
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (x < p.info) {
            return (Search(p.left, x));
        } else {
            return (Search(p.right, x));
        }
    }

    void insert(int x) { // chen node co noi dung la x vao ca^y
        Node q = new Node(x);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) { // neu x da ton tai thi ko chen nua
                System.out.println(" The key " + x + " already exist, no insertion");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;// di xuong cay con trai de tim node cha cua node muon chen
            } else {
                p = p.right; // di xuong cay con phai de tim node cha cua node muon chen
            }
        }
        if (x < f.info) { //Neu x < con cua Node cha thi chen vao ben trai
            f.left = q;
        } else { // neu x > con cua Node cha thi chen vao ben phai
            f.right = q;
        }
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print("  " + p.info);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);

    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void addArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(new Integer(a[i]));
        }
    }
}// end class BSTree
