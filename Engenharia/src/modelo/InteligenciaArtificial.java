package modelo;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> refs/remotes/origin/principal

<<<<<<< HEAD

public class InteligenciaArtificial extends Participante {

	private boolean dificuldade;
=======
public class InteligenciaArtificial {
	private int id_ia;
	private String nome;
	private String icone;
	private ArrayList<Peca> pecas_mao;
	private boolean dificil;
>>>>>>> refs/remotes/origin/principal
	
<<<<<<< HEAD
	public InteligenciaArtificial() {
		super();
	}
	
}
=======
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
	public ArrayList<Peca> getPecas() {
		return pecas_mao;
	}
	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas_mao = pecas;
	}
//	public int getDificuldade() {
//		return dificuldade;
//	}
//	public void setDificuldade(int dificuldade) {
//		this.dificuldade = dificuldade;
//	}
}
>>>>>>> refs/remotes/origin/principal
