
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="menu.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/script.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
        <%
            String usuario = "user50516@demo.afterlogic.com";
            //new Usuario().getCorreo();
        %>
    </head>
    <body>
        <header>
            <nav class="navBar">
                <ul class="menu">
                    <%
                        out.println("<a class='Encabezado'>" + usuario + "</a>");
                    %>
                    <li><a href="#">Contacts</a></li>
                    <li><a href="#">Calendar</a></li>
                    <li><a href="#">Files</a></li>
                    <li><a href="#">Tasks</a></li>
                    <li class="settings"><a href="#">Settings</a></li>
                    <li><input id="logout" onClick='return logout();' type="submit" name= "btnLogOut" value="Logout"></li>
                </ul>   
            </nav>
        </header>
        <div id="content">

            <div id="menuEnviar">
                <ul>
                <a id="nuevo_mensaje" href="redactar.jsp">New Message</a>
                <br>
                <li> <a onclick="correosRecibidos();">
                        Inbox</a></li><br>
                <li> <a onclick="correosEnviados();">Sent</a></li> 
                <br></ul>
            </div>
            <div id="bandeja">
                <i class="fa fa-trash-o" style="font-size:30px;" onclick="eliminarCorreo();"></i>
            </div>
            <div id="correo">

            </div>
        </div>
    </body>
</html>
