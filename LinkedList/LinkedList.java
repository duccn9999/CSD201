/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author bbbvv
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyList1 t = new MyList1();
        Node p, q;
        Person x;
        String[] Name = {"A", "B", "C", "E", "D", "Z", "K"};
        int[] Age = {9, 5, 17, 5, 8, 20, 30};

        //(1)
        System.out.println("\n1. test addLast and addMany");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();

        //(2)
        System.out.println("\n2. test SearchByAge and SearchByName");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        System.out.println("After SearchByAge and SearchByName");
        q = t.searchByAge(5);
        p = t.searchByName("E");
        System.out.println(p.info + "\n" + q.info);

        //(3)
        System.out.println("\n3. Test addFirst");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        x = new Person("X", 30);
        System.out.println("First add " + x + ": ");
        //q = t.searchByName("B");
        t.addFirst(x);
        t.traverse();

        //(4)
        System.out.println("\n4. Test insertAfter");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        x = new Person("V", 50);
        q = t.searchByName("B");
        t.insertAfter(q, x);
        System.out.println("Insert " + x + " after " + q.info + ": ");
        t.traverse();

        //(5)
        System.out.println("\n5. Test insertBefore");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        x = new Person("V", 50);
        q = t.searchByName("B");
        System.out.println("Insert before " + q.info + ": ");
        t.insertBefore(q, x);
        t.traverse();

        //(6)
        System.out.println("\n6. Test remove node");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        q = t.searchByName("Z");
        t.remove(q);
        t.traverse();

        //(7)
        System.out.println("\n7. Test remove(String xName), xName=B");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.remove("B");
        t.traverse();

        //(8)
        System.out.println("\n8. Test remove(int xAge), xAge=5");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.remove(5);
        t.traverse();

        //(9)
        System.out.println("\n9. Test removeAll(int xAge), xAge=5");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.removeAll(5);
        t.traverse();

        //(10)
        System.out.println("\n10. Test pos(int k), k=2");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        p = t.pos(2);
        System.out.println("The student at position 2 is: ");
        t.visit(p);
        System.out.println();

        //(11)
        System.out.println("\n11. Test removePos(int k), k=2");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.removePos(2);
        System.out.println("List after position 2 is removed: ");
        t.traverse();
        System.out.println();

        //(12)
        System.out.println("\n12. Test SortByName()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.sortByName();
        System.out.println("After SortByName(): ");
        t.traverse();

        //(13)
        System.out.println("\n12. Test SortByAge()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.sortByAge();
        System.out.println("After SortByAge(): ");
        t.traverse();

        //(14)
        System.out.println("\n14. Test size()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        int k = t.size();
        System.out.println("Size = " + k);

        //(15)
        System.out.println("\n15. Test toArray()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        Person[] u = t.toArray();
        if (u != null) {
            System.out.println("The array u is: ");
            for (int i = 0; i < Name.length; i++) {
                System.out.print(u[i]);
            }
            System.out.println();
        }

        //(16)
        System.out.println("\n16. Test reverse()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        t.reverse();
        System.out.println("After reversed: ");
        t.traverse();

        //(17)
        System.out.println("\n17. Test findMaxAge()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        p = t.findMaxAge();
        System.out.println("The student with maximum age is");
        t.visit(p);
        System.out.println();

        //(18)
        System.out.println("\n18. Test findMinAge()");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        p = t.findMinAge();
        System.out.println("The student with minimum age is");
        t.visit(p);
        System.out.println();

        //(19)
        System.out.println("\n19. Test findMinAge(): push new content to node p");
        t.clear();
        t.addMany(Name, Age);
        t.traverse();
        p = t.searchByName("B");
        x = new Person("XX", 45);
        t.setData(p, x);
        System.out.println("After test findMinAge()");
        t.traverse();

        String[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] d = {1, 2, 3, 6, 10, 4, 7, 8, 9};

        //(20)
        System.out.println("\n20. Test SortByAge(3,6)");
        t.clear();
        t.addMany(c, d);
        t.traverse();
        t.sortByAge(3, 6);
        // [D,6]->[E,10]->[F,4]->[G,7]
        // pi = 6, pj = 4
        // 6 > 4 = > [F,4]->[E,10]->[D,6]->[G,7]
        // pi = 10, pj = 6 = > [F,4]->[D,6]->[E,10]->[G,7]
        //pi = 6, pj = 7 = > [F,4]->[D,6]->[G,7]->[E,10]
        t.traverse();

        //(21)
        System.out.println("\n21. Test Reverse(3,6)");
        t.clear();
        t.addMany(c, d);
        t.traverse();
        t.reverse(3, 6); 
        t.traverse();
    }

}
