package modelo;

import java.util.ArrayList;


public class Partida {
	private int id_partida;
	private Participante lastWin; //flag para identificar ultimo participante ganhador
	private ArrayList<Participante> participantes;
	private int[] pontuacao_jogadores;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	int extremidade1;
	int extremidade2;
	int rodada;

	
	public Partida(ArrayList<Participante> participantes){
		
		this.participantes = participantes;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 0;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
	}
	
	/**
	 * firstBegin() � o m�todo repons�vel pelo inicio do jogo sem pe�as dormidas. O metodo ir� verificar qual jogador que possui o carro��o de 6
	 * O jogador que possuir este carro��o ir� come�ar jogando
	 * @return Participante
	 */
	
	public Participante firtBegin() {
		
		for (Participante participante : participantes) {
			if(participante.verificaCarrocao())
				return participante;
		}
		
		return null;		
	}
		
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}

	public Participante getLastWin() {
		return lastWin;
	}

	public void setLastWin(Participante lastWin) {
		this.lastWin = lastWin;
	}

	public ArrayList<Peca> getPecas_campo() {
		return pecas_campo;
	}
	public void setPecas_campo(ArrayList<Peca> pecas_campo) {
		this.pecas_campo = pecas_campo;
	}
	public ArrayList<Peca> getPecas_dormidas() {
		return pecas_dormidas;
	}
	public void setPecas_dormidas(ArrayList<Peca> pecas_dormidas) {
		this.pecas_dormidas = pecas_dormidas;
	}
	public int[] getPontuacao() {
		return pontuacao_jogadores;
	}
	public void setPontuacao(int[] pontuacao) {
		this.pontuacao_jogadores = pontuacao;
	}
}
