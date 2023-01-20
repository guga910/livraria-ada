package infraestrutura.acao.login;

import dominio.Usuario;
import infraestrutura.repository.UsuarioRepository;

public class Login {
	UsuarioRepository usuarioRepository= new UsuarioRepository();
			
	
	public boolean login(Usuario usuario) {
		Usuario usuarioRegistrado = usuarioRepository.buscarUsuarioPorEmail(usuario.getEmail());
		if(usuarioRegistrado== null) {
			System.err.println("\nUsuario nao registrado!");
			return false;
		}
		
		return true;
	}
	
	public boolean registrar(Usuario usuario) {
		
		Usuario usuarioVerificadoNoBancoDeDados = usuarioRepository.buscarUsuarioPorEmail(usuario.getEmail());
		boolean isEnull = usuarioVerificadoNoBancoDeDados== null;
		if(!isEnull) {
			System.err.println("\nUsuario ja registrado!\nTente novamente...");
			return false;
		}
		
		this.usuarioRepository.addUsuario(usuario);
		System.out.println("\nUsuario cadastrado com sucesso!\n");
		
		return true;
	}
	
	public boolean verificarLimitacaoAcesso(Usuario usuario) {
		
		boolean isFuncionario= usuario.getRoles()== Roles.FUNCIOANRIO;
		if(!isFuncionario) {
			return false;
		}
		return true;
	}

}
