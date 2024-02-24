package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.peca.Bispo;
import xadrez.peca.Cavalo;
import xadrez.peca.King;
import xadrez.peca.Peao;
import xadrez.peca.Rainha;
import xadrez.peca.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	private List<Peca> pecasTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	private int turno;
	private Color jogadorAtual;
	private boolean check;
	private boolean checkMate;
	private PecaXadrez enPassantVulneravel;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);

		turno = 1;
		jogadorAtual = Color.WHITE;

		iniciandoPartida();
	}

	public PecaXadrez getEnPassantVulneravel() {
		return enPassantVulneravel;
	}

	public int getTurno() {
		return turno;
	}

	public Color getJogadorAtual() {
		return jogadorAtual;
	}

	public boolean isCheckMate() {
		return checkMate;
	}

	public boolean isCheck() {
		return check;
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
		pecasTabuleiro.add(peca);
	}

	private void iniciandoPartida() {
		/*
		 * TESTE * / colocandoNovaPeca('h', 7, new Torre(tabuleiro, Color.WHITE));
		 * colocandoNovaPeca('d', 1, new Torre(tabuleiro, Color.WHITE));
		 * colocandoNovaPeca('e', 1, new King(tabuleiro, Color.WHITE));
		 * 
		 * colocandoNovaPeca('b', 8, new King(tabuleiro, Color.BLACK));
		 * colocandoNovaPeca('a', 8, new Torre(tabuleiro, Color.BLACK));
		 */

		// PRETO
		colocandoNovaPeca('a', 8, new Torre(tabuleiro, Color.BLACK));
		colocandoNovaPeca('b', 8, new Cavalo(tabuleiro, Color.BLACK));
		colocandoNovaPeca('c', 8, new Bispo(tabuleiro, Color.BLACK));
		colocandoNovaPeca('d', 8, new Rainha(tabuleiro, Color.BLACK));
		colocandoNovaPeca('e', 8, new King(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('f', 8, new Bispo(tabuleiro, Color.BLACK));
		colocandoNovaPeca('g', 8, new Cavalo(tabuleiro, Color.BLACK));
		colocandoNovaPeca('h', 8, new Torre(tabuleiro, Color.BLACK));

		colocandoNovaPeca('a', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('b', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('c', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('d', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('e', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('f', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('g', 7, new Peao(tabuleiro, Color.BLACK, this));
		colocandoNovaPeca('h', 7, new Peao(tabuleiro, Color.BLACK, this));

		// BRANCO
		colocandoNovaPeca('a', 1, new Torre(tabuleiro, Color.WHITE));
		colocandoNovaPeca('b', 1, new Cavalo(tabuleiro, Color.WHITE));
		colocandoNovaPeca('c', 1, new Bispo(tabuleiro, Color.WHITE));
		colocandoNovaPeca('d', 1, new Rainha(tabuleiro, Color.WHITE));
		colocandoNovaPeca('e', 1, new King(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('f', 1, new Bispo(tabuleiro, Color.WHITE));
		colocandoNovaPeca('g', 1, new Cavalo(tabuleiro, Color.WHITE));
		colocandoNovaPeca('h', 1, new Torre(tabuleiro, Color.WHITE));

		colocandoNovaPeca('a', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('b', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('c', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('d', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('e', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('f', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('g', 2, new Peao(tabuleiro, Color.WHITE, this));
		colocandoNovaPeca('h', 2, new Peao(tabuleiro, Color.WHITE, this));

	}

	public PecaXadrez movendoPeca(XadrezPosicao posOri, XadrezPosicao posDes) {
		Posicao origem = posOri.qualPosicao();
		Posicao destino = posDes.qualPosicao();

		validacaoPosicaoOrigem(origem);
		validacaoPosicaoDestino(origem, destino);

		Peca pecaCapturada = movendoPeca(origem, destino);

		if (testeCheck(jogadorAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			throw new XadrezException("Voce nao pode se colocar em Check !");
		}

		PecaXadrez pecaMov = (PecaXadrez) tabuleiro.peca(destino);

		check = (testeCheck(oponente(jogadorAtual))) ? true : false;

		if (testeCheckMate(oponente(jogadorAtual))) {
			checkMate = true;
		} else {
			proximoTurno();
		}

		// Movimento enPassant
		if ((pecaMov instanceof Peao)
				&& ((destino.getLinha() == origem.getLinha() - 2) || (destino.getLinha() == origem.getLinha() + 2))) {
			enPassantVulneravel = pecaMov;
		} else {
			enPassantVulneravel = null;
		}
		
		System.out.println(enPassantVulneravel);

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
		PecaXadrez p = (PecaXadrez) tabuleiro.removePeca(ori);
		Peca cap = tabuleiro.removePeca(des);
		p.aumentandoMov();

		if (cap != null) {
			pecasCapturadas.add(cap);
			pecasTabuleiro.remove(cap);
		}

		tabuleiro.colocarPeca(p, des);

		// Roque Pequeno
		if (p instanceof King && des.getColuna() == ori.getColuna() + 2) {
			Posicao oriT = new Posicao(ori.getLinha(), ori.getColuna() + 3);
			Posicao desT = new Posicao(ori.getLinha(), ori.getColuna() + 1);

			PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(oriT);
			tabuleiro.colocarPeca(torre, desT);
			torre.aumentandoMov();
		}

		// Roque Grande
		if (p instanceof King && des.getColuna() == ori.getColuna() - 2) {
			Posicao oriT = new Posicao(ori.getLinha(), ori.getColuna() - 4);
			Posicao desT = new Posicao(ori.getLinha(), ori.getColuna() - 1);

			PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(oriT);
			tabuleiro.colocarPeca(torre, desT);
			torre.aumentandoMov();
		}

		// enPassant
		if (p instanceof Peao) {
			if (ori.getColuna() != des.getColuna() && cap == null) {
				Posicao peaoCap;
				if (p.getColor() == Color.WHITE) {
					peaoCap = new Posicao(des.getLinha() + 1, des.getColuna());
				} else {
					peaoCap = new Posicao(des.getLinha() - 1, des.getColuna());
				}
				cap = tabuleiro.removePeca(peaoCap);
				pecasCapturadas.add(cap);
				pecasTabuleiro.remove(cap);
			}
		}

		return cap;
	}

	private void desfazerMovimento(Posicao ori, Posicao des, Peca peca) {
		PecaXadrez p = (PecaXadrez) tabuleiro.removePeca(des);
		tabuleiro.colocarPeca(p, ori);
		p.dmininuindoMov();

		if (peca != null) {
			tabuleiro.colocarPeca(peca, des);
			pecasCapturadas.remove(peca);
			pecasTabuleiro.add(peca);
		}

		// Roque Pequeno
		if (p instanceof King && des.getColuna() == ori.getColuna() + 2) {
			Posicao oriT = new Posicao(ori.getLinha(), ori.getColuna() + 3);
			Posicao desT = new Posicao(ori.getLinha(), ori.getColuna() + 1);

			PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(desT);
			tabuleiro.colocarPeca(torre, oriT);
			torre.dmininuindoMov();
		}

		// Roque Grande
		if (p instanceof King && des.getColuna() == ori.getColuna() - 2) {
			Posicao oriT = new Posicao(ori.getLinha(), ori.getColuna() - 4);
			Posicao desT = new Posicao(ori.getLinha(), ori.getColuna() - 1);

			PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(desT);
			tabuleiro.colocarPeca(torre, oriT);
			torre.dmininuindoMov();
		}

		// enPassant
		if (p instanceof Peao) {
			if (ori.getColuna() != des.getColuna() && peca == enPassantVulneravel) {
				
				PecaXadrez peao  = (PecaXadrez)tabuleiro.removePeca(des);
				
				Posicao peaoCap;
				if (p.getColor() == Color.WHITE) {
					peaoCap = new Posicao(3, des.getColuna());
				} else {
					peaoCap = new Posicao(4, des.getColuna());
				}
				
				tabuleiro.colocarPeca(peao, peaoCap);
			}
		}
	}

	public boolean[][] movimentosPossiveis(XadrezPosicao p) {
		Posicao pos = p.qualPosicao();
		validacaoPosicaoOrigem(pos);
		return tabuleiro.peca(pos).movimentosPossiveis();
	}

	private Color oponente(Color cor) {
		return cor == Color.WHITE ? Color.BLACK : Color.WHITE;
	}

	private PecaXadrez rei(Color cor) {
		List<Peca> pecas = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getColor() == cor).toList();
		for (Peca p : pecas) {
			if (p instanceof King) {
				return (PecaXadrez) p;
			}
		}

		throw new IllegalStateException("Não existe rei" + (cor == Color.WHITE ? "BRANCO" : "PRETO") + " !!!");
	}

	private boolean testeCheck(Color cor) {
		Posicao kingPosicao = rei(cor).getXadrezPosicao().qualPosicao();
		List<Peca> oponentePecas = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getColor() == oponente(cor))
				.toList();

		for (Peca p : oponentePecas) {
			boolean[][] mat = p.movimentosPossiveis();

			if (mat[kingPosicao.getLinha()][kingPosicao.getColuna()]) {
				return true;
			}
		}

		return false;
	}

	private boolean testeCheckMate(Color cor) {

		if (!testeCheck(cor)) {
			return false;
		}

		List<Peca> minhasPecas = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getColor() == cor).toList();

		for (Peca p : minhasPecas) {
			boolean[][] mat = p.movimentosPossiveis();

			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (mat[i][j]) {
						Posicao origem = ((PecaXadrez) p).getXadrezPosicao().qualPosicao();
						Posicao destino = new Posicao(i, j);
						Peca pecaCapturada = movendoPeca(origem, destino);
						boolean testCheck = testeCheck(cor);
						desfazerMovimento(origem, destino, pecaCapturada);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

}
