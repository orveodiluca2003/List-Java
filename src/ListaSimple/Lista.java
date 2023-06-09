package ListaSimple;

import javax.swing.JOptionPane;

public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() { //constructor.
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public boolean ListaVacia() { //esto sirve para comprobar si la lista está vacía. 
        return pFirst == null;
    }

    public void Borrar() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public void AgregarAlPrincipio(int data) { //Lo que está pasando aquí es que el nodo nuevo su apuntador está señalando al primer nodo 
        //creado, y luego se coloca en esa misma posicion.
        Nodo nodo = new Nodo(data, data);
        if (this.ListaVacia()) {
            this.pFirst = this.pLast = nodo;
        } else {
            nodo.setpNext(pFirst);
            pFirst = nodo;
        }
        size++;
    }

    public void Imprimir() {

        if (!this.ListaVacia()) {
            Nodo aux = pFirst; //aquí lo que nos quiere decir es que el nodo auxiliar vaya rondando por la lista y si el tamaño de la lista
            //es menor que el size de la lista imprimem los nodos.
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getNumero());
                aux = aux.getpNext();
            }
        } else {
            System.out.println("La lista está vacía");
        }
    }

    public void AgregarAlFinal(int data) { //pero con el pLast.
        Nodo nodito = new Nodo(data, data);
        if (this.ListaVacia()) {
            this.pFirst = this.pLast = nodito;
        } else {
            Nodo aux = pLast;
            aux.setpNext(nodito);
            pLast = nodito;
        }
        size++;
    }

    public void Creciente() {
        Nodo pAux = this.pFirst;
        Nodo pAux2 = pAux.getpNext();

        if (this.ListaVacia()) {
            System.out.println("Tienes la lista vacía");
        } else {
            while (pAux2 != null) {
                if (pAux.getNumero() > pAux2.getNumero()) {
                    int aux = pAux2.getNumero();
                    pAux2.setNumero(pAux.getNumero());
                    pAux.setNumero(aux);

                    if (pAux2 == this.pFirst) {
                        pAux = pAux2;
                        pAux2 = pAux2.getpNext();
                    } else {
                        pAux = this.pFirst;
                        pAux2 = this.pFirst.getpNext();
                    }
                } else {
                    pAux = pAux2;
                    pAux2 = pAux2.getpNext();
                }

            }

        }
    }

    public void BorrarAlFinal() {
        if (!this.ListaVacia()) {
            Nodo puntero = pFirst;
            while (puntero.getpNext() != null) { //lo que está haciendo es que está referenciando el penultimo con el ultimo nodo.
                puntero = puntero.getpNext();
            }
            size--;
        }
    }

    public void BorrarAlPrincipio() {
        Nodo aux2 = pFirst;
        pFirst = pFirst.getpNext();//aqui lo que hace es actualizar el pfirst que vaya al segundo nodo.
        aux2 = null;
        size--;

    }

    /**
     * Esta función no contiene el pLast, lo que hace es que confirma que el
     * siguiente del primero sea diferente de null y obtiene al siguiente nodo.
     */
    public void InsertarAlFinal(int data) {
        Nodo nodo = new Nodo(data, data);
        if (this.ListaVacia()) {
            this.pFirst = nodo;
        } else {
            Nodo aux = pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(nodo);
            size++;
        }
    }

    public Nodo BuscarLista(int elemento) { //al ponerlo en la main tengo que declarar una variable auxiliar, y luego imprimir con sout el getNumero/
        Nodo indice;
        int i;
        if (elemento < 0) {
            return null;
        }
        indice = pFirst;
        for (i = 1; (i < elemento) && (indice != null); i++) {
            indice = indice.getpNext();
        }
        return indice;

    }

    public void Size() {
        System.out.println(size);
    }

    public void InsertIn(int data, int numero) {
        Nodo nodito = new Nodo(data, numero);
        if (this.ListaVacia()) {
            this.pFirst = nodito;
        } else {
            Nodo aux = pFirst;
            for (int i = 0; i < numero - 1; i++) {
                aux = aux.getpNext();
            }
            nodito.setpNext(aux.getpNext());
            aux.setpNext(nodito);
        }
        size++;
    }

    public void Decreciente() {
        if (ListaVacia()) {
            System.out.println("No se puede ordenar nada");
        } else {
            Nodo pAux = pFirst;
            Nodo pAux2 = pAux.getpNext();
            
            while (pAux2 != null) {
                if (pAux.getNumero() < pAux2.getNumero()) {
                    int aux = pAux2.getNumero();
                    pAux2.setNumero(pAux.getNumero());
                    pAux.setNumero(aux);

                    if (pAux2 == this.pFirst) {
                        pAux = pAux2;
                        pAux2 = pAux2.getpNext();
                    } else {
                        pAux = this.pFirst;
                        pAux2 = this.pFirst.getpNext();
                    }
                } else {
                    pAux = pAux2;
                    pAux2 = pAux2.getpNext();
                }
            }

        }
    }
    /**
     * Lo que se hizo es jugar con los apuntadores, el prev que comienza en null, el current en el primero, y el siguiente en enull.
     * en el while podemos ver que el nodo siguiente va a tomar un valor del nodo que le sigue al primero.
     * despues el nodo que está en el primero va a modificar el valor que se encuentre en prev osea null. 
     * luego dice que prev será igual al current osea que el que era primero antes es el último ahora.
     * y que ahora el primero será el next.
     * @return 
     */
    public Nodo Reverse() {
        Nodo prev = null; 
        Nodo current = this.pFirst;
        Nodo next = null;
        if (ListaVacia()) {
            System.out.println("No se puede hacer más nada.");
        } else {
            while (current != null) {
                next = current.getpNext();
                current.setpNext(prev);
                prev = current;
                current = next;
            }
        }
        this.pFirst = prev;
        return this.pFirst;
    }
    
    public void EliminarEnPosicion(int posicion){
        Nodo pAux = pFirst; 
        Nodo pAux2 = pAux.getpNext();
        int i = 0;
        if(ListaVacia()){
            System.out.println("La lista esta vacia ");
        }else{
            while(i < posicion - 1 ){
                pAux = pAux.getpNext();
                i++;
            }
            pAux2 = pAux.getpNext().getpNext();
            pAux.setpNext(pAux2);
            size--;
        }

    }
    
     public void Comparar(Lista lista, Lista lista2){
        Nodo paux = lista.pFirst;
        Nodo paux2 = lista2.pFirst;

        while(paux2 != null){
            if(paux == null){
                paux2 = paux2.getpNext();
            }
            else if(paux.getDato() == paux2.getDato()){
                System.out.println(paux.getDato() + " está en la misma lista que " + paux2.getDato());
                paux2 = paux2.getpNext();
                paux = paux.getpNext();    
            
            }
            else{
                paux2 =paux2.getpNext();
            }
            
        }
    }
   
}
