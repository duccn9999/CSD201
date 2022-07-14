/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarysort;

import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class ElementarySort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int choice;
        int[] b = {5, 7, 11, 3, 9, 2, 6};
        SimpleSort t = new SimpleSort(b);
        while (true) {
            System.out.println("\n Choose your option(s): ");
            System.out.println("1. Create list randomly");
            System.out.println("2. Display data");
            System.out.println("3. Check sorted");
            System.out.println("4. Selection sort");
            System.out.println("5. Bubble sort");
            System.out.println("6. Insertion sort");
            System.out.println("0. Exit\n");
            System.out.println("Your option ( 0 -> 6 ): ");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println(" Goodbye, have a nice day!");
                return;
            }
            switch (choice) {
                case 1:
                    t.setRandom();
                    break;
                case 2:
                    t.Display();
                    break;
                case 3:
                    if (t.sorted()) {
                        System.out.println(" The list is sorted");
                    }else{
                        System.out.println(" The list is not sorted");
                    }
                    break;
                case 4:
                    t.SelectionSort();
                    t.Display();
                    break;
                case 5:
                    t.BubbleSort();
                    t.Display();
                    break;
                case 6:
                    t.insertionSort();
                    t.Display();
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

}
