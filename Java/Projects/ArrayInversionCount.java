/**

An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].

Write a function:

class Solution { public int solution(int[] A); }

that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.

For example, in the following array:

 A[0] = -1 A[1] = 6 A[2] = 3
 A[3] =  4 A[4] = 7 A[5] = 4
there are four inversions:

   (1,2)  (1,3)  (1,5)  (4,5)
so the function should return 4.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

*/

import java.io.*;
import java.lang.*;
import java.util.*;

class Solution { //O(n2)

    public static class Numeros{
        int valor;
        int indice;
        
        public Numeros(int valor, int indice){
            this.valor = valor;
            this.indice = indice;
        }
        
        public String toString(){
            return ("{ valor: "+valor+" indice:"+indice+" }");
        }
        
    }
    
    public static class Sortbyroll implements Comparator<Numeros> {
    // Used for sorting in ascending order of
    // roll number
        public int compare(Numeros a, Numeros b)
        {
            return a.valor - b.valor;
        }
    }
    
    
    public static int solution(int arreglo[]){
        int total = 0;
        
        Numeros[] numeros = new Numeros[arreglo.length];
        for(int i = 0; i<numeros.length; i++){
            numeros[i] = new Numeros(arreglo[i],i);
        }
        
        Arrays.sort(numeros, new Sortbyroll());
        
        //System.out.println(Arrays.toString(numeros));
        
        boolean usados[] = new boolean[arreglo.length];
        for(int j = numeros.length-1; j>=0; j--){
            
            int indiceActual = ((Numeros)numeros[j]).indice;
            usados[indiceActual] = true;
            for(int indiceNumero = indiceActual; indiceNumero<usados.length; indiceNumero++){
                if(usados[indiceNumero]==false){
                    total++;
                }
            }
        }
        return total;
    }
    
    }
