<%-- 
    Document   : listar
    Created on : 05-mar-2021, 20:53:22
    Author     : DAW2-PROFESOR
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de productos</h1>
        <% List<Productos> misProductos = (List<Productos>) request.getAttribute("misProductos");
        %>
        <table border="1">
            <tr><th>id</th><th>Nombre</th><td>Imagen</td><td>Categoría</td><td>Precio</td><td>Borrar</td></tr>
            <% for( Productos p: misProductos) { 
            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletProductos?op=borrar&id="+p.getId()+"'>Borrar</a>";
             %>
            <tr><td><%=p.getId()%></td><td><%=p.getNombre() %></td><td><%=p.getImagen() %></td>
                <td><%=p.getCategoria() %></td><td><%=p.getPrecio() %></td><td><%=cadenaBorrar%></td></tr>    
            
            <% } %>
        </table>
        <script>
            function Confirmation(){
                if ( confirm("Está seguro?")==true) {
                    alert("Procedo a borrar");
                    return true;
                }else {
                    alert("Operación cancelada");
                    return false;
                }
            }
        </script>
    </body>
</html>
