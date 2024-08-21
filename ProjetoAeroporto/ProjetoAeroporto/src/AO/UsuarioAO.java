package AO;

import conexao.Conexao;
import entidade.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAO {

  public void cadastrarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuario (name, email) VALUES (?, ?)";

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = Conexao.getConexao();
      ps = conn.prepareStatement(sql);

      ps.setString(1, usuario.getNome());
      ps.setString(2, usuario.getEmail());

      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    String sql = "SELECT name, email FROM usuario";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = Conexao.getConexao();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setNome(rs.getString("name"));
        usuario.setEmail(rs.getString("email"));
        usuarios.add(usuario);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return usuarios;
  }
}