<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.gestorcasilleros.model.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
    <h2>Lista de Usuarios</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
        </tr>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
        %>
        <tr>
            <td><%= usuario.getId() %></td>
            <td><%= usuario.getNombre() %></td>
            <td><%= usuario.getEmail() %></td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="3">No hay usuarios</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
