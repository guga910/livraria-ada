package dominio.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public interface PedidoRepository {

	public void mostrarUltimosPedidos();

	public List<Pedido> recuperarPedido();


	

	public void addIPedido(Pedido pedido);

	public void mostrarPedidosDia(LocalDate dia);

	public Pedido buscarPedidoPorUsuario(String nome);
	
	public void removerItemNomeProduto(Pedido pedido,String nome);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	default List<Pedido> arquivo() {
		Estoque estoque = new Estoque();
		List<Item> itensEmEstoque = estoque.recuperarEstoque();
		List<Pedido> listaPedidos = new ArrayList<>();

		List<Item> lista1 = List.of(new Item(2, itensEmEstoque.get(0).getProduto()),
				new Item(5, itensEmEstoque.get(3).getProduto()), new Item(2, itensEmEstoque.get(5).getProduto()));
		
		Pedido p1 = new Pedido(new Usuario("Afonso"), lista1);
		p1.setDataPedido(LocalDate.now().minusDays(1));
	
		List<Item> lista21 = List.of(new Item(2, itensEmEstoque.get(0).getProduto()),
				new Item(5, itensEmEstoque.get(3).getProduto()), new Item(2, itensEmEstoque.get(5).getProduto()));
		
		Pedido p21 = new Pedido(new Usuario("Renata"), lista21);
		p1.setDataPedido(LocalDate.now().minusDays(5));
		
		
	
		List<Item> lista31 = List.of(new Item(2, itensEmEstoque.get(0).getProduto()),
				new Item(5, itensEmEstoque.get(3).getProduto()), new Item(2, itensEmEstoque.get(5).getProduto()));
		
		Pedido p31 = new Pedido(new Usuario("Lucas"), lista31);
		p1.setDataPedido(LocalDate.now().minusDays(1));

		
		
		
		List<Item> lista2 = List.of(new Item(3, itensEmEstoque.get(1).getProduto()),
				new Item(2, itensEmEstoque.get(2).getProduto()), new Item(2, itensEmEstoque.get(6).getProduto()));
		Pedido p2 = new Pedido(new Usuario("Luiz"), lista2);
		p2.setDataPedido(LocalDate.now().minusDays(2));
		
		List<Item> lista22 = List.of(new Item(3, itensEmEstoque.get(1).getProduto()),
				new Item(2, itensEmEstoque.get(2).getProduto()), new Item(2, itensEmEstoque.get(6).getProduto()));
		Pedido p22 = new Pedido(new Usuario("Luiza"), lista22);
		p2.setDataPedido(LocalDate.now().minusDays(4));
		
		List<Item> lista32 = List.of(new Item(3, itensEmEstoque.get(1).getProduto()),
				new Item(2, itensEmEstoque.get(2).getProduto()), new Item(2, itensEmEstoque.get(6).getProduto()));
		Pedido p32 = new Pedido(new Usuario("Jurema"), lista32);
		p2.setDataPedido(LocalDate.now().minusDays(2));
		
		
		
		

		List<Item> lista3 = List.of(new Item(3, itensEmEstoque.get(2).getProduto()),
				new Item(2, itensEmEstoque.get(0).getProduto()), new Item(2, itensEmEstoque.get(0).getProduto()));
		Pedido p3 = new Pedido(new Usuario("Rebeca"), lista3);
		p3.setDataPedido(LocalDate.now().minusDays(3));

		
		List<Item> lista23 = List.of(new Item(3, itensEmEstoque.get(2).getProduto()),
				new Item(2, itensEmEstoque.get(0).getProduto()), new Item(2, itensEmEstoque.get(0).getProduto()));
		Pedido p23 = new Pedido(new Usuario("Pocoyo"), lista23);
		p3.setDataPedido(LocalDate.now().minusDays(4));
		
		
		List<Item> lista33 = List.of(new Item(3, itensEmEstoque.get(2).getProduto()),
				new Item(2, itensEmEstoque.get(0).getProduto()), new Item(2, itensEmEstoque.get(0).getProduto()));
		Pedido p33 = new Pedido(new Usuario("Helen"), lista33);
		p3.setDataPedido(LocalDate.now().minusDays(5));
		
		
		
		
		
		listaPedidos.add(p1);
		listaPedidos.add(p2);
		listaPedidos.add(p22);
		listaPedidos.add(p32);
		listaPedidos.add(p3);
		listaPedidos.add(p23);
		listaPedidos.add(p33);
		listaPedidos.add(p31);
		listaPedidos.add(p21);

		return listaPedidos;
	}

}
