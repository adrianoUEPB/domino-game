package modelo;

public class Jogada {
	private int sequencia;
	private int[][] movimento;
	private int peca;
	
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	public int[][] getMovimento() {
		return movimento;
	}
	public void setMovimento(int[][] movimento) {
		this.movimento = movimento;
	}
	public int getPeca() {
		return peca;
	}
	public void setPeca(int peca) {
		this.peca = peca;
	}
}
