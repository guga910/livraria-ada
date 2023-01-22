package infraestrutura.acao.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Usuario;
import dominio.pedido.Estoque;
import dominio.pedido.Item;
import dominio.pedido.Pedido;
import dominio.produto.Produto;

public class CriarPedido {

	public Pedido criarNovoPedido(Scanner scanner, Usuario usuario) {
		Estoque estoque = new Estoque();
		
		List<Item> listaItens = new ArrayList<>();
		String opcao = " ";
		String comando=" ";
		boolean sair = true;

		while (sair) {
			
			System.out.println("\nQual voce deseja por no carrinho?");
			comando= "(por favor, copie e cole o item escolhido)\n";
			System.out.println(comando);
		
			String produtoEscolhido = scanner.next();

			while (produtoEscolhido == null || produtoEscolhido.isEmpty()) {
				System.out.println("\nO nome do pedido nao pode ser nulo nem vazio");
				System.out.println("por favor, escolha novamente.\n");
				estoque.mostrarProdutosDoEstoque();

				produtoEscolhido = scanner.next();
			}

			Produto produto = estoque.buscarProdutoPorNome(produtoEscolhido);

			System.out.println("agora, diga a quantidade:");
			long qntEscolhida = scanner.nextLong();
			listaItens.add(new Item(qntEscolhida, produto));

			System.out.println("\n                                                                   pag 06");
			System.out.println("\n\nDigite s para Finalizar e voltar ao menu anterior,"
					 + "\nou qualquer tecla para Inserir outro produto.");
			opcao=scanner.next();
			
			sair= !opcao.equalsIgnoreCase("s");
		}
		
		Pedido pedido= new Pedido(usuario, listaItens);
		return pedido;
	}


}
