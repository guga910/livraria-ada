package dominio.produto;

import java.math.BigDecimal;

import dominio.produto.enun.Categoria;
import dominio.produto.enun.Genero;

public class Filme extends Produto{
	
	
	private String estudio;
	private String diretor;
	private Genero genero;
	

	public Filme(String nome,  BigDecimal preco, String estudio, String diretor, Genero genero) {
		super(nome,  preco, Categoria.FILME);
		this.estudio = estudio;
		this.diretor = diretor;
		this.genero = genero;
	}
	public Filme() {
		// TODO Auto-generated constructor stub
	}
	public String getEstudio() {
		return estudio;
	}
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

}
