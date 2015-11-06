package controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;


public class Conexao { 
	
	public static String status = "Não conectou..."; 

	public Conexao() { 
		 
	}
	
	public static java.sql.Connection getConexaoMySQL() { 
		Connection connection = null; 
		
		try { 
			String driverName = "com.mysql.jdbc.Driver"; 
			Class.forName(driverName); 
			String serverName = "localhost";
			String mydatabase = "projetoclinica"; 
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
			String username = "root"; //nome de um usuário de seu BD 
			String password = "admin"; //sua senha de acesso 
			connection = DriverManager.getConnection(url, username, password); 
			
			if (connection != null) { 
				status = ("STATUS--->Conectado com sucesso!"); 
			} else { 
				status = ("STATUS--->Não foi possivel realizar conexão"); 
			} 
			
			return connection; 
			
		} catch (ClassNotFoundException e) { //Driver não encontrado 
			System.out.println("O driver expecificado nao foi encontrado."); 
			return null; 
		} catch (SQLException e) { //Não conseguindo se conectar ao banco 
			System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
			return null; 
		} 
	}
	
	public static String statusConection() { 
		return status; 
	}
	
	public static boolean FecharConexao() { 
		try { 
			Conexao.getConexaoMySQL().close(); 
			return true; 
		} catch (SQLException e) { 
			return false; 
		} 
	} 
	
	public static java.sql.Connection ReiniciarConexao() { 
		FecharConexao(); 
		return Conexao.getConexaoMySQL(); 
	} 

}