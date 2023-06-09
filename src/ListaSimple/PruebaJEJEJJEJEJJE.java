
package ListaSimple;

import javax.swing.JOptionPane;

public class PruebaJEJEJJEJEJJE {

    public static void main(String[] args) {
        Lista lis = new Lista();
        System.out.println(lis.ListaVacia());
        int x = Integer.parseInt(JOptionPane.showInputDialog("Numero "));
        lis.AgregarAlPrincipio(x);
        int y = Integer.parseInt(JOptionPane.showInputDialog("Numero "));
        lis.AgregarAlPrincipio(y);
        lis.Imprimir();
        System.out.println(lis.ListaVacia());
        System.out.println("----------------------------");
        lis.Decreciente();
        lis.Imprimir();


    }
    
}
