package modelo;

import java.util.ArrayList;

public class Participante {
	private int id;
	private String nome;
	private int pontuacao;
	private String icone;
	private int partidas_vencidas;
	private int tempo_rodadas;
	private ArrayList<Peca> pecas;
	
	public Participante() {
		if(pecas == null)
			pecas = new ArrayList<>();
	}
	
	public boolean verificaCarrocao() {
		for (Peca peca : pecas) {
			if(peca.getValor1() == 6 && peca.getValor2() == 6)
				return true;
		}		
		return false;
	}
	
	public boolean VerificarJogadaPossivel(int extremidade1, int extremidade2){
		for(Peca p: this.pecas){
			if(p.getValor1() == extremidade1 || p.getValor1() == extremidade2 ||
					p.getValor2() == extremidade1 || p.getValor2() == extremidade2){
				return true;
			}
		}
		return false;
	}

	public boolean noHasPeca() {
		return pecas.isEmpty();
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
		this.partidas_vencidas += partidas_vencidas;
	}
	public int getTempo_rodadas() {
		return tempo_rodadas;
	}
	public void setTempo_rodadas(int tempo_rodadas) {
		this.tempo_rodadas += tempo_rodadas; //soma pois ira pegar o valor da partida que possui e atualizar com a nova partida
	}
	public ArrayList<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}
}
