/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;

/**
 *
 * @author bbbvv
 */
public class StringMatching {

    int bruteforceSearch(char[] a, char[] p) {
        int i, j, m, n;
        n = a.length;
        m = p.length;
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (a[i] == p[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1; //dich len 1
                j = 0;
            }
        }
        if (j == m) {
            return i - m;
        } else {
            return -1;
        }
    }

    void testSearching(String a, String p) {
        char[] a1 = a.toCharArray();
        char[] p1 = p.toCharArray();
        int k;
        k = bruteforceSearch(a1, p1);
        System.out.println(a);
        System.out.println(p);
        if (k == -1) {
            System.out.println(p + " is not found in " + a);
        } else {
            System.out.println(p + " is found at index " + k + " in " + a);
        }
    }
}
