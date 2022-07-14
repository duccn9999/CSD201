/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamilton.cycle;

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

    public Graph() {
        String s1 = "ABCDEFGHIJKLMNOOPQRSTUVWXYZ";
        v = s1.toCharArray(); // convert string to char array
    }

    void setData(String filename) throws IOException {
        int i, j;
        String s = "", s1 = "";
        StringTokenizer t;
        RandomAccessFile f;
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim());
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            s = f.readLine();
            t = new StringTokenizer(s);
            for (j = 0; j < n; j++) {
                s1 = t.nextToken();
                a[i][j] = Integer.parseInt(s1.trim());
            }
        }
        f.close();
    }

    //-----------------
    void displayData() {
        int i, j;
        System.out.println("\nThe adjacency matrix of graph: ");
        System.out.println("================================");
        for (i = 0; i < n; i++) {
            System.out.println("\n");
            for (j = 0; j < n; j++) {
                System.out.printf(" %3d", a[i][j]);

            }
        }
        System.out.println();
    }

    //------------------------------
    void displayCycle(HamiltonCycle c) {
        for (int i = 0; i < c.m; i++) {
            System.out.print(" ➜ "+(c.cyc[i] + 1));
        }
        System.out.println("\n");
    }

    //===============================
    boolean isUndirected() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    //===============================
    boolean isConnected() {
        int i, h;
        boolean[] visited = new boolean[20];
        boolean[] pushed = new boolean[20];
        for (i = 0; i < n; i++) {
            visited[i] = false;
            pushed[i] = false;
        }
        MyStack t = new MyStack(); // use stack as a list
        t.push(new Integer(0));
        pushed[0] = true;
        System.out.println();
        while (!t.isEmpty()) {
            h = ((Integer) t.pop()).intValue();
            visited[h] = true;
            for (i = n - 1; i >= 0; i--) {
                if (a[h][i] > 0 && !pushed[i]) {
                    t.push(i);
                    pushed[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    //=======================
    //TÌm đỉnh thứ i của chu trình Hamilton khi đã đến đỉnh i-1
    // i = 0, 1, 2,...., n c[0] (i=0) là đỉnh khởi đầu

    void hamiltonCycle(HamiltonCycle c, boolean visited[], int i) {
        int j;
        for (j = 0; j < n; j++) {
            if (a[c.cyc[i - 1]][j] > 0 && !visited[j]) // có dường đi từ i-1 đến j
            {
                c.cyc[i] = j;
                c.m++;
                visited[j] = true; // chọn đỉnh j và đánh dấu là đã xét rồi

                if (i < n) //i < n thì còn thiếu đỉnh, chưa hoàn thành chu trình
                {

                    if (c.cyc[i] != c.cyc[0]) // đỉnh xuất phát chưa xuất hiện ở khoảng giữa, có thể chọn đỉnh i+1 tiếp theo
                    {
                        hamiltonCycle(c, visited, i + 1); // chưa thế có chu trình vì còn ít đỉnh
                    }
                } else if (c.cyc[i] == c.cyc[0]) {
                    displayCycle(c);
                }
                visited[j] = false; // quay lùi và đặt lại trạng thái visited[j] trước đó bằng false
                c.m--;
            }
        }
    }

    //------------------------
    void hamiltonCycle(int k) {
        if (!isUndirected() || !isConnected()) {
            System.out.println(" The conditions are not satisfied");
            return;
        }
        HamiltonCycle c = new HamiltonCycle();
        boolean[] visited = new boolean[20];
        int i;
        c.cyc[0] = k; // chu trình xuất phát từ đỉnh k
        for (i = 0; i < n; i++) {
            visited[i] = false; // lúc đầu tất cả các đỉnh đều chưa xét, kể cả k, vì k phải xuất hiện 2 lần
        }
        c.cyc[0] = k; // Liệt kê tất cả các chu trình xuất phát từ đỉnh k
        System.out.println("\n Hamilton cycles of the above path");
        hamiltonCycle(c, visited, 1);
    }

}
