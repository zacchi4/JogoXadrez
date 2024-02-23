package xadrez.peca;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {

	public Cavalo(Tabuleiro tabuleiro, Color color) {
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

		// L ACIMA DIREITA
		p.setValor(posicao.getLinha() - 2, posicao.getColuna() + 1);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L ACIMA ESQUERDA
		p.setValor(posicao.getLinha() - 2, posicao.getColuna() - 1);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L INVERTIDO ESQUERDA
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 2);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L INVERTIDO DIREITA
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 2);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L ABAIXO DIREITA
		p.setValor(posicao.getLinha() + 2, posicao.getColuna() + 1);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L ABAIXO ESQUERDA
		p.setValor(posicao.getLinha() + 2, posicao.getColuna() - 1);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L INVERTIDO ESQUERDA
		p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 2);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// L INVERTIDO DIREITA
		p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 2);

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

	@Override
	public String toString() {
		return "C";
	}

}
