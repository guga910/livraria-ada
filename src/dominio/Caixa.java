package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

import dominio.pedido.Estoque;
import dominio.pedido.Pedido;
import dominio.produto.Produto;
import infraestrutura.repository.PedidoRepositoryImpl;

public class Caixa {

	private PedidoRepositoryImpl redidoRepository = new PedidoRepositoryImpl();
	private BigDecimal dinheiroEmCaixa = BigDecimal.ZERO;
	private Estoque estoque = new Estoque();

	public Estoque getEstoque() {
		return estoque;
	}

	public BigDecimal getDinheiro() {
		return dinheiroEmCaixa;
	}

	public BigDecimal getDinheiroEmCaixa() {
		BigDecimal totalhoje = redidoRepository.totalVendidoDoDia(LocalDate.now());
		return dinheiroEmCaixa = dinheiroEmCaixa.add(totalhoje);
//		return dinheiroEmCaixa ;
	}

	public void efetivarCompra(Pedido pedido) {
		Estoque meuEstoque = new Estoque();

		for (int i = 0; i < pedido.getItens().size(); i++) {

			Produto p = pedido.getItens().get(i).getProduto();
			long q = pedido.getItens().get(i).getQuantidade();

			meuEstoque.atualizarEstoque(p, q);
		}
		adicionarDinheiro(pedido.getValorTotal());

		System.out.println("\nCompra efetivada com sucesso!\n aqui esta seu resumo\n");
	}

	public void mostarDinheiroEmCaixaHoje() {

		System.out.println("valor em caixa: " + getDinheiroEmCaixa());
	}

	public BigDecimal adicionarDinheiro(BigDecimal dinheiro) {

		return dinheiroEmCaixa = dinheiroEmCaixa.add(dinheiro);
	}

}
