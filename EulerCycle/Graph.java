/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EulerCycle;

import EulerCycle.MyStack;

/**
 *
 * @author bbbvv
 */
public class Graph {

    int[][] a;
    int n;
    char[] v;

    public Graph() {
        n = 0;
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
        }
    }

    void visit(int i) {
        System.out.print(v[i] + ", ");
    }

    boolean isDirected() { // kiem tra tinh vo huong (xem ma tran co doi xung hay ko)
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    int deg(int i) {     // tra ve bac cua dinh i
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j]; // i ke voi dinh j thi dem         
        }
        if (a[i][i] > 0) { // i ma ke voi chinh i (khuyen) thi cung dem
            s += a[i][i];
        }
        return s;
    }

    boolean isConnected() { // kiem tra tinh lien thong
        MyStack s = new MyStack();
        boolean[] p = new boolean[n]; // p danh dau nhung dinh thuoc bo phan lien thong
        int i, j, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0); // day dinh dau tien vao stack
        p[0] = true;
        while (!s.isEmpty()){ //khi stack con co dinh
            r = s.pop(); // lay 1 dinh ( dinh vao sau cung ra khoi stack)
            for (i = 0; i< n; i++) {
                if(!p[i] && a[r][i] > 0){ // neu gap dinh ke^` voi dinh vua lay ra
                    s.push(i); // thi dua dinh do vao stack
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]){ // neu gap phai 1 dinh (dinh i) ko thuoc bo phan lien thong thi return false
                return false;
            }
        }// ko gap dinh nao nhu the thi do thi lien thong
        return true;
    }
    
    boolean isEvenDegree(){ // la do thi ma moi dinh deu co bac chan
        for (int i = 0; i < n; i++) {
            if(deg(i) % 2 != 0){ // gap phai 1 dinh bac le?
                return false;
            }
        }
        return true;
    }
    
    boolean hasIsolateVertex(){ // co dinh? co^ la^p
        for (int i = 0; i < n; i++) {
            if(deg(i) == 0){
                return true;
            }
        }
        return false;
    }
    
    EulerCycle findEulerCycle(int k){ // tim chu trinh euler xuat phat tu dinh k
        if(isDirected() || !isConnected()  || !isEvenDegree() || hasIsolateVertex()){
            System.out.println("The conditions for Euler cycle are not satisfied");
            return null;
        }
        MyStack s = new MyStack();
        int[][] b = new int[n][n];
        int i,j,r;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = a[i][j];
            }
        }
        EulerCycle t = new EulerCycle(); // t la 1 mang chu trinh euler
        s.push(k); //dua k vao stack s
        while(!s.isEmpty()){
            r = s.top(); //lay thong tin tu phan tu dinh stack ra gan vao r
            i=0;
            while(i < n && a[r][i] == 0){// neu dinh i KHONG KE voi dinh vua lay ra (dinh r)
                i++; // chuyen sang dinh tiep theo
            }
            if(i == n){ // tat ca cac dinh deu KHONG KE voi r ( the vertex r is now isolated)
                r = s.pop(); // lay han dinh r ra ( vi dinh nay la dinh co lap )
                t.add(r); // them vao mang t (mang chua chu trinh)
            }else{ //dinh i ke voi r
                s.push(i); // them i vao stack s
                a[r][i]--;// giam gia tri a[r][i] ( bo bot mot duong noi r voi i
                a[i][r]--;// giam gia tri a[i][r] ( bo bot mot duong noi i voi r             
            }
        }
        setData(b); // lai dua ma tran a ve trang thai ban dau
        return t;   
    }
}
