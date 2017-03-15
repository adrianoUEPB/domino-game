package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;


public class DAO {
	
	public void insert(Usuario usuario) {
		
		try {
			Connection con = new Conexao().conexao();
			con.setAutoCommit(false);
			String sql = null;
			
			Statement stmt = con.createStatement();
			
			sql = "INSERT INTO usuario (nome, senha, icone) "
					+ "VALUES ('"+usuario.getNome()+"','"+usuario.getSenha()+"', '"+usuario.getIcone()+"');";
			
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
			System.out.println("Usuario cadastrado com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar usuario!");
		}
	}
	
	public List<Usuario> search() {
		
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario;
		
		try {
			Connection con = new Conexao().conexao();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(" SELECT * FROM usuario;");
			while ( rs.next() ) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIcone(rs.getString("icone"));
				
				usuarios.add(usuario);				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao buscar usuarios!");
		}

		return usuarios;
		
	}
	
	
}
