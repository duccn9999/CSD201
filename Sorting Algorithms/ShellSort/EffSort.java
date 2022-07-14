/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shellsort;

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

    //shell sort
    void insertSort2(int h) {
        int j, x;
        for (int i = h; i < n; i++) {
            x = a[i];
            j = i;
            while (j - h >= 0 && x < a[j - h]) {
                a[j] = a[j - h]; // keo nut lon hon x len h vi tri
                j = j - h;
            }
            a[j] = x;
        }
    }

    void shellSort(int[] step) {
        /* cac buoc tang la step[0], step[1],...,step[stepnum] trong do
        step[0] > step[1] > ... > step[stepnum]
         */
        int h, stepnum = step.length;
        for (int i = 0; i < stepnum; i++) {
            h = step[i];
            insertSort2(h);
        }
    }

    void shellSort() {
        int[] step = {5, 3, 1};
        shellSort(step);
    }
}
