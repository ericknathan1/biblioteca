package br.erick.biblioteca.model;

import java.util.Date;

public class Livros {
	
	private int id;
	private String titulo;
	private String genero;
	private Date ano_publicacao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(Date ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	
}
