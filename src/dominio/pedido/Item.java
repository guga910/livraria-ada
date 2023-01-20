package dominio.pedido;

import java.math.BigDecimal;

import dominio.produto.Produto;

public class Item {
	private long quantidade;
	private Produto produto;
	private BigDecimal valorItem;

	public Item(long quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
		this.valorItem= produto.getPreco().multiply(new BigDecimal(quantidade));
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "O produto: "+produto.getNome()+" custa: "+valorItem+" temos "+quantidade+" em estoque."	;
	}
	

}
