package infraestrutura.acao.caixa;

import dominio.Caixa;
import infraestrutura.repository.PedidoRepositoryImpl;

public class CaixaService {
	
	
	private PedidoRepositoryImpl pedidoRepository= new PedidoRepositoryImpl();
	private Caixa caixa= new Caixa();
	
	
	public PedidoRepositoryImpl acessoPedidoRepository() {
		return pedidoRepository;
	}
	public Caixa acessoCaixa() {
		return caixa;
	}
	

}
