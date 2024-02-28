package Xadrez;

import Tabuleiro.Posicao;

public class XadrezPosicao {

	private char coluna;
	private int linha;
	
	public XadrezPosicao(char coluna, int linha) {
		
		if(coluna < 'a' || coluna > 'h') {
			throw new XadrezException("Atencao coluna inexistente no tabuleiro (a até h)!");
		}
		
		if(linha < 1 || linha > 8) {
			throw new XadrezException("Atencao linha inexistente no tabuleiro (1 até 8)!");
		}
		
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	protected Posicao qualPosicao() {
		return new Posicao(8-linha,  coluna - 'a');
	}
	
	protected static XadrezPosicao paraPosicao(Posicao pos) {
		return new XadrezPosicao((char)('a' + pos.getColuna()), 8 - pos.getLinha());
	}

	@Override
	public String toString() {
		return ""+coluna+linha;
	}
}
