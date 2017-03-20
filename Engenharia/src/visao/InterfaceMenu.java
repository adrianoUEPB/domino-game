package visao;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	public InterfaceMenu() {
		getContentPane().setBackground(new Color(139, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel labelDomino = new JLabel("Dominó");
		labelDomino.setForeground(Color.WHITE);
		labelDomino.setHorizontalAlignment(SwingConstants.CENTER);
		labelDomino.setFont(new Font("Brush Script MT", Font.PLAIN, 180));
		labelDomino.setBounds(36, 11, 527, 202);
		getContentPane().add(labelDomino);
		
		JButton botaoNovaPartida = new JButton();
		botaoNovaPartida.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-pressed.png"));
		botaoNovaPartida.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-rollover.png"));
		botaoNovaPartida.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-rollover.png"));
		botaoNovaPartida.setIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-normal.png"));
		botaoNovaPartida.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-disabled.png"));
		botaoNovaPartida.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-novojogo-disabled.png"));
		botaoNovaPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoNovaPartida.setBorder(null);
		botaoNovaPartida.setBounds(36, 224, 240, 70);
		getContentPane().add(botaoNovaPartida);
		
		JButton botaoContinuarPartida = new JButton();
		botaoContinuarPartida.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-pressed.png"));
		botaoContinuarPartida.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-rollover.png"));
		botaoContinuarPartida.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-rollover.png"));
		botaoContinuarPartida.setIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-normal.png"));
		botaoContinuarPartida.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-disabled.png"));
		botaoContinuarPartida.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-continuar-disabled.png"));
		botaoContinuarPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoContinuarPartida.setBorder(null);
		botaoContinuarPartida.setBounds(36, 305, 240, 70);
		getContentPane().add(botaoContinuarPartida);
		
		JButton botaoRanking = new JButton();
		botaoRanking.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-pressed.png"));
		botaoRanking.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-rollover.png"));
		botaoRanking.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-rollover.png"));
		botaoRanking.setIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-normal.png"));
		botaoRanking.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-disabled.png"));
		botaoRanking.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-ranking-disabled.png"));
		botaoRanking.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoRanking.setBorder(null);
		botaoRanking.setBounds(36, 386, 240, 70);
		getContentPane().add(botaoRanking);
		
		JButton botaoLogout = new JButton();
		botaoLogout.setPressedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-pressed.png"));
		botaoLogout.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-rollover.png"));
		botaoLogout.setRolloverIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-rollover.png"));
		botaoLogout.setIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-normal.png"));
		botaoLogout.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-disabled.png"));
		botaoLogout.setDisabledIcon(new ImageIcon(".\\image\\graphics\\BtG-logout-disabled.png"));
		botaoLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoLogout.setBorder(null);
		botaoLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new InterfaceInicial();
			}
		});
		botaoLogout.setBounds(36, 467, 240, 70);
		getContentPane().add(botaoLogout);
		
		JLabel imagemLabel = new JLabel("");
		imagemLabel.setBounds(521, 11, 263, 227);
		imagemLabel.setIcon(new ImageIcon(".\\image\\peca\\pecasMenu.png"));
		getContentPane().add(imagemLabel);
		
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
