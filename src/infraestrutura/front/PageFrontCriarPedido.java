package infraestrutura.front;

import java.util.Scanner;

import dominio.Caixa;
import dominio.Usuario;
import dominio.pedido.Estoque;
import dominio.pedido.Pedido;
import infraestrutura.acao.pedido.CriarPedido;
import infraestrutura.acao.pedido.EfetivarCompraPedido;
import infraestrutura.acao.pedido.VizualizacaoPedidoAtual;

public class PageFrontCriarPedido {
	
	protected void pedidos(Usuario usuario, Scanner scanner) {
		Caixa caixa= new Caixa();
		
		Estoque estoque = new Estoque();
		Pedido pedido= new Pedido();
//		pedido.setUsuario(usuario);
		
		boolean sair= true;
		String opcao="";
		System.out.println("\nOla "+usuario.getNome()+" , vamos criar nosso pedido?");
		
		while(sair) {
			
			pedido = new CriarPedido().criarNovoPedido(scanner,usuario);
			System.err.println(pedido);
			
			new EfetivarCompraPedido().efetivarCompra(pedido, caixa, estoque);
			
			new VizualizacaoPedidoAtual().executar(pedido);
			
			System.err.println("PageFrontCriarPedido");
			System.err.println("caixa atual: "+caixa.getDinheiroEmCaixa());


			System.out.println("\n                                                                   pag 05");
			System.out.println("\n\nDigite s voltar ao menu principal,"
					 + "\nou qualquer tecla para vizualizar novamente.");
			opcao=scanner.next();
			
			sair= !opcao.equalsIgnoreCase("s");
		}
		
	}
	

}
