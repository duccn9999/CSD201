/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author bbbvv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] b = {7, 3, 5, 9, 11, 8, 6, 15, 10, 12, 14};
        EffSort t = new EffSort(b);
        System.out.println("Before sort:");
        t.Display();
        System.out.println("The first line:");
        t.heapSort();
        System.out.println("After sorted:");
        t.Display();
    }

}
