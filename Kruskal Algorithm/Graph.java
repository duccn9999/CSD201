/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal.algorithm;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 *
 * @author bbbvv
 */
public class Graph {

    int[][] a;
    int n;
    char[] v; // vertices label
    Edge[] b;
    int m;
    //----------

    public Graph() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        v = s1.toCharArray();
        n = m = 0;
    }

    void setBlank(int k) {
        n = k;
        a = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = 0; // ma tran ke deu = 0
            }
        }
    }

    //================
    void setData(String filename) throws IOException {
        int i, j;
        String s = "", s1 = "";
        StringTokenizer t;
        RandomAccessFile f;
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim());
        a = new int[n][n]; //lay du lieu tu file, tu do xay dung ma tran a
        for (i = 0; i < n; i++) {
            s = f.readLine();
            t = new StringTokenizer(s);
            for (j = 0; j < n; j++) {
                s1 = t.nextToken();
                a[i][j] = Integer.parseInt(s1.trim());
            }
        }
        f.close();
        createEdgeList();
    }

    //============================
    void setFromArray(int[][] c, int k) { //tu ma tran c xay dung ma tran ma tran a[i][j]
        int i, j;
        n = k;
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = c[i][j];
            }
        }
        createEdgeList();
    }

    //============================
    void dispAdj() throws Exception { // in ra ma tran trong so co tu ma tran trong file
        if (n == 0) {
            setData("matrix.txt");
        }
        if (n == 0) {
            return;
        }
        int i, j;
        System.out.println("\n The weighted matrix of the graph:");
        System.out.println("\n==================================");
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
        System.out.println();
    }
    //-----------------------------

    void displayMatrix(int[][] u, int h) throws Exception {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", u[i][j]);
            }
        }
        System.out.println();
    }
    //-----------------------------

    void createEdgeList() {
        int i, j, k;
        k = 0;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                if (a[i][j] > 0) {
                    k++;
                }
            }
        }
        m = k;
        b = new Edge[m];
        k = 0;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                if (a[i][j] > 0) {
                    b[k++] = new Edge(i, j, a[i][j]);
                }
            }
        }
    }

    //----------------------
    void displayEdgeList() throws Exception {
        if (n == 0) {
            setData("matrix.txt");
        }
        if (m == 0) {
            createEdgeList();
        }
        if (m == 0) {
            return;
        }
        int i;
        System.out.println(" Number of edges m = " + m);
        for (i = 0; i < m; i++) {
            b[i].Display();
        }
        System.out.println();
    }

    //----------------------
    void sortEdgeList() {
        int i, j, k;
        int min;
        Edge t;
        for (i = 0; i < m - 1; i++) {
            min = b[i].weight;
            k = i;
            for (j = i + 1; j < m; j++) {
                if (b[j].weight < min) {
                    k = j;
                    min = b[j].weight;
                }
            }
            if(k != i){
                t = b[i];
                b[i] = b[k];
                b[k] = t;
            }
        }
    }
    //============================
    boolean isUndirected() // The adjacency matrix is  symmetric
    {
        int i,j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(a[i][j] != a[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    // --------------------------
    boolean isConnected(){
        MyStack s = new MyStack();
        boolean[] p = new boolean[n];
        int i,k;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0);
        p[0] = true;
        while(!s.isEmpty()){
            k = s.pop();
            for (i = 0; i < n; i++) {
                if(!p[i] && a[k][i] > 0){
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]){
                return false;
            }
        }
        return true;
    }
    //===================================
    boolean hasPath(int fro, int to){
        MyStack s = new MyStack();
        boolean[] p = new boolean[n];
        int i,k;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(fro);
        p[fro] = true;
        while(!s.isEmpty()){
            k = s.pop();
            for (i = 0; i < n; i++) {
                if(!p[i] && a[k][i] > 0){
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        if(p[to]){
            return true;
        }else{
            return false;
        }
    }
    
    Graph kruskal() throws Exception{
        if(!isUndirected() || !isConnected()){
            System.out.println(" The conditions are not satisfied");
            return null;
        }
        sortEdgeList();
        Graph t = new Graph();
        t.setBlank(n);
        int i=0;
        t.a[b[0].u][b[0].v] = a[b[0].u][b[0].v];
        t.a[b[0].v][b[0].u] = a[b[0].v][b[0].u];
        while(true){
            i++;
            if(!t.hasPath(b[i].u, b[i].v)){
                t.a[b[i].u][b[i].v] = a[b[i].u][b[i].v];
                t.a[b[i].v][b[i].u] = a[b[i].v][b[i].u];
            }
            if(i == n-1){
                break;
            }
        }
        t.createEdgeList();
        return t;
    }
    
    void displayTree() throws Exception{
        Graph t = kruskal();
        int i;
        System.out.println(" Edges in a minimum spanning tree:");
        int sum=0;
        t.sortEdgeList();
        for (i = 0; i < t.m; i++) {
            t.b[i].Display();
            sum += t.b[i].weight;
        }
        System.out.println(" Total weight: "+sum);
    }
}
