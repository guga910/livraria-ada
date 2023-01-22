package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import dominio.pedido.Pedido;
import infraestrutura.repository.PedidoRepositoryImpl;

class PedidoRepositoryImplTest {
	
	PedidoRepositoryImpl pedidoRepository= new PedidoRepositoryImpl();

	
	@Test
	void deveRemoverItensDoPedidoBaseadoNoNomeDoProduto(){
		
		Pedido pedido = pedidoRepository.recuperarPedido().get(0);
		String nomeProdutoRemovido = pedido.getItens().get(0).getProduto().getNome();
		int tamanhoListaDeItens = pedido.getItens().size();
		
		pedidoRepository.removerItemNomeProduto(pedido, nomeProdutoRemovido);
		int tamanhoListaComItemRemovido = pedido.getItens().size();
		
		assertEquals(tamanhoListaDeItens, tamanhoListaComItemRemovido);
		assertNotEquals(tamanhoListaDeItens, tamanhoListaComItemRemovido);
		
	}

}
