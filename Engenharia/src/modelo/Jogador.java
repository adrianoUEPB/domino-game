package modelo;

import java.util.Date;

public class Jogador extends Participante {

	private String senha;
	private Date ultima_partida;
	
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
}