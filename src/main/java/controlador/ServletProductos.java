/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import java.util.List;

/**
 *
 * @author DAW2-PROFESOR
 */
public class ServletProductos extends HttpServlet {
    private int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProductos at " + request.getContextPath() + "</h1>");
            if ( op.equals("listar")){
                List<Productos> misProductos = ProductosCRUD.getProductos();
                request.setAttribute("misProductos", misProductos);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                
//                for (Productos p: misProductos ){
//                    out.println(p.getNombre() );
//                }
            }
            if ( op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                 request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
            if ( op.equals("insert2")) { //cuando le indicamos que vaya a insertar
                
                    Productos miProducto = new Productos();
                    miProducto.setNombre(request.getParameter("nombre"));
                    miProducto.setImagen(request.getParameter("imagen"));
                    miProducto.setCategoria(request.getParameter("categoria"));
                    String precio=request.getParameter("precio");
                    miProducto.setPrecio(Float.parseFloat(precio));
                    ProductosCRUD.insertaProducto(miProducto);
                    out.println("<h1>Registro insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                    

            }
            if ( op.equals("borrar")) { //cuando le indicamos que vaya a borrar
                int id = Integer.parseInt(request.getParameter("id"));
                if ( ProductosCRUD.destroyProducto(id)>0 ) {
                    out.println("<h1>Registro Borrado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                }
                 
            }
            if ( op.equals("update1")) { //cuando le indicamos que vaya a borrar
                id = Integer.parseInt(request.getParameter("id"));
                Productos miProducto = ProductosCRUD.getProducto(id);
                request.setAttribute("miProducto", miProducto);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if ( op.equals("update2")) { //cuando le indicamos que vaya a borrar
               String nombre = request.getParameter("nombre");
               String imagen = request.getParameter("imagen");
               String categoria = request.getParameter("categoria");
               float precio = Float.parseFloat(request.getParameter("precio"));
                Productos miProducto = new Productos(id,nombre,imagen,categoria,precio);
                ProductosCRUD.insertaProducto(miProducto);
                String mensaje="Producto actualizado";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("miProducto", miProducto);
                request.getRequestDispatcher("update.jsp").forward(request, response);
//                int filas = ProductosCRUD.actualizaProducto(miProducto);
//                out.println("<h3>"+ filas + " filas actualizadas</h3>");
//                request.setAttribute("miProducto", miProducto);
//                request.getRequestDispatcher("update.jsp").forward(request, response);
            }

           
//            miProducto.setId(11);

            out.println("</body>");
            out.println("</html>");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
