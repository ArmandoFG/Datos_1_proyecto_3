/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.modelo;

/**
 *
 * @author Harold
 */
public class Aristas {
    public Nodo Start;
    public Nodo End;
    public int Peso;
    public int Id;
    
    public Aristas(int peso, int id){
    this.Start = null;
    this.End = null;
    this.Peso = peso;
    this.Id = id;
    }

    public Nodo getStart() {
        return Start;
    }

    public void setStart(Nodo Start) {
        this.Start = Start;
    }

    public Nodo getEnd() {
        return End;
    }

    public void setEnd(Nodo End) {
        this.End = End;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public int getId() {
        return Id;
    }
    
    

}
