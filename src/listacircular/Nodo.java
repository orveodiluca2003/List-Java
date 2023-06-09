/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listacircular;

/**
 *
 * @author Orveo Di Luca
 */
public class Nodo {
    private Nodo pNext;
    private int dato;
    private int numero;
    
    public Nodo(Nodo pNext, int dato) {
        this.pNext = pNext;
        this.dato = dato;
    }
    
    public Nodo(int dato) {
        this.pNext = null;
        this.dato = dato;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    
    
}
