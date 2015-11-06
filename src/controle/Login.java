package controle;

import java.sql.*;

public class Login {
	
	private Conexao conexaobd = new Conexao();
	
	public boolean autenticarLogin(String user, String senha){
		
		Statement stmt = null;
		try {
                    stmt = conexaobd.getConexaoMySQL().createStatement();
                    String sql = "SELECT count(*) as login from acesso where login ='"+user+"' and senha = '"+senha+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	
		    	if(rs.getInt("login") == 0){
		    		return false;
		    	} else {
		    		return true;
		    	}
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
	
	

}
