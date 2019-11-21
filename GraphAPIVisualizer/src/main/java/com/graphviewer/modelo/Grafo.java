package com.graphviewer.modelo;


import java.util.List;
import java.util.Vector;


/**
 *
 * @author arman
 */
public class Grafo {
    int id;   
    public static List<Nodo> nodos;
    Grafo next;
        
                   
    
   
    public Grafo(int id_grafo/*, NodoDAO Nodo*/){
        
        this.id = id_grafo;
        
        Vector<Aristas> aristas = null;
        
        for(int x = 0; x<5; x++){
            Aristas arista = new Aristas(x*3);
            aristas.add(arista);
        }
        
        Nodo nodo1 = new Nodo(88323787,"aristas",200);
        
        Vector<Aristas> aristas2 = null;
        
        for(int x = 0; x<5; x++){
            Aristas arista = new Aristas(x*2);
            aristas2.add(arista);
        }
        
        Nodo nodo2 = new Nodo(63139863,"aristas2",202);
        
        Vector<Aristas> aristas3 = null;
        
        for(int x = 0; x<5; x++){
            Aristas arista = new Aristas(x*4);
            aristas3.add(arista);
        }
        
        Nodo nodo3 = new Nodo(87145393,"aristas3",203);
        
        nodos.add(nodo1);
        nodos.add(nodo2);
        nodos.add(nodo3);

        System.out.println(nodos.get(1).Telefono);
        this.next = null;
    }
    
    public void addNodo(int telefono,Vector<Aristas> aristas){
        Nodo NbNodo = new Nodo(telefono,"aristas",404);
        this.nodos.add(NbNodo);
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Nodo getNodo(int index) {
        return nodos.get(index);
    }
    
    public static List getNodos() {
        return nodos;
    }

    
    public void setNodo(Nodo nodo,int index) {
        this.nodos.set(index, nodo);
    }

    public Grafo getNext() {
        return next;
    }

    public void setNext(Grafo next) {
        this.next = next;
    }
    

  
    

    
     
}

