<%-- 
    Document   : redactar
    Created on : Jun 23, 2020, 10:04:56 PM
    Author     : jorih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="redactar.css" rel="stylesheet" type="text/css"/>
        <title>Redactar</title>
    </head>
    <body>
        <header>
        <nav class="menu">
                <ul>
                    <li><a href="">Enviar</li></a>
                    <li><a href="">Save</li></a>
                    <li><a href="">Importance</li></a>
                    <li><a href="">Sensitivity</li></a>
                    <li><a href="">Read confirmation</li></a>
                </ul> 
            </nav>
        </header>
        <hr>
        <form action="/my-handling-form-page" method="post">
            <ul>
                <li>
                    <label for="correo">Para:</label>
                    <input type="text" id="correo" name="correo">
                </li>
                <hr>
                <li>
                    <label for="asunto">Asunto:</label>
                    <input type="asunto" id="asunto" name="asunto">
                </li>
                <hr>
                <li>
                    <label for="msg">Mensaje:</label>
                    <textarea id="msg" name="msg"></textarea>
                </li>
            </ul>
        </form>
        <li><a href="sesion.jsp">Cancelar</li></a>
    </body>
</html>

