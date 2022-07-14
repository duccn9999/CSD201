/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

/**
 *
 * @author bbbvv
 */
public class HanoiTower {

    /**
     * @param args the command line arguments
     */
    static void ThapHaNoi(int n, char a, char b, char c){
        if(n==1){
            System.out.println(" "+a+" -> "+b);
        }else{
            ThapHaNoi(n-1, a, c, b);
            ThapHaNoi(1, a, b, c);
            ThapHaNoi(n-1, c, b, a);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        char a,b,c; a='A';b='B';c='C';
        int n;
        System.out.println();
        n=3;
        System.out.println(" Ha Noi tower for n = "+n);
        ThapHaNoi(n, a, b, c);
        System.out.println();
    }
    
}
