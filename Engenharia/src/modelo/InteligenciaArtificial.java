package modelo;

public class InteligenciaArtificial extends Participante {

	private boolean dificil;

	public InteligenciaArtificial(String nome, String icone, boolean dificil) {
		super();
		super.setNome(nome);
		super.setIcone(icone);
		
		this.dificil = dificil;
	}

	public boolean isDificil() {
		return dificil;
	}
	public void setDificil(boolean dificil) {
		this.dificil = dificil;
	}
}



