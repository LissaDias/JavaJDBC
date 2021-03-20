/** 
 * Classe ClienteDao 
 * Criado em 03/11/2020
 * @author Grupo 3
*/
package model;

public class Fornecedor {
	private String cnpj;
	private String nome;
	private String endereco;
	private String telefone;
	
	/** 
	 * Construtores
	*/
	
	public Fornecedor() {
		
	}

	public Fornecedor(String cnpj, String nome, String endereco, String telefone) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	/** 
	 * Métodos getters and setters
	*/
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
