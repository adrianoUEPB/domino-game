package modelo;

import java.util.ArrayList;

public class Partida {
	private int id_partida;
//	private List<Jogada> jogadas;
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
	
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
//	public List<Jogada> getJogadas() {
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
