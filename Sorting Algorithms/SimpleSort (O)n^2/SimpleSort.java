/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarysort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class SimpleSort {

    int[] a;
    int n;

    public SimpleSort() {
    }

    public SimpleSort(int[] b) {
        int i;
        n = b.length;
        a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void setData(int[] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < 10; i++) {
            a[i] = b[i];
        }
    }

    void setRandom() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n = ");
        n = sc.nextInt();
        a = new int[n];
        //create a random number generator
        // seeds with current time by default
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            a[i] = rd.nextInt(100); // choose value from 0 - 99
        }
    }

    void Display() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    //=============
    boolean sorted() {
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //============================
    void swap(int i, int k) {
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }

    //============================
    void SelectionSort() { // simple selection sort
        int min;
        int k;
        for (int i = 0; i < n - 1; i++) {
            min = a[i];
            k = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    k = j;
                    min = a[j];
                }
                if (k != i) {
                    swap(i, k);
                }
            }
        }
    }

    void SelectionSort2() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    swap(i, j); // nho hon la doi cho ngay
                }
            }
        }
    }

    void BubbleSort() {
        boolean doicho;
        do {
            doicho = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    doicho = true;
                }
            }
        } while (doicho); // neu gap vong for ko phai doi cho lan nao thi dung ngay
    }

    //=======================
    void BubbleSort2() {
        boolean doicho;
        int k = 1;
        do {
            doicho = false;
            for (int i = 0; i < n - k; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    doicho = true;
                }
                i++;
            }
        } while (doicho); // neu gap vong for ko phai doi cho lan nao thi dung ngay
    }

    void insertionSort() {
//        int j,x;
//        for (int i = 1; i < n; i++) { // ban dau chi co 1 ptu a[0]
//            x = a[i]; // chen a[i] vao day so da sort
//            j = i;
//            while(j > 0 && x < a[j-1]){
//                a[j] = a[j+1];
//                j--;
//            };
//            // chen x vao vi tri hop le, j la vi tri dau tien ma x > = a[j-1]
//            //do do' j la vi tri can chen` x
//            a[j] = x;
//        }
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i-1;
            while(j >= 0 && key < a[j]){
                swap(j, j+1);
                j--;
            }
        }
    }
}//end simple sort
