package br.erick.biblioteca.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.erick.biblioteca.factory.Conexao;
import br.erick.biblioteca.model.Livros;

import br.erick.biblioteca.model.Livros;

public class LivrosDAO implements DAO<Livros>{
	
	

	@Override
	public void criar(Livros livro) {
		//Criando o INSERT e definindo as conexões do banco de dados
		String SQL = "INSERT INTO Livros(titulo, genero) values (?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			//Tenta definir a conexão do banco de dados
			conn = Conexao.conexaoSQL();
			pstm = conn.prepareStatement(SQL);
			
			//inseri os valores do livro nas posições desejadas
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getGenero());

			
			//Verifica o numero de linhas inseridas e tenta insirir os valores na tabela desejada
			int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livro inserido com sucesso!");
            }else {
            	System.out.println("Algo de errado ocorreu");
            }
			
		}catch(Exception e){
			//Mensegam de erro caso não seja possível criar um livro.
			
			System.out.println("Não foi possível criar o livro desejado");
			e.printStackTrace();
			
		}finally {
			//Fechar conexões caso estejam abertas
			
			try {
				
				// verifica se a conexão estava aberta
				if(conn != null) {
					conn.close();
				}
				
				//verifica se o PreparedStatement estava aberto
				
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Livros ler(int id) {
		
		//Criando conexões e criando o ResultSet como null
		String sql = "SELECT * FROM Livros WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			//Cria conexão com o banco de dados
			
			conn = Conexao.conexaoSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			//Insere na pesquisa o ID selecionado
			
			
			//Inicia a busca pelo livro e retorna as informações dele.
			if (rs.next()) {
				Livros livro = new Livros();
				livro.setId(rs.getInt(1));
				livro.setTitulo(rs.getString(2));
				livro.setGenero(rs.getString(3));
				System.out.println("ID do Livro: "+livro.getId());
				System.out.println("Nome do Livro = "+livro.getTitulo());
				System.out.println("Gênero do Livro: "+livro.getGenero());
				return livro;
			} else {
				return null;
			}
			
		}catch(Exception e){
			//Mensegam de erro caso não seja possível criar um livro.
			
			System.out.println("Não foi possível executar a pesquisa");
			e.printStackTrace();
			
		}finally {
			//Fechar conexões caso estejam abertas
			
			try {
				
				// verifica se a conexão estava aberta
				if(conn != null) {
					conn.close();
				}
				
				//verifica se o PreparedStatement estava aberto
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(rs != null) {
					rs.close();
				}
				
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Livros livro) {
		// TODO Auto-generated method stub
		//Criando o INSERT e definindo as conexões do banco de dados
		String SQL = "UPDATE Livros SET titulo = ?, genero = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			//Tenta definir a conexão do banco de dados
			conn = Conexao.conexaoSQL();
			pstm = conn.prepareStatement(SQL);
			
			//inseri os valores do livro nas posições desejadas
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getGenero());
			pstm.setInt(3, livro.getId());
			
			//Verifica o numero de linhas inseridas e tenta insirir os valores na tabela desejada
			int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livro atualizado com sucesso!");
            }else {
            	System.out.println("Algo de errado ocorreu");
            }
			
		}catch(Exception e){
			//Mensegam de erro caso não seja possível criar um livro.
			
			System.out.println("Não foi possível atualizar o livro desejado");
			e.printStackTrace();
			
		}finally {
			//Fechar conexões caso estejam abertas
			
			try {
				
				// verifica se a conexão estava aberta
				if(conn != null) {
					conn.close();
				}
				
				//verifica se o PreparedStatement estava aberto
				
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void apagar(int id) {
		String sql = "DELETE FROM Livros WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.conexaoSQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(id, id);
			
			int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livro deletado com sucesso!");
            }else {
            	System.out.println("Algo de errado ocorreu");
            }
		}catch(Exception e){
			//Mensegam de erro caso não seja possível criar um livro.
			
			System.out.println("Não foi possível deletar o livro desejado");
			e.printStackTrace();
			
		}finally {
			//Fechar conexões caso estejam abertas
			
			try {
				
				// verifica se a conexão estava aberta
				if(conn != null) {
					conn.close();
				}
				
				//verifica se o PreparedStatement estava aberto
				
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
				e.printStackTrace();
			}
		
		}
	}
	


}
