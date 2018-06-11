package br.ucsal.dao;

import br.ucsal.entidades.Autor;
import br.ucsal.entidades.Bibliografia;
import br.ucsal.entidades.Materia;
import br.ucsal.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BibliografiaDAO {

    private Conexao conexao;

    public List<Bibliografia> Consultar() {
        List<Bibliografia> bibliografias = new ArrayList<>();

        try {
            PreparedStatement ps = conexao.getConnection()
                    .prepareStatement("SELECT Bibliografia.Titulo, autor.Sobrenome, autor.Nome "
                            + "autor_bibliografia.id_autor, autor_bibliografia.id_bibliografia, editora, edicao FROM Bibliografia, autor, autor_bibliografia WHERE autor_bibliografia.id_autor = autor_bibliografia.id_bibliografia);");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bibliografia bibliografia = new Bibliografia();
                bibliografia.setId(rs.getInt("id_bibliografia"));
                bibliografia.setTitulo(rs.getString("Titulo"));
                bibliografia.setEditora(rs.getString("editora"));
                bibliografia.setEdicao(rs.getInt("edicao"));

                Autor autor = new Autor();
                autor.setId(rs.getInt("id_autor"));
                autor.setNome(rs.getString("Nome"));
                autor.setSobrenome(rs.getString("Sobrenome"));

                bibliografia.setAutor(autor);

                bibliografias.add(bibliografia);

            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bibliografias;
    }

    // A PROCURA DE UMA UTILIDADE DESSE METODO
    public List<Bibliografia> listar() {
        Statement stmt;
        List<Bibliografia> Bibliografias = new ArrayList<>();
        try {
            stmt = conexao.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select BibliografiaS.ID, Titulo, ID_AUTOR, EDICAO, EDITORA;");
            while (rs.next()) {
                Bibliografia l = new Bibliografia();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("Titulo"));
                l.setEdicao(rs.getInt("edicao"));
                l.setEditora(rs.getString("editora"));

                Autor autor = new Autor();
                autor.setId(rs.getInt("autor_id"));
                autor.setNome(rs.getString("Nome"));
                autor.setSobrenome(rs.getString("Sobrenome"));

                l.setAutor(autor);

                Bibliografias.add(l);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Bibliografias;
    }

    public void inserir(Bibliografia Bibliografia) {
        try {

            PreparedStatement ps = conexao.getConnection().prepareStatement(
                    "insert into Bibliografia (Titulo,id_Materia, EDICAO, EDITORA, id) values (?,?,?,?,?);");
            ps.setString(1, Bibliografia.getTitulo());
            ps.setInt(2, Bibliografia.getMateria().getId());
            ps.setInt(3, Bibliografia.getEdicao());
            ps.setString(4, Bibliografia.getEditora());
            ps.setInt(5, Bibliografia.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deletar(Bibliografia bibliografia) {
        return deletar(bibliografia.getId());
    }

    public boolean deletar(Integer idDeletar) {
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("DELETE Bibliografia WHERE id = ?;");
            ps.setInt(1, idDeletar);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean atualizar(Bibliografia bibliografia) {
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("update Bibliografia set titulo = ? , set edicao = ? , set editora = ? , set autor = ?, set matertia = ?");
            ps.setString(1, bibliografia.getTitulo());
            ps.setInt(2, bibliografia.getEdicao());
            ps.setString(3, bibliografia.getEditora());
            ps.setInt(4, bibliografia.getAutor().getId());
            ps.setInt(5, bibliografia.getMateria().getId());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bibliografia getById(int id) {
        Bibliografia bibliografia = null;
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("select id, titulo, edicao, editora, id_materia from bibliografia where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bibliografia = new Bibliografia();
                bibliografia.setId(rs.getInt("id"));
                bibliografia.setTitulo(rs.getString("titulo"));
                bibliografia.setEdicao(rs.getInt("edicao"));
                bibliografia.setEditora(rs.getString("editora"));

                Materia materia = new Materia();
                materia.setId(rs.getInt("id_materia"));
                bibliografia.setMateria(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return bibliografia;
    }

}
