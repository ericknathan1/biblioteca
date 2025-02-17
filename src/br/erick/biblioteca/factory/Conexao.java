package br.erick.biblioteca.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String DATABASE_URL = "jdbc:sqlserver://ESCREVA-SUA-MAQUINA-AQUI\\SQLEXPRESS:1433;databaseName=biblioteca;integratedSecurity=true;encrypt=false;";
	
	
	//criação de conexão
	
	public static Connection conexaoSQL() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL);
		
		return conexao;
	}
	
	public static void main(String[] args) throws Exception {
		
		//testagem da conexão
		
		Connection con = conexaoSQL();
		
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso");
			con.close();
		}
	}
	
	
	
}
