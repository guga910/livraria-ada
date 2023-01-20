package infraestrutura.front.acesso;

import java.util.Scanner;

import dominio.Usuario;
import infraestrutura.acao.login.Login;

public class PageRegistro {
	private Login login = new Login();
//	UsuarioRepository rp= new UsuarioRepository();

	public Usuario executar(Scanner scanner) {
//		System.err.println("Voce esta na pagina 01");
		boolean sair = true;
		String opcao = "";
		Usuario usuario = new Usuario();
		while (sair) {

			System.out.println("Vamos lá, digite seu nome:");
			String nome = scanner.next();

			System.out.println("\ndigite seu cpf:");
			String cpf = scanner.next();

			System.out.println("\ndigite seu email:");
			String email = scanner.next();

			System.out.println("\ndigite sua senha:");
			String senha = scanner.next();

			usuario = new Usuario(nome, cpf, email, senha);
			boolean deuCerto = login.registrar(usuario);

			if (deuCerto) {
				opcao = "s";
			}

			sair = !opcao.equalsIgnoreCase("s");
		}
		return usuario;
	}

}
