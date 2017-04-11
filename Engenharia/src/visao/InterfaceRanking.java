package visao;

import javax.swing.JFrame;

import modelo.*;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import controle.DAO;
import controle.PDFRanking;
import controle.Som;

import java.awt.Font;

import javax.swing.border.LineBorder;

import com.itextpdf.text.DocumentException;

public class InterfaceRanking extends JFrame {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JPanel inforTopOne, inforTopTwo, inforTopThree, inforTopFour, inforTopFive;

	public InterfaceRanking(final Jogador jogador_logado) {
		getContentPane().setBackground(new Color(139, 0, 0));
		
		ArrayList<Jogador> listaJogadores = dao.rankingDAO();
		getContentPane().setLayout(null);
		
		JPanel inforRanking = new JPanel();
		inforRanking.setBounds(0, 0, 794, 575);
		inforRanking.setBackground(new Color(139, 0, 0));
		getContentPane().add(inforRanking);
		inforRanking.setLayout(null);
		
		inforTopOne = new JPanel();
		inforTopOne.setBackground(new Color(139,0,0));
		inforTopOne.setBounds(71, 95, 713, 85);
		inforRanking.add(inforTopOne);
		inforTopOne.setLayout(null);
		
		JLabel icon1 = new JLabel(new ImageIcon(listaJogadores.get(0).getIcone()));
		icon1.setBorder(new LineBorder(new Color(0, 0, 0)));
		icon1.setBounds(0, 0, 85, 85);
		inforTopOne.add(icon1);
		
		JLabel nome1 = new JLabel("Nome:");
		nome1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome1.setForeground(Color.WHITE);
		nome1.setBounds(95, 11, 283, 25);
		inforTopOne.add(nome1);

		JLabel vitorias1 = new JLabel("Vitórias: " + listaJogadores.get(0).getPartidas_vencidas());
		vitorias1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias1.setForeground(Color.WHITE);
		vitorias1.setBounds(543, 11, 160, 38);
		inforTopOne.add(vitorias1);
		
		JLabel ponto1 = new JLabel("Pontuação: " + listaJogadores.get(0).getPontuacao());
		ponto1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto1.setForeground(Color.WHITE);
		ponto1.setBounds(388, 11, 145, 38);
		inforTopOne.add(ponto1);
		
		JLabel tempo1 = new JLabel("Tempo: " + formatTime(listaJogadores.get(0).getTempo_rodadas()));
		tempo1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo1.setForeground(Color.WHITE);
		tempo1.setBounds(388, 53, 145, 32);
		inforTopOne.add(tempo1);
		
		JLabel data1 = new JLabel("Data: " + listaJogadores.get(0).getUltima_partida());
		data1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data1.setForeground(Color.WHITE);
		data1.setBounds(543, 53, 160, 32);
		inforTopOne.add(data1);
		
		JLabel name1 = new JLabel(listaJogadores.get(0).getNome());
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Brush Script MT", Font.PLAIN, 27));
		name1.setForeground(Color.WHITE);
		name1.setBounds(95, 35, 283, 39);
		inforTopOne.add(name1);
		
		inforTopTwo = new JPanel();
		inforTopTwo.setBackground(new Color(139,0,0));
		inforTopTwo.setBounds(71, 191, 713, 85);
		inforRanking.add(inforTopTwo);
		inforTopTwo.setLayout(null);
		
		JLabel icon2 = new JLabel(new ImageIcon(listaJogadores.get(1).getIcone()));
		icon2.setBorder(new LineBorder(new Color(0, 0, 0)));
		icon2.setBounds(0, 0, 85, 85);
		inforTopTwo.add(icon2);
		
		JLabel nome2 = new JLabel("Nome:");
		nome2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome2.setForeground(Color.WHITE);
		nome2.setBounds(95, 11, 283, 25);
		inforTopTwo.add(nome2);
		
		JLabel vitorias2 = new JLabel("Vitórias: " + listaJogadores.get(1).getPartidas_vencidas());
		vitorias2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias2.setForeground(Color.WHITE);
		vitorias2.setBounds(543, 11, 160, 38);
		inforTopTwo.add(vitorias2);
		
		JLabel ponto2 = new JLabel("Pontuação: " + listaJogadores.get(1).getPontuacao());
		ponto2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto2.setForeground(Color.WHITE);
		ponto2.setBounds(388, 11, 145, 38);
		inforTopTwo.add(ponto2);
		
		JLabel tempo2 = new JLabel("Tempo: " + formatTime(listaJogadores.get(1).getTempo_rodadas()));
		tempo2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo2.setForeground(Color.WHITE);
		tempo2.setBounds(388, 53, 145, 32);
		inforTopTwo.add(tempo2);
		
		JLabel data2 = new JLabel("Data: " + listaJogadores.get(1).getUltima_partida());
		data2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data2.setForeground(Color.WHITE);
		data2.setBounds(543, 53, 160, 32);
		inforTopTwo.add(data2);
		
		JLabel name2 = new JLabel(listaJogadores.get(1).getNome());
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setFont(new Font("Brush Script MT", Font.PLAIN, 27));
		name2.setForeground(Color.WHITE);
		name2.setBounds(95, 35, 283, 39);
		inforTopTwo.add(name2);
		
		inforTopThree = new JPanel();
		inforTopThree.setBackground(new Color(139,0,0));
		inforTopThree.setBounds(71, 287, 713, 85);
		inforRanking.add(inforTopThree);
		inforTopThree.setLayout(null);
		
		JLabel icon3 = new JLabel(new ImageIcon(listaJogadores.get(2).getIcone()));
		icon3.setBorder(new LineBorder(new Color(0, 0, 0)));
		icon3.setBounds(0, 0, 85, 85);
		inforTopThree.add(icon3);
		
		JLabel nome3 = new JLabel("Nome:");
		nome3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome3.setForeground(Color.WHITE);
		nome3.setBounds(95, 11, 283, 25);
		inforTopThree.add(nome3);
		
		JLabel vitorias3 = new JLabel("Vitórias: " + listaJogadores.get(2).getPartidas_vencidas());
		vitorias3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias3.setForeground(Color.WHITE);
		vitorias3.setBounds(543, 11, 160, 38);
		inforTopThree.add(vitorias3);
		
		JLabel ponto3 = new JLabel("Pontuação: " + listaJogadores.get(2).getPontuacao());
		ponto3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto3.setForeground(Color.WHITE);
		ponto3.setBounds(388, 11, 145, 38);
		inforTopThree.add(ponto3);
		
		JLabel tempo3 = new JLabel("Tempo: " + formatTime(listaJogadores.get(2).getTempo_rodadas()));
		tempo3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo3.setForeground(Color.WHITE);
		tempo3.setBounds(388, 53, 145, 32);
		inforTopThree.add(tempo3);
		
		JLabel data3 = new JLabel("Data: " + listaJogadores.get(2).getUltima_partida());
		data3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data3.setForeground(Color.WHITE);
		data3.setBounds(543, 53, 160, 32);
		inforTopThree.add(data3);
		
		JLabel name3 = new JLabel(listaJogadores.get(2).getNome());
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setFont(new Font("Brush Script MT", Font.PLAIN, 27));
		name3.setForeground(Color.WHITE);
		name3.setBounds(95, 35, 283, 39);
		inforTopThree.add(name3);
		
		inforTopFour = new JPanel();
		inforTopFour.setBackground(new Color(139,0,0));
		inforTopFour.setBounds(71, 383, 713, 85);
		inforRanking.add(inforTopFour);
		inforTopFour.setLayout(null);
		
		JLabel icon4 = new JLabel(new ImageIcon(listaJogadores.get(3).getIcone()));
		icon4.setBorder(new LineBorder(new Color(0, 0, 0)));
		icon4.setBounds(0, 0, 85, 85);
		inforTopFour.add(icon4);
		
		JLabel nome4 = new JLabel("Nome:");
		nome4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome4.setForeground(Color.WHITE);
		nome4.setBounds(95, 11, 283, 25);
		inforTopFour.add(nome4);
		
		JLabel vitorias4 = new JLabel("Vitórias: " + listaJogadores.get(3).getPartidas_vencidas());
		vitorias4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias4.setForeground(Color.WHITE);
		vitorias4.setBounds(543, 11, 160, 38);
		inforTopFour.add(vitorias4);
		
		JLabel ponto4 = new JLabel("Pontuação: " + listaJogadores.get(3).getPontuacao());
		ponto4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto4.setForeground(Color.WHITE);
		ponto4.setBounds(388, 11, 145, 38);
		inforTopFour.add(ponto4);
		
		JLabel tempo4 = new JLabel("Tempo: " + formatTime(listaJogadores.get(3).getTempo_rodadas()));
		tempo4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo4.setForeground(Color.WHITE);
		tempo4.setBounds(388, 53, 145, 32);
		inforTopFour.add(tempo4);
		
		JLabel data4 = new JLabel("Data: " + listaJogadores.get(3).getUltima_partida());
		data4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data4.setForeground(Color.WHITE);
		data4.setBounds(543, 53, 160, 32);
		inforTopFour.add(data4);
		
		JLabel name4 = new JLabel(listaJogadores.get(3).getNome());
		name4.setHorizontalAlignment(SwingConstants.CENTER);
		name4.setFont(new Font("Brush Script MT", Font.PLAIN, 27));
		name4.setForeground(Color.WHITE);
		name4.setBounds(95, 35, 283, 39);
		inforTopFour.add(name4);
		
		inforTopFive = new JPanel();
		inforTopFive.setBackground(new Color(139,0,0));
		inforTopFive.setBounds(71, 479, 713, 85);
		inforRanking.add(inforTopFive);
		inforTopFive.setLayout(null);
		
		JLabel icon5 = new JLabel(new ImageIcon(listaJogadores.get(4).getIcone()));
		icon5.setBorder(new LineBorder(new Color(0, 0, 0)));
		icon5.setBounds(0, 0, 85, 85);
		inforTopFive.add(icon5);
		
		JLabel nome5 = new JLabel("Nome:");
		nome5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome5.setForeground(Color.WHITE);
		nome5.setBounds(95, 11, 283, 25);
		inforTopFive.add(nome5);
		
		JLabel vitorias5 = new JLabel("Vitórias: " + listaJogadores.get(4).getPartidas_vencidas());
		vitorias5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias5.setForeground(Color.WHITE);
		vitorias5.setBounds(543, 11, 160, 38);
		inforTopFive.add(vitorias5);
		
		JLabel ponto5 = new JLabel("Pontuação: " + listaJogadores.get(4).getPontuacao());
		ponto5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto5.setForeground(Color.WHITE);
		ponto5.setBounds(388, 11, 145, 38);
		inforTopFive.add(ponto5);
		
		JLabel tempo5 = new JLabel("Tempo: " + formatTime(listaJogadores.get(4).getTempo_rodadas()));
		tempo5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo5.setForeground(Color.WHITE);
		tempo5.setBounds(388, 53, 145, 32);
		inforTopFive.add(tempo5);
		
		JLabel data5 = new JLabel("Data: " + listaJogadores.get(4).getUltima_partida());
		data5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data5.setForeground(Color.WHITE);
		data5.setBounds(543, 53, 160, 32);
		inforTopFive.add(data5);
		
		JLabel name5 = new JLabel(listaJogadores.get(4).getNome());
		name5.setHorizontalAlignment(SwingConstants.CENTER);
		name5.setFont(new Font("Brush Script MT", Font.PLAIN, 27));
		name5.setForeground(Color.WHITE);
		name5.setBounds(95, 35, 283, 39);
		inforTopFive.add(name5);
		
		JLabel topFiveLbl = new JLabel("Top Five");
		topFiveLbl.setFont(new Font("Brush Script MT", Font.PLAIN, 75));
		topFiveLbl.setHorizontalAlignment(SwingConstants.CENTER);
		topFiveLbl.setForeground(Color.WHITE);
		topFiveLbl.setBounds(115, 11, 379, 73);
		inforRanking.add(topFiveLbl);
		
		JLabel primeiro = new JLabel("1º");
		primeiro.setForeground(Color.WHITE);
		primeiro.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		primeiro.setHorizontalAlignment(SwingConstants.CENTER);
		primeiro.setBounds(10, 95, 54, 85);
		inforRanking.add(primeiro);
		
		JLabel segundo = new JLabel("2º");
		segundo.setForeground(Color.WHITE);
		segundo.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		segundo.setHorizontalAlignment(SwingConstants.CENTER);
		segundo.setBounds(10, 191, 54, 85);
		inforRanking.add(segundo);
		
		JLabel terceiro = new JLabel("3º");
		terceiro.setForeground(Color.WHITE);
		terceiro.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		terceiro.setHorizontalAlignment(SwingConstants.CENTER);
		terceiro.setBounds(10, 287, 54, 85);
		inforRanking.add(terceiro);
		
		JLabel quarto = new JLabel("4º");
		quarto.setForeground(Color.WHITE);
		quarto.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		quarto.setHorizontalAlignment(SwingConstants.CENTER);
		quarto.setBounds(10, 383, 54, 85);
		inforRanking.add(quarto);
		
		JLabel quinto = new JLabel("5º");
		quinto.setForeground(Color.WHITE);
		quinto.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		quinto.setHorizontalAlignment(SwingConstants.CENTER);
		quinto.setBounds(10, 479, 54, 85);
		inforRanking.add(quinto);
		
		if(listaJogadores.get(0).getPontuacao() == 0 && listaJogadores.get(0).getTempo_rodadas() == 0){
			icon1.setVisible(false);
			vitorias1.setText("Vitórias: ");
			ponto1.setText("Pontuação: ");
			tempo1.setText("Tempo: ");
			data1.setText("Data: ");
			name1.setVisible(false);
		}
		if(listaJogadores.get(1).getPontuacao() == 0 && listaJogadores.get(1).getTempo_rodadas() == 0){
			icon2.setVisible(false);
			vitorias2.setText("Vitórias: ");
			ponto2.setText("Pontuação: ");
			tempo2.setText("Tempo: ");
			data2.setText("Data: ");
			name2.setVisible(false);
		}
		if(listaJogadores.get(2).getPontuacao() == 0 && listaJogadores.get(2).getTempo_rodadas() == 0){
			icon3.setVisible(false);
			vitorias3.setText("Vitórias: ");
			ponto3.setText("Pontuação: ");
			tempo3.setText("Tempo: ");
			data3.setText("Data: ");
			name3.setVisible(false);
		}
		if(listaJogadores.get(3).getPontuacao() == 0 && listaJogadores.get(3).getTempo_rodadas() == 0){
			icon4.setVisible(false);
			vitorias4.setText("Vitórias: ");
			ponto4.setText("Pontuação: ");
			tempo4.setText("Tempo: ");
			data4.setText("Data: ");
			name4.setVisible(false);
		}
		if(listaJogadores.get(4).getPontuacao() == 0 && listaJogadores.get(4).getTempo_rodadas() == 0){
			icon5.setVisible(false);
			vitorias5.setText("Vitórias: ");
			ponto5.setText("Pontuação: ");
			tempo5.setText("Tempo: ");
			data5.setText("Data: ");
			name5.setVisible(false);
		}
		
		JButton voltarBt = new JButton();
		voltarBt.setBounds(10, 0, 90, 90);
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
		inforRanking.add(voltarBt);
		
		JButton resetarBt = new JButton();
		resetarBt.setBounds(674, 23, 110, 40);
		resetarBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-disabled.png"));
		resetarBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-rollover.png"));
		resetarBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-rollover.png"));
		resetarBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-pressed.png"));
		resetarBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-normal.png"));
		resetarBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-disabled.png"));
		resetarBt.setMinimumSize(new Dimension(110, 40));
		resetarBt.setMaximumSize(new Dimension(110, 40));
		resetarBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetarBt.setHorizontalTextPosition(SwingConstants.CENTER);
		resetarBt.setBorder(null);
		resetarBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforRanking.add(resetarBt);
		
		JButton pdfBt = new JButton();
		pdfBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-disabled.png"));
		pdfBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-rollover.png"));
		pdfBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-rollover.png"));
		pdfBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-pressed.png"));
		pdfBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-normal.png"));
		pdfBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-gerar-disabled.png"));
		pdfBt.setMinimumSize(new Dimension(110, 40));
		pdfBt.setMaximumSize(new Dimension(110, 40));
		pdfBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pdfBt.setHorizontalTextPosition(SwingConstants.CENTER);
		pdfBt.setBorder(null);
		pdfBt.setAlignmentX(0.5f);
		pdfBt.setBounds(504, 23, 160, 40);
		pdfBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforRanking.add(pdfBt);
		
		// actions listeners
		voltarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				new InterfaceMenu(jogador_logado);
				dispose();		
			}
		});
		
		pdfBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				try {
					PDFRanking.gerarPDFRanking();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao criar PDF, verifique se o documento já está aberto");					
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		resetarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Som.somClick();
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Tem certeza que deseja resetar o ranking?", "Resetar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (i == 0){
					dao.resetarRanking();
					jogador_logado.setPartidasVencidasNula();
					jogador_logado.setTempo_rodadas(0);
					jogador_logado.setUltima_partida("0");
					repaint();
				}
			}
		});
		
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private String formatTime(int tempo) {
		int seg = tempo % 60;
		int min = tempo / 60;
		int hora = min / 60;
		min %= 60;
		
		return String.format("%d:%d:%d", hora, min, seg);
		
		
	}
}