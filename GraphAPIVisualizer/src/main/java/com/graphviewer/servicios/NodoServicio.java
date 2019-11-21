/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;

import com.graphviewer.dao.NodoDAO;
import com.graphviewer.modelo.Nodo;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Harold
 */
@Path("Nodos")

public class NodoServicio {
    private static List<Nodo> NodeList = NodoDAO.getProductos();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos() {
       return Response.ok(NodeList).build();
    }
}
