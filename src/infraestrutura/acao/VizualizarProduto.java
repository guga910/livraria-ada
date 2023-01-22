package infraestrutura.acao;

import java.util.Scanner;

import dominio.pedido.Estoque;

public class VizualizarProduto implements Funcao {

	@Override
	public void executar(Scanner scanner) {

		Estoque estoque= new Estoque();
		boolean sair= true;
		String opcao="";
		
		while(sair) {
		System.out.println("Produtos disponiveis:\n");
		estoque.mostrarProdutosDoEstoque();
		
			
		
		System.out.println("\ndigite o nome do produto: ");
		String nomeProduto= scanner.next();
		
		estoque.quantosItensDoProdutoTemEmEstoque(nomeProduto);
//		Produto produto = estoque.buscarProdutoPorNome(nomeProduto);
//		System.out.println("\nVoce escolheu: "+produto.getNome()
//				+" que custa: "+produto.getPreco()+
//				", temos "+produto+" dele em estoque.");
		System.out.println("                                                                   pag 02");
		System.out.println("\n\nDigite s voltar ao menu principal,"
						 + "\nou qualquer tecla para vizualizar novamente.");
		opcao=scanner.next();
		
		sair= !opcao.equalsIgnoreCase("s");
		}
		
	}

}
