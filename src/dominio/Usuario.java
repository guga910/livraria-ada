package dominio;

import infraestrutura.acao.login.Roles;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private Roles roles;


	public Usuario(String nome) {
		super();
		this.nome = nome;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String cpf, String email, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.roles= Roles.USER;
	}
	

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Roles getRoles() {
		return roles;
	}
	private void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	public Usuario promoverFuncionario(Usuario usuario) {
//		this.roles= Roles.FUNCIOANRIO;
		 usuario.setRoles(Roles.FUNCIOANRIO);
		 return usuario;
		
	}
	

}
