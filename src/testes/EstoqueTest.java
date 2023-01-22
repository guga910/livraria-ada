package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import dominio.pedido.Estoque;
import dominio.pedido.Item;
import dominio.produto.Produto;
import dominio.produto.enun.Categoria;

class EstoqueTest {

	private Estoque estoque = new Estoque();

	@Test
	void deveBuscarProdutoPeloNome() {
		// Cenario:
		String nome = "rAiMuNdos";

		// ação:
		Produto produtoRecuperado = estoque.buscarProdutoPorNome(nome);

		// verificação:
		assertEquals(nome.toUpperCase(), produtoRecuperado.getNome().toUpperCase());
	}

	@Test
	void adicionarProdutoAoEstoque() {
		// Cenario:
		int tamanhoListaPadrao = estoque.recuperarEstoque().size();
		String nome = "Raimundos";
		Produto produto = estoque.buscarProdutoPorNome(nome);
		long quantidade = 1;

		// Ação:
		estoque.addItemEstoque(produto, quantidade);
		int tamanhoListaDepois = estoque.recuperarEstoque().size();

		// Verificação:
		assertEquals(tamanhoListaPadrao + quantidade, tamanhoListaDepois);
	}

	@Test
	void deveTrazerListaPorCategoria() {
		// Cenario:
		String nome = "Raimundos";
		Produto produto = estoque.buscarProdutoPorNome(nome);
		Categoria categoria = produto.getCategoria();

		// Ação:
		List<Produto> listaProduto = estoque.recuperarPorCategoria(categoria);

		// Verificação
		assertEquals(categoria, listaProduto.get(0).getCategoria());
		assertFalse(Categoria.BRINQUEDO == listaProduto.get(0).getCategoria());
	}

	@Test
	void deveReduzirEstoqueDoProduto() {
		// Cenario:

		String nome = "Raimundos";
		Produto produto = estoque.buscarProdutoPorNome(nome);
		Item item = estoque.recuperarEstoque().stream().filter(p -> p.getProduto().equals(produto)).findFirst().get();
		long quantidadeAntes = item.getQuantidade();
		long quantidade = 1;

		// Ação:
		estoque.atualizarEstoque(produto, quantidade);
		long quantidadeDepois = estoque.recuperarEstoque().stream().filter(p -> p.getProduto().equals(produto))
				.findFirst().get().getQuantidade();

		// Verificação:
		assertFalse(quantidadeAntes == quantidadeDepois);
	}

	@Test
	void deveRecuperarItensDoProdutoDoEstoque() {
		// Cenario:
		String nome = "Raimundos";

		// Execução:
		Item item = estoque.recuperaItemDoEstoquePeloNomeDoProduto(nome);

		// Acção:
		assertEquals(nome, item.getProduto().getNome());

	}

}
