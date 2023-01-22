package dominio.produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;

import dominio.produto.enun.Categoria;

public class Produto {
	private long id=UUID.randomUUID().getMostSignificantBits();
	private String nome;
	private BigDecimal preco= BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private Categoria categoria;
	
	public static void main(String[] args) {
		System.out.println("preco: "+ new BigDecimal("20.897").setScale(2,RoundingMode.HALF_UP));
	}
	public Produto(String nome, BigDecimal preco, Categoria categoria) {
		super();
//		setNome(nome.toLowerCase());
		setNome(nome);
		setPreco(preco);
		setCategoria(categoria);
	}
	public Produto() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome== null) {
			throw new IllegalArgumentException("Nome não pode ser null.");
		}
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getPreco() {
		if(preco== null) {
			throw new IllegalArgumentException("Preço não pode ser null.");
		}
		return preco.setScale(2, RoundingMode.HALF_UP);
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		if(categoria== null) {
			throw new IllegalArgumentException("Categoria não pode ser null.");
		}
		this.categoria = categoria;
	}
	

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + getPreco() + ", categoria=" + categoria + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nome, preco);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Produto other = (Produto) obj;
		return categoria == other.categoria &&  Objects.equals(nome, other.nome);
			
	}
	
	
	
	
	
}
