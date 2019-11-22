/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;

import com.graphviewer.dao.Crear_grafo;

import com.graphviewer.modelo.Grafo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author arman
 */
@Path("Crear")
public class Servicio_Crear_Grafo {
    
    public static List<Grafo> Grafos_list;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Response create(Grafo grafo){
        Grafos_list = new ArrayList();
        Grafos_list.add(grafo);
        return Response.status(Response.Status.CREATED).entity(grafo).build();
    
}
    
    
}
    

