package br.erick.biblioteca.DAO;

public interface DAO<T> {	
	
	void criar(T objeto);
	T ler(int id);
	void editar(T objeto);
	void apagar(int id);
	
	//métodos genéricos relacionados ao CRUD (Criar, Ler, Editar, Apagar).
	

}
