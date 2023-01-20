package infraestrutura.acao;

import java.util.List;
import java.util.Scanner;

import dominio.pedido.Estoque;
import dominio.produto.Produto;
import dominio.produto.enun.Categoria;

public class VerListaCOmpletaDoEstoquePorCategoria implements Funcao{

	@Override
	public void executar(Scanner scanner) {

		Estoque estoque= new Estoque();
		boolean sair= true;
		String opcao="";
		
		while(sair) {
			System.out.println("\nOlá, seja bem vindo, qual categoria de produtos voce quer consultar:");
			System.out.println();
			for(Categoria ct : Categoria.values()) {
				System.out.println("Categoria: "+ct);
			}
			System.out.println("\nPode digitar:\n");
			String categoria = scanner.next();
			
			System.out.println();
			List<Produto> listaCategoria = estoque.mostrarPorCategoria(Categoria.valueOf(categoria.toUpperCase()));
			listaCategoria.forEach(p->{
				System.out.println(p.getNome()+" R$: "+p.getPreco());
			});
			
			System.out.println("\n                                                                   pag 04");
			System.out.println("\n\nDigite s voltar ao menu principal,"
					 + "\nou qualquer tecla para vizualizar novamente.");
			opcao=scanner.next();
			
			sair= !opcao.equalsIgnoreCase("s");
		}
		
	
	}
	public void mostrarPorCategoria(Scanner scanner, Estoque estoque) {
		System.out.println();
		for(Categoria ct : Categoria.values()) {
			System.out.println("Categoria: "+ct);
		}
		System.out.println("\nPode digitar:\n");
		String categoria = scanner.next();
		
		System.out.println();
		List<Produto> listaCategoria = estoque.mostrarPorCategoria(Categoria.valueOf(categoria.toUpperCase()));
		listaCategoria.forEach(p->{
			System.out.println(p.getNome()+" R$: "+p.getPreco());
		});
		
	}

}
