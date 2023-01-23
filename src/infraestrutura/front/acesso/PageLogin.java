package infraestrutura.front.acesso;

import java.util.Scanner;

import dominio.Usuario;
import infraestrutura.acao.Funcao;
import infraestrutura.acao.login.Login;
import infraestrutura.front.caixa.PageCaixa;
import infraestrutura.repository.UsuarioRepository;

public class PageLogin implements Funcao {

	private Login login = new Login();

	@Override
	public void executar(Scanner scanner) {
		UsuarioRepository usuarioRepository = new UsuarioRepository();

		boolean sair = true;
		String opcao = "";

		while (sair) {
			System.out.println("\nOk, vamos lá, digite seu email:");
			String email = opcao = scanner.next();

			System.out.println("\ndigite sua senha:");
			String senha = opcao = scanner.next();

			Usuario usuarioJaRegistrado = usuarioRepository.buscarUsuarioPorEmail(email);
			if (!usuarioJaRegistrado.getSenha().equals(senha)) {
				System.err.println("senha nao cadastrada!");
			}

			boolean deuCerto = login.login(usuarioJaRegistrado);

			if (deuCerto) {
				boolean isFuncionario = login.verificarLimitacaoAcesso(usuarioJaRegistrado);

				if (isFuncionario) {

					new PageCaixa().executar(scanner);

					opcao = "s";
					sair = !opcao.equalsIgnoreCase("s");
					break;
				}
			}
			System.err.println("Algo deu errado,parece que voce nao trabalha mas aqui\njá foi no RH?.");
			System.out.println("\n\nDigite s para sair, ou qualquer tecla para vizualizar outro.");

		}
	}
}
