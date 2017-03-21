package modelo;

import java.util.List;

public class Partida {
	private int id_partida;
	private List<Jogada> jogadas;
	private Jogador jogador;
	private List<InteligenciaArtificial> ias;
	private List<Peca> pecas_campo;
	private List<Peca> pecas_dormidas;
	private int pontuacao;
	
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
	public List<Jogada> getJogadas() {
		return jogadas;
	}
	public void setJogadas(List<Jogada> jogadas) {
		this.jogadas = jogadas;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public List<InteligenciaArtificial> getIas() {
		return ias;
	}
	public void setIas(List<InteligenciaArtificial> ias) {
		this.ias = ias;
	}
	public List<Peca> getPecas_campo() {
		return pecas_campo;
	}
	public void setPecas_campo(List<Peca> pecas_campo) {
		this.pecas_campo = pecas_campo;
	}
	public List<Peca> getPecas_dormidas() {
		return pecas_dormidas;
	}
	public void setPecas_dormidas(List<Peca> pecas_dormidas) {
		this.pecas_dormidas = pecas_dormidas;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
	
}
