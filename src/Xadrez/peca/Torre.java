package Xadrez.peca;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean mat[][] = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// ACIMA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna());

		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}

		if (getTabuleiro().existePosicao(p) && pecaOponentePosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// ABAIXO

		p.setValor(posicao.getLinha() + 1, posicao.getColuna());

		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}

		if (getTabuleiro().existePosicao(p) && pecaOponentePosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// DIREITA

		p.setValor(posicao.getLinha(), posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}

		if (getTabuleiro().existePosicao(p) && pecaOponentePosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// ESQUERDA

		p.setValor(posicao.getLinha(), posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}

		if (getTabuleiro().existePosicao(p) && pecaOponentePosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
