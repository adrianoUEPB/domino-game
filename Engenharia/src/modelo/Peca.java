package modelo;

import java.awt.Cursor;
import java.awt.Image;

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
	
	public int rotacao;
	public int direcao;
	
	public Peca(int valor1, int valor2, boolean virada){
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.virada = virada;
		imagem = new ImageIcon(".\\image\\peca\\peca" + valor1 + valor2 + ".png");
	}

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
	
	public void drawPeca(JPanel painel, int posicaoX, int posicaoY, int rotacao){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		
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
			ImageIcon desvirada = new ImageIcon(".\\image\\peca\\pecaOff.png");
			if (rotacao == 0){
				l.setIcon(desvirada);
				l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
			} else if (rotacao == 1){
				RotatedIcon rimagem = new RotatedIcon(desvirada, RotatedIcon.Rotate.DOWN);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.altura, this.largura);
			} else if (rotacao == 2){
				RotatedIcon rimagem = new RotatedIcon(desvirada, RotatedIcon.Rotate.UPSIDE_DOWN);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.largura, this.altura);
			} else if (rotacao == 3){
				RotatedIcon rimagem = new RotatedIcon(desvirada, RotatedIcon.Rotate.UP);
				l.setIcon(rimagem);
				l.setBounds(this.posicaoX, this.posicaoY, this.altura, this.largura);
			}
		}
		
		this.rotacao = rotacao;
		
		l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		painel.add(l);
	}
	
	public void drawPecaScaled(JPanel painel, int posicaoX, int posicaoY, int rotacao, int direcao){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		
		if (rotacao == -1){
			rotacao = 3;
		}
		
		Image img = imagem.getImage();
		Image scaledImg = img.getScaledInstance(largura/2 + (largura/2)/2, altura/2 + (altura/2)/2,  java.awt.Image.SCALE_SMOOTH);
		imagem = new ImageIcon(scaledImg);
		
		JLabel l = new JLabel();
		l.setName("" + valor1 + valor2);
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
		
		this.rotacao = rotacao;
		this.direcao = direcao;
		
		l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		painel.add(l);
	}
	
	/**
	 * calcularPosicaoPeca() eh o metodo reponsavel pelos cálculos que desenharão a peça
	 * no painel em determinada posicao X e Y.
	 * Direção 0 = baixo.. direção 1 = esquerda. Direção 2 = Cima.. direção 3 = direita.
	 * será visto a direção que a peça será desenhada, e se cabe no painel
	 * @return [X,Y]
	 */
	
	public void calcularPosicaoPeca(JPanel painel, Peca ext, Peca first, int direcao, int rotacao){
		int[] posicoes = new int[]{ext.posicaoX, ext.posicaoY};
		
		if (rotacao == -1)
			rotacao = 3;
		if (direcao == -1)
			direcao = 3;
		
		// coloca a primeira após a peça que inicia o jogo
		if (ext.equals(first)){
			if (direcao == 1){
				drawPecaScaled(painel, posicoes[0] - 60, posicoes[1] + 20, rotacao, 1);
				return;
			} else if (direcao == 3) {
				drawPecaScaled(painel, posicoes[0] + 27, posicoes[1] + 20, rotacao, 3);
				return;
			}
		} else {
			if (ext.direcao != direcao){
				System.out.println("ext.direcao " + ext.direcao + " -- direcao " + direcao);
				calcularPosicaoPeca(painel, ext, first, direcao-1, rotacao-1);
				return;
			} else {
				// direção para baixo
				if (direcao == 0){
					if ((ext.posicaoY + 130) > painel.getHeight()){
						if (ext.rotacao == 0 || ext.rotacao == 2){
							drawPecaScaled(painel, posicoes[0] + 27, posicoes[1] + 38, rotacao-1, 3);
							return;
						} else {
							calcularPosicaoPeca(painel, ext, first, 3, rotacao-1);
							return;
						}
					} else {
						if (ext.direcao == 0){
							if (rotacao == 1 || rotacao == 3){
								drawPecaScaled(painel, posicoes[0], posicoes[1] + 60, rotacao-1, 0);
								return;
							} else {
								drawPecaScaled(painel, posicoes[0], posicoes[1] + 60, rotacao, 0);
								return;
							}
						} else {
							calcularPosicaoPeca(painel, ext, first, ext.direcao, rotacao);
							return;
						}
					}
				// direção para esquerda
				} else if (direcao == 1){
					if ((ext.posicaoX - 60) < 0){
						if (ext.rotacao == 1 || ext.rotacao == 3){
							drawPecaScaled(painel, posicoes[0], posicoes[1] + 22, rotacao-1, 0);
							return;
						} else {
							calcularPosicaoPeca(painel, ext, first, 0, rotacao-1);
							return;
						}
					} else {
						if (ext.direcao == 1){
							if (rotacao == 0 || rotacao == 2){
								drawPecaScaled(painel, posicoes[0] - 60, posicoes[1], rotacao-1, 1);
								return;
							} else {
								drawPecaScaled(painel, posicoes[0] - 60, posicoes[1], rotacao, 1);
								return;		
							}
						} else {
							calcularPosicaoPeca(painel, ext, first, ext.direcao, rotacao);
							return;
						}
					}
				// direção para cima
				} else if (direcao == 2){
					if ((ext.posicaoY - 60) < 0){
						if (ext.rotacao == 0 || ext.rotacao == 2){
							drawPecaScaled(painel, posicoes[0] - 60, posicoes[1] + 7, rotacao-1, 1);
							return;
						} else {
							calcularPosicaoPeca(painel, ext, first, 1, rotacao-1);
							return;
						}
					} else {
						if (ext.direcao == 2){
							if (rotacao == 1 || rotacao == 3){
								drawPecaScaled(painel, posicoes[0], posicoes[1] - 60, rotacao-1, 2);
								return;
							} else {
								drawPecaScaled(painel, posicoes[0], posicoes[1] - 60, rotacao, 2);
								return;		
							}
						} else {
							calcularPosicaoPeca(painel, ext, first, ext.direcao, rotacao);
							return;
						}
					}
				// direção para direita
				} else if (direcao == 3){
					if ((ext.posicaoX + 110) > painel.getWidth()){
						if (ext.rotacao == 1 || ext.rotacao == 3){
							drawPecaScaled(painel, posicoes[0] + 31, posicoes[1] - 65, rotacao-1, 2);
							return;
						} else {
							calcularPosicaoPeca(painel, ext, first, 2, rotacao-1);
							return;
						}
					} else {
						if (ext.direcao == 3){
							if (rotacao == 0 || rotacao == 2){
								drawPecaScaled(painel, posicoes[0] + 60, posicoes[1], rotacao-1, 3);
								return;
							} else {
								drawPecaScaled(painel, posicoes[0] + 60, posicoes[1], rotacao, 3);
								return;
							}
						} else {
							calcularPosicaoPeca(painel, ext, first, ext.direcao, rotacao);
							return;
						}
					}
				}
			}
		}
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
