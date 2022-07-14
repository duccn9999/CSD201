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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringMatching t = new StringMatching();
        String a = "0123456789";
        String p = "567";
        t.testSearching(a, p);
        System.out.println();
    }
    
}
