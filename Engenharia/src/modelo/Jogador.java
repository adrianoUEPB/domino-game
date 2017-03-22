package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Jogador {
	private int id;
	private String nome;
	private String senha;
	private String icone;
	private ArrayList<Peca> pecas_mao;
	private int pontuacao;
	private double tempo_rodadas;
	private Date ultima_partida;
	private int partidas_vencidas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public double getTempo_rodadas() {
		return tempo_rodadas;
	}
	public void setTempo_rodadas(double tempo_rodadas) {
		this.tempo_rodadas = tempo_rodadas;
	}
	public Date getUltima_partida() {
		return ultima_partida;
	}
	public void setUltima_partida(Date ultima_partida) {
		this.ultima_partida = ultima_partida;
	}
	public int getPartidas_vencidas() {
		return partidas_vencidas;
	}
	public void setPartidas_vencidas(int partidas_vencidas) {
		this.partidas_vencidas = partidas_vencidas;
	}
//	public int getPecas() {
//		return pecas;
//	}
//	public void setPecas(int pecas) {
//		this.pecas = pecas;
//	}
}