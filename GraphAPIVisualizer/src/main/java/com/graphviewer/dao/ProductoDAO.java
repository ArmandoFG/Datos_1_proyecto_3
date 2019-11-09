/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

import com.graphviewer.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harold
 */
public class ProductoDAO {
    public static List<Producto> getProductos()
    {
        List<Producto> lista = new ArrayList();
        Producto producto1 = new Producto(1,"Case",500);
        Producto producto2 = new Producto(2,"SSD",420);
        Producto producto3 = new Producto(3,"HD",480);
        Producto producto4 = new Producto(4,"MD",123);
        Producto producto5 = new Producto(5,"RAM",420);
        
        lista.add(producto1);
        lista.add(producto2);
        lista.add(producto3);
        lista.add(producto4);
        lista.add(producto5);
        
        return lista;
    }
}
