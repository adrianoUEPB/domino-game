package controle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Jogador;
import modelo.Partida;

public class DAO {
	
	private Connection con;
	private PreparedStatement stmt;
	
	public void salvarPartida(int id, Object partida) {
		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(partida);
			
			byte[] data = bos.toByteArray();
			
			if (PossuiJogoSalvoSemCon(id)) {
				Object[] options = { "SIM", "NÃO" };
				int opcao = JOptionPane.showOptionDialog(null, "Já possui jogo salvo, deseja continuar?", "Aviso",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);				
				if (opcao == 0) {

					stmt = con.prepareStatement("UPDATE partida SET partida = ? WHERE id_jogador = ?;");
					stmt.setObject(1, data);
					stmt.setInt(2, id);
					stmt.executeUpdate();
					con.commit();
					JOptionPane.showMessageDialog(null, "Partida salva!");
				}
			} else {
				stmt = con.prepareStatement("INSERT INTO partida (id_jogador, partida) VALUES (?, ?);");
				stmt.setInt(1, id);			
				stmt.setObject(2, data);
				stmt.executeUpdate();
				con.commit();
				JOptionPane.showMessageDialog(null, "Partida salva!");
			}
			
			oos.flush();
			oos.close();
			bos.close();
			stmt.close();
			con.close();

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na entrada de dados!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro no banco de dados!");
		}	
	}
	
	public void deletarPartida(int id) {
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("DELETE FROM partida WHERE id_jogador = ?;");
			stmt.setInt(1, id);			
			stmt.executeUpdate();
			con.commit();
			
			stmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro no banco de dados!");
		}	
	}
	
	/**
	 * Verifica se o jogador possui algum jogo já salvo, se possuir emitirá uma mensagem, caso concorde o jogo será salvo
	 * @param id
	 * @return boolean
	 */
	private boolean PossuiJogoSalvoSemCon(int id) {
		try {
			stmt = con.prepareStatement("SELECT partida FROM partida WHERE id_jogador = ?");
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				rs.close();
				stmt.close();
				return true;			
			}
			
			stmt.close();
			rs.close();			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na verificação do jogador!");
		} 
		
		return false;
	}
	/**
	 * Verifica se o jogador possui algum jogo já salvo, se possuir emitirá uma mensagem, caso concorde o jogo será salvo
	 * @param id
	 * @return boolean
	 */
	public boolean PossuiJogoSalvo(int id) {
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("SELECT partida FROM partida WHERE id_jogador = ?");
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				rs.close();
				stmt.close();
				con.close();
				return true;			
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na verificação do jogador!");
		} 
		
		return false;
	}
	
	public Partida resgatarPartida(int id) {
		
		Partida partida = null;
			
		try {
			con = new Conexao().conexao();


			stmt = con.prepareStatement("SELECT partida FROM partida WHERE id_jogador = ?");
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes("partida"));
				ObjectInputStream ins = new ObjectInputStream(bais);
				
				partida = (Partida) ins.readObject();
				
			}

			stmt.close();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na entrada de dados!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro no banco de dados!");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro na recuperação dos dados!");
			e.printStackTrace();
		}
		
		return partida;
	}
	
	public void resetarRanking() {
		try {
			
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement("UPDATE jogador SET pontuacao = 0, "
					+ "tempo_rodadas = 0, ultima_partida = null, partidas_vencidas = 0");
			stmt.executeUpdate();
			con.commit();

			stmt.close();			
			con.close();
			JOptionPane.showMessageDialog(null, "Ranking resetado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao resetar o ranking!");
		}
	}
	
	public void insert(Jogador jogador) {		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("INSERT INTO jogador (nome, icone, senha, pontuacao, tempo_rodadas, partidas_vencidas)"
					+ "VALUES (?, ?, ?, 0, 0, 0);");
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getIcone());
			stmt.setString(3, jogador.getSenha());
	
			stmt.executeUpdate();
			stmt.close();
			con.commit();
			con.close();
			JOptionPane.showMessageDialog(null,"Jogador cadastrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar jogador!");
		}
	}
	
	public void updatePontuacao(Jogador jogador) {
		try {
			
			DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date hoje = new java.util.Date();
			
			
			con = new Conexao().conexao();
			con.setAutoCommit(false);

			stmt = con.prepareStatement("UPDATE jogador "
					+ "SET pontuacao = ?, tempo_rodadas = ?, ultima_partida = ?, partidas_vencidas = ? WHERE id_jogador= ?");
			stmt.setInt(1, jogador.getPontuacao());
			stmt.setDouble(2, jogador.getTempo_rodadas());
			stmt.setString(3, formato.format(hoje));
			stmt.setInt(4, jogador.getPartidas_vencidas());
			stmt.setInt(5, jogador.getId());			
			
			stmt.executeUpdate();
			con.commit();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar pontuação do jogador " + jogador.getNome() + "!");
		}
	}
	
	public void updateJogador(Jogador novo, Jogador antigo) {
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);

			stmt = con.prepareStatement("UPDATE jogador "
					+ "SET nome= ?, senha= ?, icone= ? WHERE id_jogador= ?");
			stmt.setString(1, novo.getNome());
			stmt.setString(2, novo.getSenha());
			stmt.setString(3, novo.getIcone());
			stmt.setInt(4, antigo.getId());
			
			
			stmt.executeUpdate();
			con.commit();
			stmt.close();
			con.close();			
			JOptionPane.showMessageDialog(null, "Jogador atualizado!");
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
			stmt = con.prepareStatement("SELECT * FROM jogador;");
			
			ResultSet rs = stmt.executeQuery();
			while ( rs.next() ) {
				jogador = new Jogador();
				jogador.setId(rs.getInt("id_jogador"));
				jogador.setNome(rs.getString("nome"));
				jogador.setPontuacao(rs.getInt("pontuacao"));				
				jogador.setIcone(rs.getString("icone"));
				jogador.setTempo_rodadas(rs.getInt("tempo_rodadas"));
				jogador.setUltima_partida(rs.getString("ultima_partida"));
				jogador.setPartidas_vencidas(rs.getInt("partidas_vencidas"));
				
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
					
			stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				throw new SQLException();
				
			jogador = new Jogador();
			jogador.setId(rs.getInt("id_jogador"));
			jogador.setNome(rs.getString("nome"));
			jogador.setSenha(rs.getString("senha"));
			jogador.setIcone(rs.getString("icone"));
			jogador.setPartidas_vencidas(rs.getInt("partidas_vencidas"));
			jogador.setTempo_rodadas(rs.getInt("tempo_rodadas"));
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
			
			stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			//se existir um proximo
			if(rs.next()) {
				rs.close();
				stmt.close();
				con.close();
				return true;			
			}
			stmt.close();
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
			
			stmt = con.prepareStatement("SELECT * FROM jogador WHERE nome = ? AND senha = ?;");
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getSenha());
			rs = stmt.executeQuery();
			if (rs.next()){
				stmt.close();
				con.close();
				return true;
			}
			stmt.close();
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
			stmt = con.prepareStatement("SELECT id_jogador FROM jogador WHERE nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
		
			if (rs.next())
				id = rs.getInt(1);
			
			rs.close();
			stmt.close();
			con.close();			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID!");
		}
		return id;
	}
	
	public void salvarPontuacao(int id_jogador, int pontuacao) {
		
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement("UPDATE jogador SET pontuacao = ? WHERE id_jogador = ?;");
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
	
	public ArrayList<Jogador> rankingDAO() {
		
		ArrayList<Jogador> top5 = new ArrayList<>();
		
		try {
			con = new Conexao().conexao();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("SELECT * FROM jogador ORDER BY pontuacao DESC, partidas_vencidas DESC, tempo_rodadas DESC, ultima_partida DESC LIMIT 5;");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Jogador jogador_ranking = new Jogador();
				jogador_ranking.setId(rs.getInt("id_jogador"));
				jogador_ranking.setNome(rs.getString("nome"));
				jogador_ranking.setIcone(rs.getString("icone"));
				jogador_ranking.setPontuacao(rs.getInt("pontuacao"));
				jogador_ranking.setTempo_rodadas(rs.getInt("tempo_rodadas"));
				jogador_ranking.setUltima_partida(rs.getString("ultima_partida"));
				jogador_ranking.setPartidas_vencidas(rs.getInt("partidas_vencidas"));
				
				top5.add(jogador_ranking);
			}
			
			rs.close();
			stmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return top5;
	}
	
	public static int buscaId(Statement stmt) {
		int lastId = 0;
		
		try {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				lastId = rs.getInt(1);
			
			rs.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar ID!");
		}
		return lastId;
	}
	
	
}
