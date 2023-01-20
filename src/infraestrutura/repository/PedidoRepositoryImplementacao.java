package infraestrutura.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.pedido.Pedido;
import dominio.pedido.PedidoRepository;

public class PedidoRepositoryImplementacao implements PedidoRepository {
	
	private List<Pedido> listaPedidos= arquivo();

	@Override
	public void mostrarUltimosPedidos() {
		recuperarPedido().forEach(System.out::println);
		
	}
	public void historicoDePedidos() {
		List<Pedido> venddasDia= new ArrayList<>();
		
		for (int i = 0; i < recuperarPedido().size() ; i++) {
			LocalDate dia = recuperarPedido().get(i).getDataPedido();
//			System.err.println(dia);
			
			for (int j = 0; j < recuperarPedido().size(); j++) {
				
				if(dia.equals(recuperarPedido().get(j).getDataPedido() )) {
					
					
					venddasDia.add(recuperarPedido().get(i));
					
				}
			}
			System.out.println(venddasDia.size());
			
//		System.out.println("No dia: "+dia+" tivemos: "+venddasDia.size()+" pedidos.\n");
		}
	}
	public static void main(String[] args) {
		
		PedidoRepositoryImplementacao p= new PedidoRepositoryImplementacao();
BigDecimal i = p.totalVendidoDoDia(LocalDate.now().minusDays(1));
System.out.println(i);
	}

	@Override
	public List<Pedido> recuperarPedido() {
		return this.listaPedidos;
	}

	@Override
	public void addIPedido(Pedido pedido) {
		this.listaPedidos.add(pedido);
		
	}

	@Override
	public void mostrarPedidosDia(LocalDate dia) {
		this.listaPedidos.stream().filter(d-> d.getDataPedido().equals(dia)).forEach(System.out::println);
		
	}
	public BigDecimal totalVendidoDoDia(LocalDate dia) {
		return this.listaPedidos.stream().filter(dian-> dian.getDataPedido().equals(dia)).map(d->d.getValorTotal()) . reduce(BigDecimal.ZERO, BigDecimal::add);
	
	}

	@Override
	public Pedido buscarPedidoPorUsuario(String nome) {
	 Pedido pedido = this.listaPedidos.stream().filter(n-> n.getUsuario().getNome().equals(nome)).findFirst().get();

		return pedido;
	}

	@Override
	public void removerItemNomeProduto(Pedido pedido,String nome) {
//		aqui
//		for (int i = 0; i < listaPedidos.size(); i++) {
//			for (int j = 0; j <listaPedidos.get(i).getItens().size(); j++) {
//				
//				if (listaPedidos.get(i).getItens().get(j).getProduto().equals(nome)) {
//					
//				  listaPedidos.get(i).getItens().remove(listaPedidos.get(i).getItens().get(j));
//				}
//				
//			}
			
//		}
		
	}
	
	

}
