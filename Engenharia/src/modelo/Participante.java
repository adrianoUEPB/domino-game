package modelo;

import java.util.ArrayList;

public class Participante {
	private int id;
	private String nome;
	private int pontuacao;
	private String icone;
	private int partidas_vencidas;
	private double tempo_rodadas;
	private ArrayList<Peca> pecas;
	
	public Participante() {
		if(pecas == null)
			pecas = new ArrayList<>();
	}
	
	public boolean verificaCarrocao() {
		for (Peca peca : pecas) {
			if(peca.getValor1() == peca.getValor2() && peca.getValor1() == 6)
				return true;
		}		
		return false;
	}
	
	public Peca pegaPeca(int valor1, int valor2) {
		if(pecas.isEmpty())
			return null;
		
		for (Peca peca : pecas) {
			if (peca.getValor1() == valor1 && peca.getValor2() == valor2)
				return peca;
		}
		
		return null;		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
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
	public int getPartidas_vencidas() {
		return partidas_vencidas;
	}

	public void setPartidas_vencidas(int partidas_vencidas) {
		this.partidas_vencidas = partidas_vencidas;
	}

	public double getTempo_rodadas() {
		return tempo_rodadas;
	}

	public void setTempo_rodadas(double tempo_rodadas) {
		this.tempo_rodadas = tempo_rodadas;
	}

	public ArrayList<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}
	
 
	
	
}