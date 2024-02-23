package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosicao;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		List<PecaXadrez> capturadas = new ArrayList<>();

		while(!partida.isCheckMate()) {
			try {
				UI.limpandoTela();
				UI.imprimindoPatida(partida, capturadas);
				System.out.println();
				System.out.print("Origem: ");
				XadrezPosicao origem = UI.lendoPosicao(sc);
				
				boolean[][] movimentosPossiveis  =  partida.movimentosPossiveis(origem);
				UI.limpandoTela();
				UI.imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosicao destino = UI.lendoPosicao(sc);
				
				PecaXadrez cap = partida.movendoPeca(origem, destino);
				
				if(cap != null) {
					capturadas.add(cap);
				}
			}catch(XadrezException xe) {
				System.out.println(xe.getMessage());
				sc.nextLine();
			}catch(InputMismatchException ie) {
				System.out.println(ie.getMessage());
				sc.nextLine();
			}
		}
		
		UI.limpandoTela();
		UI.imprimindoPatida(partida, capturadas);

		
	}

}
