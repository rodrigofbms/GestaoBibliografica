package br.ucsal.dao;

import br.ucsal.entidades.Autor;
import br.ucsal.entidades.Livro;
import br.ucsal.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Conexao conexao;

    public List<Livro> Consultar() {
        List<Livro> livros = new ArrayList<>();

        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("SELECT AUTORES.NOME, AUTORES.SOBRENOME, " +
                    "LIVROS.ID, NOMELIVRO, ID_AUTOR, EDITORA, EDICAO FROM LIVROS, AUTORES WHERE LIVROS.ID_AUTOR = AUTORES.ID);");
            ResultSet rs = ps.executeQuery();
            boolean achou = false;
            while (rs.next() && !achou) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("ID"));
                livro.setNome(rs.getString("NOMELIVROS"));
                livro.setEditora(rs.getString("EDITORA"));
                livro.setEdicao(rs.getInt("EDICAO"));

                Autor autor = new Autor();
                autor.setId(rs.getInt("ID_AUTOR"));
                autor.setNome(rs.getString("NOME"));
                autor.setSobrenome(rs.getString("SOBRENOME"));

                livro.setAutor(autor);

                if (rs.getInt("ID_AUTOR") == livro.getId() && rs.getString("NOMELIVRO").equals(livro.getNome())) {
                    achou = true;
                    livros.add(livro);
                }
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }


    public List<Livro> listar() {
        Statement stmt;
        List<Livro> livros = new ArrayList<>();
        try {
            stmt = conexao.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select LIVROS.ID, NOME, ID_AUTOR, EDICAO, EDITORA;");
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setEdicao(rs.getInt("edicao"));
                l.setEditora(rs.getString("editora"));

                Autor autor = new Autor();
                autor.setId(rs.getInt("autor_id"));
                autor.setNome(rs.getString("nome"));
                autor.setSobrenome(rs.getString("sobrenome"));

                l.setAutor(autor);


                livros.add(l);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }


    public void inserir(Livro livro) {
        try {

            PreparedStatement ps = conexao.getConnection()
                    .prepareStatement("insert into LIVROS (NOME, ID_AUTOR, EDICAO, EDITORA) values (?,?,?,?);");
            ps.setString(1, livro.getNome());
            ps.setInt(2, livro.getAutor().getId());
            ps.setInt(3, livro.getEdicao());
            ps.setString(4, livro.getEditora());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
