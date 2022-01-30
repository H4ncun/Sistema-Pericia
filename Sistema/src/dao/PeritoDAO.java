package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Perito;


public class PeritoDAO {
	private Connection con;
	
	public void inserir(Perito perito){
		
		con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("INSERT INTO PERITO (ID_PERITO, NOME_PERITO, EMAIL_PERITO, ENDERECO,TELEFONE) VALUES (SQ_FORNECEDOR.NEXTVAL,?,?,?,?)");
		
		stmt.setString(1, perito.getNome());
		stmt.setString(2, perito.getEmail());
		stmt.setString(3, perito.getEndereco());
		stmt.setString(4, perito.getTelefone());
				
		stmt.executeUpdate();
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}	
	finally {
		ConnectionFactory.CloseConnection(con, stmt, res);
		
	}
	}
	public void atualizar(Perito perito){
		
		con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("UPDATE PERITO SET NOME_PERITO=?, EMAIL_PERITO=?, ENDERECO=?, TELEFONE=? WHERE ID_PERITO=?");
		
		stmt.setString(1, perito.getNome());
		stmt.setString(2, perito.getEmail());
		stmt.setString(3, perito.getEndereco());
		stmt.setString(4, perito.getTelefone());
		stmt.setInt(5, perito.getId());
				
		stmt.executeUpdate();
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}
	finally {
		ConnectionFactory.CloseConnection(con, stmt, res);
		
	}
	}
	public void excluir(Perito perito){
		
		con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("DELETE FROM PERITO WHERE ID_PERITO=?");
		
		stmt.setInt(1, perito.getId());
		
		stmt.executeUpdate();

	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}finally {
		ConnectionFactory.CloseConnection(con, stmt, res);
		
	}
	}
public Perito localizar(Perito perito){
		
	    con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("SELECT * FROM PERITO WHERE ID_PERITO=?");
		
		stmt.setInt(1, perito.getId());
		
		res = stmt.executeQuery();
		
		if(res.next()) {
			
			perito.setId(res.getInt(""));
			perito.setNome(res.getString(""));
			perito.setEmail(res.getString(""));
			perito.setEndereco(res.getString(""));
			perito.setTelefone(res.getString(""));
				
		}
				
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}
    finally {
	    ConnectionFactory.CloseConnection(con, stmt, res);
	
    }
	return perito;
	}
public ArrayList<Perito> Todos(){
	
	ArrayList<Perito> peritos = new ArrayList<Perito>();
	
	con = ConnectionFactory.OpenConnection();
	
	PreparedStatement stmt = null;
	
	ResultSet res = null;
	 
	try {
		stmt = con.prepareStatement("SELECT *FROM PERITO");
		res = stmt.executeQuery();
		
		while(res.next()) {
			
			peritos.add(new Perito(			
			res.getInt("ID"),
			res.getString("Nome"),
			res.getString("Endereco"),
			res.getString("Telefone"),
			res.getString("Email")));
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}
	finally{
		ConnectionFactory.CloseConnection(con, stmt, res);

	} return peritos;

	}
}

