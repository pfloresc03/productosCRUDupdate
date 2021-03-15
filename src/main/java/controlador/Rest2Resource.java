/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import modelo.Productos;
import modelo.ProductosCRUD;

/**
 * REST Web Service
 *
 * @author DAW2-PROFESOR
 */
@Path("rest2")
public class Rest2Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Rest2Resource
     */
    public Rest2Resource() {
    }

    /**
     * Retrieves representation of an instance of controlador.Rest2Resource
     * @return an instance of java.lang.String
     */
       @GET
       public String ping(){
           return "Probando REST";
       }
    
       @GET
       @Path("/test/{nombre}")
       public String ping2(@PathParam("nombre") String nombre){
           return "Probando" + nombre;
       }
       
   @GET
   @Path("/persona")
   @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
     String persona = "{\"nombre\":\"Juan\",\"contraseña\";\"1234\",\"pais\":\"España\"}";
       
     ResponseBuilder res = Response.ok(persona);   
    return res.build();
    }
    
    
    @GET
   @Path("/producto/{id}")
   @Produces(MediaType.APPLICATION_JSON)
    public Response getProductoJson(@PathParam("id") int id  ) {
        Productos miProducto = ProductosCRUD.getProducto(id);
        String nombre = miProducto.getNombre();
        String imagen = miProducto.getImagen();
        
        String persona = "{\"nombre\":\""+nombre+"\",\"imagen\":\""+imagen+"\",\"pais\":\"España\"}";
       
     ResponseBuilder res = Response.ok(persona);   
    return res.build();
    }

//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    /**
     * PUT method for updating or creating an instance of Rest2Resource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
