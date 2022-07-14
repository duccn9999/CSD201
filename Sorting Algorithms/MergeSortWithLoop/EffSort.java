/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortwithloop;

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

    //--------------------
    void mergeSort() {
        int k, i, j, low1, up1, low2, up2;
        //can duoi (low), tren(up), va chi so (i,j) cua 2 ds con, con k la chi so ds ket qua
        int size;
        int[] b = new int[n];
        size = 1; // gan size = 1;
        while (size < n) {
            low1 = 0;
            k = 0;
            while (low1 + size < n) {
                low2 = low1 + size;
                up1 = low2 - 1;
                up2 = (low2 + size - 1 < n) ? low2 + size - 1 : n - 1;

                //cho i quet tu low1 den up1, j quen tu low2 den up2, voi moi i va j
                //so sanh, chon phan tu nho hon chuyen sang danh sach b
                for (i = low1, j = low2; i <= up1 && j <= up2; k++) {
                    b[k] = (a[i] <= a[j]) ? a[i++] : a[j++];
//                    if (a[i] <= a[j]) {
//                        b[k] = a[i++];
//                    } else {
//                        b[k] = a[j++];
//                    }
                }
                //khi het 1 day, chuyen day con lai sang danh sach b
                for (; i <= up1; k++) {
                    b[k] = a[i++];
                }
                for (; j <= up2; k++) {
                    b[k] = a[j++];
                }                
                low1 = up2 + 1;
            } // while(low1 + size < n);

            /*neu so ds con la so le thi khi tron tung cap se con lai ds cuoi
        cung chua dc chon. Ta phai chuyen list nay sang list b ( temporary list)*/
            for (i = low1; k < n; i++) {
                b[k++] = a[i];
            }
            for (i = 0; i < n; i++) {
                a[i] = b[i];
            }
            size *= 2; // x2 kich cua list
        }//end of size < n

    }

}
