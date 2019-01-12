package ai;
import java.util.ArrayList;
/**
 * @author Fabián Orduña Ferreira
 * @param <T> a class which contains an getHeuristic method
 * to help with the MinMax algorithm
 */
public class DataMinMax<T extends Heuristic> {
    private T data;
    private boolean max;
    private ArrayList<DataMinMax> children;
    private int depht; //number of levels below of this level
    private double heuristic;

    /**
     * This constructor creates all the nodes of a tree with an specific depht
     * with the possible children based on each node-level.
     * 
     * @param data: a class which represents a move on a game, it must has
     *              the getHeuristic() and createChildren() methods.
     *              For example numbers, boards of 4 in Line, etc.
     * @param max:  this helps to know if you are in the max or min level
     * @param depht:the numbers of levels below the current one
     * 
     */
    public DataMinMax(T data, boolean max, int depht) {
        this.data = data;
        this.max = max;
        this.depht = depht;
        
        if(max && depht >0){
            this.heuristic = Double.NEGATIVE_INFINITY;
        }else{
            if(!max && depht >0){
                this.heuristic = Double.POSITIVE_INFINITY;
            }
        }
        
        if(this.depht>0){
            this.children = new ArrayList();
            ArrayList x = data.createChildren();
            DataMinMax temp;
            for (int i = 0; i < x.size(); i++) {
                temp = new DataMinMax((T)x.get(i),!max,this.depht-1);
                this.children.add(i, temp);
            }
        }else{
            this.heuristic = this.data.getHeuristic();
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public ArrayList<DataMinMax> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<DataMinMax> children) {
        this.children = children;
    }

    public int getDepht() {
        return depht;
    }

    public void setDepht(int depht) {
        this.depht = depht;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public String toString() {
        String res = "DataMinMax{" + "\n\tdata=" + data + "\n\tmax=" + max + "\n\tdepht=" + depht + "\n\theuristic=" + heuristic;
        String children = "";
        if(this.children!=null)
            for (int i = 0; i < this.children.size(); i++) {
                children = children + this.children.get(i).getData() + "  ";
            }
        res = res + "\n\t" +children + "\n]";
        return res;
    };
    
}
