package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Jogador;



public class DAO {
	
	private Connection con;
	
	public void insert(Jogador jogador) {		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			String sql = null;
			
			Statement stmt = con.createStatement();

			sql = "INSERT INTO jogador (nome, icone, senha)"
					+ "VALUES ('"+jogador.getNome()+"','"+jogador.getIcone()+"','"+ jogador.getSenha() +"');";			
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
			JOptionPane.showMessageDialog(null,"Jogador cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("CAdastro "+e.getMessage());
			System.err.println("Erro ao cadastrar jogador!");
		}
	}
	
	public void insertPartida() {
		
	}
	
	public List<Jogador> searchJogador() {
		
		List<Jogador> jogadores = new ArrayList<>();
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
				jogador.setPecas(rs.getInt("pecas"));
//				tem que colocar pra pegar o id da partida
				
				jogadores.add(jogador);				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao buscar jogadores!");
		}

		return jogadores;		
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
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean checkLogin(Jogador jogador) {
		con = new Conexao().conexao();
		Statement stmt;
		ResultSet rs;
		try {
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
	
	public static int buscaId(Statement stmt) {
		int lastId = 0;
		
		System.out.println("entrou no lastId");
		try {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				lastId = rs.getInt(1);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID");
		}
		
		return lastId;
	}
}
