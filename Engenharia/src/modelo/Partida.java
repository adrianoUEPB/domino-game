package modelo;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> refs/remotes/origin/principal

public class Partida {
	private int id_partida;
//	private List<Jogada> jogadas;
<<<<<<< HEAD
	private Participante lastWin; //flag para identificar ultimo participante ganhador
	private List<Participante> participantes;
	private int[] pontuacao_jogadores;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	int extremidade1;
	int extremidade2;
	int rodada;
=======
	private Jogador jogador;
	private ArrayList<InteligenciaArtificial> ias;
	private int[] pontuacao_jogadores;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	int extremidade1;
	int extremidade2;
	int rodada;
	
	public Partida(Jogador jogador, ArrayList<InteligenciaArtificial> ias){
		this.jogador = jogador;
		this.ias = ias;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 0;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
	}
>>>>>>> refs/remotes/origin/principal
	
	public Partida(List<Participante> participantes){
		
		this.participantes = participantes;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 0;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
	}
	
	/**
	 * firstBegin() é o método reponsável pelo inicio do jogo sem peças dormidas. O metodo irá verificar qual jogador que possui o carroção de 6
	 * O jogador que possuir este carroção irá começar jogando
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
<<<<<<< HEAD
	public Participante getLastWin() {
		return lastWin;
	}

	public void setLastWin(Participante lastWin) {
		this.lastWin = lastWin;
	}

	//	public List<Jogada> getJogadas() {
=======
//	public List<Jogada> getJogadas() {
>>>>>>> refs/remotes/origin/principal
//		return jogadas;
//	}
//	public void setJogadas(List<Jogada> jogadas) {
//		this.jogadas = jogadas;
//	}
//	public Jogador getJogador() {
//		return jogador;
//	}
//	public void setJogador(Jogador jogador) {
//		this.jogador = jogador;
//	}
//	public List<InteligenciaArtificial> getIas() {
//		return ias;
//	}
//	public void setIas(List<InteligenciaArtificial> ias) {
//		this.ias = ias;
//	}
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
