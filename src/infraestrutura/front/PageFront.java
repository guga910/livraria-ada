package infraestrutura.front;

import static utils.CorrecaoDeTipo.isInt;

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
		Usuario usuario = new Usuario();
		System.out.println(
				"Seja bem vindo a Livraria Ada,\n    Mesmo se aqui voce não comprar, a gente vai te abraçar!\n");

		while (sair) {

			System.out.println("Digite 1 para Novo registro\nou 2 para se Logar.");
			int opcao = 0;
			opcao = isInt(scanner);

			if (opcao == 1) {

				usuario = new PageRegistro().executar(scanner);

			} else if (opcao == 2) {
				new PageLogin().executar(scanner);
				System.out.println("Volte Sempre!");

				break;
			}
			System.out.println("\nOk " + usuario.getNome() + ", selecione a opção desejada:\n");

			System.out.println("Digite 1: saber se temos seu produto em estoque.");

			System.out.println("Digite 2: Ver todos os itens que temos.");

			System.out.println("Digite 3: Ver todos os itens por categoria.");

			System.out.println("Digite 4: Para criar um pedido.\n");

			int primeiraSelecao = isInt(scanner);

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

	public static void start() {
		PageFront pageFront = new PageFront();
		Scanner scanner = new Scanner(System.in);
		pageFront.primeiroContato(scanner);
	}

}
