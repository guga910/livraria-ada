package infraestrutura.front.caixa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import infraestrutura.acao.Funcao;
import infraestrutura.acao.caixa.CaixaService;

public class PageCaixa implements Funcao {
	private CaixaService caixaService = new CaixaService();

	@Override
	public void executar(Scanner scanner) {

		boolean sair = true;
		String opcao = "";

		while (sair) {

			System.out.println("\nOla amigo, digite a opção desejada:\n");
			System.out.println("\n Digite s para sair, ou qualquer tecla para continuar.");
			opcao = scanner.next();
			if(opcao.equalsIgnoreCase("s")) {
				sair= false;
				break;
			}
			System.out.println("\nDigite 1: Ver valor vendido hoje.");
			System.out.println("Digite  2: Mostrar ultimos pedidos.");
			System.out.println("Digite 3: mostrar Pedidos de hoje.");
			System.out.println("Digite 4: Total vendido hoje.\n");

			int selecao = scanner.nextInt();
			switch (selecao) {
			case 1: {
				caixaService.acessoCaixa().mostarDinheiroEmCaixaHoje();
				break;
			}
			case 2: {
				caixaService.acessoPedidoRepository().mostrarUltimosPedidos();
				break;

			}
			case 3: {
				caixaService.acessoPedidoRepository().mostrarPedidosDia(LocalDate.now());
				break;
			}
			case 4: {
				BigDecimal totalVendidoDoDia = caixaService.acessoPedidoRepository().totalVendidoDoDia(LocalDate.now());
				System.out.println("Total vendido no dia de hoje: " + totalVendidoDoDia);
			}

			
//			default:
//			}

		}}

	}
}
