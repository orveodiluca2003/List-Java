package ListaDoblementeEnlazda;

import javax.swing.JOptionPane;

public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

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

    public boolean Vacio() {
        return pFirst == null;
    }

    public void AgregarAlPrincipio(int data) {
        Nodo nodo = new Nodo(data, data);
        if (this.Vacio()) {
            this.pFirst = this.pLast = nodo;
        } else {
            nodo.setpNext(pFirst);
            pFirst.setpPrev(nodo);
            pFirst = nodo;
        }
        size++;
    }

    public void AgregarAlFinal(int data) {
        Nodo nodo = new Nodo(data, data);
        if (this.Vacio()) {
            this.pFirst = this.pLast = nodo;
        } else {
            pLast.setpNext(nodo);
            nodo.setpPrev(pLast);
            pLast = nodo;
        }
        size++;
    }

    public void AgregarAlFinal2(int data) {
        //pero sin pLast.
        Nodo nodo = new Nodo(data, data);
        if (this.Vacio()) {
            this.pFirst = nodo;
        } else {
            Nodo pAux = pFirst.getpNext();
            
            for (int i = 0; i < size; i++) {
                pAux = pAux.getpNext();
                pAux.setpNext(nodo);
                pAux.setpNext(nodo);
                nodo.setpPrev(pAux);
            }

        }
        size++;
    }

    public void Borrar() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public void PrintPnext() {
        if (!this.Vacio()) {
            Nodo aux = this.pFirst;
            String cadena = "";
            String algo;
            int i = 0;
            while (i < size) {
                System.out.println(aux.getNumero());
                algo = Integer.toString(aux.getNumero());
                cadena = cadena + "," + algo;
                aux = aux.getpNext();
                i++;
            }
            JOptionPane.showInputDialog(cadena);
        } else {

            System.out.println("La lista está vacía");
        }
    }

    /**
     * La función hace que se ingrese el numero con el parametro de la función y
     * la posición.
     *
     * @param numero
     * @param posicion
     */
    public void InsertIn2(int numero, int posicion) {
        Nodo nodo = new Nodo(numero);
        if (this.Vacio()) {
            this.pFirst = this.pLast = nodo;
        } else {
            Nodo pAux = this.pFirst;
            Nodo pAux2 = this.pFirst;
            int i = 0;
            if (posicion == 0) {
                this.AgregarAlPrincipio(numero);
            } else if (posicion == size) {
                this.AgregarAlFinal(numero);
            } else if (posicion < 0 || posicion > size) {
                System.out.println("No se puede insertar en esa posicion.");
            } else {
                while (i < posicion - 1) {
                    pAux2 = pAux.getpNext();
                    i++;
                }
                pAux = pAux2.getpNext();
                pAux2.setpNext(nodo);
                nodo.setpNext(pAux);
                nodo.setpPrev(pAux2);
                pAux.setpPrev(nodo);
                size++;
            }

        }
    }

    public void ElimnarAlPrincipio() {
        if (this.Vacio()) {
            System.out.println("La lista está vacía");
        } else {
            pFirst = pFirst.getpNext();
            pFirst.setpPrev(null);
        }
        size--;
    }

    public void EliminarAlFinal() {
        if (this.Vacio()) {
            System.out.println("La Lista está vacía");
        } else {
            pLast = pLast.getpPrev();
            pLast.setpNext(null);
        }
        size--;
    }

    public void EliminarEnPosicion(int posicion) {
        Nodo pAux = pFirst;
        Nodo pAux2 = pFirst;
        int i = 0;
        if (this.Vacio()) {
            System.out.println("No se puede eliminar ningun nodo ya que está vacío.");
        } else {
            if (posicion == 0) {
                ElimnarAlPrincipio();
            } else if (posicion == size) {
                EliminarAlFinal();
            } else if (posicion < 0 || posicion > size) {
                System.out.println("Imposible eliminar en esta posición no hay nodos");
            } else {
                while (i < posicion - 1) {
                    pAux = pAux.getpNext();
                    i++;
                }
                pAux2 = pAux.getpNext().getpNext();

                pAux2.setpPrev(pAux);
                pAux.setpNext(pAux2);
                size--;
            }

        }

    }

    public void Creciente() {
        if (this.Vacio()) {
            System.out.println("No se puede organizar nada porque está vacía.");
        } else {
            Nodo pAux = pFirst;
            Nodo pAux2 = pAux.getpNext();
            while (pAux2 != null) {
                if (pAux.getNumero() > pAux2.getNumero()) {
                    int aux = pAux2.getNumero();
                    pAux2.setNumero(pAux.getNumero());
                    pAux.setNumero(aux);

                    if (pAux2 == pFirst) {
                        pAux = pAux2;
                        pAux2 = pAux2.getpNext();
                    } else {
                        pAux = pFirst;
                        pAux2 = pFirst.getpNext();
                    }
                } else {
                    pAux = pAux2;
                    pAux2 = pAux2.getpNext();
                }
            }
        }
    }
    
    public void Decreciente(){
        if (this.Vacio()) {
            System.out.println("No se puede organizar nada porque está vacía.");
        } else {
            Nodo pAux = pFirst;
            Nodo pAux2 = pAux.getpNext();
            while (pAux2 != null) {
                if (pAux.getNumero() < pAux2.getNumero()) {
                    int aux = pAux2.getNumero();
                    pAux2.setNumero(pAux.getNumero());
                    pAux.setNumero(aux);

                    if (pAux2 == pFirst) {
                        pAux = pAux2;
                        pAux2 = pAux2.getpNext();
                    } else {
                        pAux = pFirst;
                        pAux2 = pFirst.getpNext();
                    }
                } else {
                    pAux = pAux2;
                    pAux2 = pAux2.getpNext();
                }
            }
        }
    }

    /**
     * es la misma primitiva solo que estoy empezando en el ultimo nodo y estoy
     * yendo de atrás hacía adelante.
     *
     * @param elemento
     * @return
     */
    public Nodo BuscarLista(int elemento) {
        Nodo pAux = pLast;
        int i;
        if (elemento < 0) {
            return null;
        }
        for (i = 1; (i < elemento) && (pAux != null); i++) {
            pAux = pAux.getpPrev();
        }
        return pAux;
    }

    /**
     * pero esta es comenzando en el último nodo.
     *
     * @param posicion
     * @return
     */
    public Nodo BuscarLista2(int posicion) {
        Nodo pAux = pFirst;
        if (posicion < 0) {
            System.out.println("No se puede poner una posición menor que el size de la lista");
        }
        for (int i = 0; (i < posicion) && (pAux != null); i++) {
            pAux = pAux.getpNext();
        }
        return pAux;
    }

    public void Reverse(){ 
        Nodo temp = null ; 
        Nodo current = pFirst; 
        while (current != null){
            temp = current.getpPrev(); 
            current.setpPrev(current.getpNext());
            current.setpNext(temp);
            current = current.getpPrev();
        }
        if(temp != null){
            pFirst = temp.getpPrev();
        }
    }

   
} 
