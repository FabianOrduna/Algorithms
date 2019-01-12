package Trees;
/**
 *
 * @author Fabián Orduña Ferreira
 * @param <T>
 */
public class TreeNode<T extends Comparable>{
    private T elem;
    private TreeNode<T> leftSon;
    private TreeNode<T> rightSon;

    public TreeNode(T elem) {
        this.elem = elem;
    }

    public T getElem() {
        return elem;
    }

    public TreeNode<T> getLeftSon() {
        return leftSon;
    }

    public TreeNode<T> getRightSon() {
        return rightSon;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setLeftSon(TreeNode<T> leftSon) {
        this.leftSon = leftSon;
    }

    public void setRightSon(TreeNode<T> rightSon) {
        this.rightSon = rightSon;
    }

}
