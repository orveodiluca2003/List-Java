
package ListaDoblementeEnlazda;

public class Main {
    
    public static void main(String[] args) {
        Lista lis = new Lista(); 
        System.out.println(lis.Vacio());
       
        lis.AgregarAlPrincipio(5);
        lis.AgregarAlPrincipio(6);
        lis.AgregarAlPrincipio(8);
        lis.AgregarAlFinal(10);
        lis.PrintPnext();
        System.out.println("------------------");
        lis.Decreciente();
        lis.PrintPnext();

    }
    
}
