package ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Fabián Orduña Ferreira
 * @param <T> This helps us to work with classes which has the getHeuristic()
 *            and createChildren() methods.
 */
public class MiniMax<T extends Heuristic> {

    private DataMinMax<T> head;
    private int depht;
    
    public MiniMax(){
    }
    
    public MiniMax(DataMinMax head){
        this.head = head;
        this.depht = head.getDepht();
    }
    
    public MiniMax(T val, int depht){
        this.head = new DataMinMax(val,true,depht);
        this.depht = depht;
    }

    public DataMinMax<T> getHead() {
        return head;
    }

    public void setHead(DataMinMax<T> head) {
        this.head = head;
    }

    public int getDepht() {
        return depht;
    }

    public void setDepht(int depht) {
        this.depht = depht;
    }
    
    /**This method print all the nodes which are in the MiniMax tree*/
    public void inlineOrder(){  
        Queue<DataMinMax> cola = new LinkedList();
        DataMinMax c,t;
        if (this.head != null){
            cola.add(this.head);
            while(!cola.isEmpty()){
                t = cola.remove();
                System.out.println(t.toString());
                if(t.getChildren()!=null){
                    for (int i = 0; i < t.getChildren().size(); i++) {
                        c = (DataMinMax)t.getChildren().get(i);
                        cola.add(c);
                    }
                }       
            }
        } 
    }
    
    /*This method helps to update the MiniMax tree heuristic by node
     *Launch the calculateOwnHeuristic(DataMinMax d)*/
    public void runMiniMax(){
        this.head = this.calculateOwnHeuristic(this.head);
        this.depht = this.head.getDepht();
    }
    
    /**This method helps to update the heuristic of a given DataMinMax node
     *and returns a DataMinMax which has the same data as the given one,
     *but whit the difference that all the tree has the new heuristics for all
     *the nodes */
    public DataMinMax calculateOwnHeuristic(DataMinMax data){
        double res;
            if(data.getDepht()<1){
                return data;
            }else{
                if(data.isMax()){
                    res = Double.NEGATIVE_INFINITY;
                }else{
                    res = Double.POSITIVE_INFINITY;
                }
                ArrayList<DataMinMax> ch = data.getChildren();
                double aux;
                for (int i = 0; i < ch.size(); i++) {
                    aux = calculateOwnHeuristic(ch.get(i)).getHeuristic();
                    if(data.isMax() && aux>res){
                        res = aux;
                    }else{
                        if(!data.isMax() && aux<res){
                            res = aux;
                        }
                    }
                }
                data.setHeuristic(res);
        }
        return data;
        
    }
    
    
    
}
