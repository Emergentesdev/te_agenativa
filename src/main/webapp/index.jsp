<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Contacto"%>
<%
    ArrayList<Contacto> lista =  (ArrayList<Contacto>) request.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de contactos</h1>
        <p>Nuevo contacto</p>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Correo</td>
                <td>Teléfono</td>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.telefono}</td>
                    <td>${item.correo}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
