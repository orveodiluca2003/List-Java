/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listacircular;

/**
 *
 * @author Orveo Di Luca
 */
public class ListaCircular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista lis = new Lista();
        lis.AddAtTheFirst(1);
        lis.AddAtTheFinal(2);
        lis.AddAtTheFinal(3);
        lis.AddAtTheFinal(4);
        System.out.println("----Primera Lista---------");
        lis.Print();
        
        Lista lis2 = new Lista(); 
        lis2.AddAtTheFirst(5);
        lis2.AddAtTheFinal(6);
        lis2.AddAtTheFinal(7);
        lis2.AddAtTheFinal(8);
        System.out.println("-----Segunda Lista--------");
        lis.Print();
        
        Lista lis3 = new Lista(); 
        lis3.AddAtTheFirst(8);
        lis3.AddAtTheFinal(9);
        lis3.AddAtTheFinal(10);
        lis3.AddAtTheFinal(11);
        System.out.println("-----Tercera Lista--------");
        lis.Print();
        System.out.println("-------------------");
        lis.Union(lis, lis2,lis3);
        lis.Print();
        
    }
    
}
