/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst_insert_recursion;

/**
 *
 * @author bbbvv
 */
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    Node Insert(Node p, int x) { // chen Node co noi dung la x vao cay
        if (p == null) {
            p = new Node(x); // tao node moi co noi dung la x, cho node do lam root
            return p;
        }
        if (x < p.info) { // noi dung cua node > x thi chen x vao ben trai
            p.left = Insert(p.left, x);
        } else if (x > p.info) { // neu ko thi chen vao ben phai
            p.right = Insert(p.right, x);
        } else { // neu node ton tai roi thi ko insert nua
            System.out.println(" The key " + x + " already exists, no insertion");
        }
        return p;
    }

    void Insert(int x) {
        root = Insert(root, x);
    }

    void visit(Node p) {// visit node p ( in ra noi dung cua p )
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
            Insert(a[i]);
        }
    }

}
