package ListaSimple;

public class Nodo {

    private Object dato;
    private int numero;
    private Nodo pNext;

    //este constructor es para el final
    public Nodo(Object dato,int numero) {
        this.dato = dato;
        this.pNext = null;
        this.numero = numero;
    }

    //este constructor es para el inicio
    public Nodo(Object dato, Nodo next) {
        this.dato = dato;
        this.pNext = next;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the next
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param next the next to set
     */
    public void setpNext(Nodo next) {
        this.pNext = next;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
   

}
