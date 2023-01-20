package infraestrutura.acao;

import java.util.Scanner;

import dominio.pedido.Estoque;

public class ListaCompletaItensEmEstoque implements Funcao{

	@Override
	public void executar(Scanner scanner) {
		Estoque estoque= new Estoque();
		boolean sair= true;
		String opcao="";
		
		while(sair) {

		
		
		System.out.println("\nOlá, seja bem vindo, aqui esta todos os nossos produtos:\n");
		estoque.mostrarProdutosDoEstoque();
		System.out.println();
		
		System.out.println("                                                                   pag 03");
		System.out.println("\n\nDigite s voltar ao menu principal,"
				 + "\nou qualquer tecla para vizualizar novamente.");
		opcao=scanner.next();
		
		sair= !opcao.equalsIgnoreCase("s");
		}
		
		
		
	}

}
