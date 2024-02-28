package Xadrez.peca;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {

	public Bispo(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	private boolean podeMover(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec == null || pec.getColor() != getColor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean mat[][] = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// ACIMA DIREITA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() - 1, p.getColuna() - 1);
		}

		// ACIMA ESQUERDA

		p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() + 1, p.getColuna() + 1);
		}

		// ABAIXO DIREITA

		p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() + 1, p.getColuna() - 1);
		}

		// ABAIXO ESQUERDA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() - 1, p.getColuna() + 1);
		}

		return mat;
	}

	@Override
	public String toString() {
		return "B";
	}

}
