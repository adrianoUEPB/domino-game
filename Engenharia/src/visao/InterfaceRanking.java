package visao;

import javax.swing.JFrame;

import modelo.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class InterfaceRanking extends JFrame {
	private static final long serialVersionUID = 1L;

	public InterfaceRanking(final Jogador jogador_logado) {
		getContentPane().setBackground(new Color(139, 0, 0));
		
		JPanel inforRanking = new JPanel();
		inforRanking.setBackground(new Color(139, 0, 0));
		inforRanking.setBounds(10, 0, 784, 571);
		getContentPane().add(inforRanking);
		inforRanking.setLayout(null);
		
		JPanel inforTopOne = new JPanel();
		inforTopOne.setBackground(new Color(139,0,0));
		inforTopOne.setBounds(115, 91, 659, 85);
		inforRanking.add(inforTopOne);
		inforTopOne.setLayout(null);
		
		JLabel icon1 = new JLabel("New label");
		icon1.setBounds(0, 0, 85, 85);
		inforTopOne.add(icon1);
		
		JLabel nome1 = new JLabel("Nome:");
		nome1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome1.setForeground(Color.WHITE);
		nome1.setBounds(107, 11, 148, 25);
		inforTopOne.add(nome1);
		
		JLabel vitorias1 = new JLabel("Vit\u00F3rias:");
		vitorias1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias1.setForeground(Color.WHITE);
		vitorias1.setBounds(501, 11, 148, 38);
		inforTopOne.add(vitorias1);
		
		JLabel ponto1 = new JLabel("Pontua\u00E7\u00E3o:");
		ponto1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto1.setForeground(Color.WHITE);
		ponto1.setBounds(315, 11, 176, 38);
		inforTopOne.add(ponto1);
		
		JLabel tempo1 = new JLabel("Tempo:");
		tempo1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo1.setForeground(Color.WHITE);
		tempo1.setBounds(315, 60, 176, 25);
		inforTopOne.add(tempo1);
		
		JLabel data1 = new JLabel("Data:");
		data1.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data1.setForeground(Color.WHITE);
		data1.setBounds(501, 60, 148, 25);
		inforTopOne.add(data1);
		
		JLabel name1 = new JLabel("New label");
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		name1.setForeground(Color.WHITE);
		name1.setBounds(107, 35, 198, 39);
		inforTopOne.add(name1);
		
		JPanel inforTopTwo = new JPanel();
		inforTopTwo.setBackground(new Color(139,0,0));
		inforTopTwo.setBounds(115, 187, 659, 85);
		inforRanking.add(inforTopTwo);
		inforTopTwo.setLayout(null);
		
		JLabel icon2 = new JLabel("New label");
		icon2.setBounds(0, 0, 85, 85);
		inforTopTwo.add(icon2);
		
		JLabel nome2 = new JLabel("Nome:");
		nome2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome2.setForeground(Color.WHITE);
		nome2.setBounds(107, 11, 148, 25);
		inforTopTwo.add(nome2);
		
		JLabel vitorias2 = new JLabel("Vit\u00F3rias:");
		vitorias2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias2.setForeground(Color.WHITE);
		vitorias2.setBounds(501, 11, 148, 38);
		inforTopTwo.add(vitorias2);
		
		JLabel ponto2 = new JLabel("Pontua\u00E7\u00E3o:");
		ponto2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto2.setForeground(Color.WHITE);
		ponto2.setBounds(315, 11, 176, 38);
		inforTopTwo.add(ponto2);
		
		JLabel tempo2 = new JLabel("Tempo:");
		tempo2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo2.setForeground(Color.WHITE);
		tempo2.setBounds(315, 60, 176, 25);
		inforTopTwo.add(tempo2);
		
		JLabel data2 = new JLabel("Data:");
		data2.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data2.setForeground(Color.WHITE);
		data2.setBounds(501, 60, 148, 25);
		inforTopTwo.add(data2);
		
		JLabel name2 = new JLabel("New label");
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		name2.setForeground(Color.WHITE);
		name2.setBounds(107, 35, 198, 39);
		inforTopTwo.add(name2);
		
		JPanel inforTopThree = new JPanel();
		inforTopThree.setBackground(new Color(139,0,0));
		inforTopThree.setBounds(115, 283, 659, 85);
		inforRanking.add(inforTopThree);
		inforTopThree.setLayout(null);
		
		JLabel icon3 = new JLabel("New label");
		icon3.setBounds(0, 0, 85, 85);
		inforTopThree.add(icon3);
		
		JLabel nome3 = new JLabel("Nome:");
		nome3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome3.setForeground(Color.WHITE);
		nome3.setBounds(107, 11, 148, 25);
		inforTopThree.add(nome3);
		
		JLabel vitorias3 = new JLabel("Vit\u00F3rias:");
		vitorias3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias3.setForeground(Color.WHITE);
		vitorias3.setBounds(501, 11, 148, 38);
		inforTopThree.add(vitorias3);
		
		JLabel ponto3 = new JLabel("Pontua\u00E7\u00E3o:");
		ponto3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto3.setForeground(Color.WHITE);
		ponto3.setBounds(315, 11, 176, 38);
		inforTopThree.add(ponto3);
		
		JLabel tempo3 = new JLabel("Tempo:");
		tempo3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo3.setForeground(Color.WHITE);
		tempo3.setBounds(315, 60, 176, 25);
		inforTopThree.add(tempo3);
		
		JLabel data3 = new JLabel("Data:");
		data3.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data3.setForeground(Color.WHITE);
		data3.setBounds(501, 60, 148, 25);
		inforTopThree.add(data3);
		
		JLabel name3 = new JLabel("New label");
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		name3.setForeground(Color.WHITE);
		name3.setBounds(107, 35, 198, 39);
		inforTopThree.add(name3);
		
		JPanel inforTopFour = new JPanel();
		inforTopFour.setBackground(new Color(139,0,0));
		inforTopFour.setBounds(115, 379, 659, 85);
		inforRanking.add(inforTopFour);
		inforTopFour.setLayout(null);
		
		JLabel icon4 = new JLabel("New label");
		icon4.setBounds(0, 0, 85, 85);
		inforTopFour.add(icon4);
		
		JLabel nome4 = new JLabel("Nome:");
		nome4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome4.setForeground(Color.WHITE);
		nome4.setBounds(107, 11, 148, 25);
		inforTopFour.add(nome4);
		
		JLabel vitorias4 = new JLabel("Vit\u00F3rias:");
		vitorias4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias4.setForeground(Color.WHITE);
		vitorias4.setBounds(501, 11, 148, 38);
		inforTopFour.add(vitorias4);
		
		JLabel ponto4 = new JLabel("Pontua\u00E7\u00E3o:");
		ponto4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto4.setForeground(Color.WHITE);
		ponto4.setBounds(315, 11, 176, 38);
		inforTopFour.add(ponto4);
		
		JLabel tempo4 = new JLabel("Tempo:");
		tempo4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo4.setForeground(Color.WHITE);
		tempo4.setBounds(315, 60, 176, 25);
		inforTopFour.add(tempo4);
		
		JLabel data4 = new JLabel("Data:");
		data4.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data4.setForeground(Color.WHITE);
		data4.setBounds(501, 60, 148, 25);
		inforTopFour.add(data4);
		
		JLabel name4 = new JLabel("New label");
		name4.setHorizontalAlignment(SwingConstants.CENTER);
		name4.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		name4.setForeground(Color.WHITE);
		name4.setBounds(107, 35, 198, 39);
		inforTopFour.add(name4);
		
		JPanel inforTopFive = new JPanel();
		inforTopFive.setBackground(new Color(139,0,0));
		inforTopFive.setBounds(115, 475, 659, 85);
		inforRanking.add(inforTopFive);
		inforTopFive.setLayout(null);
		
		JLabel icon5 = new JLabel("New label");
		icon5.setBounds(0, 0, 85, 85);
		inforTopFive.add(icon5);
		
		JLabel nome5 = new JLabel("Nome:");
		nome5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		nome5.setForeground(Color.WHITE);
		nome5.setBounds(107, 11, 148, 25);
		inforTopFive.add(nome5);
		
		JLabel vitorias5 = new JLabel("Vit\u00F3rias:");
		vitorias5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		vitorias5.setForeground(Color.WHITE);
		vitorias5.setBounds(501, 11, 148, 38);
		inforTopFive.add(vitorias5);
		
		JLabel ponto5 = new JLabel("Pontua\u00E7\u00E3o:");
		ponto5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		ponto5.setForeground(Color.WHITE);
		ponto5.setBounds(315, 11, 176, 38);
		inforTopFive.add(ponto5);
		
		JLabel tempo5 = new JLabel("Tempo:");
		tempo5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		tempo5.setForeground(Color.WHITE);
		tempo5.setBounds(315, 60, 176, 25);
		inforTopFive.add(tempo5);
		
		JLabel data5 = new JLabel("Data:");
		data5.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		data5.setForeground(Color.WHITE);
		data5.setBounds(501, 60, 148, 25);
		inforTopFive.add(data5);
		
		JLabel name5 = new JLabel("New label");
		name5.setHorizontalAlignment(SwingConstants.CENTER);
		name5.setFont(new Font("Brush Script MT", Font.PLAIN, 35));
		name5.setForeground(Color.WHITE);
		name5.setBounds(107, 35, 198, 39);
		inforTopFive.add(name5);
		
		JLabel lblNewLabel = new JLabel("Top Five");
		lblNewLabel.setFont(new Font("Brush Script MT", Font.PLAIN, 65));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(115, 11, 539, 69);
		inforRanking.add(lblNewLabel);
		
		JLabel primeiro = new JLabel("1\u00BA");
		primeiro.setForeground(Color.WHITE);
		primeiro.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		primeiro.setHorizontalAlignment(SwingConstants.CENTER);
		primeiro.setBounds(10, 91, 95, 85);
		inforRanking.add(primeiro);
		
		JLabel segundo = new JLabel("2\u00BA");
		segundo.setForeground(Color.WHITE);
		segundo.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		segundo.setHorizontalAlignment(SwingConstants.CENTER);
		segundo.setBounds(10, 187, 95, 85);
		inforRanking.add(segundo);
		
		JLabel terceiro = new JLabel("3\u00BA");
		terceiro.setForeground(Color.WHITE);
		terceiro.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		terceiro.setHorizontalAlignment(SwingConstants.CENTER);
		terceiro.setBounds(10, 283, 95, 85);
		inforRanking.add(terceiro);
		
		JLabel quarto = new JLabel("4\u00BA");
		quarto.setForeground(Color.WHITE);
		quarto.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		quarto.setHorizontalAlignment(SwingConstants.CENTER);
		quarto.setBounds(10, 379, 95, 85);
		inforRanking.add(quarto);
		
		JLabel quinto = new JLabel("5\u00BA");
		quinto.setForeground(Color.WHITE);
		quinto.setFont(new Font("Brush Script MT", Font.PLAIN, 60));
		quinto.setHorizontalAlignment(SwingConstants.CENTER);
		quinto.setBounds(10, 475, 95, 85);
		inforRanking.add(quinto);
		
		JButton voltarBt = new JButton();
		voltarBt.setBounds(15, 0, 90, 90);
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
		resetarBt.setBounds(664, 23, 110, 40);
		resetarBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-disabled.png"));
		resetarBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-rollover.png"));
		resetarBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-rollover.png"));
		resetarBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-pressed.png"));
		resetarBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-normal.png"));
		resetarBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-resetar-disabled.png"));
		resetarBt.setMinimumSize(new Dimension(110, 40));
		resetarBt.setMaximumSize(new Dimension(110, 40));
		resetarBt.setHorizontalTextPosition(SwingConstants.CENTER);
		resetarBt.setBorder(null);
		resetarBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		inforRanking.add(resetarBt);
		
		// actions listeners
		voltarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InterfaceMenu(jogador_logado);
				dispose();		
			}
		});

		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}
}
