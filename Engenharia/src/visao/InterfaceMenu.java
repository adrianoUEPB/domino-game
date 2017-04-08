package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controle.DAO;
import controle.Som;
import modelo.InteligenciaArtificial;
import modelo.Jogador;
import modelo.Participante;
import modelo.Partida;

public class InterfaceMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	Som som = new Som();
	JPanel opcoes, sobre;
	JButton botaoNovaPartida, botaoContinuarPartida, botaoRanking, botaoSobre, jogoFacil, jogoDificil, botaoHelp;
	JLabel sobreLabel1, sobreLabel2, sobreLabel3, sobreLabel4, sobreLabel5, sobreLabel6, sobreLabel7, bemVindo, icone;
	JButton botaoVoltar;

	public InterfaceMenu(final Jogador jogador_logado) {
		dao = new DAO();
		getContentPane().setBackground(new Color(139, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel labelDomino = new JLabel("Dominó");
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
		if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
			botaoContinuarPartida.setEnabled(true);
		} else {
			botaoContinuarPartida.setEnabled(false);
		}
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
		
		bemVindo = new JLabel("Bem vindo, "+ jogador_logado.getNome() +"! ");
		bemVindo.setHorizontalAlignment(SwingConstants.RIGHT);
		bemVindo.setForeground(Color.WHITE);
		bemVindo.setFont(new Font("Brush Script MT", Font.PLAIN, 38));
		bemVindo.setBounds(398, 200, 386, 70);
		getContentPane().add(bemVindo);
		
		opcoes = new JPanel();
		opcoes.setBackground(new Color(139, 0, 0));
		opcoes.setBounds(270, 372, 514, 139);
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

		icone = new JLabel(new ImageIcon(jogador_logado.getIcone()));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		icone.setBounds(669, 261, 100, 100);
		getContentPane().add(icone);
		
		botaoHelp = new JButton();
		botaoHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoHelp.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-help-disabled.png"));
		botaoHelp.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-help-rollover.png"));
		botaoHelp.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-help-rollover.png"));
		botaoHelp.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-help-pressed.png"));
		botaoHelp.setIcon(new ImageIcon(".\\image\\graphics\\BtP-help-normal.png"));
		botaoHelp.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-help-disabled.png"));
		botaoHelp.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoHelp.setBorder(null);
		botaoHelp.setBounds(739, 519, 45, 45);
		getContentPane().add(botaoHelp);
		
		sobre = new JPanel();
		sobre.setVisible(false);
		sobre.setBackground(new Color(139, 0, 0));
		sobre.setBounds(326, 232, 389, 332);
		getContentPane().add(sobre);
		sobre.setLayout(null);
		
		sobreLabel1 = new JLabel(" Engenharia de Software ");
		sobreLabel1.setBounds(21, 5, 346, 44);
		sobreLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		sobreLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel1.setForeground(Color.WHITE);
		sobreLabel1.setFont(new Font("Brush Script MT", Font.BOLD, 35));
		sobre.add(sobreLabel1);
		
		sobreLabel2 = new JLabel("Equipe:                          ");
		sobreLabel2.setBounds(86, 54, 217, 29);
		sobreLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		sobreLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel2.setForeground(Color.WHITE);
		sobreLabel2.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		sobre.add(sobreLabel2);
		
		sobreLabel3 = new JLabel(" Adriano Araújo Felisberto ");
		sobreLabel3.setBounds(90, 88, 209, 29);
		sobreLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel3.setForeground(Color.WHITE);
		sobreLabel3.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		sobre.add(sobreLabel3);
		
		sobreLabel4 = new JLabel(" Eleonilia Monteiro Rodrigues ");
		sobreLabel4.setBounds(79, 122, 231, 29);
		sobreLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel4.setForeground(Color.WHITE);
		sobreLabel4.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		sobre.add(sobreLabel4);
		
		sobreLabel5 = new JLabel(" Maria José Oliveira Costa ");
		sobreLabel5.setBounds(89, 156, 210, 29);
		sobreLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel5.setForeground(Color.WHITE);
		sobreLabel5.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		sobre.add(sobreLabel5);
		
		sobreLabel6 = new JLabel(" Wendell Gomes Silva ");
		sobreLabel6.setBounds(109, 190, 170, 29);
		sobreLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel6.setForeground(Color.WHITE);
		sobreLabel6.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
		sobre.add(sobreLabel6);
		
		sobreLabel7 = new JLabel("  Desenvolvido em 2017  ");
		sobreLabel7.setBounds(52, 224, 285, 44);
		sobreLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
		sobreLabel7.setForeground(Color.WHITE);
		sobreLabel7.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		sobreLabel7.setAlignmentX(0.5f);
		sobre.add(sobreLabel7);
		
		botaoVoltar = new JButton();
		botaoVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoVoltar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		botaoVoltar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		botaoVoltar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		botaoVoltar.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-pressed.png"));
		botaoVoltar.setIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-normal.png"));
		botaoVoltar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		botaoVoltar.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoVoltar.setBorder(null);
		botaoVoltar.setBounds(161, 259, 90, 90);
		sobre.add(botaoVoltar);
		
		// actions listeners
		botaoNovaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				opcoes.setVisible(true);
				botaoContinuarPartida.setEnabled(false);
				botaoNovaPartida.setEnabled(false);
				botaoRanking.setEnabled(false);
				botaoSobre.setEnabled(false);
				botaoHelp.setEnabled(false);
			}
		});
		
		botaoContinuarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				dispose();
				new InterfaceJogo(dao.resgatarPartida(jogador_logado.getId()), true);
				return;
			}
		});
		
		botaoRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				dispose();
				new InterfaceRanking(jogador_logado);
			}
		});

		botaoSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				sobre.setVisible(true);
				botaoContinuarPartida.setEnabled(false);
				botaoNovaPartida.setEnabled(false);
				botaoRanking.setEnabled(false);
				botaoSobre.setEnabled(false);
				botaoHelp.setEnabled(false);
				bemVindo.setVisible(false);
				icone.setVisible(false);
			}
		});
		
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				sobre.setVisible(false);
				if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
					botaoContinuarPartida.setEnabled(true);
				} else {
					botaoContinuarPartida.setEnabled(false);
				}
				botaoNovaPartida.setEnabled(true);
				botaoRanking.setEnabled(true);
				botaoSobre.setEnabled(true);
				botaoHelp.setEnabled(true);
				bemVindo.setVisible(true);
				icone.setVisible(true);
			}
		});
		
		// nova partida facil
		jogoFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				boolean flag = false;
				if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
					Object[] options = { "SIM", "NÃO" };
					int opcao = JOptionPane.showOptionDialog(null, "Já possui jogo salvo, deseja continuar?", "Aviso",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[0]);	
					
					if (opcao == 0) {
						flag = true;
						dao.deletarPartida(jogador_logado.getId());
					} else {
						opcoes.setVisible(false);
						if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
							botaoContinuarPartida.setEnabled(true);
						} else {
							botaoContinuarPartida.setEnabled(false);
						}
						botaoNovaPartida.setEnabled(true);
						botaoRanking.setEnabled(true);
						botaoSobre.setEnabled(true);
						botaoHelp.setEnabled(true);
					}
				} else {
					flag = true;
				}
				if (flag) {
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
					new InterfaceJogo(part, false);
				}

			}
		});
		
		// nova partida difícil
		jogoDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				boolean flag = false;
				if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
					Object[] options = { "SIM", "NÃO" };
					int opcao = JOptionPane.showOptionDialog(null, "Já possui jogo salvo, deseja continuar?", "Aviso",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[0]);	
					
					if (opcao == 0) {
						flag = true;
						dao.deletarPartida(jogador_logado.getId());
					} else {
						opcoes.setVisible(false);
						if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
							botaoContinuarPartida.setEnabled(true);
						} else {
							botaoContinuarPartida.setEnabled(false);
						}
						botaoNovaPartida.setEnabled(true);
						botaoRanking.setEnabled(true);
						botaoSobre.setEnabled(true);
						botaoHelp.setEnabled(true);
					}
				} else {
					flag = true;
				}
				if (flag) {
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
					new InterfaceJogo(part, false);
				}
			}
		});
		
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
				opcoes.setVisible(false);
				if (dao.PossuiJogoSalvo(jogador_logado.getId())) {
					botaoContinuarPartida.setEnabled(true);
				} else {
					botaoContinuarPartida.setEnabled(false);
				}
				botaoNovaPartida.setEnabled(true);
				botaoRanking.setEnabled(true);
				botaoSobre.setEnabled(true);
				botaoHelp.setEnabled(true);
			}
		});
		
		botaoLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som.somClick();
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
