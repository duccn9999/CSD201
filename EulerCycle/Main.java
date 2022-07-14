/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EulerCycle;

/**
 *
 * @author bbbvv
 */
public class  Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][]b = {
            {0,1,0,1,0},
            {1,0,1,0,2},
            {0,1,0,1,2},
            {1,0,1,0,0},
            {0,2,2,0,0},
        };
        Graph g = new Graph();
        g.setData(b);
        
        System.out.println("\n1. Display adjacency matrix:");
        g.dispAdj();
        System.out.println("\n2. Test finding Euler Cycle");
        EulerCycle t;
        t = g.findEulerCycle(0);
        t.display();
        System.out.println();
    }
    
}
