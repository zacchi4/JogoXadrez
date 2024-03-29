package Principal;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Xadrez.Color;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezPosicao;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprirPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h ");
	}

	public static void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] movPos) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprirPeca(pecas[i][j], movPos[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h ");
	}

	public static void imprimindoPatida(PartidaXadrez partida, List<PecaXadrez> caps) {
		imprimirTabuleiro(partida.getPecas());
		System.out.println();
		imprimirPecasCapturadas(caps);
		System.out.println();
		System.out.println("Turno: " + partida.getTurno());

		if (!partida.isCheckMate()) {
			System.out
					.println("Aguardando Jogador: " + (partida.getJogadorAtual() == Color.WHITE ? "BRANCO" : "PRETO"));

			if (partida.isCheck()) {
				System.out.println(ANSI_RED);
				System.out.println("CHECK !");
				System.out.println(ANSI_RESET);
			}
		} else {
			System.out.println(ANSI_GREEN);
			System.out.println("CHECK MATE!");
			System.out.println("VENCEDOR: " + (partida.getJogadorAtual() == Color.WHITE ? "BRANCO" : "PRETO"));
			System.out.println(ANSI_RESET);
		}
	}

	private static void imprirPeca(PecaXadrez peca, boolean background) {

		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}

		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peca.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	public static XadrezPosicao lendoPosicao(Scanner sc) {
		try {
			String s = sc.nextLine();
			char col = s.charAt(0);
			int lin = Integer.parseInt(s.substring(1));
			return new XadrezPosicao(col, lin);
		} catch (RuntimeException ie) {
			throw new InputMismatchException("Erro lendo posicao de xadrez, valores validos sao de a1 ate h8 !");
		}
	}

	public static void limpandoTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void imprimirPecasCapturadas(List<PecaXadrez> capturadas) {
		List<PecaXadrez> brancas = capturadas.stream().filter(x -> x.getColor() == Color.WHITE)
				.collect(Collectors.toList());
		List<PecaXadrez> pretas = capturadas.stream().filter(x -> x.getColor() == Color.BLACK)
				.collect(Collectors.toList());

		System.out.println("Pecas Capturadas: ");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(brancas.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Pretos: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(pretas.toArray()));
		System.out.print(ANSI_RESET);
	}
}
