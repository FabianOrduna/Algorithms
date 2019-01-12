package ai;

import java.util.ArrayList;

/**
 * @author Fabián Orduña Ferreira
 * 
 * This is an example class which can be use in the MiniMax class
 */
public class MyNumber implements Heuristic {
    
    private int number;
    
    public MyNumber(){
        this.number = (int) (Math.random() * 40) - 20;
    }

    public int getNumber() {
        return number;
    }
    
    @Override
    public double getHeuristic() {
        return Math.random()*70-20;
    }
    
    @Override
    public ArrayList<MyNumber>  createChildren(){
        ArrayList<MyNumber> lista = new ArrayList();
        int vueltas = (int) (Math.random()*2) + 2;    
        for (int i = 0; i < vueltas; i++) {
            lista.add(new MyNumber());
        }
        return lista;
    }

    @Override
    public String toString() {
        return "MyNumber{" + "value= " + number + '}';
    }
    
    
}
