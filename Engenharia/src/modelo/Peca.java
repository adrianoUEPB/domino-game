package modelo;

import javax.swing.ImageIcon;

public class Peca {
	ImageIcon imagem;
	int largura = 40;
	int altura = 85;
	public int valor1;
	public int valor2;
	int posicaoX;
	int posicaoY;
	boolean virada;
	
	public Peca(int valor1, int valor2){
		this.valor1 = valor1;
		this.valor2 = valor2;
		imagem = new ImageIcon(".\\image\\peca\\peca" + valor1 + valor2 + ".png");
	}
}
