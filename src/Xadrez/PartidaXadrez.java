package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.peca.King;
import xadrez.peca.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciandoPartida();
	}
	
	public PecaXadrez[][] getPecas(){
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int i = 0; i<tabuleiro.getLinhas();i++) {
			for (int j = 0; j<tabuleiro.getColunas();j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		
		return mat;
	}
	
	private void colocandoNovaPeca(char col, int lin, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(col, lin).qualPosicao());
	}
	
	private void iniciandoPartida() {
		//BRANCO		
		colocandoNovaPeca('a', 8, new Torre(tabuleiro, Color.WHITE));
		colocandoNovaPeca('h', 8, new Torre(tabuleiro, Color.WHITE));
		
		colocandoNovaPeca('e', 8, new King(tabuleiro, Color.WHITE));
		
		//PRETO
		colocandoNovaPeca('a', 1, new Torre(tabuleiro, Color.BLACK));
		colocandoNovaPeca('h', 1, new Torre(tabuleiro, Color.BLACK));
		
		colocandoNovaPeca('e', 1, new King(tabuleiro, Color.BLACK));

	}

	public PecaXadrez movendoPeca(XadrezPosicao posOri, XadrezPosicao posDes) {
		Posicao origem = posOri.qualPosicao();
		Posicao destino = posDes.qualPosicao();
		
		validacaoPosicaoOrigem(origem);
		
		Peca pecaCapturada = movendoPeca(origem, destino);
		
		return (PecaXadrez) pecaCapturada;
	}
	
	private void validacaoPosicaoOrigem(Posicao pos) {
		if(!tabuleiro.temUmaPeca(pos)) {
			throw new XadrezException("Nao temos nenhuma peca nessa posicao !");
		}
		
		if(!tabuleiro.peca(pos).existeMovimentoPossivel()) {
			throw new XadrezException("Nao temos nenhum movimento possivel para a peca selecionada !");
		}
	}
	
	private Peca movendoPeca (Posicao ori, Posicao des) {
		Peca p = tabuleiro.removePeca(ori);
		Peca cap = tabuleiro.removePeca(des);
		
		tabuleiro.colocarPeca(p, des);
		return cap;
	}
	
}
