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
        <script src="JavaScript/script.js" type="text/javascript"></script>
        <title>Redactar</title>
    </head>
    <body>
        <header>
            <nav class="menu">
                <ul>
                    <li><a href='sesion.jsp' onclick='return enviarCorreo();'>Enviar</a></li>
                    <li><a>Save</a></li>
                    <li><a href="">Importance</a></li>
                    <li><a href="">Sensitivity</a></li>
                    <li><a href="">Read confirmation</a></li>
                </ul> 
            </nav>
        </header>
        <hr>
        <form action="/my-handling-form-page" method="post">
            <ul>
                <li>
                    <label for="correo">Para:</label>
                    <input onClick='return recuperarUsuarios();' type="text" id="correo" name="correo">
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
    <div> 
        <table>
            <tbody id='tabla_contactos'>
                
            </tbody>
        </table>
    </div>
</body>
</html>

