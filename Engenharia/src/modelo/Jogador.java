package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Jogador extends Participante {

	private String senha;
	private Date ultima_partida;
<<<<<<< HEAD
=======
	private int partidas_vencidas;
	private ArrayList<Peca> pecas;

	public Jogador() {
		if(pecas == null)
			pecas = new ArrayList<>();
	}
	
	public Peca verificaCarroca() {
		for (Peca peca : pecas) {
			if(peca.getValor1() == peca.getValor2() && peca.getValor1() == 6)
				return peca;
		}		
		return null;
	}
	
	public boolean possuiPecas() {
		return !pecas.isEmpty();
	}
>>>>>>> refs/remotes/origin/principal
	
	public Jogador() {
		super();
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getUltima_partida() {
		return ultima_partida;
	}
	public void setUltima_partida(Date ultima_partida) {
		this.ultima_partida = ultima_partida;
	}
<<<<<<< HEAD

	
=======
	public int getPartidas_vencidas() {
		return partidas_vencidas;
	}
	public void setPartidas_vencidas(int partidas_vencidas) {
		this.partidas_vencidas = partidas_vencidas;
	}	
	public ArrayList<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}	
>>>>>>> refs/remotes/origin/principal
}