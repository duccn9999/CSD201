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
public class MyList1 {

    Node head, tail;

    public MyList1() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1)
    void addLast(Person x) {
        // them vao cuoi list 1 nut chua noi dung la x
        Node q = new Node(x);/* tao 1 nut moi co noi dung la x */
        /* moc nut moi vao cuoi ds */
        /* neu day la nut dau tien */
        if (isEmpty()) {
            head = tail = q; // q duoc add vao list neu list trong
            return;
        }
        // neu ko rong thi add vao cuoi
        tail.next = q;
        tail = q;
    }

    void visit(Node q) {
        if (q != null) {
            System.out.print(q.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next; // sang nut tiep theo
            if (p != null) {
                System.out.print("->");
            } else {
                System.out.print("");
            }
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n;
        n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {// them vao dau 1 nut co noi dung la x
        head = new Node(x, head);
    }

    // (4)
    void insertAfter(Node q, Person x) {// chen 1 nut noi dung la x vao sau nut tro cua q
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;// cho q1 giu dia chi cua nut sau nut q
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    // (5)
    void insertBefore(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;// sau vong lap nay f tro vao nut TRUOC nut q

        }
        if (f == null) {
            return;// q ko co trong list
        }
        insertAfter(f, x); // chen f vao f, tuc la truoc q
    }

    // (6)
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;// head cho vao node sau, not truoc bi xoa
        if (head == null) {// neu list cho co 1 node
            tail = null;
        }
    }

    void remove(Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next; // sau vong loop nay f tro vao nut TRUOC nut q
        }
        if (f == null) {
            return;
        }
        Node q1 = q.next;// cho q1 tro vao nut sau nut q
        f.next = q1; // f se tro vao nut TRUOC q1
        if (f.next == null) {
            tail = f;
        }
    }

    // (7)
    void remove(String xName) { //remove by name
       // Node headNode = head;
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) { //remove by age
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByAge(xAge); // tim` te^n de^n' khi nao` kho*p' thi` tho^i
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // (10)
    Node pos(int k) { // tim dia chi cua phan tu thu k
        int i = 0;
        Node p = head;
        while (p != null) { // khi chua het danh sach
            if (i == k) { // neu da den phan tu thu k
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    // (11)
    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    // (12)
    void sortByName() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) { // khi chua het danh sach
            pj = pi.next; // cho pi di sau pj
            while (pj != null) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {// node sau > node truoc thi doi cho
                    // swap
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) { // khi chua het danh sach
            pj = pi.next; // cho pj di sau pi
            while (pj != null) {
                if (pj.info.age < (pi.info.age)) {// node sau > node truoc thi doi cho
                    // swap
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (14)
    int size() { // dem so phan tu
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    // (15)
    Person[] toArray() {
        int i, n;
        n = size();
        Person[] a = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            a[i++] = new Person(p.info.name, p.info.age);

            p = p.next;
        }
        return (a);
    }

    // (16)
    void reverse() {
        MyList1 t = new MyList1(); // tao 1 list moi
        Node p = head;
        while (p != null) {
            t.addFirst(new Person(p.info.name, p.info.age));
            p = p.next;
        }
        head = t.head;
        tail = t.tail;
    }

    // (17)
    Node findMaxAge() {
        if (isEmpty()) {
            return (null);
        }
        int x;
        Node p, q;
        /* p = */ q = head;
        x = head.info.age;
        p = q.next;
        while (p != null) {
            if (p.info.age > x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (18)
    Node findMinAge() {
        if (isEmpty()) {
            return (null);
        }
        int x;
        Node p, q;
        /* p = */ q = head;
        x = head.info.age;
        p = q.next;
        while (p != null) {
            if (p.info.age < x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (19)
    void setData(Node p, Person x) { // Do noi dung vao nut tro boi p
        if (p != null) {
            p.info = x;
        }
    }

    // (20)
    void sortByAge(int k, int h) {// sap xep 1 doan tu vi tri k den vi tri h
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size(); // n la so phan tu trong TOAN danh sach
        if (h > n - 1) {
            h = n - 1; // h-1 la chi so ( so thu tu ) cua phan tu cuoi cung
        }

        Node u = pos(k);// cho con tro u giu dia chi cua phan tu thu k
        Node v = pos(h + 1);// cho con tro v giu dia chi chua phan tu thu h+1
        Node pi, pj;
        Person x;
        pi = u;
        while (pi != v) {
            pj = pi.next;
            while (pj != v) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (21)
    void reverse(int k, int h) {
        if (k > h) {
            return;
        }
        int n = size();
        int i, j;
        if (k < 0 || h > n - 1) {
            return;
        }
        Person[] a = toArray();
        i = k;
        j = h;
        Person x;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }

    // end my list
}
