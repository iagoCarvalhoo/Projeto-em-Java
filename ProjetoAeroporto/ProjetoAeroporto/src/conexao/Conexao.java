package conexao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

      private static final String url = "jdbc:mysql://172.18.0.2:3306/ProjetoAeroporto";
      private static final String usuario = "root";
      private static final String senha = "1234";

      private static Connection conn;

      public static Connection getConexao() {

            try {
                  if (conn == null) {
                        conn = DriverManager.getConnection(url, usuario, senha);
                        return conn;
                  } else {
                        return conn;
                  }

            } catch (SQLException e) {
                  e.printStackTrace();
                  return null;
            }
      }

}