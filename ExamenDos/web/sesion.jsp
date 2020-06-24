
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="menu.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <%
            String usuario="eif209.una.ac.cr";
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
                   <li><a href="#"></a>Contacts</li>
                   <li><a href="#"></a>Calendar</li>
                   <li><a href="#"></a>Files</li>
                   <li><a href="#"></a>Tasks</li>
                   <li><a href="#"></a>Settings</li>
                   <li><input id="logout" type="submit" value="Logout"></li>
                </ul>   
            </nav>
        </header>
        <h1>
            
        </h1>
    </body>
</html>
