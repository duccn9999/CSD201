/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal.algorithm;

/**
 *
 * @author bbbvv
 */
public class Edge {

    int u, v;
    int weight;

    public Edge(int u1, int v1, int w1) {
        u = u1;
        v = v1;
        weight = w1;
    }

    public Edge(Edge h) {
        u = h.u;
        v = h.v;
        weight = h.weight;
    }

    void Display(){
        System.out.println(" (" +(u+1)+", "+(v+1)+", weight is "+weight+")");
    }
    
    

}
