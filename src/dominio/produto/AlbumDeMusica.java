package dominio.produto;

import static dominio.produto.enun.Categoria.ALBUMdEmUSICA;

import java.math.BigDecimal;

import dominio.produto.enun.Genero;

public class AlbumDeMusica extends Produto {
	
	private String banda;
	private Genero genero;
	private String selo;
	
	public AlbumDeMusica() {
		// TODO Auto-generated constructor stub
	}
	
	public AlbumDeMusica(String nome,  BigDecimal preco, String banda, Genero genero, String selo) {
		super(nome,  preco, ALBUMdEmUSICA);
		this.banda = banda;
		this.genero = genero;
		this.selo = selo;
	}

	public String getBanda() {
		return banda;
	}
	public void setBanda(String banda) {
		this.banda = banda;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getSelo() {
		return selo;
	}
	public void setSelo(String selo) {
		this.selo = selo;
	}
	
	

}
