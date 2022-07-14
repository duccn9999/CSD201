/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class HashTable {

    MyList[] a;
    int M;

    public HashTable() {
        M = 11;
        a = new MyList[M];
        for (int i = 0; i < M; i++) {
            a[i] = new MyList();
        }
    }

    boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < M; i++) {
            if (!a[i].isEmpty()) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    void clear() {
        for (int i = 0; i < M; i++) {
            a[i].head = a[i].tail = null;
        }
    }

    void add(int x) {
        int i = x % M;
        a[i].add(x);
    }

    void traverse() {
        if (isEmpty()) {
            System.out.println("hash table is empty");
            return;
        }
        for (int i = 0; i < M; i++) {
            System.out.print(" Linked List at " + i + ": ");
            a[i].traverse();
        }
        System.out.println();
    }

    Node search(int x) {
        int i = x % M;
        return a[i].search(x);
    }

    void delete(int x) {
        int i = x % M;
        a[i].delete(x);
    }

    void addArray(int[] b) {
        int i, n;
        n = b.length;
        for (i = 0; i < n; i++) {
            add(b[i]);
        }
    }

    void addRandom() {
        int n, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = Integer.parseInt(sc.nextLine());
        Random rd = new Random();
        clear();
        for (int i = 0; i < n; i++) {
            x = rd.nextInt(100); // choose value 0 - 99
            add(x);
        }
    }
}
