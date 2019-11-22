/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

import static com.graphviewer.dao.Crear_grafo.Grafos_list;
import com.graphviewer.modelo.Grafo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arman
 */
public class Recorrer_Grafos {
    
    static List<Integer> id;
    
    public static void recorrer(){
        //id = new ArrayList();
        for (Grafo grafos :Grafos_list){
            id.add(grafos.getId());
        }
    }
    public static List<Integer>  Recorrer(){
       List<Integer> id = new ArrayList(); 
       recorrer();
       id.add(111);
       return id; 
    }
    
    
}
