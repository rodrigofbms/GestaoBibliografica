package br.ucsal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.entidades.Usuario;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        if (!usuario.verificarUsuario(usuario)) {
            usuario.inserirUsuario(usuario);
        } else {

        }
    }

}