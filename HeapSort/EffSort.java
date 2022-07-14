/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author bbbvv
 */
public class EffSort {

    int[] a;
    int n;

    public EffSort() {
    }

    public EffSort(int[] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void setData(int[] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void Display() {
        for (int i = 0; i < n; i++) {
            System.out.printf(" " + a[i]);
        }
        System.out.println();
    }

    //heap sort
    void heapSort() { // vun dong bang chen tung phan tu cua mang vao dong
        int s, f, x;
        for (int i = 1; i < n; i++) {
            x = a[i]; //lay a[i] ra de chuan bi chen vao dong
            s = i; // s la nut con, hien tai tren heap chua co a[i]
            //f = (s-1)/2 la nut cha
            while (s > 0 && x > a[(s - 1) / 2]) {
                a[s] = a[(s - 1) / 2]; // keo nut < x xuong 1 muc
                s = (s - 1) / 2;
            }
            a[s] = x;
        } // ket thuc chuyen danh sach thanh heap
        Display();
        //lan luot xoa nut a[0] tren heap, dua ve vi tri thich hop tren ds
        for (int i = n - 1; i > 0; i--) {
            x = a[i];
            a[i] = a[0];
            //sua khi lay 1 phan tu goc ( tuc la a[0] ) di, phai vun lai dong
            f = 0; // f la nut cha, s la nut con lon hon
            s = 2 * f + 1; // gan s la nut con ben trai
            if (s + 1 < i && a[s] < a[s + 1]) {
                s += 1; // neu co nut phai lon hon thi chon nut phai
            }
            while (s < i && x < a[s]) {
                a[f] = a[s]; //con lon thay the cha
                f = s;    //chuyen con lon tiep theo
                s = 2 * f + 1;
                if (s + 1 < i && a[s] < a[s + 1]) {
                    s += 1;
                }
            }
            a[f] = x; // nut a[k] dc chen dung cho
        }
    }
}//end
