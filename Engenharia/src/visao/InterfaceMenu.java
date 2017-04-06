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
import javax.swing.border.LineBorder;

public class InterfaceMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel opcoes;
	JButton botaoNovaPartida, botaoContinuarPartida, botaoRanking, botaoSobre, jogoFacil, jogoDificil;

	public InterfaceMenu(final Jogador jogador_logado) {
		getContentPane().setBackground(new Color(139, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel labelDomino = new JLabel("Domin�");
		labelDomino.setForeground(Color.WHITE);
		labelDomino.setHorizontalAlignment(SwingConstants.CENTER);
		labelDomino.setFont(new Font("Brush Script MT", Font.PLAIN, 180));
		labelDomino.setBounds(20, 20, 571, 153);
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
		botaoNovaPartida.setBounds(20, 210, 240, 70);
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
		botaoContinuarPartida.setBounds(20, 281, 240, 70);
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
		botaoRanking.setBounds(20, 352, 240, 70);
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
		botaoLogout.setBounds(20, 494, 240, 70);
		getContentPane().add(botaoLogout);
		
		botaoSobre = new JButton();
		botaoSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoSobre.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-pressed.png"));
		botaoSobre.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-rollover.png"));
		botaoSobre.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-rollover.png"));
		botaoSobre.setIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-normal.png"));
		botaoSobre.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-disabled.png"));
		botaoSobre.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-sobre-disabled.png"));
		botaoSobre.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoSobre.setBorder(null);
		botaoSobre.setBounds(20, 423, 240, 70);
		getContentPane().add(botaoSobre);
		
		JLabel imagemLabel = new JLabel();
		imagemLabel.setBounds(485, 11, 263, 227);
		imagemLabel.setIcon(new ImageIcon(".\\image\\peca\\pecasMenu.png"));
		getContentPane().add(imagemLabel);
		
		JLabel bemVindo = new JLabel("Bem vindo, "+ jogador_logado.getNome() +"! ");
		bemVindo.setHorizontalAlignment(SwingConstants.RIGHT);
		bemVindo.setForeground(Color.WHITE);
		bemVindo.setFont(new Font("Brush Script MT", Font.PLAIN, 38));
		bemVindo.setBounds(398, 200, 386, 70);
		getContentPane().add(bemVindo);
		
		opcoes = new JPanel();
		opcoes.setBackground(new Color(139, 0, 0));
		opcoes.setBounds(270, 405, 514, 139);
		opcoes.setLayout(null);
		opcoes.setVisible(false);
		getContentPane().add(opcoes);
		
		JButton botaoCancelar = new JButton();
		botaoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoCancelar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-pressed.png"));
		botaoCancelar.setIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-normal.png"));
		botaoCancelar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoCancelar.setBorder(null);
		botaoCancelar.setBounds(199, 92, 120, 35);
		opcoes.add(botaoCancelar);
		
		jogoFacil = new JButton();
		jogoFacil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jogoFacil.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-disabled.png"));
		jogoFacil.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-rollover.png"));
		jogoFacil.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-rollover.png"));
		jogoFacil.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-pressed.png"));
		jogoFacil.setIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-normal.png"));
		jogoFacil.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtM-facil-disabled.png"));
		jogoFacil.setHorizontalTextPosition(SwingConstants.CENTER);
		jogoFacil.setBorder(null);
		jogoFacil.setBounds(10, 11, 240, 70);
		opcoes.add(jogoFacil);
		
		jogoDificil = new JButton();
		jogoDificil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jogoDificil.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-disabled.png"));
		jogoDificil.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-rollover.png"));
		jogoDificil.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-rollover.png"));
		jogoDificil.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-pressed.png"));
		jogoDificil.setIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-normal.png"));
		jogoDificil.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtM-dificil-disabled.png"));
		jogoDificil.setHorizontalTextPosition(SwingConstants.CENTER);
		jogoDificil.setBorder(null);
		jogoDificil.setBounds(264, 11, 240, 70);
		opcoes.add(jogoDificil);

		JLabel icone = new JLabel(new ImageIcon(jogador_logado.getIcone()));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		icone.setBounds(669, 261, 100, 100);
		getContentPane().add(icone);
		
		// actions listeners
		botaoNovaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcoes.setVisible(true);
				botaoContinuarPartida.setEnabled(false);
				botaoNovaPartida.setEnabled(false);
				botaoRanking.setEnabled(false);
				botaoSobre.setEnabled(false);
			}
		});
		
		botaoRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new InterfaceRanking(jogador_logado);
			}
		});
		
		// nova partida facil
		jogoFacil.addActionListener(new ActionListener() {
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
				
				Partida part = new Partida(participantes, false);
				part.criarPartida();
				
				dispose();
				new InterfaceJogo(part);
			}
		});
		
		// nova partida dif�cil
		jogoDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Participante> participantes = new ArrayList<Participante>();
				participantes.add(jogador_logado);
				
				Participante IA1;
				if (jogador_logado.getIcone().contains("Taz")){
					IA1 = new InteligenciaArtificial("Frajola", ".\\image\\icon\\Frajola.png", true);
				} else {
					IA1 = new InteligenciaArtificial("Taz", ".\\image\\icon\\Taz.png", true);
				}
				participantes.add(IA1);
				
				Participante IA2;
				if (jogador_logado.getIcone().contains("Eufrazino")){
					IA2 = new InteligenciaArtificial("Frajola", ".\\image\\icon\\Frajola.png", true);
				} else {
					IA2 = new InteligenciaArtificial("Eufrazino", ".\\image\\icon\\Eufrazino.png", true);
				}
				participantes.add(IA2);
				
				Participante IA3;
				if (jogador_logado.getIcone().contains("Marvin")){
					IA3 = new InteligenciaArtificial("Frajola", ".\\image\\icon\\Frajola.png", true);
				} else {
					IA3 = new InteligenciaArtificial("Marvin", ".\\image\\icon\\Marvin.png", true);
				}
				participantes.add(IA3);
				
				Partida part = new Partida(participantes, true);
				part.criarPartida();
				
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
				botaoSobre.setEnabled(true);
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
