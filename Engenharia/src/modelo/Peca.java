package modelo;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Peca {
	private int valor1;
	private int valor2;
	public ImageIcon imagem;
	public int largura = 40;
	public int altura = 85;
	public int posicaoX;
	public int posicaoY;
	public boolean virada;
	
	public Peca(int valor1, int valor2, boolean virada){
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.virada = virada;
		imagem = new ImageIcon(".\\image\\peca\\peca" + valor1 + valor2 + ".png");
	}
	
	public void drawPeca(JPanel painel, int posicaoX, int posicaoY){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		
		JLabel l = new JLabel();
		l.setName("" + valor1 + valor2);
		if (this.virada){
			l.setIcon(imagem);
		} else {
			l.setIcon(new ImageIcon(".\\image\\peca\\pecaOff.png"));
		}
		l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
		painel.add(l);
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
