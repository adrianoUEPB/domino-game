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
	public Peca JogarPeca(int extremidade1, int extremidade2){
		if(super.VerificarJogadaPossivel(extremidade1, extremidade2)){
			if(dificil){
				// ia difícil em breve
			} else {
				// ia fácil
				for(Peca p: super.getPecas()){
					if(p.getValor1() == extremidade1 || p.getValor2() == extremidade1 ||
							p.getValor2() == extremidade1 || p.getValor2() == extremidade2){
						return p;
					}
				}
			}
		}
		// Metodo para chamar o jogador da vez
		return null;
	}

}



