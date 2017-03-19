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
		
		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(135, 242, 100, 32);
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
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(27, 242, 89, 32);
		informacoes.add(botaoCancelar);
		botaoCancelar.setVisible(false);
		
		icone = new JLabel("");
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		icone.setBounds(135, 128, 100, 100);
		informacoes.add(icone);
		icone.setVisible(false);

		botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.setBackground(Color.WHITE);
		botaoCadastro.setBounds(39, 207, 120, 35);
		getContentPane().add(botaoCadastro);
		
		botaoLogin = new JButton("Login");
		botaoLogin.setBackground(Color.WHITE);
		botaoLogin.setBounds(39, 241, 120, 35);
		getContentPane().add(botaoLogin);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBackground(Color.WHITE);
		botaoSair.setBounds(39, 275, 120, 35);
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
			}
		});
		
		botaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFlag = false;
				nome.setVisible(true);
				senha.setVisible(true);
				nomeLabel.setVisible(true);
				senhaLabel.setVisible(true);
				botaoEntrar.setText("Cadastrar");
				botaoEntrar.setVisible(true);
				iconeLabel.setVisible(true);
				iconeCombobox.setVisible(true);
				botaoCancelar.setVisible(true);
				botaoCadastro.setEnabled(false);
				botaoLogin.setEnabled(false);
				icone.setVisible(true);
			}
		});

		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setVisible(false);
				senha.setVisible(false);
				nomeLabel.setVisible(false);
				senhaLabel.setVisible(false);
				botaoEntrar.setText("Entrar");
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
					dispose();
					new InterfaceMenu();
				} else {
					if (nome.getText().equals("") || senhaTxt.equals("") || iconeCombobox.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null,"Campo obrigatório!");
					}else{
						if(!dao.searchJogador(nome.getText())){
							jogador.setNome(nome.getText());
							jogador.setSenha(senhaTxt);
							jogador.setIcone(".\\image\\icon\\"+((String)iconeCombobox.getSelectedItem())+".png");
							dao.insert(jogador);					
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
