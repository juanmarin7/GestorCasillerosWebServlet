package com.proyecto.gestorcasilleros.servlets;

import com.proyecto.gestorcasilleros.dao.UsuarioDAO;
import com.proyecto.gestorcasilleros.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
        req.setAttribute("usuarios", usuarios);
        req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
    }
    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nombre = req.getParameter("nombre");
    String email = req.getParameter("email");
    String contrasena = req.getParameter("contrasena");

    Usuario usuario = new Usuario(0, nombre, email, contrasena);
    //usuarioDAO.guardarUsuario(usuario);

    resp.sendRedirect("usuarios");
}

}
