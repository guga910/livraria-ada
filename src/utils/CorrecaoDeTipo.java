package utils;

import java.util.Scanner;

public class CorrecaoDeTipo {

	public static String string(Scanner scanner) {
		String test = "";
		try {

			test = scanner.next();
			System.out.println(test);
		} catch (Exception e) {
			boolean sair = true;
			System.err.println("tem que ser texto!");
			while (sair) {

				if (test == null) {
					System.out.println("teste nao foi nulo");
					test = scanner.next();
					sair = false;

				}
			}
			return test;
		}

		return test;
	}
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("digite um texto: ");
		String texto = string(scanner);
		
		System.out.println("Ta aqui seu texto: "+texto);
	}

}
