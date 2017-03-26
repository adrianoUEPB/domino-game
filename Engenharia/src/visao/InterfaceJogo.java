package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Component;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class InterfaceJogo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel jogadorPecas, iaCimaPecas, iaEsquerdaPecas, iaDireitaPecas, tabuleiro;

	public InterfaceJogo(final Partida part){
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel iaUpPainel = new JPanel();
		iaUpPainel.setBackground(new Color(139, 0, 0));
		iaUpPainel.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaUpPainel, BorderLayout.NORTH);
		iaUpPainel.setLayout(new BoxLayout(iaUpPainel, BoxLayout.LINE_AXIS));
		
		JLabel blockCimEsq = new JLabel();
		blockCimEsq.setMinimumSize(new Dimension(100, 100));
		blockCimEsq.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(blockCimEsq);
		
		iaCimaPecas = new JPanel();
		iaCimaPecas.setBackground(new Color(139, 0, 0));
		iaCimaPecas.setMinimumSize(new Dimension(100, 100));
		iaCimaPecas.setMaximumSize(new Dimension(494, 100));
		iaUpPainel.add(iaCimaPecas);
		
		JLabel inforCima = new JLabel(new ImageIcon(part.participantes.get(1).getIcone()));
		inforCima.setVerticalTextPosition(SwingConstants.TOP);
		inforCima.setVerticalAlignment(SwingConstants.TOP);
		inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforCima.setMinimumSize(new Dimension(10, 100));
		inforCima.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(inforCima);
		
		JLabel blockCimDir = new JLabel();
		blockCimDir.setMinimumSize(new Dimension(100, 100));
		blockCimDir.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(blockCimDir);
		
		JPanel iaLeftPainel = new JPanel();
		iaLeftPainel.setBackground(new Color(139, 0, 0));
		iaLeftPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaLeftPainel, BorderLayout.WEST);
		iaLeftPainel.setLayout(new BoxLayout(iaLeftPainel, BoxLayout.PAGE_AXIS));
		
		JLabel inforEsquerda = new JLabel(new ImageIcon(part.participantes.get(3).getIcone()));
		inforEsquerda.setVerticalTextPosition(SwingConstants.TOP);
		inforEsquerda.setVerticalAlignment(SwingConstants.TOP);
		inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforEsquerda.setMinimumSize(new Dimension(100, 100));
		inforEsquerda.setMaximumSize(new Dimension(100, 100));
		iaLeftPainel.add(inforEsquerda);
		
		iaEsquerdaPecas = new JPanel();
		iaEsquerdaPecas.setBackground(new Color(139, 0, 0));
		iaEsquerdaPecas.setAlignmentX(Component.LEFT_ALIGNMENT);
		iaEsquerdaPecas.setMinimumSize(new Dimension(100, 100));
		iaEsquerdaPecas.setMaximumSize(new Dimension(100, 494));
		iaLeftPainel.add(iaEsquerdaPecas);
		
		JPanel jogadorPainel = new JPanel();
		jogadorPainel.setBackground(new Color(139, 0, 0));
		jogadorPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(jogadorPainel, BorderLayout.SOUTH);
		jogadorPainel.setLayout(new BoxLayout(jogadorPainel, BoxLayout.LINE_AXIS));
		
		JLabel blockBxoEsq = new JLabel();
		blockBxoEsq.setMinimumSize(new Dimension(100, 100));
		blockBxoEsq.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(blockBxoEsq);
		
		JLabel inforBaixo = new JLabel(new ImageIcon(part.participantes.get(0).getIcone()));
		inforBaixo.setVerticalTextPosition(SwingConstants.TOP);
		inforBaixo.setVerticalAlignment(SwingConstants.TOP);
		inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforBaixo.setMinimumSize(new Dimension(100, 100));
		inforBaixo.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(inforBaixo);
		
		jogadorPecas = new JPanel();
		jogadorPecas.setBackground(new Color(139, 0, 0));
		jogadorPecas.setMinimumSize(new Dimension(100, 100));
		jogadorPecas.setMaximumSize(new Dimension(494, 100));
		jogadorPainel.add(jogadorPecas);
		
		JLabel blockBxoDir = new JLabel();
		blockBxoDir.setMinimumSize(new Dimension(100, 100));
		blockBxoDir.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(blockBxoDir);
		
		JPanel iaRightPainel = new JPanel();
		iaRightPainel.setMaximumSize(new Dimension(100, 100));
		iaRightPainel.setBackground(new Color(139, 0, 0));
		iaRightPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaRightPainel, BorderLayout.EAST);
		iaRightPainel.setLayout(new BoxLayout(iaRightPainel, BoxLayout.PAGE_AXIS));
		
		iaDireitaPecas = new JPanel();
		iaDireitaPecas.setAlignmentX(Component.LEFT_ALIGNMENT);
		iaDireitaPecas.setBackground(new Color(139, 0, 0));
		iaDireitaPecas.setMinimumSize(new Dimension(100, 100));
		iaDireitaPecas.setMaximumSize(new Dimension(100, 494));
		iaRightPainel.add(iaDireitaPecas);
		
		JLabel inforDireita = new JLabel(new ImageIcon(part.participantes.get(2).getIcone()));
		inforDireita.setVerticalTextPosition(SwingConstants.TOP);
		inforDireita.setVerticalAlignment(SwingConstants.TOP);
		inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforDireita.setMinimumSize(new Dimension(100, 100));
		inforDireita.setMaximumSize(new Dimension(100, 100));
		iaRightPainel.add(inforDireita);
		
		tabuleiro = new JPanel();
		tabuleiro.setSize(new Dimension(600, 600));
		tabuleiro.setMinimumSize(new Dimension(600, 600));
		tabuleiro.setMaximumSize(new Dimension(600, 600));
		tabuleiro.setPreferredSize(new Dimension(600, 600));
		tabuleiro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabuleiro.setBackground(new Color(20, 75, 20));
		getContentPane().add(tabuleiro, BorderLayout.CENTER);
		tabuleiro.setLayout(null);
		
		JLabel nomeCim = new JLabel(part.participantes.get(1).getNome());
		nomeCim.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeCim.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeCim.setForeground(Color.WHITE);
		nomeCim.setBounds(469, 5, 120, 20);
		tabuleiro.add(nomeCim);
		
		JLabel nomeEsq = new JLabel(part.participantes.get(3).getNome());
		nomeEsq.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeEsq.setForeground(Color.WHITE);
		nomeEsq.setBounds(5, 5, 120, 20);
		tabuleiro.add(nomeEsq);
		
		JLabel nomeDir = new JLabel(part.participantes.get(2).getNome());
		nomeDir.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeDir.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeDir.setForeground(Color.WHITE);
		nomeDir.setBounds(469, 550, 120, 20);
		tabuleiro.add(nomeDir);
		
		JLabel nomeBai = new JLabel(part.participantes.get(0).getNome());
		nomeBai.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeBai.setForeground(Color.WHITE);
		nomeBai.setBounds(5, 550, 120, 20);
		tabuleiro.add(nomeBai);
		
		Random r = new Random();
		int maiorX = tabuleiro.getWidth() - 50;
		int maiorY = tabuleiro.getHeight() - 110;
		int resultX;
		int resultY;
		
		for (Peca p: part.pecas_dormidas){
			resultX = r.nextInt(maiorX);
			resultY = r.nextInt(maiorY);
			p.drawPeca(tabuleiro, resultX, resultY);
		}	
		
		Component[] c = tabuleiro.getComponents();
		for (int i = 0; i < c.length; i++){
			c[i].addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e){
					
					// AINDA POSSUI ALGUNS BUGS QUE IREI CORRIGIR DEPOIS:
					// - ao remover uma peça, todos os outros IDs são modificados
					// - quando o erro acima ocorre, a peça não é removida do tabuleiro
					// - o erro acima faz parecer q existem mais peças do q o normal
					
					JLabel lab = (JLabel) e.getSource();
					String nome = lab.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					// calcular o índice da peça selecionada
					int p1 = (v1 * 6 + v2);
					int p2 = (v1 * v1/2) - v1/2;
					int index = p1 - p2;
					// pegar a peça pelo índice dentre as peças dormidas
					Peca p = part.pecas_dormidas.remove(index);
					tabuleiro.remove(e.getComponent());
					part.participantes.get(0).getPecas().add(p);
					p.virada = true;
					p.drawPeca(jogadorPecas, 2 + 42*(part.participantes.get(0).getPecas().size()-1), 5);

					Random r = new Random();
					for (int i = 0; i < 3; i++){
						int remove = r.nextInt(part.pecas_dormidas.size());
						tabuleiro.remove(remove);
						p = part.pecas_dormidas.remove(remove);
						p.virada = true; // TRUE APENAS PARA TESTAR, DEPOIS APAGAREI ESSA LINHA
						part.participantes.get(i).getPecas().add(p);
						if (i == 0){
							// cima
							p.drawPeca(iaCimaPecas, 0, 0);
						}
						if (i == 1){
							// direita
							p.drawPeca(iaDireitaPecas, 0, 0);
						}
						if (i == 2){
							// esquerda
							p.drawPeca(iaEsquerdaPecas, 0, 0);
						}
					}
					tabuleiro.updateUI();
					repaint();
				}
			});
		}
		
		setVisible(true);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
