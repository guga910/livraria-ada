package utils;

import static java.lang.Character.isLetter;

import java.util.Scanner;

public class CorrecaoDeTipo {

	public static int isInt(Scanner scanner) {
		String valorRecebido = "";
		try {

			boolean sair = true;

			while (sair) {
				valorRecebido = scanner.next();

				char[] array = valorRecebido.toCharArray();
				if (!isLetter(array[0])) {
					sair = false;
				}
				if (sair) {
					System.err.println("Nao pode ser texto, só numeros, tente novamente:");
				}
			}
			return Integer.valueOf(valorRecebido);

		} catch (Exception e) {

		}
		return Integer.valueOf(valorRecebido);
	}

}
