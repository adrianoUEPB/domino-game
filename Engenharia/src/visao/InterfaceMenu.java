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
		getContentPane().setBackground(new Color(128, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel labelDomino = new JLabel("Dominó");
		labelDomino.setForeground(Color.WHITE);
		labelDomino.setHorizontalAlignment(SwingConstants.CENTER);
		labelDomino.setFont(new Font("Brush Script MT", Font.PLAIN, 180));
		labelDomino.setBounds(36, 11, 527, 202);
		getContentPane().add(labelDomino);
		
		JButton botaoNovaPartida = new JButton("Iniciar uma nova partida");
		botaoNovaPartida.setBounds(36, 224, 180, 70);
		getContentPane().add(botaoNovaPartida);
		
		JButton botaoContinuarPartida = new JButton("Continuar partida");
		botaoContinuarPartida.setBounds(36, 305, 180, 70);
		getContentPane().add(botaoContinuarPartida);
		
		JButton botaoRanking = new JButton("Ranking");
		botaoRanking.setBounds(36, 386, 180, 70);
		getContentPane().add(botaoRanking);
		
		JButton botaoLogout = new JButton("Logout");
		botaoLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new InterfaceInicial();
			}
		});
		botaoLogout.setBounds(36, 467, 180, 70);
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
