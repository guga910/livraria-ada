package infraestrutura.front;

import java.util.Scanner;

import dominio.Usuario;
import infraestrutura.acao.ListaCompletaItensEmEstoque;
import infraestrutura.acao.VerListaCOmpletaDoEstoquePorCategoria;
import infraestrutura.acao.VizualizarProduto;
import infraestrutura.front.acesso.PageLogin;
import infraestrutura.front.acesso.PageRegistro;

public class PageFront {

	public void primeiroContato(Scanner scanner) {

		boolean sair = true;
		String entrada = "";
		Usuario usuario= new Usuario();
		System.out.println(
				"Seja bem vindo a Livraria Ada,\n    Mesmo se aqui voce não comprar, a gente vai te abraçar!\n");

		while (sair) {

			System.out.println("Digite 1 para Novo registro\nou 2 para se Logar.");
			int opcao = scanner.nextInt();
			if (opcao == 1) {
				usuario= new PageRegistro().executar(scanner);
				
			} else if (opcao == 2) {
				new PageLogin().executar(scanner);
				System.out.println("Volte Sempre!");
				
				break;
			}

//			System.out.println("Por favor, como posso lhe chamar?");
//			entrada = scanner.next();
//			Usuario usuario = new Usuario(entrada);
			/*
			 * se for funcionario chama o metodo que controla o caixa eletronico vou segyuir
			 * com o fluxo de um cliente cirnaod um 0pedido e efetuando a compra
			 */

			System.out.println("\nOk " + usuario.getNome() + ", selecione a opção desejada:\n");

			System.out.println("Digite 1: saber se temos seu produto em estoque.");

			System.out.println("Digite 2: Ver todos os itens que temos.");

			System.out.println("Digite 3: Ver todos os itens por categoria.");

			System.out.println("Digite 4: Para criar um pedido.\n");

			int primeiraSelecao = scanner.nextInt();

			switch (primeiraSelecao) {
			case 1: {
				new VizualizarProduto().executar(scanner);
				break;
			}
			case 2: {
				new ListaCompletaItensEmEstoque().executar(scanner);
				break;
			}
			case 3: {
				new VerListaCOmpletaDoEstoquePorCategoria().executar(scanner);
				break;
			}
			case 4: {
				new PageFrontCriarPedido().pedidos(usuario, scanner);
				break;
			}
			}

			System.out.println("                                                                   pag 01");
			System.out.println("\nEstamos na tela inicial," + "\nDigite s para sair do progama"
					+ "\nou qualquer outra tecla para iniciar novamente.");
			entrada = scanner.next();
			sair = !entrada.equalsIgnoreCase("s");
		}
	}

}
