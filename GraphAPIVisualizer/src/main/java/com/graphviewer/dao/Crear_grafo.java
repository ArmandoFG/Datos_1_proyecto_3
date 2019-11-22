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
public class Crear_grafo {
    
    
    
    public static List<Grafo> getProductos()
    {
        List<Grafo> lista = new ArrayList();
        Grafo grafo1 = new Grafo(500);
        
        lista.add(grafo1);

        return lista;
    }
}