package controller;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import model.Cliente;


public class ClienteController {

	public int cadastrar(String cpf, String nome, String logradouro, int numero, String cidade, String estado, String telefone ) {
		Cliente c=new Cliente(cpf, nome, logradouro, numero, cidade, estado, telefone);
		ClienteDao cDao=new ClienteDao();
		return(cDao.create(c));
		
	}
	
	public List<Cliente> consultar(){
		List<Cliente> lista = new ArrayList<>();
		ClienteDao cDao = new ClienteDao();
		lista = cDao.read();
		return lista;
	}
	
	//criar um objeto do produto	
	//criar metodo de consulta
	//método cadastrar
	//método consultar
	
	
}
