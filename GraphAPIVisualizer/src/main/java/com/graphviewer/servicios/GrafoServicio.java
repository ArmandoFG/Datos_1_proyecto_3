/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;


import com.graphviewer.modelo.Aristas;
import com.graphviewer.modelo.Grafo;
import com.graphviewer.modelo.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Harold
 * @author Armando
 */

@Path("graphs")
public class GrafoServicio {
    private static List<Grafo> GrafoList = new ArrayList();/*Crear_grafo.getProductos();*/
    private static int contGrafos = 1; 
    private static int contNodos = 1; 
    private static int contAristas = 1; 
    
    /**
     * 
     * @return retorna la lista de grafos
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response getGrafos() {
       return Response.ok(GrafoList).build();
    }
    
    /**
     * 
     * @return Retorna el grafo creado
     */
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)  //Comunicacion mediante JSON
    public Response CreateGrafo(){
        
        Grafo graph = new Grafo(contGrafos);    // Crea un grafo
        contGrafos++;   //Contador para id de grafos
        GrafoList.add(graph);   //Agrega el grafo a la lista
        
        return Response.ok(graph.getId()).build();  //Retorna el grafo
    
    }
    
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response EliminarGrafos() {
       GrafoList.clear();   //Elimina todos los grafos de la lista
       return Response.ok().build();
    }
    
    /**
     * 
     * @param id Id del grafo a buscar
     * @return Retorna el grafo buscado
     */
    @GET
    @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    
    public Response BuscarGrafo(@PathParam("id") int id){
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){ // Examina si el grafo está en la lista
            for(Grafo graph :GrafoList){    //Recorre la lista con los grafos
                if (graph.getId() == id){   // Obtiene el grafo que tenga la misma id que se busca
                    return Response.ok(graph).build();  //Retorna el grafo
                }
            }
            
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
    
    }
    
    /**
     * 
     * @param id Identificacion del grafo a eliminar
     * @return Retorna solo si hay un fallo durante el proceso
     */
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)       //Comunicacion mediante JSON
    public Response EliminarGrafo(@PathParam("id") int id){
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){ // Examina si el grafo está en la lista
            GrafoList.remove(grafo);    //Remueve el nodo de la lista
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
    
    }
    
    /**
     * 
     * @param id    Identificacion del grafo donde se va a agregar el nodo
     * @param entity
     * @return Retorna el nodo creado o un fallo si se da
     */
    
    @POST
    @Path("/{id}/nodes")
    @Consumes(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response addNodo(@PathParam("id") int id, Object entity){
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            for(Grafo graph :GrafoList){    //Recorre la lista de los grafos
                if (graph.getId() == id){   //Obtiene el grafo donde se debe crear
                    Nodo node = new Nodo(contNodos);    //Crea el nodo
                    node.setEntity(entity);
                    graph.nodos.add(node);  //Agrega el nodo al grafo
                    contNodos++;    //aumenta el contador de los nodos
                    return Response.ok(node.getID()).build();   //Retorna el nodo creado
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
    
    }
    
    /**
     * 
     * @param id Identificacion del grafo donde se quiere obtener los nodos
     * @return Retorna los nodos
     */
    
    @GET
    @Path("/{id}/nodes")
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response getNodos(@PathParam("id") int id) {
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            for(Grafo graph :GrafoList){    //Recorre la lista de los grafos
                if (graph.getId() == id){   //Obtiene el grafo donde se deben obtener los nodos
                    
                    return Response.ok(graph.getNodos()).build();   //Retorna los nodos
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
    }
    /**
     * 
     * @param id
     * @param id2
     * @param entity
     * @return 
     */
    @PUT
    @Path("/{id}/nodes/{id2}")
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response updateNodo(@PathParam("id") int id, @PathParam("id2") int id2, Object entity) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            GrafoList.get(id-1).getNodo(id2-1).setEntity(entity);   
            
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    /**
     * 
     * @param id   Identificacion del grofo que se quiere obtener las aristas
     * @return Retorna la arista o error si se da
     */
    @GET
    @Path("/{id}/edges")
    @Produces(MediaType.APPLICATION_JSON)   //Comunicacion mediante JSON
    public Response getAristas(@PathParam("id") int id) {   
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){ // Examina si el grafo está en la lista
            for(Grafo graph :GrafoList){    //Recorre la lista de los grafos
                if (graph.getId() == id){   //Obtiene el grafo donde se deben obtener las aristas
                    
                    return Response.ok(graph.getAristas()).build(); //Retorna las aristas
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
    }
    /**
     * 
     * @param id    Identificacion del grafo donde se va a crear la arista
     * @param arista
     * @return  Retorna la arista creada
     */
    
    @POST
    @Path("/{id}/edges")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addArista(@PathParam("id") int id, Aristas arista){
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){ // Examina si el grafo está en la lista
            for(Grafo graph :GrafoList){    //Recorre la lista de los grafos
                if (graph.getId() == id){   //Obtiene el grafo donde se deben agregar las aristas
                    arista.setId(contAristas);  
                    graph.aristas.add(arista);  //Asigna la arista al grafo
                    contAristas++;  //Aumenta contador de las arista
                    return Response.ok(arista.getId()).build(); //Retorna la arista
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();  //Retorna error
       
    }
    
    /**
     * 
     * @param id
     * @param id2
     * @param obj
     * @return 
     */
    
    @PUT
    @Path("/{id}/edges/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateArista(@PathParam("id") int id, @PathParam("id2") int id2, Aristas obj) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
   
            GrafoList.get(id-1).getArista(id2-1).setStart(obj.start);   
            GrafoList.get(id-1).getArista(id2-1).setEnd(obj.end);   
            GrafoList.get(id-1).getArista(id2-1).setPeso(obj.peso);   
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("/{id}/degree")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Sort(@PathParam("id") int id, String sort) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    List<Nodo> nodos = grafo.getNodos();
                    int n = nodos.size();
                    int k;
                    if(sort.equalsIgnoreCase("DESC")){
                        for (int m = 0; m < n; m++) {
                            for (int i = 0; i < n - 1; i++) {
                                k = i + 1;
                                int prom1 = (nodos.get(i).inDegree + nodos.get(i).outDegree)/2;
                                int prom2 = (nodos.get(k).inDegree + nodos.get(k).outDegree)/2;
                                if (prom1 > prom2) {
                                    Nodo temp;
                                    temp = nodos.get(i);
                                    nodos.set(i, nodos.get(k));
                                    nodos.set(k, temp);
                                }
                            }

                        }
                    }else{
                        for (int m = 0; m < n; m++) {
                            for (int i = 0; i < n - 1; i++) {
                                k = i + 1;
                                int prom1 = (nodos.get(i).inDegree + nodos.get(i).outDegree)/2;
                                int prom2 = (nodos.get(k).inDegree + nodos.get(k).outDegree)/2;
                                if (prom1 < prom2) {
                                    Nodo temp;
                                    temp = nodos.get(i);
                                    nodos.set(i, nodos.get(k));
                                    nodos.set(k, temp);
                                }
                            }

                        }
                    }
                    
                    
                    return Response.ok(nodos).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    /**
     * 
     * @param id    Identificacion del grafo de los nodos a borrar
     * @return  Retorna error si llega a pasar
     */
    
    @DELETE 
    @Path("/{id}/nodes") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarNodos(@PathParam("id") int id) { 
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            GrafoList.get(id-1).getNodos().clear();     //Elimina los nodos de la lista del grafo
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); //Retorna error
    } 
     
    /**
     * 
     * @param id    Identificacion del grafo donde se encuentra el nodo a eliminar
     * @param id2   Identificacion del nodo a eliminar
     * @return  Retorna error
     */
    @DELETE 
    @Path("/{id}/nodes/{id2}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarNodo(@PathParam("id") int id, @PathParam("id2") int id2) { 
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            GrafoList.get(id-1).getNodos().remove(id2-1);   //Remueve el nodo
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); //Retorna error
    } 
    
    /**
     * 
     * @param id    Identificacion de la arista a borrar
     * @return      Retorna error si sucede
     */
    @DELETE 
    @Path("/{id}/edges") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarAristas(@PathParam("id") int id) { 
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            GrafoList.get(id-1).getAristas().clear();    //elimina las aristas del grafo
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); //Retorna error
    } 
    /**
     * 
     * @param id    Identificacion del grafo donde se encuentra las aristas a eliminar
     * @param id2   Identificacion de la arista a eliminar
     * @return  //Retorna error
     */
     
    @DELETE 
    @Path("/{id}/edges/{id2}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarArista(@PathParam("id") int id, @PathParam("id2") int id2) { 
        Grafo grafo = new Grafo(id);    //Crea un grafo con la id asignada para saber si existe
        if (GrafoList.contains(grafo)){     // Examina si el grafo está en la lista
            GrafoList.get(id-1).getAristas().remove(id2-1);    //elimina la arista del grafo
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); //retorna error
    }
    
}
