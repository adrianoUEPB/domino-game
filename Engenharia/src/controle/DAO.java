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

			PreparedStatement stmt = con.prepareStatement("DELETE FROM jogador WHERE id_jogador = ?;");
			stmt.setString(1, nome);
			stmt.executeUpdate();
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
			PreparedStatement stmt = con.prepareStatement("INSERT INTO jogador (nome, icone, senha)"
					+ "VALUES (?, ?, ?);");
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getIcone());
			stmt.setString(3, jogador.getSenha());
	
			stmt.executeUpdate();
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

			PreparedStatement stmt = con.prepareStatement("UPDATE jogador "
					+ "SET nome= ?, senha= ?, icone= ? WHERE id_jogador= ?");
			stmt.setString(1, novo.getNome());
			stmt.setString(2, novo.getSenha());
			stmt.setString(3, novo.getIcone());
			stmt.setInt(4, antigo.getId());
			
			
			stmt.executeUpdate();
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
					
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				throw new SQLException();
				
			jogador = new Jogador();
			jogador.setId(rs.getInt("id_jogador"));
			jogador.setNome(rs.getString("nome"));
			jogador.setSenha(rs.getString("senha"));
			jogador.setIcone(rs.getString("icone"));
			jogador.setPontuacao(rs.getInt("pontuacao"));
			
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
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
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
		
		ResultSet rs;
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ? AND senha = ?;");
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getSenha());
			rs = stmt.executeQuery();
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
			PreparedStatement stmt = con.prepareStatement("SELECT id_jogador FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
		
			if (rs.next())
				id = rs.getInt(1);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID!");
		}
		return id;
	}
	
	public void salvarPontuacao(int id_jogador, int pontuacao) {
		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			PreparedStatement stmt = con.prepareStatement("UPDATE jogador SET pontuacao = ? WHERE id_jogador = ?;");
			stmt.setInt(1, pontuacao);
			stmt.setInt(2, id_jogador);
			
			stmt.executeUpdate();
			stmt.close();
			con.commit();
			con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
