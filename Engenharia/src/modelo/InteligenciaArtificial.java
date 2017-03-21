package modelo;

import java.util.List;

public class InteligenciaArtificial {
	private int id_ia;
	private String nome;
	private List<Peca> pecas;
	private int dificuldade;
	
	public int getId_ia() {
		return id_ia;
	}
	public void setId_ia(int id_ia) {
		this.id_ia = id_ia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
	
}
