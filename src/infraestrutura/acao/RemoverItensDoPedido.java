package infraestrutura.acao;

import java.util.Scanner;

public class RemoverItensDoPedido implements Funcao{

	@Override
	public void executar(Scanner scanner) {
		boolean sair= false;
		String entrada =scanner.next();
		while(sair) {
			System.out.println("Digite o nome do item que voce deseja remover: ");
			entrada =scanner.next();
			
			
			
			
			System.out.println("Digite \"s\" para sair.");
			entrada = scanner.next();

			sair = !entrada.equals("s");
		}

		
		
	}

}
