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
    
    static int contador;
    static List<Grafo> Grafos_list;
    static String nombre;
    
    public static void crear()
    {
        
        List<Grafo> Grafos_list = new ArrayList();
        nombre = "grafo" + Integer.toString(contador);
        Grafo nombre = new Grafo(contador);
        Grafos_list.add(nombre);
        contador++;
        
}
}