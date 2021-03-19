<%-- 
    Document   : login
    Created on : 19-mar-2021, 21:13:52
    Author     : DAW-A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Restaurante Bosco</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="ServletProductos?op=listar">Listar productos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletProductos?op=insert1"">Nuevo Producto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="servletLogin">Login</a>
      </li>
    </ul>
  </div>
</nav>
        <p>${mensaje}</p>
        <h1>Restaurante Bosco</h1>
        <form action="servletLogin" method="POST">
            Usuario: <input type="text" name="usuario"><br>
            Contraseña: <input type="password" name="password"><br>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
