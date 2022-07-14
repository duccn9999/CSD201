/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamilton.cycle;

import java.io.IOException;

/**
 *
 * @author bbbvv
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String filname;
        filname = "matrix.txt";
        Graph g = new Graph();
        g.setData(filname);
        g.displayData();
        g.hamiltonCycle(0);
        System.out.println();
    }
}
