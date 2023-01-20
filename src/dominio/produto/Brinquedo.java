package dominio.produto;

import java.math.BigDecimal;

import dominio.produto.enun.Categoria;

public class Brinquedo extends Produto{
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public Brinquedo() {
		// TODO Auto-generated constructor stub
	}

	public Brinquedo(String nome,  BigDecimal preco, String tipo) {
		super(nome,  preco, Categoria.BRINQUEDO);
		this.tipo = tipo;
	}
	

}
