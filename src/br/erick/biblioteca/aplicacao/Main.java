package br.erick.biblioteca.aplicacao;

import java.util.Scanner;

import br.erick.biblioteca.DAO.LivrosDAO;
import br.erick.biblioteca.model.Livros;

public class Main {
	public static void main(String[] args) {
		// Cria o Scanner e uma variável para o while
		Scanner s = new Scanner(System.in); //Scanner para criação de um livro
		int opt = -1;
		
		int i = 0;

		try {
			
			while(i == 0) {
				
			System.out.println("\nBiblioteca");
			System.out.println("1 = Criar um livro");
			System.out.println("2 = Pesquisar um livro");
			System.out.println("3 = Atualizar um livro");
			System.out.println("4 = Apagar um livro");
			System.out.println("5 = Sair do programa");
			System.out.println("Escolha uma opção: ");
			
			if(s.hasNextInt()) {
				opt = s.nextInt();
				s.nextLine();
			}else {
				System.out.println("\nPor favor, insira um número");
				s.nextLine();
			}
			
			switch(opt) {
			
				case 1:
					System.out.println("\nInsira o titulo do livro: "); String titulo =
					s.nextLine();
					 
					System.out.println("Insira o gênero do livro: "); String genero =
					s.nextLine();
					 
					Livros livro_1 = new Livros();
					 
					livro_1.setTitulo(titulo); livro_1.setGenero(genero);
					 
					LivrosDAO livro_1DAO = new LivrosDAO();
					livro_1DAO.criar(livro_1);
					break;
					
				case 2:
					
					LivrosDAO buscaDAO = new LivrosDAO();
					System.out.println("\nInsira o ID do Livro desejado: "); int escolha =
					s.nextInt();
					
					Livros livro = buscaDAO.ler(escolha); if(livro == null) {
						
					System.out.println("Nenhum livro foi encontrado com este ID."); 
					
					}
					
					break;
				
				default:
					System.out.println("Por favor, insira uma opção válida.");
					break;
					
				case 3:
					Livros livroDesejado = new Livros();
					LivrosDAO updateDAO = new LivrosDAO();
					
					
					System.out.println("\nInsira o ID do livro que deseja atualizar: ");
					livroDesejado.setId(s.nextInt());
					s.nextLine();
					System.out.println("Insira o novo título: ");
					livroDesejado.setTitulo(s.nextLine());
					System.out.println("Insira o novo gênero");
					livroDesejado.setGenero(s.nextLine());
					
					updateDAO.editar(livroDesejado);
					
					break;
				
				case 4:
					LivrosDAO apagarDAO = new LivrosDAO();
					
					System.out.println("\nInsira o ID do livro que você deseja apagar: ");
					int escolha1 = s.nextInt();
					s.nextLine();
					apagarDAO.apagar(escolha1);
					
					break;
					
							
				case 5:
					System.out.println("Saindo do programa...");
					i = 1;
					
					
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}

	}
}
