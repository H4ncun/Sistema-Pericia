//NOME: Luiz Felipe Cardoso Gonçalves

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ConnectionFactory {
	
	public static Connection OpenConnection(){
		
		
		Connection con = null;
		
		
		try {
			
			con = DriverManager.getConnection("Definir banco aqui", "Usuário", "Senha");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Conecte ao banco de dados");
		}
		
		return con;
			
	}

	 public static void CloseConnection(Connection con,PreparedStatement stmt, ResultSet res){
		 
		 
		        if (con != null) {
		          try {  
		        	  con.close();
		        }catch(SQLException e){
		        	
		        }
		        }
		        
		        if (stmt != null) {
		            try {  
			        	  stmt.close();
			        }catch(SQLException e){
			        	
			        }
			        }  
		 
		        if (res != null) {
		            try {  
			        	  res.close();
			        }catch(SQLException e){
			        	
			        }
			        }  
	 }
	 }
	