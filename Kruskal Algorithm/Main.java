/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal.algorithm;

import java.util.Scanner;

/**
 *
 * @author bbbvv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int choice;
        Graph g = new Graph();
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println(" 1. Read adjacency matrix from file");
            System.out.println(" 2. Display adjacency matrix");
            System.out.println(" 3. Create list of edges");
            System.out.println(" 4. Display adjacency matrix & list of edges");
            System.out.println(" 5. Display a minimun spanning tree");
            System.out.println(" 0. Exit\n");
            System.out.println(" Your choice (0 -> 5): ");
            choice = s.nextInt();
            if (choice == 0) {
                System.out.println(" Goodby, have a nice day!");
                return ;
            }
            switch (choice) {
                case 1:
                    g.setData("matrix.txt");
                    break;
                case 2:
                    g.dispAdj();
                    break;
                case 3:
                    g.createEdgeList();
                    break;
                case 4:
                    g.dispAdj();
                    g.displayEdgeList();
                    break;
                case 5:
                    g.setData("matrix.txt");
                    g.dispAdj();
                    g.displayEdgeList();
                    g.displayTree();
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.**");
            }
            System.out.println();
        }
    }

}
