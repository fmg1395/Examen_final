<%-- 
    Document   : index
    Created on : 23/06/2020, 10:47:54 AM
    Author     : frank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="content">
            <form id='form_login' name='form_login' onsubmit='return obtenerLogin()'>
                <img class="avatar" src="img/arroba.png" alt="logo email">
                <input id ='idCorreo' name="idCorreo" type="text" placeholder="Login">
                <input id ='idPass' name="idPass" type="password" placeholder="Password">     
                <input type="submit" name= "btnLogIn" value="Sign in">
            </form>
        </div>
    </body>
</html>
