package start;
import java.util.Scanner;

import infraestrutura.front.PageFront;

public class ApplicationLivrariaAda {
	public static void main(String[] args) {
		
		PageFront pageFront= new PageFront();
		Scanner scanner= new Scanner(System.in);
		
		pageFront.primeiroContato(scanner);
	}

}
//usuario: yoda@email.com
//funcionario: bob@email.com

//senha: senha


//System.err.println("Voce esta na pagina 01");
//
//Estoque estoque= new Estoque();
//boolean sair= true;
//String opcao="";
//
//while(sair) {
//System.out.println("\n\nDigite s para sair, ou qualquer tecla para vizualizar outro.");
//opcao=scanner.next();
//
//sair= !opcao.equalsIgnoreCase("s");
//}
