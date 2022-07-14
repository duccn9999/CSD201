/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue;

/**
 *
 * @author VSIT
 */
public class ArrayQueue {

    protected Object[] a;
    protected int last, first, max;

    public ArrayQueue() {
        this(50);
    }

    public ArrayQueue(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }

    boolean grow() {
        int i, max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return false;
        } else {
            if (first <= last) {
                for (int j = first; j <= last; j++) {
                    a1[j - first] = a[j];
                }
            } else {
                for (int j = first; j < max; j++) {
                    a1[j - first] = a[j];
                }
                int k = max - first;
                for (int j = 0; j <= last; j++) {
                    a1[k + j] = a[j];
                }
            }
            a = a1;
            first = 0;
            last = max - 1;
            max = max1;
            return true;
        }
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return ((first == 0 && last == max - 1) || first == last + 1);
    }

    void enqueue(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = x;
        }
    }

    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (a[first]);
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = a[first];
        if (first == last) // only one element
        {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return (x);
    }

    public void displayAll() {
        int i, j;
        if (first <= last) {
            for (i = first; i <= last; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            for (i = first; i < max; i++) {
                System.out.print(a[i] + " ");
            }
            for (j = 0; j <= last; j++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }
}
