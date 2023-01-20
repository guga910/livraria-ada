package infraestrutura.acao.pedido;

import dominio.Caixa;
import dominio.pedido.Estoque;
import dominio.pedido.Pedido;
import dominio.produto.Produto;

public class EfetivarCompraPedido {
	
	public void efetivarCompra(Pedido pedido, Caixa caixa, Estoque meuEstoque) {

		for (int i=0; i< pedido.getItens().size(); i++) {
			
			Produto ped= pedido.getItens().get(i).getProduto();
			long qnd= pedido.getItens().get(i).getQuantidade();
			
			
			meuEstoque.atualizarEstoque(ped, qnd);
		}
		caixa.adicionarDinheiro(pedido.getValorTotal());
		

		System.out.println("\nCompra efetivada com sucesso!\n aqui esta seu resumo\n");
	}

}
