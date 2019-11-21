/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

import com.graphviewer.modelo.Nodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harold
 */
public class NodoDAO {
    public static List<Nodo> getProductos()
    {
        List<Nodo> lista = new ArrayList();
        Nodo nodo1 = new Nodo(88323787,001);
        Nodo nodo2 = new Nodo(63139863,203);
        Nodo nodo3 = new Nodo(63632009,404);
        Nodo nodo4 = new Nodo(87145393,800);
        Nodo nodo5 = new Nodo(22545566,200);
        
        lista.add(nodo1);
        lista.add(nodo2);
        lista.add(nodo3);
        lista.add(nodo4);
        lista.add(nodo5);
        return lista;
    }
}
 

