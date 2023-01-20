package dominio.produto;

import java.math.BigDecimal;

import dominio.produto.enun.Categoria;
import dominio.produto.enun.Genero;

public class Livro extends Produto{
	
	
	private Genero genero;
	private String escritor;
	private String editora;
	
	
	
	public Livro( String nome, BigDecimal preco,  Genero genero, String escritor, String editora) {
		super(nome, preco, Categoria.LIVRO);
		this.genero = genero;
		this.escritor = escritor;
		this.editora = editora;
	}
	public Livro() {}
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getEscritor() {
		return escritor;
	}
	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	

}
