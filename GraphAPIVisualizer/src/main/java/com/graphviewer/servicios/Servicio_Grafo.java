/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;

import com.graphviewer.dao.GrafoDAO;
import com.graphviewer.modelo.Grafo;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author arman
 */

@Path("Grafos")
public class Servicio_Grafo {
    
    private static List<Grafo> Grafolist = GrafoDAO.getProductos();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos(){
        return Response.ok(Grafolist).build();
    }
}
