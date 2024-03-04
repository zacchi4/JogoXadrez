package Tabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private final Tabuleiro tabuleiro;

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
		
            for (boolean[] mat1 : mat) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat1[j]) {
                        return true;
                    }
                }
            }

		return false;
	}
}
