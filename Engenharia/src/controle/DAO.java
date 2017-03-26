package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Jogador;

public class DAO {
	
	private Connection con;
	private String sql = null;
	
	public void deleteJogador(String nome) {
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			int id = buscaId(nome);

			JOptionPane.showMessageDialog(null, id);
			PreparedStatement stmt = con.prepareStatement("DELETE FROM jogador WHERE id_jogador = ?;");
			stmt.setString(1, nome);
			stmt.executeUpdate(sql);
			con.commit();
			stmt.close();			
			con.close();
			JOptionPane.showMessageDialog(null,"Jogador deletado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar jogador!");
		}
	}
	
	public void insert(Jogador jogador) {		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();

			sql = "INSERT INTO jogador (nome, icone, senha)"
					+ "VALUES ('"+jogador.getNome()+"','"+jogador.getIcone()+"','"+ jogador.getSenha() +"');";			
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
			JOptionPane.showMessageDialog(null,"Jogador cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar jogador!");
		}
	}
	
	public void updateJogador(Jogador novo, Jogador antigo) {
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);

			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE jogador "
					+ "SET nome= '"+novo.getNome()+"', senha='"+ novo.getSenha() +"', icone= '"+ novo.getIcone()+"'"
							+ " WHERE id_jogador="+antigo.getId());
			con.commit();
			stmt.close();
			con.close();			
			JOptionPane.showMessageDialog(null, "Jogador atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar jogador!");
		}
	}
	

	public ArrayList<Jogador> searchJogador() {
		ArrayList<Jogador> jogadores = new ArrayList<>();
		Jogador jogador;
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(" SELECT * FROM jogador;");
			while ( rs.next() ) {
				jogador = new Jogador();
				jogador.setId(rs.getInt("id_jogador"));
				jogador.setNome(rs.getString("nome"));
				jogador.setPontuacao(rs.getInt("pontuacao"));				
				jogador.setIcone(rs.getString("icone"));
				jogador.setTempo_rodadas(rs.getDouble("tempo_rodadas"));
				jogador.setUltima_partida(rs.getDate("ultima_partida"));
				jogador.setPartidas_vencidas(rs.getInt("partidas_vencidas"));
//				jogador.setPecas(rs.getInt("pecas"));
//				tem que colocar pra pegar o id da partida
				
				jogadores.add(jogador);				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar jogadores!");
		}
		return jogadores;		
	}
	
	public Jogador findJogador(String nome) {
		Jogador jogador = null;
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
					
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM jogador WHERE nome = '"+ nome +"';");

			if(!rs.next())
				throw new SQLException();
				
			jogador = new Jogador();
			jogador.setId(rs.getInt("id_jogador"));
			jogador.setNome(rs.getString("nome"));
			jogador.setSenha(rs.getString("senha"));
			jogador.setIcone(rs.getString("icone"));
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Jogador não encontrado!");
		} 		
		return jogador;
	}
	
	public boolean searchJogador(String nome) {
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM jogador WHERE nome = '"+ nome +"';");
			//se existir um proximo
			if(rs.next()) {
				con.close();
				return true;			
			}
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Jogador não encontrado!");
		}
		return false;
	}
	
	public boolean checkLogin(Jogador jogador) {
		Statement stmt;
		ResultSet rs;
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM jogador WHERE nome = '"+ 
					jogador.getNome() +"' AND senha = '"+ jogador.getSenha() +"';");
			if (rs.next()){
				con.close();
				return true;
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int buscaId(String nome) {
		int id = 0;
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_jogador FROM jogador WHERE nome = '"
					+ nome + "'");
		
			if (rs.next())
				id = rs.getInt(1);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID!");
		}
		return id;
	}
	
	public static int buscaId(Statement stmt) {
		int lastId = 0;
		
		try {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				lastId = rs.getInt(1);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID!");
		}
		return lastId;
	}
}
