package MyBinaryTree;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BTree<E extends Comparable<E>> {

    private TreeNode root;
    private int size = 0;

    public void clear() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void visit(TreeNode<E> p) {
        System.out.print(p.getInfor() + " ");
    }

//    public void insert(E data) {
//        root = insert(root, data);
//        size++;
//    }
//
//    public TreeNode<E> insert(TreeNode<E> root, E data) {
//        if (root == null) {
//            return new TreeNode<>(data);
//        } else if (data.compareTo(root.getInfor()) < 0) {
//            root.setLeft(insert(root.getLeft(), data));
//        } else {
//            root.setRight(insert(root.getRight(), data));
//        }
//        return root;
//    }
    public void insert(E data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        TreeNode prev = null;
        TreeNode tmp = root;
        while (tmp != null) {
            prev = tmp;
            int check = data.compareTo((E) tmp.getInfor());
            if (check == 0) {
                System.out.println("Data is existed.");
                return;
            } else if (check > 0) {
                tmp = tmp.getRight();
            } else {
                tmp = tmp.getLeft();
            }
        }
        int check2 = data.compareTo((E) prev.getInfor());
        if (check2 < 0) {
            prev.setLeft(newNode);
        } else {
            prev.setRight(newNode);
        }
        size++;
    }

    public void inorder(TreeNode p) {
        if (p != null) {
            inorder(p.getLeft());
            visit(p);
            inorder(p.getRight());
        }
    }

    public void postorder(TreeNode p) {
        if (p != null) {
            postorder(p.getLeft());
            postorder(p.getRight());
            visit(p);
        }
    }

    public void preorder(TreeNode p) {
        if (p != null) {
            visit(p);
            preorder(p.getLeft());
            preorder(p.getRight());
        }
    }

    public void breadth(TreeNode p) {
        if (p == null) {
            return;
        }
        MyQueue myq = new MyQueue();
        myq.enqueue(p);
        TreeNode r;
        while (!myq.isEmpty()) {
            r = myq.dequeue();
            visit(r);
            if (r.getLeft() != null) {
                myq.enqueue(r.getLeft());
            }
            if (r.getRight() != null) {
                myq.enqueue(r.getRight());
            }
        }
    }

    //lay phan tu o giua lam goc
    public TreeNode<E> balance(ArrayList<E> t, int i, int j) {
        if (i > j) {
            return null;
        }
        int k = (i + j) / 2;
        E x = t.get(k);
//        insert(x);
        TreeNode<E> root = new TreeNode<>(x);
        root.setLeft(balance(t, i, k - 1));
        root.setRight(balance(t, k + 1, j));
        return root;
    }

    //duyet theo inorder de luu cac gia tri cua cay vao mang
    public void balance(ArrayList<E> t, TreeNode p) {
        if (p == null) {
            return;
        }
        balance(t, p.getLeft());
        t.add((E) p.getInfor());
        balance(t, p.getRight());
    }

    public TreeNode<E> balance(TreeNode x) {
        ArrayList<E> n = new ArrayList<>();
        //chuyen cay vao arraylist
        balance(n, x);
        //xoa tree
//        clear();
        //balance
        return balance(n, 0, n.size() - 1);
    }
    
    public void balanceNode(TreeNode x){
        TreeNode tmp = root;
        TreeNode prev = null;
        while(tmp != null){
            if(tmp.getInfor().compareTo(x.getInfor()) == 0){
                balance(x);
                return;
            }else if(tmp.getInfor().compareTo(x.getInfor()) < 0){
                tmp = tmp.getRight();
            }else{
                tmp = tmp.getLeft();
            }
        }
    }
//    public void deleteNode(E p) {
//        if (p == null) {
//            return;
//        }
//        if (root == null) {
//            return;
//        }
//        TreeNode prev = null;
//        TreeNode tmp = root;
//        while (tmp != null) {
//            prev = tmp;
//            if (p == tmp) {
//                break;
//            }
//            if (p.compareTo((E) tmp) > 0) {
//                tmp = tmp.getRight();
//            } else {
//                tmp = tmp.getLeft();
//            }
//        }
//        //not found
//        if (tmp == null) {
//            return;
//        }
//        //not have child
//        if (tmp.getRight() == null && tmp.getLeft() == null) {
//            //node to be deleted is root
//            if (prev == null) {
//                root = null;
//            } else {
//                tmp = null;
//            }
//            size--;
//            return;
//        }
//        //have one left child
//        if (tmp.getRight() != null && tmp.getLeft() == null) {
//            if (prev == null) {
//                root = p.getLeft();
//            } else {
//                if (prev.getLeft() == tmp) {
//                    tmp.setRight(tmp.getLeft());
//                } else {
//                    tmp.setLeft(tmp.getLeft());
//                }
//            }
//            size--;
//            return;
//        }
//        //have one right child
//        if (tmp.getRight() == null && tmp.getLeft() != null) {
//            if (prev == null) {
//                root = p.getLeft();
//            } else {
//                if (prev.getLeft() == tmp) {
//                    tmp.setRight(tmp.getLeft());
//                } else {
//                    tmp.setLeft(tmp.getLeft());
//                }
//            }
//            size--;
//            return;
//        }
//
//        //have two child
//        if (tmp.getLeft() != null && tmp.getRight() != null) {
//            //find the right-most node in the left sub-tree
//            TreeNode q = tmp.getLeft();
//            TreeNode frp, rp;
//            frp = null;
//            rp = q;
//            while (rp.getRight() != null) {
//                frp = rp;
//                rp = rp.getRight();
//            }
//            //rp now is the right-most node
//            tmp.setInfor(rp.getInfor());
//            if (frp == null) {
//                //q is the right-most node
//                tmp.setLeft(q.getLeft());
//            } else {
//                frp.setRight(rp.getLeft());
//            }
//        }
//    }
    public void delete(E data) {
        root = delete(root, data);
        size--;
    }

    private TreeNode<E> delete(TreeNode<E> root, E data) {
        // if the root node is null, then either there's nothing to delete or no more traversal is necessary
        if (root == null) {
            return null;
        } // if the value of the data being searched for is less than the value of the current root node, then 
        // traverse to the left node of the current root, setting the current left node to whatever gets returned
        // from the delete method 
        else if (data.compareTo(root.getInfor()) < 0) {
            root.setLeft(delete(root.getLeft(), data));
        } // if the value of the data being searched for is greater than the value of the current root node, then 
        // traverse to the right node of the current root, setting the current right node to whatever gets returned
        // from the delete method
        else if (data.compareTo(root.getInfor()) > 0) {
            root.setRight(delete(root.getRight(), data));
        } // this else statement means that the data being searched for is equal to the current root, meaning that
        // we've found the node we wish to delete
        else {
            // if the node has no children, then return a value of null
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } // if the node has a left child, but no right child, then return the left child
            else if (root.getRight() == null) {
                return root.getLeft();
            } // if the node has a right child, but no left child, then return the right child
            else if (root.getLeft() == null) {
                return root.getRight();
            } // if the node has two children, then set the node's data to be the largest element
            // in the left sub-tree of the node, and then set the left child's data to be equal to
            // whatever data is returned when deleting the new root data from the left sub-tree
            // (i.e., the data that is currently set in the left child)
            else {
                root.setInfor((E) findMax(root.getLeft()));
                root.setLeft(delete(root.getLeft(), root.getInfor()));
            }
        }

        return root;
    }

    private E findMax(TreeNode<E> root) {
        // simply continue traversing to the right until you can't go no mo', and then you've found
        // the largest element 
        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getInfor();
    }

    public TreeNode<E> contains(E data) {
        return contains(root, data);
    }

    private TreeNode<E> contains(TreeNode<E> root, E data) {
        // if the root is null, then either the binary search tree is empty or the value has 
        // not been found and traversal cannot continue
        if (root == null) {
            return null;
        } // if the data being searched for is less than the value of the current root's data, 
        // check if the data exists in the current root's left sub-tree
        else if (data.compareTo(root.getInfor()) < 0) {
            return contains(root.getLeft(), data);
        } // if the data being searched for is greater than the value of the current root's data, 
        // check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.getInfor()) > 0) {
            return contains(root.getRight(), data);
        } // if the data being searched for is equal to the value of the current root's data, then 
        // the search was successful and the method should return true
        else {
            return root;
        }
    }
        public TreeNode<E> rotateRight(TreeNode<E> p) {
        if (p == null || p.getLeft() == null) {
            return p;
        }
        TreeNode<E> q = p.getLeft();
        p.setLeft(q.getRight()); 
        q.setRight(p);
        return q;
    }

    public TreeNode<E> rotateLeft(TreeNode<E> p) {
        if (p == null || p.getRight() == null) {
            return p;
        }
        TreeNode<E> q = p.getRight();
        p.setRight(q.getLeft());
        q.setLeft(p);
        return q;
    }
}

class Test {

    public static void main(String[] args) {
        BTree<Integer> bt = new BTree<>();
        bt.insert(8);
        bt.insert(6);
        bt.insert(9);
        bt.insert(2);
        bt.insert(7);
        bt.insert(1);
        bt.insert(3);
        bt.insert(5);
        bt.insert(4);
        bt.breadth(bt.getRoot());
        System.out.println();
//        bt.delete(6);
//        bt.breadth(bt.getRoot());
    }
}
