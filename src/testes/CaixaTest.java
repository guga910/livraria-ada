package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import dominio.Caixa;
import dominio.Usuario;
import dominio.pedido.Item;
import dominio.pedido.Pedido;
import dominio.produto.Produto;

class CaixaTest {

	private Caixa caixa = new Caixa();

	@Test
	void deveDiminuirAQuantidadeDosValoresNoEstoqueAoEfetivarCompra() {
		caixa.getDinheiroEmCaixa();
		BigDecimal valorAntes = caixa.getDinheiro();
		Produto produto = caixa.getEstoque().buscarProdutoPorNome("Raimundos");
		Pedido pedido= new Pedido(new Usuario("bob"), List.of(new Item(1, produto)));
		
		caixa.efetivarCompra(pedido);
		BigDecimal valorDepois = caixa.getDinheiro();
//		2233.40
		
		assertNotEquals(valorAntes, valorDepois);
		assertEquals(valorAntes.add(pedido.getValorTotal()), valorDepois);

	}
	
	@Test
	void deveAdicionarDinheiroEmCaixa() {
		BigDecimal valorEmCaixa = caixa.getDinheiro();
		
		BigDecimal caixaDepois = caixa.adicionarDinheiro(new BigDecimal("20.00"));
		
		assertNotEquals(valorEmCaixa, caixaDepois);
		
	}

}
