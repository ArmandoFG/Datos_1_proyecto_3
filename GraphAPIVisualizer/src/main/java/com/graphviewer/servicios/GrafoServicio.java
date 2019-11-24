/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;


import com.graphviewer.modelo.Aristas;
import com.graphviewer.modelo.Grafo;
import com.graphviewer.modelo.Nodo;
import com.graphviewer.modelo.Ruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
 */
@Path("graphs")
public class GrafoServicio {
    static List<Integer> visitado = new ArrayList();
    static Stack<Integer> pila = new Stack<Integer>();
    static List<Ruta> MejorRuta = new ArrayList();
    static String ruta = "";
    static int peso;
        
        
    private static List<Grafo> GrafoList = new ArrayList();/*Crear_grafo.getProductos();*/
    private static int contGrafos = 1; 
    private static int contNodos = 1; 
    private static int contAristas = 1; 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrafos() {
       return Response.ok(GrafoList).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)  
    public Response CreateGrafo(){
        
        Grafo graph = new Grafo(contGrafos);
        contGrafos++;
        GrafoList.add(graph);
        
        return Response.ok(graph.getId()).build();
    
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
    
    @POST
    @Path("/{id}/nodes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNodo(@PathParam("id") int id, Object entity){
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    Nodo node = new Nodo(contNodos);
                    node.setEntity(entity);
                    graph.nodos.add(node);
                    contNodos++;
                    return Response.ok(node.getID()).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    
    }
    
    @GET
    @Path("/{id}/nodes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNodos(@PathParam("id") int id) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    
                    return Response.ok(graph.getNodos()).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("/{id}/nodes/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNodo(@PathParam("id") int id, @PathParam("id2") int id2, Object entity) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            GrafoList.get(id-1).getNodo(id2-1).setEntity(entity);   
            
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("/{id}/edges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAristas(@PathParam("id") int id) {
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    
                    return Response.ok(graph.getAristas()).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("/{id}/edges")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addArista(@PathParam("id") int id, Aristas arista){
        Grafo grafo = new Grafo(id);
        if (GrafoList.contains(grafo)){
            for(Grafo graph :GrafoList){
                if (graph.getId() == id){
                    arista.setId(contAristas);
                    graph.aristas.add(arista);
                    contAristas++;
                    return Response.ok(arista.getId()).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
       
    }
    
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
    
    @DELETE 
    @Path("/{id}/nodes") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarNodos(@PathParam("id") int id) { 
        Grafo grafo = new Grafo(id); 
        if (GrafoList.contains(grafo)){ 
            GrafoList.get(id-1).getNodos().clear();    
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); 
    } 
     
    @DELETE 
    @Path("/{id}/nodes/{id2}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarNodo(@PathParam("id") int id, @PathParam("id2") int id2) { 
        Grafo grafo = new Grafo(id); 
        if (GrafoList.contains(grafo)){ 
            GrafoList.get(id-1).getNodos().remove(id2-1);    
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); 
    } 
    
    @DELETE 
    @Path("/{id}/edges") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarAristas(@PathParam("id") int id) { 
        Grafo grafo = new Grafo(id); 
        if (GrafoList.contains(grafo)){ 
            GrafoList.get(id-1).getAristas().clear();    
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); 
    } 
     
    @DELETE 
    @Path("/{id}/edges/{id2}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response eliminarArista(@PathParam("id") int id, @PathParam("id2") int id2) { 
        
        Grafo grafo = new Grafo(id); 
        if (GrafoList.contains(grafo)){ 
            GrafoList.get(id-1).getAristas().remove(id2-1);    
             
            return Response.ok().build(); 
        } 
        return Response.status(Response.Status.NOT_FOUND).build(); 
    }
    
    @GET
    @Path("/{id}/graphs/{id1}/nodes/{id2}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response RutaMasCorta(@PathParam("id") int id, @PathParam("id1") int id1, @PathParam("id2") int id2) { 
        ruta_primaria(id, id1, id2);    //Llama a la funcion para analizar la mejor ruta
        int aux = 0;    
        Ruta auxRuta = null;
        if (MejorRuta.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }else{
        for (Ruta rutas :MejorRuta){
            if (rutas.getPeso() > aux){
                aux = rutas.getPeso();
                auxRuta = rutas;
            }
        }
        
        }
        return Response.ok(auxRuta).build();
    }
    
    public void ruta_primaria(int id, int id1, int id2){
        int pos = GrafoList.indexOf(id);    
        Grafo grafo = GrafoList.get(pos);   
                    for(Aristas aris :grafo.getAristas()){
                        if(aris.getStart() == id1){
                            if(aris.getEnd() == id2 && !visitado.contains(aris.getId())){
                                pila.add(aris.getStart());
                                pila.add(aris.getEnd());
                                peso = aris.getPeso();
                                visitado.add(aris.getId());
                                while(!pila.isEmpty()) ruta+=(pila.pop() + " ");
                                Ruta rutas = new Ruta(peso, ruta);
                                MejorRuta.add(rutas);
                                peso = 0;
                                pila = null;
                                break;
                            }
                            else{
                                int aux = aris.getEnd();
                                ruta(grafo, aux, id2);
                            }
                        }
                    }
        
    }
    
    public void ruta(Grafo grafo, int id, int id2){
        for(Aristas arista :grafo.getAristas()){
            if(arista.getStart() == id){
                for(Aristas aristaux :grafo.getAristas()){
                    if(aristaux.getEnd() == id2 && !visitado.contains(aristaux.getId())){
                                pila.add(aristaux.getStart());
                                pila.add(aristaux.getEnd());
                                peso += aristaux.getPeso();
                                visitado.add(aristaux.getId());
                                while(!pila.isEmpty()) ruta+=(pila.pop() + " ");
                                Ruta rutas = new Ruta(peso, ruta);
                                MejorRuta.add(rutas);
                                peso = 0;
                                pila = null;
                                break;
                    
                    }
                    else{
                        pila.add(aristaux.getStart());
                        pila.add(aristaux.getEnd());
                        peso += aristaux.getPeso();
                        ruta(grafo, aristaux.getEnd(), id2);
                        
                }
            }}
        }
        
    }
    
   
    
    
    
}
