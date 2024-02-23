package tabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public abstract boolean[][] movimentosPossiveis();

	public boolean movimentoPosivel(Posicao pos) {
		return movimentosPossiveis()[pos.getLinha()][pos.getColuna()];
	}

	public boolean existeMovimentoPossivel() {
		boolean[][] mat = movimentosPossiveis();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}

		return false;
	}
}
