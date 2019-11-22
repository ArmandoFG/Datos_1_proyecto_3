/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;



import com.graphviewer.modelo.Grafo;
import static com.graphviewer.servicios.Servicio_Crear_Grafo.Grafos_list;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author arman
 */
@Path("Buscar")
public class Buscar {
    
    @GET
    @Path("/(id)")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response Buscar(@PathParam("id") int id){
        Grafo grafo = new Grafo(id);
        if (Grafos_list.contains(id)){
            for(Grafo grafito :Grafos_list){
                if (grafito.getId() == id){
                    return Response.ok(grafito).build();
                }
            }
            
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    
}
    
}
