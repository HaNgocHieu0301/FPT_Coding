package MyBinaryTree;
import MyLinkedList.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class MyQueue {

    MyLinkedList<TreeNode> t;

    public MyQueue() {
        t = new MyLinkedList<>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(TreeNode p) {
        t.addLast(p);
    }

    TreeNode dequeue() {
        if (isEmpty()) {
            return null;
        }
        return (t.removeFirst());
    }

    TreeNode front() {
        if (isEmpty()) {
            return null;
        }
        return (t.getFirst());
    }
}
