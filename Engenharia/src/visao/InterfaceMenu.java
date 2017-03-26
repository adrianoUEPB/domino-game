package visao;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import modelo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Cursor;

public class InterfaceMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel opcoes;
	JButton botaoNovaPartida, botaoContinuarPartida, botaoRanking;

	public InterfaceMenu(final Jogador jogador_logado) {
		getContentPane().setBackground(new Color(139, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel labelDomino = new JLabel("Dominó");
		labelDomino.setForeground(Color.WHITE);
		labelDomino.setHorizontalAlignment(SwingConstants.CENTER);
		labelDomino.setFont(new Font("Brush Script MT", Font.PLAIN, 180));
		labelDomino.setBounds(36, 11, 527, 202);
		getContentPane().add(labelDomino);
		
		botaoNovaPartida = new JButton();
		botaoNovaPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoNovaPartida.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-pressed.png"));
		botaoNovaPartida.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-rollover.png"));
		botaoNovaPartida.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-rollover.png"));
		botaoNovaPartida.setIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-normal.png"));
		botaoNovaPartida.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-disabled.png"));
		botaoNovaPartida.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-disabled.png"));
		botaoNovaPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoNovaPartida.setBorder(null);
		botaoNovaPartida.setBounds(10, 251, 240, 70);
		getContentPane().add(botaoNovaPartida);
		
		botaoContinuarPartida = new JButton();
		botaoContinuarPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoContinuarPartida.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-pressed.png"));
		botaoContinuarPartida.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-rollover.png"));
		botaoContinuarPartida.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-rollover.png"));
		botaoContinuarPartida.setIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-normal.png"));
		botaoContinuarPartida.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-disabled.png"));
		botaoContinuarPartida.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-disabled.png"));
		botaoContinuarPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoContinuarPartida.setBorder(null);
		botaoContinuarPartida.setBounds(10, 332, 240, 70);
		getContentPane().add(botaoContinuarPartida);
		
		botaoRanking = new JButton();
		botaoRanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoRanking.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-pressed.png"));
		botaoRanking.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-rollover.png"));
		botaoRanking.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-rollover.png"));
		botaoRanking.setIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-normal.png"));
		botaoRanking.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-disabled.png"));
		botaoRanking.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-disabled.png"));
		botaoRanking.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoRanking.setBorder(null);
		botaoRanking.setBounds(10, 413, 240, 70);
		getContentPane().add(botaoRanking);
		
		JButton botaoLogout = new JButton();
		botaoLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoLogout.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-pressed.png"));
		botaoLogout.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-rollover.png"));
		botaoLogout.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-rollover.png"));
		botaoLogout.setIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-normal.png"));
		botaoLogout.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-disabled.png"));
		botaoLogout.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-disabled.png"));
		botaoLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoLogout.setBorder(null);
		botaoLogout.setBounds(10, 494, 240, 70);
		getContentPane().add(botaoLogout);
		
		JLabel imagemLabel = new JLabel("");
		imagemLabel.setBounds(521, 11, 263, 227);
		imagemLabel.setIcon(new ImageIcon(".\\image\\peca\\pecasMenu.png"));
		getContentPane().add(imagemLabel);
		
		JLabel bemVindo = new JLabel("Bem vindo, "+ jogador_logado.getNome() +"! Divirta-se! ");
		bemVindo.setHorizontalAlignment(SwingConstants.RIGHT);
		bemVindo.setForeground(Color.WHITE);
		bemVindo.setFont(new Font("Brush Script MT", Font.PLAIN, 36));
		bemVindo.setBounds(260, 224, 524, 70);
		getContentPane().add(bemVindo);
		
		opcoes = new JPanel();
		opcoes.setBackground(new Color(139, 0, 0));
		opcoes.setBounds(260, 305, 524, 259);
		opcoes.setLayout(null);
		opcoes.setVisible(false);
		getContentPane().add(opcoes);
		
		JButton jogoNormal = new JButton("f\u00E1cil");
		jogoNormal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jogoNormal.setBounds(128, 11, 240, 70);
		opcoes.add(jogoNormal);
		
		JButton jogoDificil = new JButton("dificil");
		jogoDificil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jogoDificil.setEnabled(false);
		jogoDificil.setBounds(128, 92, 240, 70);
		opcoes.add(jogoDificil);
		
		JButton botaoCancelar = new JButton("");
		botaoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoCancelar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-pressed.png"));
		botaoCancelar.setIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-normal.png"));
		botaoCancelar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoCancelar.setBorder(null);
		botaoCancelar.setBounds(190, 193, 120, 35);
		opcoes.add(botaoCancelar);
		
		// actions listeners
		botaoNovaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcoes.setVisible(true);
				botaoContinuarPartida.setEnabled(false);
				botaoNovaPartida.setEnabled(false);
				botaoRanking.setEnabled(false);
			}
		});
		
		// nova partida facil
		jogoNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Participante> participantes = new ArrayList<Participante>();
				participantes.add(jogador_logado);
				
				Participante IA1;
				if (jogador_logado.getIcone().contains("Pernalonga")){
					IA1 = new InteligenciaArtificial("Gaguinho", ".\\image\\icon\\Gaguinho.png", false);
				} else {
					IA1 = new InteligenciaArtificial("Pernalonga", ".\\image\\icon\\Pernalonga.png", false);
				}
				participantes.add(IA1);
				
				Participante IA2;
				if (jogador_logado.getIcone().contains("Lola")){
					IA2 = new InteligenciaArtificial("Gaguinho", ".\\image\\icon\\Gaguinho.png", false);
				} else {
					IA2 = new InteligenciaArtificial("Lola", ".\\image\\icon\\Lola.png", false);
				}
				participantes.add(IA2);
				
				Participante IA3;
				if (jogador_logado.getIcone().contains("Patolino")){
					IA3 = new InteligenciaArtificial("Gaguinho", ".\\image\\icon\\Gaguinho.png", false);
				} else {
					IA3 = new InteligenciaArtificial("Patolino", ".\\image\\icon\\Patolino.png", false);
				}
				participantes.add(IA3);
				
				Partida part = new Partida(participantes);

				for (int valor1 = 0; valor1 <= 6; valor1++) {
					for (int valor2 = valor1; valor2 <= 6; valor2++) {
						Peca peca = new Peca(valor1, valor2, false);
						part.pecas_dormidas.add(peca);
					}
				}
				
				dispose();
				new InterfaceJogo(part);
			}
		});
		
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcoes.setVisible(false);
				botaoContinuarPartida.setEnabled(true);
				botaoNovaPartida.setEnabled(true);
				botaoRanking.setEnabled(true);
			}
		});
		
		botaoLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new InterfaceInicial();
			}
		});
		
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
