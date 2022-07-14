/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst_delete_copying;

/**
 *
 * @author bbbvv
 */
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void Insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                System.out.println(" The key " + x + " already exists, no insertion");
                return;
            }
            // x nho hon thi sang trai, lon hon thi sang phai
            if (x < p.info) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void CopyDelete(int x) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                break; // found key x
            }
            if (x < p.info) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + x + " does not exists, no deletion");
            return;
        }
        // delete a leaf
        if (p.left == null && p.right == null) { // p is a leaf
            // becasue in this function f is father of p, if p is a leaf then we just let
            // f.left or f.right point to null
            if (f == null) { // the tree is one node
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }


        //p chi co 1 con
        //b1: xac dinh cha cua p
        //b2: noi cha cua p voi con cua p
        if (p.left != null && p.right == null) { 
            if (f == null) { 
                root = p.left;
            } else {
                if (f.left == p) { // p is a left child
                    f.left = p.left; // noi cha cua p voi con cua p
                } else {
                    f.right = p.right; // noi cha cua p voi con cua p
                }
            }
            return;
        }

        if (p.left == null && p.right != null) { 
            if (f == null) { 
                root = p.right;
            } else {
                if (f.left == p) { // p is a left child
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) { // p has both left and right childs
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            //q = p.left;
            rp = p.left;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right;
            } // find the right most node on the left sub-tree then swap with the node you want to delete
            p.info = rp.info;
            if (fr == null) { // rp is just a left son of p
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        } 

    }
    // =================

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(" " + p.info);
    }

    void preOrder(Node p) { // Node -> L -> R
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) { // Node L -> Node -> R
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
        
    }


    void postOrder(Node p) { // L -> R -> Node
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
