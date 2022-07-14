/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author bbbvv
 */
public class EffSort {

    int[] a;
    int n;

    public EffSort() {
    }

    public EffSort(int[] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void setData(int[] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void Display() {
        for (int i = 0; i < n; i++) {
            System.out.printf(" " + a[i]);
        }
        System.out.println();
    }

    //--------------------
    void swap(int[] a, int i, int k) { // doi cho i voi k
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }

    //-------------------
    //chia day co  can trai la low, can phai la up thanh 2 day, tra ve chi so cua cho^t'
    int partition(int low, int up) {
        int pivot, pivotal;
        pivotal = a[low]; //chon nut dau lam chot
        int i = low;
        int j = up;
        while (i < j) { // bat dau quet
            while (a[i] <= pivotal && i < up) {
                i++; // i++ cho den khi a[i] > pitoval
            }
            while (a[j] > pivotal) {
                j--;
            }
            if (i < j) {
                swap(a, i, j); // doi cho a[i] cho a[j]: dua phan tu nho hon chot trai sang chot
                //va phan tu lon hon chot sang phai chot
            }
        }

        swap(a, low, j); // doi cho a[low] voi a[j]: doi cho chot len vi tri j
        pivot = j;  // cap nhat lai chi so cua chot
        return pivot;   //tra ve chot
    }
    //===============================

    void quickSort(int low, int up) { //bigO(n)
        int pivot;
        if (low >= up) {
            return;
        }
        pivot = partition(low, up); //O(n)
        quickSort(low, pivot - 1); // T(n/2)
        quickSort(pivot + 1, up);// T(n/2)
    }

    //===============================
    void quickSort() {
        quickSort(0, n - 1); // goi quick sort cho toan day
    }
}//end

