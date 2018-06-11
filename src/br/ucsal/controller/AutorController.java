package br.ucsal.controller;

import br.ucsal.dao.AutorDAO;
import br.ucsal.entidades.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AutorController")
public class AutorController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");

        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setSobrenome(sobrenome);

        AutorDAO autorDAO = new AutorDAO();
        autorDAO.inserir(autor);

        // FIX ME
        request.getRequestDispatcher("AutorHome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
