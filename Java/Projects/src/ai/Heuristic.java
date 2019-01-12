package ai;
import java.util.ArrayList;
/**
 * @author Fabián Orduña Ferreira
 * 
 * This interface is use to help with the creation of nodes which can be use on
 * a MinMax tree
 */
public interface Heuristic {
    public double getHeuristic();
    public ArrayList createChildren();
    
}
