<%-- 
    Document   : Registrar
    Created on : 25/04/2017, 12:42:58 AM
    Author     : moust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgendaOnline</title>
    </head>
    <body>
        <h1>Registrar</h1>
        <form action="RegisterController" method="POST">
            <div>    
                <label>Nombre Completo: <input type="text" name="nombre" value=""></label>
                <br></br>
                <label>Usuario: <input name="user" type="text" value=""></label>
                <br></br>
                <label>Password: <input name="password" type="password" value=""></label>
                <br></br>
                <input type="submit" value="Registrar" name="Registrar">
            </div>
        </form>
    </body>
</html>
