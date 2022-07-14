/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

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
    void merge(int p, int q, int r) { // chi so can trai la p , phai la r, giua la q
        if (!(p <= q) && (q <= r)) {
            return;
        }
        int n, i, j, k, x;
        n = r - p + 1;
        int[] b = new int[n];
        i = p;
        j = q + 1;
        k = 0;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) { // so sanh de tim phan tu nho hon, chuyen no sang day b
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= q) { // khi day ben phai het chuyen sang day trai b
            b[k++] = a[i++];
        }
        while (j <= r) {
            b[k++] = a[j++];
        }
        k = 0;
        for (i = p; i <= r; i++) {
            a[i] = b[k++];
        }
    }

    void mergeSort(int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(p, q);
        mergeSort(q + 1, r);
        merge(p, q, r);
    }

}//end
