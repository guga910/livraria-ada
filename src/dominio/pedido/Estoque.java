package dominio.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dominio.produto.AlbumDeMusica;
import dominio.produto.Livro;
import dominio.produto.Produto;
import dominio.produto.enun.Categoria;
import dominio.produto.enun.Genero;

public class Estoque {

	private List<Item> listaItens = arquivo();

	public List<Item> recuperarEstoque() {
		return this.listaItens;
	}
	
		
	public void mostrarProdutosDoEstoque() {
		
		listaItens.stream().forEach(nomeProdutos-> 
		System.out.println("O produto: "+nomeProdutos.getProduto().getNome()));
	}

	public void addItemEstoque(Produto produto, long qnt) {
		listaItens.add(new Item(qnt, produto));
	}

	public List<Produto> recuperarPorCategoria(Categoria categoria) {

		List<Item> itens = listaItens.stream().filter(c -> c.getProduto().getCategoria().equals(categoria)).toList();

		List<Produto> produtos = itens.stream().map(p -> p.getProduto()).toList();
		return produtos;
	}

	public Produto buscarProdutoPorNome(String nome) {
		Produto produtoEscolhido = this.listaItens.stream()
				  .filter(i-> i.getProduto().getNome()
						  .equalsIgnoreCase(nome))
				  .map(p-> p.getProduto())
				  .findFirst()
				  .orElseThrow(()-> new RuntimeException("Produto nao foi encontrado."));
		  
		  
		
		return produtoEscolhido;
	}
	
	
	
	public void atualizarEstoque(Produto produto, long quantidade) {
		
		for (Item item : listaItens) {
			if(item.getProduto().equals(produto)) {
				
				long atual = item.getQuantidade();
				item.setQuantidade(atual-quantidade);
			}
		}
		
	}
	
	public void quantosItensDoProdutoTemEmEstoque(String	nome) {
		Produto prod = buscarProdutoPorNome(nome);
		Item itemBuscado = recuperarEstoque().stream()
		.filter(p-> p.getProduto().equals(prod))
		.findFirst().get();
		
		String texto= "Voce escolheu o produto "+itemBuscado.getProduto().getNome()+
				" que custa R$: "+itemBuscado.getProduto().getPreco()+
				" e ainda temos "+itemBuscado.getQuantidade()+" dele no estoque.";
		System.out.println(texto);
	}
	public Item recuperaItemDoEstoquePeloNomeDoProduto(String	nome) {
		Produto prod = buscarProdutoPorNome(nome);
		Item itemBuscado = recuperarEstoque().stream()
				.filter(p-> p.getProduto().equals(prod))
				.findFirst().get();
		return itemBuscado;
	}
	
	
	
	

	private List<Item> arquivo() {
		List<Item> itens = new ArrayList<>();

		AlbumDeMusica lavouTaNovo = new AlbumDeMusica("Raimundos", new BigDecimal(20.90), "Raimundos", Genero.MUSICA,
				"18+");
		itens.add(new Item(10, lavouTaNovo));

		AlbumDeMusica santaGeracao = new AlbumDeMusica("Santa_geracao", new BigDecimal(27.90), "Santa geracao",
				Genero.MUSICA, "gospel");
		itens.add(new Item(10, santaGeracao));
		AlbumDeMusica fernandinho = new AlbumDeMusica("Fernandinho", new BigDecimal(29.90), "fernandinho",
				Genero.MUSICA, "gospel");
		itens.add(new Item(10, fernandinho));

		Livro aprenderAProgamar = new Livro("aprenderAProgamar", new BigDecimal(70.90), Genero.PROGAMACAO,
				"ERIC FREEMAN", "ALTA BOOKS");
		itens.add(new Item(10, aprenderAProgamar));
		Livro cleancode = new Livro("Clean_Code", new BigDecimal(90.90), Genero.PROGAMACAO, "ERIC FREEMAN",
				"ALTA BOOKS");
		itens.add(new Item(10, cleancode));
		Livro cleancode2 = new Livro("Padrao_de_projetos", new BigDecimal(170.90), Genero.PROGAMACAO, "ERIC GAMMA",
				"ALTA BOOKS");
		itens.add(new Item(10, cleancode2));
		Livro puroESimples = new Livro("Cristianismo_Puro_e_Simples", new BigDecimal(30.90), Genero.CRISTA,
				"C.S. Lewis", "Martins Fontes");
		itens.add(new Item(10, puroESimples));

		return itens;
	}

}
