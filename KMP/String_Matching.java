package KMP;

public class String_Matching {
    void initText(char[] p, int[] next){
        int m,i,j;
        m = p.length;
        next[0] = -1;
        for (i = 1; i < m; i++) {
            j = next[i-1];
            while (j >= 0){
                if (p[j] == p[i-1]){
                    break;
                }else{
                    j = next[j];
                }
            }
            next[i] = j+1;
        }
    }

    int kmpSearch(char[] a, char[] p){
        int i,j,m,n;
        n = a.length;
        m = p.length;
        int[] next = new int[m];
        initText(p,next);
        i = j = 0;
        while ( i < n ){
            if ( j == -1 ){
                i++;
                j = 0;
            } else if (a[i] == p[j]) {
                i++;
                j++;
                if ( j == m){
                    return i-m;
                }
            }else{
                j = next[j];
            }
        }
        return -1;
    }
    void testSearch(String a, String p){
        int i,j,m,n;
        char[] a1 = a.toCharArray();
        char[] p1 = p.toCharArray();
        int k = kmpSearch(a1,p1);
        System.out.println(a);
        System.out.println("    "+p);
        if ( k == -1 ){
            System.out.println(p + " is not found in "+a);
        }else{
            System.out.println(p + " is found at index "+ k +" in "+a);
        }
        System.out.println();
    }
}
