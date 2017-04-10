package visao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controle.Som;
import modelo.Jogador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InterfaceHelp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	int escolha = 1;
	JButton rightBt, leftBt;
	JLabel help;

	public InterfaceHelp(final Jogador jogador_logado){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(139, 0, 0));
		
		help = new JLabel();
		help.setIcon(new ImageIcon(".\\image\\graphics\\help1.png"));
		help.setHorizontalAlignment(SwingConstants.CENTER);
		help.setBounds(10, 115, 774, 449);
		getContentPane().add(help);
		
		JButton voltarBt = new JButton();
		voltarBt.setBounds(34, 11, 90, 90);
		voltarBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		voltarBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		voltarBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-rollover.png"));
		voltarBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-pressed.png"));
		voltarBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-normal.png"));
		voltarBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-voltar-disabled.png"));
		voltarBt.setHorizontalTextPosition(SwingConstants.CENTER);
		voltarBt.setBorder(null);
		voltarBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltarBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		voltarBt.setMinimumSize(new Dimension(90, 90));
		voltarBt.setMaximumSize(new Dimension(90, 90));
		getContentPane().add(voltarBt);
		
		JLabel labelAjuda = new JLabel("Ajuda");
		labelAjuda.setHorizontalAlignment(SwingConstants.CENTER);
		labelAjuda.setForeground(Color.WHITE);
		labelAjuda.setFont(new Font("Brush Script MT", Font.PLAIN, 87));
		labelAjuda.setBounds(268, 11, 235, 93);
		getContentPane().add(labelAjuda);
		
		leftBt = new JButton();
		leftBt.setEnabled(false);
		leftBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-left-disabled.png"));
		leftBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-left-rollover.png"));
		leftBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-left-rollover.png"));
		leftBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-left-pressed.png"));
		leftBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-left-normal.png"));
		leftBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-left-disabled.png"));
		leftBt.setHorizontalTextPosition(SwingConstants.CENTER);
		leftBt.setBorder(null);
		leftBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		leftBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftBt.setMinimumSize(new Dimension(45, 45));
		leftBt.setMaximumSize(new Dimension(45, 45));
		leftBt.setBounds(594, 37, 45, 45);
		getContentPane().add(leftBt);
		
		rightBt = new JButton();
		rightBt.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-right-disabled.png"));
		rightBt.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtP-right-rollover.png"));
		rightBt.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtP-right-rollover.png"));
		rightBt.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtP-right-pressed.png"));
		rightBt.setIcon(new ImageIcon(".\\image\\graphics\\BtP-right-normal.png"));
		rightBt.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtP-right-disabled.png"));
		rightBt.setHorizontalTextPosition(SwingConstants.CENTER);
		rightBt.setBorder(null);
		rightBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rightBt.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightBt.setMinimumSize(new Dimension(45, 45));
		rightBt.setMaximumSize(new Dimension(45, 45));
		rightBt.setBounds(649, 37, 45, 45);
		getContentPane().add(rightBt);
		
		// actions listeners
		voltarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				new InterfaceMenu(jogador_logado);
				dispose();
			}
		});
		
		leftBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				if (escolha > 1){
					escolha--;
					rightBt.setEnabled(true);
					help.setIcon(new ImageIcon(".\\image\\graphics\\help" + escolha + ".png"));
					if (escolha == 1){
						leftBt.setEnabled(false);
					} else {
						leftBt.setEnabled(true);
					}
				}
			}
		});
		
		rightBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Som.somClick();
				if (escolha < 4){
					escolha++;
					leftBt.setEnabled(true);
					help.setIcon(new ImageIcon(".\\image\\graphics\\help" + escolha + ".png"));
					if (escolha == 3){
						rightBt.setEnabled(false);
					} else {
						rightBt.setEnabled(true);
					}
				}
			}
		});
	
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
