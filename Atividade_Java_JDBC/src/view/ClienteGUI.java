/** 
 * Classe para representar a tela de cadastro
 * Criado em 03/11/2020
 * @author Grupo 3
*/


package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.Cliente;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class ClienteGUI extends JFrame {
/**
 * Declarando as variáveis.
*/
	private JTextField txtNumero;
	private JTextField txtLogradouro;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblCidade;
	private JLabel lblNumero;
	private JLabel lblLogradouro;
	private JLabel lblEstado;
	private JLabel lblTelefone;
	private JComboBox cmbEstado;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JTable tableCliente;
	private JScrollPane scrollPaneCliente;
	private DefaultTableModel modelo;
	

/**
 * Create the frame.
 */
	public ClienteGUI() {
		setBounds(100, 100, 682, 788);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	
/**
 * Criando labels.
 */
		Ouvinte ouvinte = new Ouvinte();
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(77, 36, 46, 14);
		getContentPane().add(lblCpf);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(77, 94, 46, 14);
		getContentPane().add(lblNome);
		
		lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCidade.setBounds(77, 222, 62, 14);
		getContentPane().add(lblCidade);
		
		lblNumero = new JLabel("N\u00DAMERO");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero.setBounds(304, 157, 68, 14);
		getContentPane().add(lblNumero);
		
		lblLogradouro = new JLabel("LOGRADOURO");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogradouro.setBounds(77, 159, 101, 14);
		getContentPane().add(lblLogradouro);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(77, 280, 62, 14);
		getContentPane().add(lblEstado);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(77, 342, 80, 14);
		getContentPane().add(lblTelefone);
	
/**
 * Criando caixas de texto.
 */	
	
		txtNumero = new JTextField();
		txtNumero.setBounds(304, 175, 86, 32);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(77, 175, 205, 32);
		getContentPane().add(txtLogradouro);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(77, 116, 205, 32);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(77, 51, 205, 32);
		getContentPane().add(txtCpf);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(77, 237, 205, 32);
		getContentPane().add(txtCidade);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(77, 359, 205, 32);
		getContentPane().add(txtTelefone);
		
/**
 * Criando combobox.
 */		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ES", "MG", "RJ", "SP"}));
		cmbEstado.setBounds(77, 298, 205, 33);
		getContentPane().add(cmbEstado);
		
/**
 * Criando botões.
 */	
	
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(77, 428, 89, 23);
		btnLimpar.addActionListener(ouvinte);
		getContentPane().add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(193, 428, 89, 23);
		btnEnviar.addActionListener(ouvinte);
		getContentPane().add(btnEnviar);
		
		tableCliente = new JTable();
		scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(31, 462, 603, 286);
		getContentPane().add(scrollPaneCliente);
		
		
/**
 * Definindo responsividade e visibilidade da caixa.
 */	
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
	
	public void definirJTable(){
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Cpf");
		 modelo.addColumn("Nome");
		 modelo.addColumn("Logradouro");
		 modelo.addColumn("Numero");
		 modelo.addColumn("Cidade");
		 modelo.addColumn("Estado");
		 modelo.addColumn("Telefone");
		 tableCliente = new JTable(modelo);
	}
	
	public void adicionarDados(List<Cliente> lista) {
		modelo.setNumRows(0);
		for(Cliente user: lista) {
			Object[] cliente = {user.getCpf(),user.getNome(), user.getLogradouro(), user.getNumero(), user.getCidade(), user.getEstado(), user.getTelefone() };
			modelo.addRow(cliente);
		}
		
	}
	
	public void limpar() {
		txtNumero.setText("");
		txtNome.setText("");
		txtLogradouro.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtCidade.setText("");
		cmbEstado.setSelectedIndex(0);
	}
	
	public class Ouvinte implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnLimpar) {
				limpar();
			}
			else {
				//evento do botão cadastrar
				if(e.getSource()==btnEnviar) {
					String nome = txtNome.getText();
					String numero = txtNumero.getText();
					String logradouro = txtLogradouro.getText();
					String cpf = txtCpf.getText();
					String telefone = txtTelefone.getText();
					String cidade = txtCidade.getText();
					String estado = cmbEstado.getSelectedItem().toString();
					
					if((nome.equals("")) || (numero.equals("")) || (logradouro.equals("")) || (cpf.equals("")) || (telefone.equals("")) || (cidade.equals("")) || (estado.equals(""))) {
						JOptionPane.showMessageDialog(getContentPane(), "Todos os campos devem ser preenchidos", "Atenção!", 1, null);
						
					}
					else {
						ClienteController ccontrol= new	ClienteController();
						if (ccontrol.cadastrar(cpf, nome, logradouro, Integer.parseInt(numero), cidade, estado, telefone)==1){
							JOptionPane.showMessageDialog(getContentPane(), "Usuário cadastrado com sucesso", "Bem-vindo!", 1, null);
							limpar();
							adicionarDados(ccontrol.consultar());
						}
						else {
							
							JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o usuário", "ATENÇÃO", 1);
						}
						
					}
				}
			}
		}
	}
}

/*Na tela de cadastro, ao clicar no botão “limpar”, todos os campos
devem ficar vazios e ao clicar no botão “ENVIAR”, os campos
devem ser validados quanto ao preenchimento. Estando todos os
campos preenchidos, a aplicação deve exibir a mensagem “DADOS
CADASTRADOS COM SUCESSO!” utilizando uma caixa de
diálogo.*/
