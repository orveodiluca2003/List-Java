/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listacircular;

/**
 *
 * @author Orveo Di Luca
 */
public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Lista() {
        this.pFirst = null;
        this.pLast = pFirst;
        this.size = 0;
    }

    public boolean IsEmpty() {
        return pFirst == null;
    }

    public void AddAtTheFirst(int dato) {
        Nodo nodo = new Nodo(dato);
        if (this.IsEmpty()) {
            this.pFirst = this.pLast = nodo;
        } else {
            nodo.setpNext(pFirst);
            pLast.setpNext(nodo);
            pFirst = nodo;
        }
        size++;
    }

    public void AddAtTheFinal(int dato) {
        Nodo nodo = new Nodo(dato);
        if (this.IsEmpty()) {
            this.pFirst = this.pLast = nodo;
        } else {
            Nodo aux = pLast;
            aux.setpNext(nodo);
            pLast = nodo;
            nodo.setpNext(pFirst);
        }
        size++;
    }
    
     public void Print() {
        if (!IsEmpty()) {
            Nodo aux = pFirst;
            int i = 0;

            while (i < size) {
                System.out.println(aux.getDato());
                aux = aux.getpNext();
                i++;
            }
        } else {
            System.out.println("No se puede imprimir ya que la lista está vacia.");
        }
    }

    public void Printear() { //ver si en verdad está apuntando al primero
        System.out.println(pLast.getpNext().getDato());
    }

    public void InsertIn(int dato, int posicion) {
        Nodo nodo = new Nodo(dato);
        if (IsEmpty()) {
            pFirst = pLast = nodo;
        } else {
            if (posicion == 0) {
                AddAtTheFirst(dato);
            } else if (posicion == size) {
                AddAtTheFinal(dato);
            } else if (posicion < 0 || posicion > size) {
                System.out.println("No se puede agregar ya que la posicion no está disponible");
            } else {
                Nodo pAux1 = pFirst;
                Nodo pAux2 = pFirst;
                int i = 0;
                while (i < posicion - 1) {
                    pAux2 = pAux1.getpNext();
                    i++;
                }
                pAux1 = pAux2.getpNext();
                pAux2.setpNext(nodo);
                nodo.setpNext(pAux1);
                size++;
            }
        }
    }

    public void DeleteAtTheStart() {
        if (IsEmpty()) {
            System.out.println("No se puede borrar elementos de una lista vacía.");
        } else {
            Nodo aux = pFirst;
            pFirst = pFirst.getpNext();
            aux = null;
            size--;
        }
    }

    public void DeleteAtTheFinal() {
        if (IsEmpty()) {
            System.out.println("No se puede borrar elementos de una lista vacía.");
        } else {
            Nodo aux = pFirst;
            for (int i = 0; i < size - 1; i++) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            aux.setpNext(pFirst);
            pLast = null;
            pLast = aux;
            size--;
        }
    }

    public void DeleteInPosicion(int posicion) {
        if (IsEmpty()) {
            System.out.println("No se puede borrar elementos de una lista vacía.");
        } else {
            if (posicion == 0) {
                DeleteAtTheStart();
            } else if (posicion == size) {
                DeleteAtTheFinal();
            } else if (posicion < 0 || posicion > size) {
                System.out.println("No se puede eliminar en esta posicion");
            } else {
                Nodo pAux = pFirst;
                int i = 0;
                while (i < posicion - 1) {
                    pAux = pAux.getpNext();
                    i++;
                }
                Nodo pAux2 = pAux.getpNext();
                pAux.setpNext(pAux2.getpNext());
                pAux2.setpNext(null);
                size--;
            }
        }
    }

    public Nodo SearchInPosition(int posicion) {
        Nodo pAux = pFirst;
        if (IsEmpty()) {
            System.out.println("La lista está vacía y no se puede buscar nada.");
        } else {
            if (posicion < 0) {
                System.out.println("No se puede buscar en una posicion que sea menor que el tamanio de la lista");
            } else {
                for (int i = 0; (i < posicion) && (pAux != null); i++) {
                    pAux = pAux.getpNext();
                }
            }
        }
        return pAux;
    }

    public void Creciente() {
        Nodo Aux = pFirst;
        Nodo Aux2 = Aux.getpNext();
        int i = 0;
        if (IsEmpty()) {
            System.out.println("La lista está vacía no se puede organizar nada");
        } else {
            while (i < size) {
                if (Aux.getDato() > Aux2.getDato()) {
                    int aux = Aux2.getDato();
                    Aux2.setDato(Aux.getDato());
                    Aux.setDato(aux);

                    if (Aux2 == this.pFirst) {
                        Aux = Aux2;
                        Aux2 = Aux2.getpNext();
                    } else {
                        Aux = this.pFirst;
                        Aux2 = this.pFirst.getpNext();
                    }
                } else {
                    Aux = Aux2;
                    Aux2 = Aux2.getpNext();
                }
                i++;
            }
        }
    }

    public void Decreciente() {
        Nodo Aux = pFirst;
        Nodo Aux2 = Aux.getpNext();
        if (IsEmpty()) {
            System.out.println("No se puede organizar nada ya que no hay elementos");
        } else {
            while(Aux2 != pFirst){
                if(Aux.getDato() < Aux2.getDato()){
                    int aux = Aux2.getDato();
                    Aux2.setDato(Aux.getDato());
                    Aux.setDato(aux);
                    if (Aux2 == this.pFirst) {
                        Aux = Aux2;
                        Aux2 = Aux2.getpNext();
                    } else {
                        Aux = this.pFirst;
                        Aux2 = this.pFirst.getpNext();
                    }
                }else{
                    Aux = Aux2; 
                    Aux2 = Aux2.getpNext();
                }
            }
        }
    }
    
    public Lista Union(Lista lista1 , Lista lista2, Lista lista3){
        Nodo pAux1 = lista1.pLast ; 
        Nodo pAux11 = lista1.pFirst;
        Nodo pAux2 = lista2.pLast; 
        Nodo pAux22 = lista2.pFirst;
        Nodo pAux3 = lista3.pLast;
        Nodo pAux33 = lista3.pFirst;
        
        pAux1.setpNext(pAux22);
        lista1.pLast = lista2.pFirst;
        pAux2.setpNext(pAux11);
        pAux2.setpNext(pAux33);
        lista2.pLast = lista3.pFirst;
        pAux3.setpNext(pAux11);
        lista1.setSize(lista1.size + lista2.size + lista3.size);
        return lista1;
    }

}


