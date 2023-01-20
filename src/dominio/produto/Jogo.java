package dominio.produto;

import java.math.BigDecimal;

import dominio.produto.enun.Categoria;
import dominio.produto.enun.Genero;

public class Jogo extends Produto{
//	 distribuidora, gêneros e estúdio
	private String distribuidora;
	private Genero genero;
	private String estudio;
	
	
	
	public Jogo(String nome,  BigDecimal preco, String distribuidora, Genero genero, String estudio) {
		super(nome,  preco, Categoria.JOGO);
		this.distribuidora = distribuidora;
		this.genero = genero;
		this.estudio = estudio;
	}
	public Jogo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getEstudio() {
		return estudio;
	}
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	

}
