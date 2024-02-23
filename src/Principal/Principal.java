package principal;

import java.util.Scanner;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezPosicao;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();

		while(true) {
			UI.imprimirTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			XadrezPosicao origem = UI.lendoPosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			XadrezPosicao destino = UI.lendoPosicao(sc);
			
			PecaXadrez cap = partida.movendoPeca(origem, destino);
		}
		
		
		
	}

}
