package infraestrutura.acao.caixa;

import dominio.Caixa;
import infraestrutura.repository.PedidoRepositoryImplementacao;

public class CaixaService {
	
	
	private PedidoRepositoryImplementacao pedidoRepository= new PedidoRepositoryImplementacao();
	private Caixa caixa= new Caixa();
	
	
	public PedidoRepositoryImplementacao acessoPedidoRepository() {
		return pedidoRepository;
	}
	public Caixa acessoCaixa() {
		return caixa;
	}
	

}
