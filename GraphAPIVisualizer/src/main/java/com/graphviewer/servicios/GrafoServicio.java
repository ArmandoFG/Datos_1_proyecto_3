/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;

import com.graphviewer.dao.Crear_grafo;
import com.graphviewer.dao.NodoDAO;
import com.graphviewer.modelo.Grafo;
import com.graphviewer.modelo.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Harold
 */
@Path("graphs")
public class GrafoServicio {
    private static List<Grafo> GrafoList = new ArrayList();/*Crear_grafo.getProductos();*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrafos() {
       return Response.ok(GrafoList).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Response CreateGrafo(Grafo grafo){
        
        GrafoList.add(grafo);
        
        return Response.status(Response.Status.CREATED).entity(grafo).build();
    
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response EliminarGrafos() {
       GrafoList.clear();
       return Response.ok().build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response BuscarGrafo(@PathParam("id") int id){
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    return Response.ok(graph).build();
                }
            }
            
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response EliminarGrafo(@PathParam("id") int id){
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            GrafoList.remove(grafo);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    
    }
}
