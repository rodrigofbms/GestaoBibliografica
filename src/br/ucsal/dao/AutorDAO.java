package br.ucsal.dao;

import br.ucsal.entidades.Autor;
import br.ucsal.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutorDAO {

    private Conexao conexao;

    public boolean deletar(Autor autor) {
        return deletar(autor.getId());
    }

    public boolean deletar(Integer idDeletar) {
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("DELETE Autores WHERE id = ?;");
            ps.setInt(1, idDeletar);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void inserir(Autor autor) {
        try {

            PreparedStatement ps = conexao.getConnection()
                    .prepareStatement("insert into Autores (Nome,sobrenome) values (?,?);");
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getSobrenome());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Autor getById(int id){
        Autor autor = null;
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement("select id, nome, sobrenome from autores where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setSobrenome(rs.getString("sobrenome"));
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
    return autor;
    }

}
