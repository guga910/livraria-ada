package infraestrutura.acao.pedido;

import java.time.format.DateTimeFormatter;

import dominio.pedido.Pedido;

public class VizualizacaoPedidoAtual{

	public void executar(Pedido pedido) {
		System.out.println("\n--------------------------------------------------------------------------------\n");
		System.out.println("\n Livraria Ada\nAqui voce acha!");
		System.out.println();
		System.out.println();
		System.out.println("Cliente: " + pedido.getUsuario().getNome());
		System.out.println("Cpf: " + pedido.getUsuario().getCpf());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataCompraFormatado =  pedido.getDataPedido().format(formatter);
        
		System.out.println("Data: " + dataCompraFormatado );
		System.out.println();
		for (int i = 0; i < pedido.getItens().size(); i++) {
			System.out.println("Item 0" + (i + 1) + "-> Descrição: " + pedido.getItens().get(i).getProduto().getNome()
					+ ",  Qnt: " + pedido.getItens().get(i).getQuantidade() + ", Valor Uni: "
					+ pedido.getItens().get(i).getProduto().getPreco() + ", Total: "
					+ pedido.getItens().get(i).getValorItem());
		}
		System.out.println("\nO valor do Pedido foi: " + pedido.getValorTotal());
		System.out.println("\nObrigado e Volte sempre.");
		System.out.println("\nA Ada esta de maõs dadas com voce! ");
		System.out.println(" 0/\n");
		System.out.println("\n--------------------------------------------------------------------------------");
		
//		mostarDinheiroEmCaixa();
//		adicionarDinheiro(pedido.getValorTotal());
		
	}

}
