/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

import com.graphviewer.modelo.Grafo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arman
 */
public class GrafoDAO {
      public static List<Grafo> getProductos()
    {
        List<Grafo> lista = new ArrayList();
        Grafo grafo1 = new Grafo(1);
        Grafo grafo2 = new Grafo(2);
        Grafo grafo3 = new Grafo(3);
        Grafo grafo4 = new Grafo(4);
        Grafo grafo5 = new Grafo(5);
        
        lista.add(grafo1);
        lista.add(grafo2);
        lista.add(grafo3);
        lista.add(grafo4);
        lista.add(grafo5);
        return lista;
    }
}
