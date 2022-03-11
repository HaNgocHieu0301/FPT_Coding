package MyBinaryTree;

/**
 *
 * @author ADMIN
 */
public class TreeNode<E extends Comparable<E>> implements Comparable<E>{

    private E infor;
    private TreeNode left, right;

    TreeNode() {
    }

    TreeNode(E infor) {
        this.infor = infor;
        left = right = null;
    }

    public E getInfor() {
        return infor;
    }

    public void setInfor(E infor) {
        this.infor = infor;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(E o) {
        return this.getInfor().compareTo(o);
    }
    
}
