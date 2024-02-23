package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.peca.King;
import xadrez.peca.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	private int turno;
	private Color jogadorAtual;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);

		turno = 1;
		jogadorAtual = Color.WHITE;

		iniciandoPartida();
	}

	public int getTurno() {
		return turno;
	}

	public Color getJogadorAtual() {
		return jogadorAtual;
	}

	public PecaXadrez[][] getPecas() {

		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}

		return mat;
	}

	private void colocandoNovaPeca(char col, int lin, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(col, lin).qualPosicao());
	}

	private void iniciandoPartida() {
		// BRANCO
		colocandoNovaPeca('a', 8, new Torre(tabuleiro, Color.WHITE));
		colocandoNovaPeca('h', 8, new Torre(tabuleiro, Color.WHITE));

		colocandoNovaPeca('e', 8, new King(tabuleiro, Color.WHITE));

		// PRETO
		colocandoNovaPeca('a', 1, new Torre(tabuleiro, Color.BLACK));
		colocandoNovaPeca('h', 1, new Torre(tabuleiro, Color.BLACK));

		colocandoNovaPeca('e', 1, new King(tabuleiro, Color.BLACK));

	}

	public PecaXadrez movendoPeca(XadrezPosicao posOri, XadrezPosicao posDes) {
		Posicao origem = posOri.qualPosicao();
		Posicao destino = posDes.qualPosicao();

		validacaoPosicaoOrigem(origem);
		validacaoPosicaoDestino(origem, destino);

		Peca pecaCapturada = movendoPeca(origem, destino);
		
		proximoTurno();

		return (PecaXadrez) pecaCapturada;
	}

	private void validacaoPosicaoOrigem(Posicao pos) {
		if (!tabuleiro.temUmaPeca(pos)) {
			throw new XadrezException("Nao temos nenhuma peca nessa posicao ! (validacaoPosicaoOrigem)");
		}
		
		if (jogadorAtual != ((PecaXadrez) tabuleiro.peca(pos)).getColor()) {
			throw new XadrezException("Atenção essa peça não é sua ! (validacaoPosicaoOrigem)");
		}

		if (!tabuleiro.peca(pos).existeMovimentoPossivel()) {
			throw new XadrezException(
					"Nao temos nenhum movimento possivel para a peca selecionada ! (validacaoPosicaoOrigem)");
		}
	}

	private void validacaoPosicaoDestino(Posicao ori, Posicao des) {
		if (!tabuleiro.peca(ori).movimentoPosivel(des)) {
			throw new XadrezException("Peca escolhida nao pode se mover para o destino ! (validacaoPosicaoDestino)");
		}
	}

	private Peca movendoPeca(Posicao ori, Posicao des) {
		Peca p = tabuleiro.removePeca(ori);
		Peca cap = tabuleiro.removePeca(des);

		tabuleiro.colocarPeca(p, des);
		return cap;
	}

	public boolean[][] movimentosPossiveis(XadrezPosicao p) {
		Posicao pos = p.qualPosicao();
		validacaoPosicaoOrigem(pos);
		return tabuleiro.peca(pos).movimentosPossiveis();
	}

	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Color.WHITE) ? Color.BLACK:Color.WHITE;
	}

}
