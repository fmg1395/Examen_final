<%-- 
    Document   : sesion
    Created on : 23 jun. 2020, 12:51:53
    Author     : Kike
--%>
<%--<%@page import="modelo.Usuario"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="menu.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <%
            String usuario="user50516@demo.afterlogic.com";
        //new Usuario().getCorreo();
        %>
    </head>
    <body>
        <header>
            <nav class="navBar">
               <ul class="menu">
                  <%
                   out.println("<a class='Encabezado'>"+usuario+"</a>");
                   %>
                   <li><a href="#">Contacts</a></li>
                   <li><a href="#">Calendar</a></li>
                   <li><a href="#">Files</a></li>
                   <li><a href="#">Tasks</a></li>
                   <li class="settings"><a href="#">Settings</a></li>
                   <li><input id="logout" type="submit" name= "btnLogOut" value="Logout"></li>
                </ul>   
            </nav>
        </header>
        <div id="content">
            
            </div><div id="botonEnviar">
                <input id="nuevo_mensaje" class="botonMensaje" value="New message">
                </input>       
        </div>
    </body>
</html>
