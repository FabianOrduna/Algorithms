/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;
import Trees.BinaryTree;
/**
 * @author Fabián Orduña Ferreira
 * @mail fabian_ordufer@yah
 */
public class Projects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] arre = {5,5,7,6,8,3};
        BinaryTree arbol = new BinaryTree();
        
        for (int i = 0; i < arre.length; i++) {
            arbol.addElement(arre[i]);
            //System.out.println("Insertado");
        }
        System.out.println("Inline Order");
        arbol.inlineOrder();
        System.out.println("Total de elementos");
        System.out.println(arbol.getTotElems());
        int elem = -5;
        System.out.println("Buscando el elemento "+ elem);
        System.out.println(arbol.searchElem(elem));
    }
    
}
