/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraystack;

import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class ArrayStackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        int x,k;
        Scanner s = new Scanner(System.in);
        ArrayStack d = new ArrayStack();
        Integer X;
        while(true){
            System.out.println();
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. Display all");
            System.out.println("0. Exit");
            System.out.print("    Your selection (0 -> 4):    ");
            choice = s.nextInt();
            if(choice == 0){
                break;
            }
            switch(choice){
                case 1:
                    System.out.print("Enter the value to be pushed: ");
                    x = s.nextInt();
                    X = new Integer(x);
                    d.push(X);
                    System.out.printf("\n%d has been pushed successfully!",X);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("The element at the top is: "+d.top());
                    break;
                case 3:
                    System.out.print("The element poped is: "+d.pop());
                    break;
                case 4:
                    d.displayAll();
                    break;
            }
        }
    }
    
}
