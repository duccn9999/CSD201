/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedqueue;

import java.util.Scanner;

/**
 *
 * @author VSIT
 */
public class Main {
    public static void main(String[] args) throws Exception{
        int choice, x, k;
        Scanner sc = new Scanner(System.in);
        LinkedQueue lq = new LinkedQueue();
        Integer X;
        while (true) {
            System.out.println();
            System.out.println("1. Enqueue");
            System.out.println("2. View first");
            System.out.println("3. Dequeue");
            System.out.println("4. Display All");
            System.out.println("0. Exit");
            System.out.println("    Your selection (0->4): ");
            choice = sc.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be enqueued: ");
                    x = sc.nextInt();
                    X = new Integer(x);
                    lq.enqueue(X);
                    break;
                case 2:
                        System.out.print("The elements at the front: " + lq.front());
                    break;
                case 3:
                        System.out.print("The dequeued elements: " + lq.dequeue());
                    break;
                case 4: 
                    lq.displayAll();
            }
        }
    }
}
