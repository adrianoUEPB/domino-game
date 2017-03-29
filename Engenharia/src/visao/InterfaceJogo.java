package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import modelo.*;

public class InterfaceJogo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private int contador = 0;
	
	JPanel jogadorPecas, iaCimaPecas, iaEsquerdaPecas, iaDireitaPecas, tabuleiro;
	JLabel inforCima, inforBaixo, inforEsquerda, inforDireita;

	public InterfaceJogo(final Partida part){
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel iaUpPainel = new JPanel();
		iaUpPainel.setBackground(new Color(139, 0, 0));
		iaUpPainel.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaUpPainel, BorderLayout.NORTH);
		iaUpPainel.setLayout(new BoxLayout(iaUpPainel, BoxLayout.LINE_AXIS));
		
		JPanel blockCimEsq = new JPanel();
		blockCimEsq.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		blockCimEsq.setBackground(new Color(139, 0, 0));
		blockCimEsq.setMinimumSize(new Dimension(100, 100));
		blockCimEsq.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(blockCimEsq);
		blockCimEsq.setLayout(new BoxLayout(blockCimEsq, BoxLayout.PAGE_AXIS));
		
		JLabel rodadaLbl = new JLabel("Rodada");
		rodadaLbl.setFont(new Font("Brush Script MT", Font.BOLD, 26));
		rodadaLbl.setForeground(Color.WHITE);
		rodadaLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockCimEsq.add(rodadaLbl);
		
		JLabel rodadaInt = new JLabel("1");
		rodadaInt.setHorizontalAlignment(SwingConstants.CENTER);
		rodadaInt.setMinimumSize(new Dimension(50, 50));
		rodadaInt.setMaximumSize(new Dimension(50, 50));
		rodadaInt.setFont(new Font("Brush Script MT", Font.BOLD, 45));
		rodadaInt.setForeground(Color.WHITE);
		rodadaInt.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockCimEsq.add(rodadaInt);
		
		iaCimaPecas = new JPanel();
		iaCimaPecas.setBackground(new Color(139, 0, 0));
		iaCimaPecas.setMinimumSize(new Dimension(100, 100));
		iaCimaPecas.setMaximumSize(new Dimension(494, 100));
		iaUpPainel.add(iaCimaPecas);
		
		JPanel inforCimaP = new JPanel();
		inforCimaP.setBackground(new Color(139, 0, 0));
		inforCimaP.setMinimumSize(new Dimension(100, 100));
		inforCimaP.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(inforCimaP);
		inforCimaP.setLayout(new BoxLayout(inforCimaP, BoxLayout.PAGE_AXIS));
		
		JLabel nomeCim = new JLabel(part.participantes.get(2).getNome());
		nomeCim.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforCimaP.add(nomeCim);
		nomeCim.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeCim.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeCim.setForeground(Color.WHITE);
		
		inforCima = new JLabel(new ImageIcon(part.participantes.get(2).getIcone()));
		inforCima.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforCimaP.add(inforCima);
		inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforCima.setMinimumSize(new Dimension(100, 78));
		inforCima.setMaximumSize(new Dimension(100, 78));
		
		JPanel blockCimDir = new JPanel();
		blockCimDir.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		blockCimDir.setMinimumSize(new Dimension(100, 100));
		blockCimDir.setMaximumSize(new Dimension(100, 100));
		blockCimDir.setBackground(new Color(139, 0, 0));
		iaUpPainel.add(blockCimDir);
		blockCimDir.setLayout(new BoxLayout(blockCimDir, BoxLayout.PAGE_AXIS));
		
		JLabel tempoLbl = new JLabel("Tempo");
		tempoLbl.setForeground(Color.WHITE);
		tempoLbl.setFont(new Font("Brush Script MT", Font.BOLD, 26));
		tempoLbl.setAlignmentX(0.5f);
		blockCimDir.add(tempoLbl);
		
		final JLabel tempoInt = new JLabel("00:00:00");
		tempoInt.setMinimumSize(new Dimension(50, 50));
		tempoInt.setMaximumSize(new Dimension(75, 50));
		tempoInt.setHorizontalAlignment(SwingConstants.CENTER);
		tempoInt.setForeground(Color.WHITE);
		tempoInt.setFont(new Font("Brush Script MT", Font.BOLD, 18));
		tempoInt.setAlignmentX(0.5f);
		
		EventQueue.invokeLater(new Runnable(){
			@Override 
			public void run() {
				this.cronometro();
			}

			private void cronometro() {
				Timer tm;
				tm = new Timer();
				tm.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						contador++;
						int seg = contador % 60;
						int min = contador / 60;
						int hora = min / 60;
						min %= 60;
						tempoInt.setText(String.format("%02d:%02d:%02d", hora, min, seg));
					}
				}, 1000, 1000);				
				
			}			
		});
		
		
		blockCimDir.add(tempoInt);
		
		JPanel iaLeftPainel = new JPanel();
		iaLeftPainel.setBackground(new Color(139, 0, 0));
		iaLeftPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaLeftPainel, BorderLayout.WEST);
		iaLeftPainel.setLayout(new BoxLayout(iaLeftPainel, BoxLayout.PAGE_AXIS));
		
		JPanel inforEsquerdaP = new JPanel();
		inforEsquerdaP.setBackground(new Color(139, 0, 0));
		inforEsquerdaP.setMinimumSize(new Dimension(100, 100));
		inforEsquerdaP.setMaximumSize(new Dimension(100, 100));
		iaLeftPainel.add(inforEsquerdaP);
		inforEsquerdaP.setLayout(new BoxLayout(inforEsquerdaP, BoxLayout.PAGE_AXIS));
		
		JLabel nomeEsq = new JLabel(part.participantes.get(1).getNome());
		nomeEsq.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforEsquerdaP.add(nomeEsq);
		nomeEsq.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeEsq.setForeground(Color.WHITE);
		
		inforEsquerda = new JLabel(new ImageIcon(part.participantes.get(1).getIcone()));
		inforEsquerda.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforEsquerdaP.add(inforEsquerda);
		inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforEsquerda.setMinimumSize(new Dimension(100, 78));
		inforEsquerda.setMaximumSize(new Dimension(100, 78));
		
		iaEsquerdaPecas = new JPanel();
		iaEsquerdaPecas.setBackground(new Color(139, 0, 0));
		iaEsquerdaPecas.setMinimumSize(new Dimension(100, 100));
		iaEsquerdaPecas.setMaximumSize(new Dimension(100, 494));
		iaLeftPainel.add(iaEsquerdaPecas);
		
		JPanel jogadorPainel = new JPanel();
		jogadorPainel.setBackground(new Color(139, 0, 0));
		jogadorPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(jogadorPainel, BorderLayout.SOUTH);
		jogadorPainel.setLayout(new BoxLayout(jogadorPainel, BoxLayout.LINE_AXIS));
		
		JPanel blockBxoEsq = new JPanel();
		blockBxoEsq.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		blockBxoEsq.setBackground(new Color(139, 0, 0));
		blockBxoEsq.setMinimumSize(new Dimension(100, 100));
		blockBxoEsq.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(blockBxoEsq);
		blockBxoEsq.setLayout(new BoxLayout(blockBxoEsq, BoxLayout.Y_AXIS));
		
		JPanel inforBaixoP = new JPanel();
		inforBaixoP.setBackground(new Color(139, 0, 0));
		inforBaixoP.setMinimumSize(new Dimension(100, 100));
		inforBaixoP.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(inforBaixoP);
		inforBaixoP.setLayout(new BoxLayout(inforBaixoP, BoxLayout.PAGE_AXIS));
		
		JLabel nomeBai = new JLabel(part.participantes.get(0).getNome());
		nomeBai.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforBaixoP.add(nomeBai);
		nomeBai.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeBai.setForeground(Color.WHITE);
		
		inforBaixo = new JLabel(new ImageIcon(part.participantes.get(0).getIcone()));
		inforBaixo.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforBaixoP.add(inforBaixo);
		inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforBaixo.setMinimumSize(new Dimension(100, 78));
		inforBaixo.setMaximumSize(new Dimension(100, 78));
		
		jogadorPecas = new JPanel();
		jogadorPecas.setBackground(new Color(139, 0, 0));
		jogadorPecas.setMinimumSize(new Dimension(100, 100));
		jogadorPecas.setMaximumSize(new Dimension(494, 100));
		jogadorPainel.add(jogadorPecas);
		
		JPanel blockBxoDir = new JPanel();
		blockBxoDir.setBackground(new Color(139, 0, 0));
		blockBxoDir.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		blockBxoDir.setMinimumSize(new Dimension(10, 100));
		blockBxoDir.setMaximumSize(new Dimension(100, 100));
		jogadorPainel.add(blockBxoDir);
		blockBxoDir.setLayout(new BoxLayout(blockBxoDir, BoxLayout.PAGE_AXIS));
		
		JButton voltarBt = new JButton();
		voltarBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		voltarBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		voltarBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		voltarBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-pressed.png"));
		voltarBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-normal.png"));
		voltarBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		voltarBt.setHorizontalTextPosition(SwingConstants.CENTER);
		voltarBt.setBorder(null);
		voltarBt.setMinimumSize(new Dimension(90, 90));
		voltarBt.setMaximumSize(new Dimension(90, 90));
		voltarBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltarBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockBxoEsq.add(voltarBt);
		
		JButton salvarBt = new JButton();
		salvarBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-disabled.png"));
		salvarBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-rollover.png"));
		salvarBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-rollover.png"));
		salvarBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-pressed.png"));
		salvarBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-normal.png"));
		salvarBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-salvar-disabled.png"));
		salvarBt.setHorizontalTextPosition(SwingConstants.CENTER);
		salvarBt.setBorder(null);
		salvarBt.setMinimumSize(new Dimension(90, 90));
		salvarBt.setMaximumSize(new Dimension(90, 90));
		salvarBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salvarBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockBxoDir.add(salvarBt);
		
		JPanel iaRightPainel = new JPanel();
		iaRightPainel.setMaximumSize(new Dimension(100, 100));
		iaRightPainel.setBackground(new Color(139, 0, 0));
		iaRightPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaRightPainel, BorderLayout.EAST);
		iaRightPainel.setLayout(new BoxLayout(iaRightPainel, BoxLayout.PAGE_AXIS));
		
		iaDireitaPecas = new JPanel();
		iaDireitaPecas.setBackground(new Color(139, 0, 0));
		iaDireitaPecas.setMinimumSize(new Dimension(100, 100));
		iaDireitaPecas.setMaximumSize(new Dimension(100, 494));
		iaRightPainel.add(iaDireitaPecas);
		
		JPanel inforDireitaP = new JPanel();
		inforDireitaP.setMinimumSize(new Dimension(100, 100));
		inforDireitaP.setMaximumSize(new Dimension(100, 100));
		inforDireitaP.setBackground(new Color(139, 0, 0));
		iaRightPainel.add(inforDireitaP);
		inforDireitaP.setLayout(new BoxLayout(inforDireitaP, BoxLayout.PAGE_AXIS));
		
		JLabel nomeDir = new JLabel(part.participantes.get(3).getNome());
		nomeDir.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforDireitaP.add(nomeDir);
		nomeDir.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeDir.setFont(new Font("Brush Script MT", Font.BOLD, 17));
		nomeDir.setForeground(Color.WHITE);
		
		inforDireita = new JLabel(new ImageIcon(part.participantes.get(3).getIcone()));
		inforDireita.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforDireitaP.add(inforDireita);
		inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforDireita.setMinimumSize(new Dimension(100, 78));
		inforDireita.setMaximumSize(new Dimension(100, 78));
		
		tabuleiro = new JPanel();
		tabuleiro.setSize(new Dimension(600, 600));
		tabuleiro.setMinimumSize(new Dimension(600, 600));
		tabuleiro.setMaximumSize(new Dimension(600, 600));
		tabuleiro.setPreferredSize(new Dimension(600, 600));
		tabuleiro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabuleiro.setBackground(new Color(20, 75, 20));
		getContentPane().add(tabuleiro, BorderLayout.CENTER);
		tabuleiro.setLayout(null);
		
		Random r = new Random();
		int maiorX = tabuleiro.getWidth() - 50;
		int maiorY = tabuleiro.getHeight() - 110;
		int resultX;
		int resultY;
		
		for (Peca p: part.pecas_dormidas){
			resultX = r.nextInt(maiorX);
			resultY = r.nextInt(maiorY);
			p.drawPeca(tabuleiro, resultX, resultY, 0);
		}	
		
		Component[] c = tabuleiro.getComponents();
		for (int i = 0; i < c.length; i++){
			c[i].addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e){
					
					JLabel lab = (JLabel) e.getSource();
					tabuleiro.remove(lab);
					String nome = lab.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					
					Peca peca = null;
					Iterator<Peca> it = part.pecas_dormidas.iterator();
					while(it.hasNext()) {
						Peca p = it.next();
					    if (p.getValor1() == v1 && p.getValor2() == v2) {
					    	peca = p;
					        it.remove();
					    }
					}
					
					tabuleiro.remove(e.getComponent());
					part.participantes.get(0).getPecas().add(peca);
					peca.virada = true;
					peca.drawPeca(jogadorPecas, 0, 0, 0);

					Random r = new Random();
					for (int i = 1; i < 4; i++){
						int remove = r.nextInt(part.pecas_dormidas.size());
						tabuleiro.remove(remove);
						
						peca = part.pecas_dormidas.remove(remove);
						peca.virada = true; // TRUE APENAS PARA TESTAR
						part.participantes.get(i).getPecas().add(peca);
						if (i == 1){	// ia esquerda
							peca.drawPeca(iaEsquerdaPecas, 0, 0, 1);
						}
						if (i == 2){	// ia cima
							peca.drawPeca(iaCimaPecas, 0, 0, 2);
						}
						if (i == 3){	// ia direita
							peca.drawPeca(iaDireitaPecas, 0, 0, 3);
						}
						tabuleiro.updateUI();
						repaint();
					}

					if(part.pecas_dormidas.size() == 0){
						IniciaPartida(part);
					}
				}
			});
		}
		
		voltarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jogador jogador_logado = (Jogador) part.participantes.get(0);
				new InterfaceMenu(jogador_logado);
				dispose();
			}
		});
		
		setVisible(true);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// método da primeira jogada de cada rodada
	public void IniciaPartida(final Partida part) {
		Participante primeiro;
		if (part.id_lastWin == -1){			
			// verifica quem é o jogador da vez
			primeiro = part.firstBegin();
			if(part.jogadorDaVez == 0){ // jogador				
				Component[] c = jogadorPecas.getComponents();
				for (int i = 0; i < c.length; i++){
					JLabel lab = (JLabel) c[i];
					String nome = lab.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					
					if (v1 == 6 && v2 == 6){
						c[i].addMouseListener(new MouseAdapter(){
							@Override
							public void mousePressed(MouseEvent e){
								
								JLabel lab = (JLabel) e.getSource();
								String nome = lab.getName();
								int v1 = Integer.parseInt("" + nome.charAt(0));
								int v2 = Integer.parseInt("" + nome.charAt(1));
								
								Peca peca = null;
								Iterator<Peca> it = part.participantes.get(0).getPecas().iterator();
								while(it.hasNext()) {
									Peca p = it.next();
								    if (p.getValor1() == v1 && p.getValor2() == v2) {
								    	peca = p;
								        it.remove();
								    }
								}

								part.setUltima_peca(peca);
								jogadorPecas.remove(e.getComponent());
								part.participantes.get(0).getPecas().remove(peca);
								peca.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 20, tabuleiro.getHeight()/2 - 42, 0);
								part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
								part.extremidade1 = peca.getValor1();
								part.extremidade2 = peca.getValor2();
								tabuleiro.updateUI();
								jogadorPecas.updateUI();
								repaint();
								
								Component[] c = jogadorPecas.getComponents();
								for (Component j: c){
									j.setEnabled(true);;
								}
								
								JogadasSeguintes(part);
								return;
							}
						});
					} else {
						lab.setEnabled(false);
					}
				}
			} else { // inteligência artificial
				for(int i = 0; i < primeiro.getPecas().size(); i++){
					Peca p = primeiro.getPecas().get(i);
					if(p.getValor1() == 6 && p.getValor2() == 6){
						primeiro.getPecas().remove(p);
						if (part.jogadorDaVez == 1) //ia esquerda
							iaEsquerdaPecas.remove(i);
						if (part.jogadorDaVez == 2) //ia cima
							iaCimaPecas.remove(i);
						if (part.jogadorDaVez == 3) //ia direita
							iaDireitaPecas.remove(i);

						part.setUltima_peca(p);
						p.virada = true;
						p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 20, tabuleiro.getHeight()/2 - 42, 0);
						part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
						part.extremidade1 = p.getValor1();
						part.extremidade2 = p.getValor2();
						tabuleiro.updateUI();
						repaint();
						
						//break;
						
						JogadasSeguintes(part);
						return;
					}
				}
			}
		} else {
			primeiro = part.participantes.get(part.id_lastWin);
			part.jogadorDaVez = part.id_lastWin;
			
			if(part.jogadorDaVez == 0){	// jogador
					
				Component[] c = jogadorPecas.getComponents();
				for (int i = 0; i < c.length; i++){
					
					c[i].addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent e){
							
							JLabel lab = (JLabel) e.getSource();
							String nome = lab.getName();
							int v1 = Integer.parseInt("" + nome.charAt(0));
							int v2 = Integer.parseInt("" + nome.charAt(1));
							
							Peca peca = null;
							Iterator<Peca> it = part.participantes.get(0).getPecas().iterator();
							while(it.hasNext()) {
								Peca p = it.next();
							    if (p.getValor1() == v1 && p.getValor2() == v2) {
							    	peca = p;
							        it.remove();
							    }
							}
							
							part.setUltima_peca(peca);
							jogadorPecas.remove(e.getComponent());
							part.participantes.get(0).getPecas().remove(peca);
							peca.virada = true;
							peca.drawPeca(tabuleiro, 50, 50, 0);
							part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
							tabuleiro.updateUI();
							jogadorPecas.updateUI();
							repaint();
							
							JogadasSeguintes(part);
							return;
						}
					});
				}
			} else { // inteligência artificial
				Peca p;
				for(int i = 0; i < primeiro.getPecas().size(); i++){
					p = primeiro.getPecas().get(i);
					if(p.getValor1() == p.getValor2()){ // pega o primeiro carrocao q aparecer
						primeiro.getPecas().remove(p);
						if (part.jogadorDaVez == 1) //ia esquerda
							iaEsquerdaPecas.remove(i);
						if (part.jogadorDaVez == 2) //ia cima
							iaCimaPecas.remove(i);
						if (part.jogadorDaVez == 3) //ia direita
							iaDireitaPecas.remove(i);

						part.setUltima_peca(p);
						p.virada = true;
						p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 20, tabuleiro.getHeight()/2 - 42, 0);
						part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
						part.extremidade1 = p.getValor1();
						part.extremidade2 = p.getValor2();
						tabuleiro.updateUI();
						repaint();
						
						JogadasSeguintes(part);
						return;
					} else {
						if(i == primeiro.getPecas().size()-1){
							primeiro.getPecas().remove(0);
							if (part.jogadorDaVez == 1) //ia esquerda
								iaEsquerdaPecas.remove(0);
							if (part.jogadorDaVez == 2) //ia cima
								iaCimaPecas.remove(0);
							if (part.jogadorDaVez == 3) //ia direita
								iaDireitaPecas.remove(0);

							part.setUltima_peca(p);
							p.virada = true;
							p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 20, tabuleiro.getHeight()/2 - 42, 0);
							part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
							part.extremidade1 = p.getValor1();
							part.extremidade2 = p.getValor2();
							tabuleiro.updateUI();
							repaint();
							
							JogadasSeguintes(part);
							return;
						}
					}
				}
			}
		}
	}
	
	public void JogadasSeguintes(final Partida part){

		if(part.jogadorDaVez == 0){ // jogador
			// esse if verifica se tem jogada para fazer
			if (part.participantes.get(0).VerificarJogadaPossivel(part.extremidade1, part.extremidade2)){
				
				Component[] c = jogadorPecas.getComponents();
				for (int i = 0; i < c.length; i++){
					JLabel lab = (JLabel) c[i];
					String nome = lab.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					
					if (v1 == part.extremidade1 || v2 == part.extremidade2 ||
							v1 == part.extremidade2 || v2 == part.extremidade1){
						c[i].addMouseListener(new MouseAdapter(){
							@Override
							public void mousePressed(MouseEvent e){
								
								JLabel lab = (JLabel) e.getSource();
								String nome = lab.getName();
								int v1 = Integer.parseInt("" + nome.charAt(0));
								int v2 = Integer.parseInt("" + nome.charAt(1));
								
								Peca peca = null;
								Peca p = null;
								Iterator<Peca> it = part.participantes.get(0).getPecas().iterator();
								while(it.hasNext()) {
									p = it.next();
									if (p == null){
										break;
									} else {
									    if (p.getValor1() == v1 && p.getValor2() == v2) {
									    	peca = p;
									        it.remove();
									        break;
									    }
									}
								}
								
								jogadorPecas.remove(e.getComponent());
								part.participantes.get(0).getPecas().remove(peca);
								
								if (peca.getValor1() == part.extremidade1){
									peca.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 103, tabuleiro.getHeight()/2, 1);
									part.extremidade1 = peca.getValor2();
								} else if (peca.getValor2() == part.extremidade1){
									peca.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 103, tabuleiro.getHeight()/2, 3);
									part.extremidade1 = peca.getValor1();
								} else if (peca.getValor1() == part.extremidade2){
									peca.drawPeca(tabuleiro, tabuleiro.getWidth()/2 + 18, tabuleiro.getHeight()/2, 3);
									part.extremidade2 = peca.getValor2();
								} else if (peca.getValor2() == part.extremidade2){
									peca.drawPeca(tabuleiro, tabuleiro.getWidth()/2 + 18, tabuleiro.getHeight()/2, 1);
									part.extremidade2 = peca.getValor1();
								}

								// falta calcular as posições X e Y onde a peça irá ser encaixada
								// dependendo da extremidade que for encaixada
								
								part.setUltima_peca(peca);
								part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
								tabuleiro.updateUI();
								jogadorPecas.updateUI();
								repaint();

								// falta checar o winner após cada jogada feita pelo jogador ou pelas IAs

								Component[] c = jogadorPecas.getComponents();
								for (Component j: c){
									MouseListener[] m = j.getMouseListeners();
									if(m.length > 0)
										j.removeMouseListener(m[0]);
									j.setEnabled(true);;
								}
								JogadasSeguintes(part);
								return;
							}
						});
					} else {
						lab.setEnabled(false);
					}
				}
			} else { // passa a vez
				part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
				System.out.println("Jogador passou a vez!");
				JogadasSeguintes(part);
				return;
			}
		} else { // inteligência artificial
			Peca p;
			// esse if verifica se tem peça que pode ser jogada
			if (part.participantes.get(part.jogadorDaVez).VerificarJogadaPossivel(part.extremidade1, part.extremidade2)){
				for(int i = 0; i < part.participantes.get(part.jogadorDaVez).getPecas().size(); i++){
					p = part.participantes.get(part.jogadorDaVez).getPecas().get(i);
					if (p.getValor1() == part.extremidade1 || p.getValor1() == part.extremidade2 ||
							p.getValor2() == part.extremidade2 || p.getValor2() == part.extremidade1){
						part.participantes.get(part.jogadorDaVez).getPecas().remove(p);
						if (part.jogadorDaVez == 1) //ia esquerda
							iaEsquerdaPecas.remove(i);
						if (part.jogadorDaVez == 2) //ia cima
							iaCimaPecas.remove(i);
						if (part.jogadorDaVez == 3) //ia direita
							iaDireitaPecas.remove(i);
						
						if (p.getValor1() == part.extremidade1){
							p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 103, tabuleiro.getHeight()/2, 1);
							part.extremidade1 = p.getValor2();
						} else if (p.getValor2() == part.extremidade1){
							p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 - 103, tabuleiro.getHeight()/2, 3);
							part.extremidade1 = p.getValor1();
						} else if (p.getValor1() == part.extremidade2){
							p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 + 18, tabuleiro.getHeight()/2, 3);
							part.extremidade2 = p.getValor2();
						} else if (p.getValor2() == part.extremidade2){
							p.drawPeca(tabuleiro, tabuleiro.getWidth()/2 + 18, tabuleiro.getHeight()/2, 1);
							part.extremidade2 = p.getValor1();
						}
						
						// falta calcular as posições X e Y onde a peça irá ser encaixada
						// dependendo da extremidade que for encaixada

						part.setUltima_peca(p);
						p.virada = true;
						part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
						tabuleiro.updateUI();
						repaint();
						
						// falta checar o winner após cada jogada feita pelo jogador ou pelas IAs
						
						JogadasSeguintes(part);
						return;
					}
				}
			} else {
				System.out.println(part.participantes.get(part.jogadorDaVez) + " passou a vez!");
				part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
				
				// tá bugado aqui, sem isso a IA não passa a vez e com isso, nunca é verificado
				// quando a partida acaba
				JogadasSeguintes(part);
				return;
			}
		}
	}
}
