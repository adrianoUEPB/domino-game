package modelo;

public class Jogador extends Participante {
	private static final long serialVersionUID = 1L;
	
	private String senha;
	private String ultima_partida;
	
	public Jogador() {
		super();
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUltima_partida() {
		return ultima_partida;
	}
	public void setUltima_partida(String ultima_partida) {
		this.ultima_partida = ultima_partida;
	}
}