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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import controle.DAO;
import controle.Som;
import modelo.*;

import java.awt.FlowLayout;

public class InterfaceJogo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel jogadorPecas, iaCimaPecas, iaEsquerdaPecas, iaDireitaPecas, tabuleiro;
	JLabel inforCima, inforBaixo, inforEsquerda, inforDireita;
	JLabel pontosCim, pontosBai, pontosEsq, pontosDir;
	JButton somBt;
	Timer tm;
	DAO dao = new DAO();

	public InterfaceJogo(final Partida part, boolean continuando){
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
		
		JLabel rodadaLbl = new JLabel("Partida");
		rodadaLbl.setFont(new Font("Brush Script MT", Font.BOLD, 26));
		rodadaLbl.setForeground(Color.WHITE);
		rodadaLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockCimEsq.add(rodadaLbl);
		
		JLabel rodadaInt = new JLabel();
		if (part.multiplicador == 1){
			rodadaInt.setText("" + part.rodada);
		} else {
			rodadaInt.setText("" + part.rodada + " x" + part.multiplicador);
		}
		rodadaInt.setHorizontalAlignment(SwingConstants.CENTER);
		rodadaInt.setMinimumSize(new Dimension(80, 50));
		rodadaInt.setMaximumSize(new Dimension(80, 50));
		rodadaInt.setFont(new Font("Brush Script MT", Font.BOLD, 45));
		rodadaInt.setForeground(Color.WHITE);
		rodadaInt.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockCimEsq.add(rodadaInt);
		
		iaCimaPecas = new JPanel();
		iaCimaPecas.setBackground(new Color(139, 0, 0));
		iaCimaPecas.setMinimumSize(new Dimension(100, 100));
		iaCimaPecas.setMaximumSize(new Dimension(396, 100));
		iaUpPainel.add(iaCimaPecas);
		
		JPanel inforCimaP = new JPanel();
		inforCimaP.setBackground(new Color(139, 0, 0));
		inforCimaP.setMinimumSize(new Dimension(100, 100));
		inforCimaP.setMaximumSize(new Dimension(100, 100));
		iaUpPainel.add(inforCimaP);
		inforCimaP.setLayout(new BoxLayout(inforCimaP, BoxLayout.LINE_AXIS));
		
		JPanel inforCimaP2 = new JPanel();
		inforCimaP2.setBackground(new Color(139, 0, 0));
		inforCimaP2.setPreferredSize(new Dimension(100, 100));
		inforCimaP2.setMinimumSize(new Dimension(100, 100));
		inforCimaP2.setMaximumSize(new Dimension(100, 100));
		inforCimaP.add(inforCimaP2);
		
		JLabel nomeCim = new JLabel(part.participantes.get(2).getNome());
		inforCimaP2.add(nomeCim);
		nomeCim.setAlignmentX(Component.CENTER_ALIGNMENT);
		nomeCim.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeCim.setFont(new Font("Brush Script MT", Font.BOLD, 25));
		nomeCim.setForeground(Color.WHITE);
		
		pontosCim = new JLabel("Pontos: " + part.pontuacao_jogadores[2]);
		pontosCim.setPreferredSize(new Dimension(90, 30));
		pontosCim.setMinimumSize(new Dimension(90, 14));
		inforCimaP2.add(pontosCim);
		pontosCim.setHorizontalAlignment(SwingConstants.CENTER);
		pontosCim.setMaximumSize(new Dimension(90, 14));
		pontosCim.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		pontosCim.setForeground(Color.WHITE);
		pontosCim.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		inforCima = new JLabel(new ImageIcon(part.participantes.get(2).getIcone()));
		inforCima.setPreferredSize(new Dimension(100, 100));
		iaUpPainel.add(inforCima);
		inforCima.setMaximumSize(new Dimension(100, 100));
		inforCima.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforCima.setMinimumSize(new Dimension(100, 100));
		
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
		tempoInt.setMinimumSize(new Dimension(75, 30));
		tempoInt.setMaximumSize(new Dimension(75, 30));
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
				tm = new Timer();
				tm.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						part.tempoPartida++;
						int seg = part.tempoPartida % 60;
						int min = part.tempoPartida / 60;
						int hora = min / 60;
						min %= 60;
						tempoInt.setText(String.format("%02d:%02d:%02d", hora, min, seg));
					}
				}, 1000, 1000);				
				
			}			
		});
		
		blockCimDir.add(tempoInt);
		
		somBt = new JButton();
		if (Som.somAtivo){
			somBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-rollover.png"));
			somBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-rollover.png"));
			somBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-pressed.png"));
			somBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-normal.png"));
		} else {
			somBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-rollover.png"));
			somBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-rollover.png"));
			somBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-pressed.png"));
			somBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-normal.png"));
		}
		somBt.setHorizontalTextPosition(SwingConstants.CENTER);
		somBt.setBorder(null);
		somBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		somBt.setMinimumSize(new Dimension(25, 25));
		somBt.setMaximumSize(new Dimension(25, 25));
		somBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		blockCimDir.add(somBt);
		
		JPanel iaLeftPainel = new JPanel();
		iaLeftPainel.setBackground(new Color(139, 0, 0));
		iaLeftPainel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(iaLeftPainel, BorderLayout.WEST);
		iaLeftPainel.setLayout(new BoxLayout(iaLeftPainel, BoxLayout.PAGE_AXIS));
		
		inforEsquerda = new JLabel(new ImageIcon(part.participantes.get(1).getIcone()));
		inforEsquerda.setPreferredSize(new Dimension(10, 100));
		iaLeftPainel.add(inforEsquerda);
		inforEsquerda.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforEsquerda.setMinimumSize(new Dimension(100, 100));
		inforEsquerda.setMaximumSize(new Dimension(100, 100));
		
		JPanel inforEsquerdaP = new JPanel();
		inforEsquerdaP.setPreferredSize(new Dimension(100, 100));
		inforEsquerdaP.setBackground(new Color(139, 0, 0));
		inforEsquerdaP.setMinimumSize(new Dimension(100, 100));
		inforEsquerdaP.setMaximumSize(new Dimension(100, 100));
		iaLeftPainel.add(inforEsquerdaP);
		inforEsquerdaP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nomeEsq = new JLabel(part.participantes.get(1).getNome());
		nomeEsq.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforEsquerdaP.add(nomeEsq);
		nomeEsq.setFont(new Font("Brush Script MT", Font.BOLD, 25));
		nomeEsq.setForeground(Color.WHITE);
		
		pontosEsq = new JLabel("Pontos: " + part.pontuacao_jogadores[1]);
		pontosEsq.setMinimumSize(new Dimension(90, 14));
		pontosEsq.setPreferredSize(new Dimension(90, 30));
		pontosEsq.setHorizontalAlignment(SwingConstants.CENTER);
		pontosEsq.setMaximumSize(new Dimension(90, 14));
		pontosEsq.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		pontosEsq.setForeground(Color.WHITE);
		pontosEsq.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforEsquerdaP.add(pontosEsq);
		
		iaEsquerdaPecas = new JPanel();
		iaEsquerdaPecas.setBackground(new Color(139, 0, 0));
		iaEsquerdaPecas.setMinimumSize(new Dimension(100, 100));
		iaEsquerdaPecas.setMaximumSize(new Dimension(100, 396));
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
		inforBaixoP.setMinimumSize(new Dimension(200, 100));
		inforBaixoP.setMaximumSize(new Dimension(200, 100));
		jogadorPainel.add(inforBaixoP);
		inforBaixoP.setLayout(new BoxLayout(inforBaixoP, BoxLayout.LINE_AXIS));
		
		inforBaixo = new JLabel(new ImageIcon(part.participantes.get(0).getIcone()));
		inforBaixo.setPreferredSize(new Dimension(100, 100));
		inforBaixo.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforBaixoP.add(inforBaixo);
		inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforBaixo.setMinimumSize(new Dimension(100, 100));
		inforBaixo.setMaximumSize(new Dimension(100, 100));
		
		JPanel inforBaixoP2 = new JPanel();
		inforBaixoP2.setBackground(new Color(139, 0, 0));
		inforBaixoP2.setPreferredSize(new Dimension(100, 100));
		inforBaixoP2.setMinimumSize(new Dimension(100, 100));
		inforBaixoP2.setMaximumSize(new Dimension(100, 100));
		inforBaixoP.add(inforBaixoP2);
		
		JLabel nomeBai = new JLabel(part.participantes.get(0).getNome());
		inforBaixoP2.add(nomeBai);
		nomeBai.setAlignmentX(Component.CENTER_ALIGNMENT);
		nomeBai.setFont(new Font("Brush Script MT", Font.BOLD, 25));
		nomeBai.setForeground(Color.WHITE);
		
		pontosBai = new JLabel("Pontos: " + part.pontuacao_jogadores[0]);
		pontosBai.setPreferredSize(new Dimension(90, 30));
		inforBaixoP2.add(pontosBai);
		pontosBai.setHorizontalAlignment(SwingConstants.CENTER);
		pontosBai.setMaximumSize(new Dimension(90, 14));
		pontosBai.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		pontosBai.setForeground(Color.WHITE);
		pontosBai.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jogadorPecas = new JPanel();
		jogadorPecas.setBackground(new Color(139, 0, 0));
		jogadorPecas.setMinimumSize(new Dimension(100, 100));
		jogadorPecas.setMaximumSize(new Dimension(396, 100));
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
		iaDireitaPecas.setMaximumSize(new Dimension(100, 396));
		iaRightPainel.add(iaDireitaPecas);
		
		JPanel inforDireitaP = new JPanel();
		inforDireitaP.setPreferredSize(new Dimension(100, 100));
		inforDireitaP.setMinimumSize(new Dimension(100, 100));
		inforDireitaP.setMaximumSize(new Dimension(100, 100));
		inforDireitaP.setBackground(new Color(139, 0, 0));
		iaRightPainel.add(inforDireitaP);
		inforDireitaP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nomeDir = new JLabel(part.participantes.get(3).getNome());
		nomeDir.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforDireitaP.add(nomeDir);
		nomeDir.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeDir.setFont(new Font("Brush Script MT", Font.BOLD, 25));
		nomeDir.setForeground(Color.WHITE);
		
		pontosDir = new JLabel("Pontos: " + part.pontuacao_jogadores[3]);
		pontosDir.setPreferredSize(new Dimension(90, 30));
		pontosDir.setHorizontalAlignment(SwingConstants.CENTER);
		pontosDir.setMaximumSize(new Dimension(90, 14));
		pontosDir.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		pontosDir.setForeground(Color.WHITE);
		pontosDir.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforDireitaP.add(pontosDir);
		
		inforDireita = new JLabel(new ImageIcon(part.participantes.get(3).getIcone()));
		inforDireita.setPreferredSize(new Dimension(100, 100));
		iaRightPainel.add(inforDireita);
		inforDireita.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		inforDireita.setMinimumSize(new Dimension(100, 100));
		inforDireita.setMaximumSize(new Dimension(100, 100));
		
		tabuleiro = new JPanel();
		tabuleiro.setSize(new Dimension(600, 600));
		tabuleiro.setMinimumSize(new Dimension(600, 600));
		tabuleiro.setMaximumSize(new Dimension(600, 600));
		tabuleiro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabuleiro.setBackground(new Color(20, 75, 20));
		getContentPane().add(tabuleiro, BorderLayout.CENTER);
		tabuleiro.setLayout(null);
		int v = 6;// seis
		Jogador jogador_logado = (Jogador) part.participantes.get(0);
		
		Som.somEmbaralha();
		
		if(part.pontuacao_jogadores[0] >= v){
			Som.somVenceuRodada();
			JOptionPane.showMessageDialog(null, "Você venceu a rodada! Parabéns!", "Vencedor", JOptionPane.INFORMATION_MESSAGE);
			jogador_logado.setTempo_rodadas(part.tempoPartida);
			dao.updatePontuacao(jogador_logado);
			if (dao.PossuiJogoSalvo(jogador_logado.getId()))
				dao.deletarPartida(jogador_logado.getId());
			new InterfaceMenu(jogador_logado);
			return;
		} else if(part.pontuacao_jogadores[1] >= v) {
			Som.somPerdeuPartida();
			JOptionPane.showMessageDialog(null, part.participantes.get(1).getNome() + " venceu a rodada! Você perdeu.", "Perdedor", JOptionPane.INFORMATION_MESSAGE);
			jogador_logado = (Jogador) part.participantes.get(0);
			jogador_logado.setTempo_rodadas(part.tempoPartida);
			dao.updatePontuacao(jogador_logado);
			if (dao.PossuiJogoSalvo(jogador_logado.getId()))
				dao.deletarPartida(jogador_logado.getId());
			new InterfaceMenu(jogador_logado);
			return;
		} else if(part.pontuacao_jogadores[2] >= v) {
			Som.somPerdeuPartida();
			JOptionPane.showMessageDialog(null, part.participantes.get(2).getNome() + " venceu a rodada! Você perdeu.", "Perdedor", JOptionPane.INFORMATION_MESSAGE);
			jogador_logado = (Jogador) part.participantes.get(0);
			jogador_logado.setTempo_rodadas(part.tempoPartida);
			dao.updatePontuacao(jogador_logado);
			if (dao.PossuiJogoSalvo(jogador_logado.getId()))
				dao.deletarPartida(jogador_logado.getId());
			new InterfaceMenu(jogador_logado);
			return;
		} else if(part.pontuacao_jogadores[3] >= v) {
			Som.somPerdeuPartida();
			JOptionPane.showMessageDialog(null, part.participantes.get(3).getNome() + " venceu a rodada! Você perdeu.", "Perdedor", JOptionPane.INFORMATION_MESSAGE);			
			jogador_logado = (Jogador) part.participantes.get(0);
			jogador_logado.setTempo_rodadas(part.tempoPartida);
			dao.updatePontuacao(jogador_logado);
			if (dao.PossuiJogoSalvo(jogador_logado.getId()))
				dao.deletarPartida(jogador_logado.getId());
			new InterfaceMenu(jogador_logado);
			return;
		}
		
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
		
		if (continuando){
			for(Peca p: part.participantes.get(0).getPecas()){
				p.drawPeca(jogadorPecas, 0, 0, 0);
			}
			for(Peca p: part.participantes.get(1).getPecas()){
				p.drawPeca(iaEsquerdaPecas, 0, 0, 1);
			}
			for(Peca p: part.participantes.get(2).getPecas()){
				p.drawPeca(iaCimaPecas, 0, 0, 2);
			}
			for(Peca p: part.participantes.get(3).getPecas()){
				p.drawPeca(iaDireitaPecas, 0, 0, 3);
			}
			for(Peca p: part.pecas_campo){
				p.drawPecaScaled(tabuleiro, p.posicaoX, p.posicaoY, p.rotacao, p.direcao);
			}
			if (part.pecas_dormidas.size() == 0){
				JogadasSeguintes(part);
			}
		}

		if (part.pecas_dormidas.size() > 0){
			Component[] c = tabuleiro.getComponents();
			for (int i = 0; i < c.length; i++){
				c[i].addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e){
						
						Som.somPegaUma();
						
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
							//peca.virada = true; // TRUE APENAS PARA TESTAR
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
		}
		
		voltarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				Jogador jogador_logado = (Jogador) part.participantes.get(0);
				tm.cancel();
				part.tempoPartida = 0;
				new InterfaceMenu(jogador_logado);
				dispose();
			}
		});
		
		salvarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				Jogador jogador_logado = (Jogador) part.participantes.get(0);
				dao.salvarPartida(jogador_logado.getId(), part);
			}
		});

		somBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somAtivo = !Som.somAtivo;
				if (Som.somAtivo){
					somBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-rollover.png"));
					somBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-rollover.png"));
					somBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-pressed.png"));
					somBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-somE-normal.png"));
				} else {
					somBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-rollover.png"));
					somBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-rollover.png"));
					somBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-pressed.png"));
					somBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-somD-normal.png"));
				}
				Som.somClick();
			}
		});
		
		setVisible(true);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// metodo da primeira jogada de cada rodada
	public void IniciaPartida(final Partida part) {
		
		int id = 0;
		for (Participante p : part.participantes){
			boolean flag = false;
			int pq = p.quantidadeCarrocao();
			String mensagem;
			
			switch (pq) {
				case 4:
					part.multiplicador += 1;
					mensagem = p.getNome() + " possui 4 carroças, a partida será reiniciada e valerá x" + part.multiplicador + " pontos!";
					JOptionPane.showMessageDialog(null, mensagem, "Reiniciando", JOptionPane.INFORMATION_MESSAGE);
					flag = true;
					tm.cancel();
					dispose();
					part.criarPartida();
					new InterfaceJogo(part, false);
					break;
				case 5:
					p.setPontuacao(p.getPontuacao() + 1);
					part.pontuacao_jogadores[id] += 1;
					mensagem = p.getNome() + " ganhou +1 ponto pois iniciou com 5 carroças e agora possui " + part.pontuacao_jogadores[id] + " pontos.\n\nO jogo continua...";
					JOptionPane.showMessageDialog(null, mensagem, "Pontuação extra", JOptionPane.INFORMATION_MESSAGE);
					pontosBai.setText("Pontos: " + part.pontuacao_jogadores[0]);
					pontosEsq.setText("Pontos: " + part.pontuacao_jogadores[1]);
					pontosCim.setText("Pontos: " + part.pontuacao_jogadores[2]);
					pontosDir.setText("Pontos: " + part.pontuacao_jogadores[3]);
					repaint();
					break;
				case 6:
					part.setWinner(p);
					mensagem = p.getNome() + " venceu a partida e ganhou +1 ponto pois iniciou com 6 carroças!\n\n";
					mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
					mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
					mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
					mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
					JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					part.criarPartida();
					new InterfaceJogo(part, false);
					break;
			}
			if(flag)
				return;
			id++;
		}
	
		Participante primeiro;
		if (part.id_lastWin == -1){
			// verifica quem eh o jogador da vez
			primeiro = part.firstBegin();
			if(part.jogadorDaVez == 0){ // jogador
				
				inforBaixo.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				JOptionPane.showMessageDialog(jogadorPecas, "Você inicia a partida!", "Partida iniciada", JOptionPane.INFORMATION_MESSAGE);
				
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
	
								Som.somJogaPeca();
								part.setUltima_peca(peca);
								jogadorPecas.remove(e.getComponent());
								part.participantes.get(0).getPecas().remove(peca);
								part.pecas_campo.add(peca);
								peca.drawPecaScaled(tabuleiro, tabuleiro.getWidth()/2 - 47, tabuleiro.getHeight()/2 - 50, 0, 0);
								part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
								part.extremidade1 = peca.getValor1();
								part.extremidade2 = peca.getValor2();
								part.primeiraPecaJogada = peca;
								part.ext1Peca = peca;
								part.ext2Peca = peca;
								tabuleiro.updateUI();
								jogadorPecas.updateUI();
								repaint();
								
								Component[] c = jogadorPecas.getComponents();
								for (Component j: c){
									j.setEnabled(true);;
								}
								
								if (part.isDificil()){
									JogadasSeguintesDificil(part);
									return;									
								} else {
									JogadasSeguintes(part);
									return;
								}
							}
						});
					} else {
						lab.setEnabled(false);
					}
				}
			} else { // inteligencia artificial
				if (part.jogadorDaVez == 1){
					inforEsquerda.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 2){
					inforCima.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 3){
					inforDireita.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				}
				JOptionPane.showMessageDialog(jogadorPecas, primeiro.getNome() + " inicia a partida!", "Partida iniciada", JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " inicia a partida!", "Partida iniciada", JOptionPane.INFORMATION_MESSAGE);
				for(int i = 0; i < primeiro.getPecas().size(); i++){
					Peca p = primeiro.getPecas().get(i);
					if(p.getValor1() == 6 && p.getValor2() == 6){
						primeiro.getPecas().remove(p);
						part.pecas_campo.add(p);
						if (part.jogadorDaVez == 1){ //ia esquerda
							iaEsquerdaPecas.remove(i);
						}
						if (part.jogadorDaVez == 2){ //ia cima
							iaCimaPecas.remove(i);
						}
						if (part.jogadorDaVez == 3){ //ia direita
							iaDireitaPecas.remove(i);
						}
	
						Som.somJogaPeca();
						part.setUltima_peca(p);
						p.virada = true;
						p.drawPecaScaled(tabuleiro, tabuleiro.getWidth()/2 - 47, tabuleiro.getHeight()/2 - 50, 0, 0);
						part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
						part.extremidade1 = p.getValor1();
						part.extremidade2 = p.getValor2();
						part.primeiraPecaJogada = p;
						part.ext1Peca = p;
						part.ext2Peca = p;
						tabuleiro.updateUI();
						repaint();
						
						if (part.jogadorDaVez == 0){
							JogadasSeguintes(part);
							return;				
						} else {
							if (part.isDificil()){
								JogadasSeguintesDificil(part);
								return;
							} else {
								JogadasSeguintes(part);
								return;				
							}
						}
					}
				}
			}
		} else {
			primeiro = part.participantes.get(part.id_lastWin);
			part.jogadorDaVez = part.id_lastWin;
			int quantidadeCarrocao = 0;
			
			if(part.jogadorDaVez == 0){	// jogador
	
				inforBaixo.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				JOptionPane.showMessageDialog(jogadorPecas, "Você inicia!", "Partida iniciada", JOptionPane.INFORMATION_MESSAGE);
				
				Component[] c = jogadorPecas.getComponents();
				for (int i = 0; i < c.length; i++){
					JLabel lab = (JLabel) c[i];
					String nome = lab.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					
					if (v1 == v2){
						quantidadeCarrocao++;
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
	
								Som.somJogaPeca();
								part.setUltima_peca(peca);
								jogadorPecas.remove(e.getComponent());
								part.participantes.get(0).getPecas().remove(peca);
								part.pecas_campo.add(peca);
								peca.drawPecaScaled(tabuleiro, tabuleiro.getWidth()/2 - 47, tabuleiro.getHeight()/2 - 50, 0, 0);
								part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
								part.extremidade1 = peca.getValor1();
								part.extremidade2 = peca.getValor2();
								part.primeiraPecaJogada = peca;
								part.ext1Peca = peca;
								part.ext2Peca = peca;
								tabuleiro.updateUI();
								jogadorPecas.updateUI();
								repaint();
	
								// tirando os listeners dos botoes do mouse
								Component[] c = jogadorPecas.getComponents();
								for (Component j: c){
									MouseListener[] m = j.getMouseListeners();
									if(m.length > 0)
										j.removeMouseListener(m[0]);
									j.setEnabled(true);;
								}
								
								if (part.isDificil()){
									JogadasSeguintesDificil(part);
									return;
								} else {
									JogadasSeguintes(part);
									return;
								}
							}
						});
					} else {
						lab.setEnabled(false);
					}
				}
				if (quantidadeCarrocao == 0){ // passa a vez
					JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " não tem carroça para iniciar, então passou a vez!", "Passou a vez", JOptionPane.INFORMATION_MESSAGE);
					Som.somPassouVez();
					int j = part.jogadorDaVez;
					part.jogadorDaVez = part.checkNext(j);
					part.id_lastWin = part.checkNext(j);
					contadorEmpate++;
					// tirando os listeners dos botoes do mouse
					Component[] compArray = jogadorPecas.getComponents();
					for (Component comp: compArray){
						MouseListener[] m = comp.getMouseListeners();
						if(m.length > 0)
							comp.removeMouseListener(m[0]);
						comp.setEnabled(true);;
					}
					
					IniciaPartida(part);
					return;
				}
			} else { // inteligencia artificial
				Peca p;
				if (part.jogadorDaVez == 1){
					inforEsquerda.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 2){
					inforCima.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 3){
					inforDireita.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				}
				JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " inicia!", "Partida iniciada", JOptionPane.INFORMATION_MESSAGE);
				for(int i = 0; i < primeiro.getPecas().size(); i++){
					p = primeiro.getPecas().get(i);
					if(p.getValor1() == p.getValor2()){ // pega o primeiro carrocao q aparecer
						primeiro.getPecas().remove(p);
						part.pecas_campo.add(p);
						if (part.jogadorDaVez == 1){ //ia esquerda
							iaEsquerdaPecas.remove(i);
						}
						if (part.jogadorDaVez == 2){ //ia cima
							iaCimaPecas.remove(i);
						}
						if (part.jogadorDaVez == 3){ //ia direita
							iaDireitaPecas.remove(i);
						}
	
						Som.somJogaPeca();
						part.setUltima_peca(p);
						p.virada = true;
						p.drawPecaScaled(tabuleiro, tabuleiro.getWidth()/2 - 47, tabuleiro.getHeight()/2 - 50, 0, 0);
						part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
						part.extremidade1 = p.getValor1();
						part.extremidade2 = p.getValor2();
						part.primeiraPecaJogada = p;
						part.ext1Peca = p;
						part.ext2Peca = p;
						tabuleiro.updateUI();
						repaint();
						
						if (part.jogadorDaVez == 0){
							JogadasSeguintes(part);
							return;
						} else {
							if (part.isDificil()){
								JogadasSeguintesDificil(part);
								return;
							} else {
								JogadasSeguintes(part);
								return;
							}
						}
					}
				}
				JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " não tem carroça para iniciar, então passou a vez!", "Passou a vez", JOptionPane.INFORMATION_MESSAGE);
				Som.somPassouVez();
				int j = part.jogadorDaVez;
				part.jogadorDaVez = part.checkNext(j);
				part.id_lastWin = part.checkNext(j);
				contadorEmpate++;

				IniciaPartida(part);
				return;
			}
		}
	}
	
	private int contadorEmpate = 0;
	
	public void JogadasSeguintes(final Partida part){
		
		if(part.jogadorDaVez == 0){ // jogador
			inforBaixo.setBorder(new LineBorder(new Color(0, 200, 0), 5));
			inforDireita.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			JOptionPane.showMessageDialog(jogadorPecas, "Sua vez!", "Partida em andamento", JOptionPane.INFORMATION_MESSAGE);
			// esse if verifica se tem jogada para fazer
			if (part.participantes.get(0).VerificarJogadaPossivel(part.extremidade1, part.extremidade2)){
				contadorEmpate = 0;
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
								part.pecas_campo.add(peca);
								part.setUltima_peca(peca);
								int x = part.pontuacao();
								
								if (peca.getValor1() == peca.getValor2()){
									if (peca.getValor1() == part.extremidade1){
										peca.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 1);
										part.extremidade1 = peca.getValor2();
										part.ext1Peca = peca;
									} else if (peca.getValor1() == part.extremidade2){
										peca.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 3);
										part.extremidade2 = peca.getValor2();
										part.ext2Peca = peca;
									}
								} else {
									if ((peca.getValor1() == part.extremidade1 && peca.getValor2() == part.extremidade2) ||
										(peca.getValor1() == part.extremidade2 && peca.getValor2() == part.extremidade1)){
										
										Object[] options = { "Lado do " + part.extremidade1, "Lado do " + part.extremidade2};
										int i = JOptionPane.showOptionDialog(null, "Qual extremidade?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
										if (i == 0){
											if (peca.getValor1() == part.extremidade1){
												peca.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 1);
												part.extremidade1 = peca.getValor2();
												part.ext1Peca = peca;
											} else if (peca.getValor2() == part.extremidade1){
												peca.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 3);
												part.extremidade1 = peca.getValor1();
												part.ext1Peca = peca;
											}
										} else if (i == 1) {
											if (peca.getValor1() == part.extremidade2){
												peca.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 3);
												part.extremidade2 = peca.getValor2();
												part.ext2Peca = peca;
											} else if (peca.getValor2() == part.extremidade2){
												peca.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 1);
												part.extremidade2 = peca.getValor1();
												part.ext2Peca = peca;
											}
										}
									} else {
										if (peca.getValor1() == part.extremidade1){
											peca.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 1);
											part.extremidade1 = peca.getValor2();
											part.ext1Peca = peca;
										} else if (peca.getValor2() == part.extremidade1){
											peca.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 3);
											part.extremidade1 = peca.getValor1();
											part.ext1Peca = peca;
										} else if (peca.getValor1() == part.extremidade2){
											peca.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 3);
											part.extremidade2 = peca.getValor2();
											part.ext2Peca = peca;
										} else if (peca.getValor2() == part.extremidade2){
											peca.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 1);
											part.extremidade2 = peca.getValor1();
											part.ext2Peca = peca;
										}
									}
								}

								Som.somJogaPeca();
								tabuleiro.updateUI();
								jogadorPecas.updateUI();
								repaint();
								
								Component[] c = jogadorPecas.getComponents();
								for (Component j: c){
									MouseListener[] m = j.getMouseListeners();
									if(m.length > 0)
										j.removeMouseListener(m[0]);
									j.setEnabled(true);;
								}

								Participante vencedor = part.checkWinner();
								if (vencedor == null){
									part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
									if (part.isDificil()){
										JogadasSeguintesDificil(part);
										return;
									} else {
										JogadasSeguintes(part);
										return;
									}
								} else {
									Som.somVenceuPartida();
									String mensagem = "";
									if (x == 1 || x/part.multiplicador == 1){
										mensagem = vencedor.getNome() + " venceu a partida com uma batida simples e ganhou " + x + " pontos!\n\n";
									} else if (x == 2 || x/part.multiplicador == 2){
										mensagem = vencedor.getNome() + " venceu a partida com um carroça e ganhou " + x + " pontos!\n\n";
									} else if (x == 3 || x/part.multiplicador == 3){
										mensagem = vencedor.getNome() + " venceu a partida com lá e lô e ganhou " + x + " pontos!\n\n";
									} else if (x == 6 || x/part.multiplicador == 6){
										mensagem = vencedor.getNome() + " venceu a partida com uma cruzada e ganhou " + x + " pontos!\n\n";
									}
									mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
									mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
									mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
									mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
									JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
									part.multiplicador = 1;

									tm.cancel();
									dispose();
									part.criarPartida();
									new InterfaceJogo(part, false);
								}
							}
						});
					} else {
						lab.setEnabled(false);
					}
				}
			} else { // passa a vez
				if(contadorEmpate == 3){

					Component[] c1 = iaCimaPecas.getComponents();
					for (Component j: c1){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					Component[] c2 = iaDireitaPecas.getComponents();
					for (Component j: c2){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					Component[] c3 = iaEsquerdaPecas.getComponents();
					for (Component j: c3){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					
					tabuleiro.updateUI();
					jogadorPecas.updateUI();
					iaCimaPecas.updateUI();
					iaEsquerdaPecas.updateUI();
					iaDireitaPecas.updateUI();
					repaint();
					
					Participante vencedor = part.checkEmpate();
					if (vencedor.getNome().equals(part.participantes.get(0).getNome())){
						Som.somVenceuPartida();
					} else {
						Som.somPerdeuPartida();
					}
					String mensagem = "Empatou! " + vencedor.getNome() + " venceu pela contagem dos pontos e ganhou " + 1*part.multiplicador + " pontos!\n\n";
					mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
					mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
					mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
					mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
					JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
					part.multiplicador = 1;
					
					tm.cancel();
					dispose();
					part.criarPartida();
					new InterfaceJogo(part, false);
					
				} else {		
					JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " passou a vez!", "Passou a vez", JOptionPane.INFORMATION_MESSAGE);
					if (part.isDificil()){
						InteligenciaArtificial iaAnterior = (InteligenciaArtificial) part.participantes.get(3);
						iaAnterior.alvoPassouVez(part.extremidade1, part.extremidade2);
					}
					Som.somPassouVez();			
					part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
					contadorEmpate++;
					if (part.isDificil()){
						JogadasSeguintesDificil(part);
						return;
					} else {
						JogadasSeguintes(part);
						return;
					}
				}
			}
		} else { // inteligencia artificial facil
			Peca p;
			if (part.jogadorDaVez == 1){
				inforEsquerda.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			} else if (part.jogadorDaVez == 2){
				inforCima.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			} else if (part.jogadorDaVez == 3){
				inforDireita.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			}
			// esse if verifica se tem peca que pode ser jogada
			if (part.participantes.get(part.jogadorDaVez).VerificarJogadaPossivel(part.extremidade1, part.extremidade2)){
				JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " tem a vez!", "Partida em andamento", JOptionPane.INFORMATION_MESSAGE);							
				contadorEmpate = 0;
				for(int i = 0; i < part.participantes.get(part.jogadorDaVez).getPecas().size(); i++){
					p = part.participantes.get(part.jogadorDaVez).getPecas().get(i);
					if (p.getValor1() == part.extremidade1 || p.getValor1() == part.extremidade2 ||
							p.getValor2() == part.extremidade2 || p.getValor2() == part.extremidade1){
						part.participantes.get(part.jogadorDaVez).getPecas().remove(p);
						part.pecas_campo.add(p);
						if (part.jogadorDaVez == 1){ //ia esquerda
							iaEsquerdaPecas.remove(i);
						}
						if (part.jogadorDaVez == 2){ //ia cima
							iaCimaPecas.remove(i);
						}
						if (part.jogadorDaVez == 3){ //ia direita
							iaDireitaPecas.remove(i);
						}

						Som.somJogaPeca();
						part.setUltima_peca(p);
						int x = part.pontuacao();
						p.virada = true;
						
						if (p.getValor1() == part.extremidade1){
							p.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 1);
							part.extremidade1 = p.getValor2();
							part.ext1Peca = p;
						} else if (p.getValor2() == part.extremidade1){
							p.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 3);
							part.extremidade1 = p.getValor1();
							part.ext1Peca = p;
						} else if (p.getValor1() == part.extremidade2){
							p.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 3);
							part.extremidade2 = p.getValor2();
							part.ext2Peca = p;
						} else if (p.getValor2() == part.extremidade2){
							p.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 1);
							part.extremidade2 = p.getValor1();
							part.ext2Peca = p;
						}

						tabuleiro.updateUI();
						repaint();
						
						Participante vencedor = part.checkWinner();
						if (vencedor == null){
							part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
							JogadasSeguintes(part);
							return;
						} else {
							String mensagem = "";
							Som.somPerdeuPartida();
							if (x == 1 || x/part.multiplicador == 1){
								mensagem = vencedor.getNome() + " venceu a partida com uma batida simples e ganhou " + x + " pontos!\n\n";
							} else if (x == 2 || x/part.multiplicador == 2){
								mensagem = vencedor.getNome() + " venceu a partida com um carroça e ganhou " + x + " pontos!\n\n";
							} else if (x == 3 || x/part.multiplicador == 3){
								mensagem = vencedor.getNome() + " venceu a partida com lá e lô e ganhou " + x + " pontos!\n\n";
							} else if (x == 6 || x/part.multiplicador == 6){
								mensagem = vencedor.getNome() + " venceu a partida com uma cruzada e ganhou " + x + " pontos!\n\n";
							}
							mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
							mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
							mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
							mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
							JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
							part.multiplicador = 1;
							
							tm.cancel();
							dispose();
							part.criarPartida();
							new InterfaceJogo(part, false);
						}
					}
				}
			} else {
				if(contadorEmpate == 3){
					
					Component[] c1 = iaCimaPecas.getComponents();
					for (Component j: c1){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					Component[] c2 = iaDireitaPecas.getComponents();
					for (Component j: c2){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					Component[] c3 = iaEsquerdaPecas.getComponents();
					for (Component j: c3){
						JLabel m = (JLabel) j;
						String nome = m.getName();
						int v1 = Integer.parseInt("" + nome.charAt(0));
						int v2 = Integer.parseInt("" + nome.charAt(1));
						m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
					}
					
					tabuleiro.updateUI();
					jogadorPecas.updateUI();
					iaCimaPecas.updateUI();
					iaEsquerdaPecas.updateUI();
					iaDireitaPecas.updateUI();
					repaint();
					
					Participante vencedor = part.checkEmpate();
					if (vencedor.getNome().equals(part.participantes.get(0).getNome())){
						Som.somVenceuPartida();
					} else {
						Som.somPerdeuPartida();
					}
					String mensagem = "Empatou! " + vencedor.getNome() + " venceu pela contagem dos pontos e ganhou " + 1*part.multiplicador + " pontos!\n\n";
					mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
					mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
					mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
					mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
					JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
					part.multiplicador = 1;
					
					tm.cancel();
					dispose();
					part.criarPartida();
					new InterfaceJogo(part, false);
					
				} else {
					JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " passou a vez!", "Passou a vez", JOptionPane.INFORMATION_MESSAGE);
					Som.somPassouVez();
					part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
					contadorEmpate++;
					JogadasSeguintes(part);
					return;
				}
			}
		}
	}
	
	// IA dificil
	public void JogadasSeguintesDificil(final Partida part){
		Peca p;
		Peca aux;
		// esse if verifica se tem peca que pode ser jogada
		if (part.participantes.get(part.jogadorDaVez).VerificarJogadaPossivel(part.extremidade1, part.extremidade2)){
			if (part.jogadorDaVez == 1){
				inforEsquerda.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			} else if (part.jogadorDaVez == 2){
				inforCima.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			} else if (part.jogadorDaVez == 3){
				inforDireita.setBorder(new LineBorder(new Color(0, 200, 0), 5));
				inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			}
			JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " tem a vez!", "Partida em andamento", JOptionPane.INFORMATION_MESSAGE);							
			contadorEmpate = 0;
			InteligenciaArtificial ia = (InteligenciaArtificial) part.participantes.get(part.jogadorDaVez);
			
			p = ia.jogarPecaPensada(part);
			for (int i = 0; i < part.participantes.get(part.jogadorDaVez).getPecas().size(); i++){
				aux = part.participantes.get(part.jogadorDaVez).getPecas().get(i);
				if (p.equals(aux)){
					part.participantes.get(part.jogadorDaVez).getPecas().remove(p);
					part.pecas_campo.add(p);
					if (part.jogadorDaVez == 1){ //ia esquerda
						iaEsquerdaPecas.remove(i);
						break;
					}
					if (part.jogadorDaVez == 2){ //ia cima
						iaCimaPecas.remove(i);
						break;
					}
					if (part.jogadorDaVez == 3){ //ia direita
						iaDireitaPecas.remove(i);
						break;
					}
				}
			}

			Som.somJogaPeca();
			part.setUltima_peca(p);
			int x = part.pontuacao();
			p.virada = true;
			
			if (p.getValor1() == part.extremidade1){
				p.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 1);
				part.extremidade1 = p.getValor2();
				part.ext1Peca = p;
			} else if (p.getValor2() == part.extremidade1){
				p.calcularPosicaoPeca(tabuleiro, part.ext1Peca, part.primeiraPecaJogada, 1, 3);
				part.extremidade1 = p.getValor1();
				part.ext1Peca = p;
			} else if (p.getValor1() == part.extremidade2){
				p.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 3);
				part.extremidade2 = p.getValor2();
				part.ext2Peca = p;
			} else if (p.getValor2() == part.extremidade2){
				p.calcularPosicaoPeca(tabuleiro, part.ext2Peca, part.primeiraPecaJogada, 3, 1);
				part.extremidade2 = p.getValor1();
				part.ext2Peca = p;
			}

			tabuleiro.updateUI();
			repaint();
			
			Participante vencedor = part.checkWinner();
			if (vencedor == null){
				part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
				if (part.jogadorDaVez == 0){
					JogadasSeguintes(part);
					return;
				} else {
					JogadasSeguintesDificil(part);
					return;
				}
			} else {
				String mensagem = "";
				Som.somPerdeuPartida();
				if (x == 1 || x/part.multiplicador == 1){
					mensagem = vencedor.getNome() + " venceu a partida com uma batida simples e ganhou " + x + " pontos!\n\n";
				} else if (x == 2 || x/part.multiplicador == 2){
					mensagem = vencedor.getNome() + " venceu a partida com um carroça e ganhou " + x + " pontos!\n\n";
				} else if (x == 3 || x/part.multiplicador == 3){
					mensagem = vencedor.getNome() + " venceu a partida com lá e lô e ganhou " + x + " pontos!\n\n";
				} else if (x == 6 || x/part.multiplicador == 6){
					mensagem = vencedor.getNome() + " venceu a partida com uma cruzada e ganhou " + x + " pontos!\n\n";
				}
				mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
				mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
				mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
				mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
				JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
				part.multiplicador = 1;
				
				tm.cancel();
				dispose();
				part.criarPartida();
				new InterfaceJogo(part, false);
			}
		} else {
			if(contadorEmpate == 3){
				
				Component[] c1 = iaCimaPecas.getComponents();
				for (Component j: c1){
					JLabel m = (JLabel) j;
					String nome = m.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
				}
				Component[] c2 = iaDireitaPecas.getComponents();
				for (Component j: c2){
					JLabel m = (JLabel) j;
					String nome = m.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
				}
				Component[] c3 = iaEsquerdaPecas.getComponents();
				for (Component j: c3){
					JLabel m = (JLabel) j;
					String nome = m.getName();
					int v1 = Integer.parseInt("" + nome.charAt(0));
					int v2 = Integer.parseInt("" + nome.charAt(1));
					m.setIcon(new ImageIcon(".\\image\\peca\\peca" + v1 + v2 + ".png"));
				}
				
				tabuleiro.updateUI();
				jogadorPecas.updateUI();
				iaCimaPecas.updateUI();
				iaEsquerdaPecas.updateUI();
				iaDireitaPecas.updateUI();
				repaint();
				
				Participante vencedor = part.checkEmpate();
				if (vencedor.getNome().equals(part.participantes.get(0).getNome())){
					Som.somVenceuPartida();
				} else {
					Som.somPerdeuPartida();
				}
				String mensagem = "Empatou! " + vencedor.getNome() + " venceu pela contagem dos pontos e ganhou " + 1*part.multiplicador + " pontos!\n\n";
				mensagem += part.participantes.get(0).getNome() + " possui " + part.pontuacao_jogadores[0] + " pontos.\n";
				mensagem += part.participantes.get(1).getNome() + " possui " + part.pontuacao_jogadores[1] + " pontos.\n";
				mensagem += part.participantes.get(2).getNome() + " possui " + part.pontuacao_jogadores[2] + " pontos.\n";
				mensagem += part.participantes.get(3).getNome() + " possui " + part.pontuacao_jogadores[3] + " pontos.\n";
				JOptionPane.showMessageDialog(null, mensagem, "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
				part.multiplicador = 1;
				
				tm.cancel();
				dispose();
				part.criarPartida();
				new InterfaceJogo(part, false);
				
			} else {
				if (part.jogadorDaVez == 1){
					inforEsquerda.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 2){
					inforCima.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforEsquerda.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				} else if (part.jogadorDaVez == 3){
					inforDireita.setBorder(new LineBorder(new Color(0, 200, 0), 5));
					inforCima.setBorder(new LineBorder(new Color(0, 0, 0), 5));
				}

				JOptionPane.showMessageDialog(jogadorPecas, part.participantes.get(part.jogadorDaVez).getNome() + " passou a vez!", "Passou a vez", JOptionPane.INFORMATION_MESSAGE);
				if (part.jogadorDaVez > 1){
					InteligenciaArtificial iaAnterior = (InteligenciaArtificial) part.participantes.get(part.jogadorDaVez - 1);
					iaAnterior.alvoPassouVez(part.extremidade1, part.extremidade2);
				}
				Som.somPassouVez();
				part.jogadorDaVez = part.checkNext(part.jogadorDaVez);
				contadorEmpate++;
				if (part.jogadorDaVez == 0){
					JogadasSeguintes(part);
					return;
				} else {
					JogadasSeguintesDificil(part);
					return;
				}
			}
		}
	}
}