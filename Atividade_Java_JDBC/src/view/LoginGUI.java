/** 
 * Classe para representar a tela de login
 * Criado em 03/11/2020
 * @author Grupo 3
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI extends JFrame {
/**
 * Declarando as variáveis.
*/		
	private JPasswordField txtSenha;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JButton btnLimpar;
	private JButton btnEntrar;
	

/**
 * Create the frame.
*/
	public LoginGUI() {
		setTitle("Tela de Login");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
/**
 * Criando labels.
*/	
		Ouvinte ouvinte = new Ouvinte();
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(97, 31, 66, 27);
		getContentPane().add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(97, 111, 66, 27);
		getContentPane().add(lblSenha);
		
/**
 * Criando caixas de texto.
*/	
		txtSenha = new JPasswordField();
		txtSenha.setBounds(97, 136, 234, 35);
		getContentPane().add(txtSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(97, 57, 234, 35);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
/**
 * Criando botões.
*/		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(97, 209, 89, 23);
		btnLimpar.addActionListener(ouvinte);
		getContentPane().add(btnLimpar);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(231, 209, 100, 23);
		btnEntrar.addActionListener(ouvinte);
		getContentPane().add(btnEntrar);
		
/**
 * Definindo responsividade e visibilidade da caixa.
*/	
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
	
	public void limpar() {
		txtSenha.setText("");
		txtLogin.setText("");
	}
	
	public class Ouvinte implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnLimpar) {
				limpar();
			}
			else {
				if(e.getSource()==btnEntrar) {
					//ação que eu não quero que seja executada
					String login = txtLogin.getText();
					String senha = String.valueOf(txtSenha.getPassword());
					if((login.equals("")) || (senha.equals(""))) {
						JOptionPane.showMessageDialog(getContentPane(), "Todos os campos devem ser preenchidos", "Atenção", 1, null);
					}
					else {
						if((login.equals("user"))&&(senha.equals("12345"))) {
							dispose();
							ClienteGUI telaCad = new ClienteGUI();
						}
						else {
							JOptionPane.showMessageDialog(getContentPane(), "Usuário e/ou senha incorreto", "Atenção", 1, null);
						}
					}
				}
			}
		}
	}	
}
