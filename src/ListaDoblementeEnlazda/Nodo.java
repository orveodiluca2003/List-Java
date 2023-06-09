
package ListaDoblementeEnlazda;

public class Nodo {
    private Nodo pPrev;
    private Nodo pNext;
    private Object dato;
    private int numero;
    private String nombre;

    public Nodo(Object dato, int numero) {
        this.dato = dato;
        this.numero = numero;
        this.pNext = null;
        this.pPrev = null;
    }
    
    public Nodo(int dato){
        this.dato = 0;
        this.numero = dato;
        this.pNext = null;
        this.pPrev = null;

    }

    public Nodo getpPrev() {
        return pPrev;
    }

    public void setpPrev(Nodo pPrev) {
        this.pPrev = pPrev;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
    
    
    
    

}