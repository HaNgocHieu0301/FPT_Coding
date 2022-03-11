package MyLinkedList;

import Entity.*;

/**
 *
 * @author ADMIN
 */
public class MyLinkedList<E> {

    public Node head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (E) head.getElement();
    }
//
//    public E last() {
//        if (isEmpty()) {
//            return null;
//        }
//        return (E) tail.getElement();
//    }

    public void addFirst(E element) {
        Node p = new Node(element);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.setNext(head);
            head = p;
        }
    }

    public void addLast(E element) {
        Node p = new Node(element);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.setNext(p);
            tail = p;
        }
    }

    public void visit(Node<E> p) {
        System.out.print(p.getElement().toString());
    }

    public void travese() {
        Node p = head;
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        while (p.getNext() != null) {
            visit(p);
            System.out.println();
            p = p.getNext();
        }
        visit(p);
        System.out.println();
    }

    public Node<E> search(E element) {
        Node p = head;
        while (p != null) {
            if (p.getElement() == element) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return (E) tmp.getElement();
    }

    public void remove(Node<E> p) {
        if (isEmpty()) {
            return;
        }
        if (p == head) {
            removeFirst();
        }
        Node q = head;
        while (q != null) {
            if (q.getNext() == p) {
                q.setNext(p.getNext());
                return;
            }
            q = q.getNext();
        }
        return;
    }

    public void remove(E element) {
        Node p = search(element);
        if (p == null) {
            System.out.println("Failed. Not found!");
            return;
        }
        remove(p);
    }

    public Node<E> pos(int k) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (k == count) {
                return p;
            }
            count++;
            p = p.getNext();
        }
        return null;
    }

    public void insertAfter(Node q, E element) {
        if (q == null) {
            return;
        }
        if (q == tail) {
            addLast(element);
            return;
        }
//        Node p = q.next;
//        Node newNode = new Node(element, p);
        Node newNode = new Node(element, q.getNext());
        q.setNext(newNode);
//        if(q == tail){
//            //tail = p ??? -> trong answer cua thay
//            tail = newNode;
//        }
    }

    public static void main(String[] args) {
        MyLinkedList<Customer> listC = new MyLinkedList<>();
        Customer a1 = new Customer("HE1", "A", "0123");
        Customer a2 = new Customer("HE2", "B", "0124");
        Customer a3 = new Customer("HE3", "C", "0125");
        Customer a4 = new Customer("HE4", "D", "0126");
        listC.addFirst(a1);
        listC.addLast(a2);
        listC.addLast(a3);
        listC.remove(a2);
        listC.travese();
        System.out.println("");
        System.out.println(listC.size());
    }
}
