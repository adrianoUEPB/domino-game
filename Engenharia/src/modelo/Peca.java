package modelo;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.RotatedIcon;

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
	
	public void drawPeca(JPanel painel, int posicaoX, int posicaoY, int rotacao){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		// rotacao
		// 0 = posicao original		-	 O
		//								 X
		//
		// 1 = 90º para a direita	-	 XO
		//
		// 2 = 180º para a direita	-	 X
		//								 O
		//
		// 3 = 270º para a direita	-	OX
		//
		
		JLabel l = new JLabel();
		l.setName("" + valor1 + valor2);
		if (this.virada){
			if (rotacao == 0){
				l.setIcon(imagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
			} else if (rotacao == 1){
				RotatedIcon rimagem = new RotatedIcon(imagem, RotatedIcon.Rotate.DOWN);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.altura, this.largura);
			} else if (rotacao == 2){
				RotatedIcon rimagem = new RotatedIcon(imagem, RotatedIcon.Rotate.UPSIDE_DOWN);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
			} else if (rotacao == 3){
				RotatedIcon rimagem = new RotatedIcon(imagem, RotatedIcon.Rotate.UP);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.altura, this.largura);
			}
		} else {
			l.setIcon(new ImageIcon(".\\image\\peca\\pecaOff.png"));
			l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
		}
		l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
