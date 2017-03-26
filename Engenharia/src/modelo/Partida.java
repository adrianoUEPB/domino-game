package modelo;

import java.util.ArrayList;


public class Partida {
	private int id_partida;
	public Participante lastWin; //flag para identificar ultimo participante ganhador
	public int[] pontuacao_jogadores;
	public ArrayList<Participante> participantes;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	public int extremidade1;
	public int extremidade2;
	public int rodada;

	
	public Partida(ArrayList<Participante> participantes){
		this.participantes = participantes;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 0;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
	}
	
	/**
	 * firstBegin() eh o metodo reponsavel pelo inicio do jogo sem pecas dormidas.
	 * O metodo ira verificar qual jogador que possui o carrocao de 6
	 * O jogador que possuir este carrocao ira comecar jogando
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
}
