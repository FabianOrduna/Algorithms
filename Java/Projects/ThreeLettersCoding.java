public class MyClass {
    
    public static int cuentaCaracter(String cadena, char caracter){
        int counter = 0;
        for(int i = 0; i< cadena.length(); i++){
            if(cadena.charAt(i)==caracter){
                counter++;
            }
        }
        return counter;
    }
    
    public static String concatenaACadena(String cadena, String valor, int total){
        if(total==0)return cadena;
        //total can only be between 1 and 2
        switch(total){
            case 1:
                return cadena += valor;
            case 2:
                return cadena += valor + valor;
        }
        return cadena;
    }
    
    public static String regresaCadena(int a, int b){
        String result = "";
        
              /**
       * 
       *        0   1   --> b
       *        0   2   --> bb
       *        1   1   --> ab
       *        1   2   --> bba
       *        1   3   --> bbab
       *        1   4   --> bbabb
       *        2   3   --> bbabaa
       *        2   4   --> bbaabb
       *        2   5   --> bbabbab
       *        2   6   --> bbabbabb
       *        3   7   --> bbabbabbab
       * 
       *        22 10   --> aabaabaabaabaabaabaa
       *    
       * 
       *        el primero:= es el más grande de los 2 (a o b)
       *        el segundo:= es el más chico de los 2 (a o b)
       * 
       *        Se comienza con el primero:
       *            Se ponen 2 del primero en caso de que alcance o solo se pone 1
       *        Despues va el segundo
       *            Si el primero -min(2,primero) es mayor que 0, entonces se pone 1, sino se pueden poner 2 o lo más que se tenga (2 ó 1)
       * 
       * 
       *        
       * 
       */
       
       String primero = "a";
       if(b>a){
           primero = "b";
       }
       
       boolean turnoPrimero = true;
        
        while(a!=0 && b!=0){
            //System.out.println(result);
            if(turnoPrimero){
                if(primero == "a"){
                    if(a-2>=0){
                        result = concatenaACadena(result, "a", 2);
                        a-=2;
                    }else{
                        result = concatenaACadena(result, "a", 1);
                        a--;
                    }
                }else{
                    if(b-2>=0){
                        result = concatenaACadena(result, "b", 2);
                        b-=2;
                    }else{
                        result = concatenaACadena(result, "b", 1);
                        b--;
                    }
                }
                turnoPrimero = false;
            }else{
                //Despues va el segundo
                //Si el primero -min(2,segundo) es mayor que 0, entonces se pone 1, sino se pueden poner 2 o lo más que se tenga (2 ó 1)
                if(primero == "a"){
                    //en realidad este espacio s
                    if(a - Math.min(2,b)>0 && b<a){
                        result = concatenaACadena(result, "b", 1);
                        b--;
                    }else{
                        //se ponen 2 o mas del b
                        if(b-2>=0){
                            result = concatenaACadena(result, "b", 2);
                            b-=2;
                        }else{
                            result = concatenaACadena(result, "b", 1);
                            b--;
                        }
                    }
                }else{
                    if(b - Math.min(2,a)>0 && a<b){
                        result = concatenaACadena(result, "a", 1);
                        a--;
                    }else{
                        //se ponen 2 o mas del b
                        if(a-2>=0){
                            result = concatenaACadena(result, "a", 2);
                            a-=2;
                        }else{
                            result = concatenaACadena(result, "a", 1);
                            a--;
                        }
                    }
                }
                turnoPrimero = true;
            }
        }
        
        
        if(a==0){
            return concatenaACadena(result, "b", b);
        }
        if(b==0){
            return concatenaACadena(result, "a", a);
        }
        
        
        return result;
    }
    
    
    public static void main(String args[]) {
      int a=2;
      int b=6;
      String s = regresaCadena(a,b);
      System.out.println(s);
      System.out.println(cuentaCaracter(s, 'a'));
      System.out.println(cuentaCaracter(s, 'b'));
      

      
      
    }
}
