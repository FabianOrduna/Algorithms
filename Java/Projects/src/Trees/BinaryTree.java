package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Fabián Orduña Ferreira
 * @param <T>
 */
public class BinaryTree<T extends Comparable>{
    private TreeNode<T> head;
    private int totElems = 0;

    public BinaryTree(){
    }
    
    public BinaryTree(T head) {
        TreeNode<T> h = new TreeNode(head);
        if(head!=null){
            this.head = h;
            totElems = 1;
        }else{
            this.head=null;
        }
    }
    
    public void addElement(T elem){
        TreeNode n;
        if(elem!=null){
            n = new TreeNode(elem);
            if(totElems==0){
                this.head = n;
                this.totElems++;
            }else{
                this.totElems++;
                TreeNode anterior,actual;
                anterior = head;actual=head;
                while(actual!=null){
                    if(elem.compareTo((T)actual.getElem())<=0){
                        anterior = actual;
                        actual = actual.getLeftSon();
                    }else{
                        anterior = actual;
                        actual = actual.getRightSon();
                    }
                }
                if(elem.compareTo((T)anterior.getElem())<=0){
                    anterior.setLeftSon(new TreeNode(elem));
                }else{
                    anterior.setRightSon(new TreeNode(elem));
                }
        
            }
        }
        
    }
    
    public boolean searchElem(T elem){
        boolean res = false;
        TreeNode current = this.head;
        if(elem!=null){
            while(!res && current!=null){
                if(current.getElem().equals(elem)){
                    res = true;
                }else{
                    if(elem.compareTo(current.getElem())<0){
                        current = current.getLeftSon();
                    }else
                        current = current.getRightSon();
                }
            }
        }
        return res;
    }
    
    public T deleteElement(){
        T res = null;
        
        return res;
    }
    
    public TreeNode<T> getHead() {
        return head;
    }

    public int getTotElems() {
        return totElems;
    }

    public void inlineOrder(){
        if(this.totElems>0){
            Queue<TreeNode> cola = new LinkedList();
            TreeNode t;
            if (this.head != null){
                cola.add(this.head);
                while(!cola.isEmpty()){
                    t = cola.remove();
                    System.out.println(t.getElem());
                    if(t.getLeftSon()!=null){    
                        cola.add(t.getLeftSon());  
                    }
                    if(t.getRightSon()!=null){    
                        cola.add(t.getRightSon());  
                    }
                }
            }
            
        }
        
    }
        
}
