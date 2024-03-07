package Principal;

import InterfaceGrafica.TabuleiroIG;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezException;
import Xadrez.XadrezPosicao;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PartidaXadrez partida = new PartidaXadrez();

        List<PecaXadrez> capturadas = new ArrayList<>();

        TabuleiroIG tab = new TabuleiroIG();

        tab.imprimindoPatida(partida, capturadas);
        tab.setVisible(true);
        
        
        /*
        while (!partida.isCheckMate()) {
            try {
                UI.limpandoTela();
                UI.imprimindoPatida(partida, capturadas);
                System.out.println();
                System.out.print("Origem: ");

                XadrezPosicao origem = tab.lendoPosicao("");

                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
                UI.limpandoTela();
                UI.imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.print("Destino: ");
                XadrezPosicao destino = UI.lendoPosicao(sc);

                PecaXadrez cap = partida.movendoPeca(origem, destino);

                if (cap != null) {
                    capturadas.add(cap);
                }

                if (partida.getPromoted() != null) {
                    System.out.print("Entre com a peca promovida (C {cavalo}, Q {rainha}, T {torre}, B {bispo}): ");
                    String tipo = sc.nextLine().toUpperCase();

                    while (!tipo.equals("B") && !tipo.equals("T") && !tipo.equals("C") && !tipo.equals("Q")) {
                        System.out.println("Atenção, valor inválido, digite novamente!");
                        tipo = sc.nextLine().toUpperCase();
                    }

                    partida.trocandoPecaPromovida(tipo);
                }
            } catch (XadrezException | InputMismatchException xe) {
                System.out.println(xe.getMessage());
                sc.nextLine();
            }
        }
         */
        //UI.limpandoTela();
        //UI.imprimindoPatida(partida, capturadas);
    }
}
