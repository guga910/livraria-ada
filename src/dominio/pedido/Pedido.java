package dominio.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class Pedido {

//	Optional<BigDecimal> valorTotal = lista.stream().reduce(BigDecimal::add);

	private Usuario usuario;
	private List<Item> itens= new ArrayList<>();
	private BigDecimal valorTotal= BigDecimal.ZERO;
	private LocalDate dataPedido;
	
	public Pedido(Usuario usuario, List<Item> itens) {
		super();
		this.usuario = usuario;
		this.itens = itens;
		this.valorTotal= itens.stream().map(t-> t.getValorItem()).reduce(BigDecimal.ZERO, BigDecimal::add);
		this.dataPedido= LocalDate.now();
	}
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	@Override
	public String toString() {
		return "Pedido [usuario=" + usuario.getNome() + ", total de itens= " + itens.size() + ", valorTotal=" + valorTotal + " data: "+dataPedido+".";
	}
	
	

	

}
