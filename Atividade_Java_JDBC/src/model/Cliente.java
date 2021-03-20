/** 
 * Classe para representar Cliente
 * Criado em 17/11/2020
 * @author Grupo 3 
*/

package model;

public class Cliente {
	private String cpf;
	private String nome;	
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	private String telefone;
	
	/** 
	 * Construtores 
	*/
	public Cliente() {
		
	}
	
	public Cliente(String cpf, String nome, String logradouro, int numero, String cidade, String estado,
			String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}
	/** 
	 * Métodos getters and setters
	*/
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
