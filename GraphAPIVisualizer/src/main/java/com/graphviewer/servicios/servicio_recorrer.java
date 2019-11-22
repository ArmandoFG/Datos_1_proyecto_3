/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.servicios;

import com.graphviewer.dao.Recorrer_Grafos;
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
@Path("recorrer")
public class servicio_recorrer {
    private static List<Integer> List = Recorrer_Grafos.Recorrer();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response recorrer() {
       return Response.ok(List).build();
    }
}
