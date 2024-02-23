package Principal;

import Xadrez.PecaXadrez;

public class UI {

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i<pecas.length;i++) {
			System.out.print((8-i)+" ");
			for (int j = 0; j<pecas.length;j++) {
				imprirPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h ");
	}
	
	private static void imprirPeca(PecaXadrez peca) {
		if(peca == null) {
			System.out.print("-");
		}else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}
	
}
