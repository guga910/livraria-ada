package infraestrutura.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dominio.Usuario;
import infraestrutura.acao.login.Roles;

public class UsuarioRepository {

	private List<Usuario> listaDeUsuarios = arquivoUsuarios();

	public void addUsuario(Usuario usuario) {
		this.listaDeUsuarios.add(usuario);
	}

	public List<Usuario> buscarTodosUsuarios() {
		return listaDeUsuarios;
	}

	public Usuario buscarUsuarioPorNome(String nome) {
//		Usuario usuario = this.listaDeUsuarios.stream().filter(u -> u.getNome().equalsIgnoreCase(nome)).findFirst()
//				.get();
		Optional<Usuario> usuario = this.listaDeUsuarios.stream().filter(u -> u.getNome().equalsIgnoreCase(nome))
				.findFirst();

		if (!usuario.isPresent()) {
			System.err.println("Não existe usuario cadastrado com esse nome.");
			return null;
		}

		return usuario.get();
	}

	public Usuario buscarUsuarioPorEmail(String email) {
		Optional<Usuario> usuario = this.listaDeUsuarios.stream().filter(e -> e.getEmail().equalsIgnoreCase(email))
				.findFirst();

		if (!usuario.isPresent()) {
//			System.err.println("Não existe usuario cadastrado com esse email.");
			return null;
		}

		return usuario.get();
	}

	public boolean isFundionario(Usuario usuario) {
		boolean funcionario = usuario.getRoles() == Roles.FUNCIOANRIO;

		if (!funcionario) {
			System.err.println("O Usuario " + usuario.getNome() + " nao é um Funcionario!");
			return false;
		}
		return true;
	}

	public void removerUsuarioPorEmail(String email) {

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			listaDeUsuarios.get(i).getEmail().equalsIgnoreCase(email);
			listaDeUsuarios.remove(i);
		}

	}

	public List<Usuario> arquivoUsuarios() {
		List<Usuario> arquiviUsuario = new ArrayList<>();

		Usuario u1 = new Usuario("Luck", "098-098-098-09", "leia@email.com", "senha");
		Usuario u2 = new Usuario("leia", "098-098-098-09", "leia@email.com", "senha");
		Usuario u3 = new Usuario("yoda", "098-098-098-09", "yoda@email.com", "senha");
		Usuario u4 = new Usuario("bob", "098-098-098-09", "bob@email.com", "senha");
		Usuario seinao = u4.promoverFuncionario(u4);
		arquiviUsuario.add(u1);
		arquiviUsuario.add(u2);
		arquiviUsuario.add(u3);
		arquiviUsuario.add(seinao);

		return arquiviUsuario;
	}

}
