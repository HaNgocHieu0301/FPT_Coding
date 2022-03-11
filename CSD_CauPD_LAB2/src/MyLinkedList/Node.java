package MyLinkedList;
import Entity.*;
/**
 *
 * @author ADMIN
 */
public class Node<E> {
    private E element;
    private Node<E> next;

    public Node() {
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public Node(E element) {
        this.element = element;
        next = null;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

}
