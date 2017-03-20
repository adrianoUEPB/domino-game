package visao;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import modelo.Jogador;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import controle.DAO;

public class InterfaceInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	
	boolean loginFlag;
	JTextField nome;
	JPasswordField senha;
	JLabel nomeLabel, senhaLabel, iconeLabel, icone;
	JButton botaoEntrar, botaoCadastro, botaoCancelar, botaoLogin;
	JComboBox<String> iconeCombobox;
	
	public InterfaceInicial(){
		getContentPane().setBackground(new Color(139, 0, 0));
		getContentPane().setLayout(null);

		JPanel informacoes = new JPanel();
		informacoes.setBackground(new Color(139, 0, 0));
		informacoes.setBounds(222, 145, 262, 299);
		getContentPane().add(informacoes);
		informacoes.setLayout(null);

		nome = new JTextField();
		nome.setBounds(27, 36, 208, 20);
		informacoes.add(nome);
		nome.setColumns(10);
		nome.setVisible(false);

		senha = new JPasswordField();
		senha.setBounds(27, 92, 208, 20);
		informacoes.add(senha);
		senha.setColumns(10);
		senha.setVisible(false);
				
		nomeLabel = new JLabel("Nome do usuário:");
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setBounds(10, 11, 154, 14);
		informacoes.add(nomeLabel);
		nomeLabel.setVisible(false);
		
		senhaLabel = new JLabel("Senha:");
		senhaLabel.setForeground(Color.WHITE);
		senhaLabel.setBounds(10, 67, 154, 14);
		informacoes.add(senhaLabel);
		senhaLabel.setVisible(false);
		
		botaoEntrar = new JButton("");
		botaoEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoEntrar.setBorder(null);
		botaoEntrar.setBounds(139, 242, 113, 35);
		informacoes.add(botaoEntrar);
		botaoEntrar.setVisible(false);
		
		iconeCombobox = new JComboBox<String>();
		iconeCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Pernalonga", "Lola", "Eufrazino", "Patolino", "Marvin", "Frajola", "Piu Piu", "Gaguinho", "Taz"}));
		iconeCombobox.setBounds(27, 148, 89, 20);
		informacoes.add(iconeCombobox);
		iconeCombobox.setVisible(false);
		
		iconeLabel = new JLabel("Ícone:");
		iconeLabel.setForeground(Color.WHITE);
		iconeLabel.setBounds(10, 123, 154, 14);
		informacoes.add(iconeLabel);
		iconeLabel.setVisible(false);
		
		botaoCancelar = new JButton();
		botaoCancelar.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-pressed.png"));
		botaoCancelar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-rollover.png"));
		botaoCancelar.setIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-normal.png"));
		botaoCancelar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-cancelar-disabled.png"));
		botaoCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoCancelar.setBorder(null);
		botaoCancelar.setBounds(15, 242, 113, 35);
		informacoes.add(botaoCancelar);
		botaoCancelar.setVisible(false);
		
		icone = new JLabel();
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		icone.setBounds(135, 128, 100, 100);
		informacoes.add(icone);
		icone.setVisible(false);

		botaoCadastro = new JButton();
		botaoCadastro.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-disabled.png"));
		botaoCadastro.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-rollover.png"));
		botaoCadastro.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-rollover.png"));
		botaoCadastro.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-pressed.png"));
		botaoCadastro.setIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-normal.png"));
		botaoCadastro.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-cadastro-disabled.png"));
		botaoCadastro.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoCadastro.setBorder(null);
		botaoCadastro.setBounds(39, 207, 120, 35);
		getContentPane().add(botaoCadastro);
		
		botaoLogin = new JButton();
		botaoLogin.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-login-rollover.png"));
		botaoLogin.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-login-rollover.png"));
		botaoLogin.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-login-pressed.png"));
		botaoLogin.setIcon(new ImageIcon(".\\image\\graphics\\Bt-login-normal.png"));
		botaoLogin.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-login-disabled.png"));
		botaoLogin.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-login-disabled.png"));
		botaoLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoLogin.setBorder(null);
		botaoLogin.setBounds(39, 246, 120, 35);
		getContentPane().add(botaoLogin);
		
		JButton botaoSair = new JButton();
		botaoSair.setBorder(null);
		botaoSair.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-disabled.png"));
		botaoSair.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-disabled.png"));
		botaoSair.setIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-normal.png"));
		botaoSair.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-pressed.png"));
		botaoSair.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-rollover.png"));
		botaoSair.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-sair-rollover.png"));
		botaoSair.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoSair.setBounds(39, 285, 120, 35);
		getContentPane().add(botaoSair);
		
		JLabel labelDomino = new JLabel("Dominó");
		labelDomino.setForeground(Color.WHITE);
		labelDomino.setHorizontalAlignment(SwingConstants.CENTER);
		labelDomino.setFont(new Font("Brush Script MT", Font.PLAIN, 120));
		labelDomino.setBounds(10, 11, 474, 123);
		getContentPane().add(labelDomino);
		
		// actions listeners
		botaoLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFlag = true;
				nome.setVisible(true);
				senha.setVisible(true);
				nomeLabel.setVisible(true);
				senhaLabel.setVisible(true);
				botaoEntrar.setVisible(true);
				botaoCancelar.setVisible(true);
				botaoCadastro.setEnabled(false);
				botaoLogin.setEnabled(false);
				icone.setVisible(false);
				
				botaoEntrar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-rollover.png"));
				botaoEntrar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-rollover.png"));
				botaoEntrar.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-pressed.png"));
				botaoEntrar.setIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-normal.png"));
				botaoEntrar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-disabled.png"));
				botaoEntrar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-entrar-disabled.png"));
			}
		});
		
		botaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFlag = false;
				nome.setVisible(true);
				senha.setVisible(true);
				nomeLabel.setVisible(true);
				senhaLabel.setVisible(true);
				botaoEntrar.setVisible(true);
				iconeLabel.setVisible(true);
				iconeCombobox.setVisible(true);
				botaoCancelar.setVisible(true);
				botaoCadastro.setEnabled(false);
				botaoLogin.setEnabled(false);
				icone.setVisible(true);

				botaoEntrar.setRolloverSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-rollover.png"));
				botaoEntrar.setRolloverIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-rollover.png"));
				botaoEntrar.setPressedIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-pressed.png"));
				botaoEntrar.setIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-normal.png"));
				botaoEntrar.setDisabledSelectedIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-disabled.png"));
				botaoEntrar.setDisabledIcon(new ImageIcon(".\\image\\graphics\\Bt-concluir-disabled.png"));
			}
		});

		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setVisible(false);
				senha.setVisible(false);
				nomeLabel.setVisible(false);
				senhaLabel.setVisible(false);
				botaoEntrar.setVisible(false);
				iconeLabel.setVisible(false);
				iconeCombobox.setVisible(false);
				botaoCancelar.setVisible(false);
				botaoCadastro.setEnabled(true);
				botaoLogin.setEnabled(true);
				icone.setVisible(false);
				iconeCombobox.setSelectedIndex(0);
			}
		});
		
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogador jogador = new Jogador();
				DAO dao = new DAO();
				String senhaTxt = String.valueOf(senha.getPassword());

				if (loginFlag == true){	
					jogador.setNome(nome.getText());
					jogador.setSenha(senhaTxt);
					if(dao.checkLogin(jogador)){
						dispose();
						new InterfaceMenu();							
					}else{
						JOptionPane.showMessageDialog(null,"Login ou senha incorreta!");
						nome.setText("");
						senha.setText("");
						iconeCombobox.setSelectedIndex(0);
					}
				} else {
					if (nome.getText().equals("") || senhaTxt.equals("") || iconeCombobox.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null,"Campo obrigatório!");
					}else{
						if(!dao.searchJogador(nome.getText())){
							jogador.setNome(nome.getText());
							jogador.setSenha(senhaTxt);
							jogador.setIcone(".\\image\\icon\\"+((String)iconeCombobox.getSelectedItem())+".png");
							dao.insert(jogador);
							nome.setText("");
							senha.setText("");
							iconeCombobox.setSelectedIndex(0);

						}else{
							JOptionPane.showMessageDialog(null,"Jogador já cadastrado, escolha outro nome.");
						}
					}
				}
			}
		});
		
		iconeCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboSelecionado = (String) iconeCombobox.getSelectedItem();
				icone.setIcon(new ImageIcon(".\\image\\icon\\" + comboSelecionado + ".png"));
			}
		});
		
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setSize(500, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
