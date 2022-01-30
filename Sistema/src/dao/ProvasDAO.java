package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.CadastroProvas;
import model.Perito;


public class ProvasDAO {
	private Connection con;
	
	public void inserir(CadastroProvas provas){
		
		con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("INSERT INTO PROVA(ID_PROVA, NOME_PROVA, NUMERO_PROCESSO, LAUDO, ID_PERITO) VALUES (SQ_PRODUTO.NEXTVAL, '?', '?', '?', '?');");
		
		stmt.setString(1, provas.getNome());
		stmt.setString(2, provas.getComentario());
		stmt.setString(3, provas.getNumero_processo());		
		stmt.setInt(4, provas.getPerito().getId());
		
		
		stmt.executeUpdate();
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}	
	finally {
		ConnectionFactory.CloseConnection(con, stmt, res);
		
	}
	}
	public void excluir(CadastroProvas provas){
		
		con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("DELETE FROM PROVA WHERE ID_PROVA=?");
		
		stmt.setInt(1, provas.getId());
		
		stmt.executeUpdate();

	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}finally {
		ConnectionFactory.CloseConnection(con, stmt, res);
		
	}
	}
public CadastroProvas localizar(CadastroProvas provas){
		
	    con = ConnectionFactory.OpenConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet res = null;
		
	
	try {
		
		stmt = con.prepareStatement("SELECT PROVA.ID_PROVA, PROVA.NOME_PROVA, PRODUTO.NUMERO_PROCESSO, PROVA.LAUDO, PERITO.ID_PERITO, PERITO.NOME_PERITO, PERITO.EMAIL_PERITO, PERITO.ENDERECO,PERITO.TELEFONE FROM PROVA INNER JOIN PERITO ON PROVA.ID_PERITO=PERITO.ID_PERITO WHERE PROVA.ID_PROVA=?");
		
		stmt.setInt(1, provas.getId());
		
		res = stmt.executeQuery();
		
		if(res.next()) {
			
			provas.setId(res.getInt(""));
			provas.setNome(res.getString(""));
			provas.setComentario(res.getString(""));
			provas.setNumero_processo(res.getString(""));
			provas.setPerito(new Perito(res.getInt(""), res.getString(""), res.getString(""), res.getString(""),res.getString("")));
				
		}
				
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "POR FAVOR, CADASTRAR BANCO DE DADOS");
	}
    finally {
	    ConnectionFactory.CloseConnection(con, stmt, res);
	
    }
	return provas;
	}
}
