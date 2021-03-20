/** 
 * Classe ClienteDao 
 * Criado em 17/11/2020
 * @author Grupo 3 + os novos amiguinhos :)
*/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDao {
	
	/** 
	 * Evento create Cliente c	
	*/
	 public int create(Cliente c) {
		 Connection con = null;
		 String sql = "INSERT INTO cliente(cpf, nome, logradouro, numero, cidade, estado, telefone) VALUES(?,?,?,?,?,?,?)";
		 PreparedStatement stmt = null;
		 con = ConnectionFactory.getConnection();
		 try {
			 stmt = con.prepareStatement(sql);
			 stmt.setString(1, c.getCpf());
			 stmt.setString(2, c.getNome());
			 stmt.setString(3, c.getLogradouro());
			 stmt.setInt(4, c.getNumero());
			 stmt.setString(5, c.getCidade());
			 stmt.setString(6, c.getEstado());
			 stmt.setString(7, c.getTelefone());
			 stmt.execute();
			 return 1;
		 } catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastro no banco de dados!", "Erro", 2);
				return 0;
			}
			finally {
				ConnectionFactory.closeConnection(con,stmt);
			}
	 }
	 
	 public List<Cliente> read(){
		 Connection con=ConnectionFactory.getConnection();
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 String sql="SELECT * FROM CLIENTE";
		 List<Cliente> clientes=new ArrayList<>();
		 try {
			 stmt= con.prepareStatement(sql);
			 rs= stmt.executeQuery();
			 while(rs.next()) {
					Cliente c = new Cliente();
					c.setCpf(rs.getString("cpf"));
					c.setNome(rs.getString("nome"));
					c.setLogradouro(rs.getString("logradouro"));
					c.setNumero(rs.getInt("numero"));
					c.setCidade(rs.getString("cidade"));
					c.setEstado(rs.getString("estado"));
					c.setTelefone(rs.getString("telefone"));
					clientes.add(c);
				}

		 }catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao consultar no Banco de Dados" +e.getMessage());
				
				ConnectionFactory.closeConnection(con, stmt, rs);
		 	}
			return clientes;
		 
	 }
}
