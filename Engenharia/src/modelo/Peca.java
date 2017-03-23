package modelo;

import javax.swing.ImageIcon;

public class Peca {
	ImageIcon imagem;
	int largura = 40;
	int altura = 85;
	private int valor1;
	private int valor2;
	int posicaoX;
	int posicaoY;
	boolean virada;
	
	public Peca(int valor1, int valor2){
		this.valor1 = valor1;
		this.valor2 = valor2;
		imagem = new ImageIcon(".\\image\\peca\\peca" + valor1 + valor2 + ".png");
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
}
