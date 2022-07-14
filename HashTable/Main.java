/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, x;
        Node p;
        int[] b = {5, 7, 11, 3, 9, 2, 6, 5, 17, 23, 92, 25};
        HashTable t = new HashTable();
        t.addArray(b);
        while (true) {
            System.out.println("\n Choose your option");
            System.out.println("1. Create list randomly");
            System.out.println("2. Display list");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("0. Exit");
            System.out.println(" Your selection (0-4)");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) {
                System.out.println("Goodebye, have a nice day");
                return;
            }
            switch (choice) {
                case 1:
                    t.addRandom();
                    break;
                case 2:
                    t.traverse();
                    break;
                case 3:
                    System.out.print("\n Enter value to be searched: ");
                    x = Integer.parseInt(sc.nextLine());
                    p = t.search(x);
                    if (p != null) {
                        System.out.println(x + " is found in the list");
                    } else {
                        System.out.println(x + " is not found in the list");
                    }
                    break;
                case 4:
                    System.out.print("\n Enter value to be deleted: ");
                    x = Integer.parseInt(sc.nextLine());
                    t.delete(x);
                    System.out.println(x+ " has been deleted");
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

}
