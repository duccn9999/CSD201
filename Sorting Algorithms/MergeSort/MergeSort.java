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
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] b = {7, 3, 5, 9, 11, 8, 6, 15, 10, 12, 14};
        EffSort t = new EffSort(b);
        int n = b.length;
        System.out.println("Before sort");
        t.Display();
        System.out.println("After sorted");
        t.mergeSort(0, n - 1);
        t.Display();
        System.out.println();
    }
}
