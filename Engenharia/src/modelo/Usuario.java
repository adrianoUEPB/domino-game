package modelo;

public class Usuario {
	private int id;
	private String nome;
	private String senha;
	private String icone;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ID: " + getId());
		str.append("\tNome: " + getNome());
		str.append("\tSenha: " + getSenha());
		str.append("\tCaminho Icone: "+getIcone() + "\n");
		
		return str.toString();
	}
	
}

