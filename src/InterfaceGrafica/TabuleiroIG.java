package InterfaceGrafica;

import Xadrez.Color;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezPosicao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TabuleiroIG extends javax.swing.JFrame {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private XadrezPosicao origem;
    private PartidaXadrez partida;

    private boolean jogadas = true;
    private boolean jogou = false;

    public TabuleiroIG() {
        initComponents();
        this.voltandoBackground();
    }

    private Icon criandoImagem(String tipo) throws IOException {

        Icon img;

        BufferedImage bImg;

        switch (tipo) {
            case "bB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\bispoBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "bP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\bispoPreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "tB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\torreBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "tP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\torrePreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "cB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\cavaloBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "cP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\cavaloPreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "kB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\reiBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "kP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\reiPreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "qB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\rainhaBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "qP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\rainhaPreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "pB" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\peaoBranco_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "pP" -> {
                bImg = ImageIO.read(new File("C:\\Users\\zacch\\Documents\\workspaces\\java-curso\\JogoXadrez\\images\\peaoPreto_vetor.png"));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            default -> {
                img = null;
            }
        }

        return img;
    }

    private String retornandoPosicaoXadrez(int lin, int col) {
        String retorno;

        switch (lin) {
            case 1 ->
                retorno = "A";
            case 2 ->
                retorno = "B";
            case 3 ->
                retorno = "C";
            case 4 ->
                retorno = "D";
            case 5 ->
                retorno = "E";
            case 6 ->
                retorno = "F";
            case 7 ->
                retorno = "G";
            case 8 ->
                retorno = "H";
            default ->
                retorno = "";
        }

        return retorno + String.valueOf(col);
    }

    private String retornandoPosicaoTabuleiro(int lin, String col) {
        String retorno;

        col = col.toUpperCase();

        switch (lin) {
            case 1 ->
                retorno = "A";
            case 2 ->
                retorno = "B";
            case 3 ->
                retorno = "C";
            case 4 ->
                retorno = "D";
            case 5 ->
                retorno = "E";
            case 6 ->
                retorno = "F";
            case 7 ->
                retorno = "G";
            case 8 ->
                retorno = "H";
            default ->
                retorno = "";
        }

        retorno = switch (col) {
            case "A" ->
                retorno + "1";
            case "B" ->
                retorno + "2";
            case "C" ->
                retorno + "3";
            case "D" ->
                retorno + "4";
            case "E" ->
                retorno + "5";
            case "F" ->
                retorno + "6";
            case "G" ->
                retorno + "7";
            case "H" ->
                retorno + "8";

            default ->
                "";
        };

        return retorno;
    }

    private void setandoImgBotao(Icon img, String posicao) {

        posicao = posicao.toUpperCase();

        switch (posicao) {
            case "A1" -> {
                jButtonA1.setIcon(img);
                break;
            }
            case "A2" -> {
                jButtonB1.setIcon(img);
                break;
            }
            case "A3" -> {
                jButtonC1.setIcon(img);
                break;
            }
            case "A4" -> {
                jButtonD1.setIcon(img);
                break;
            }
            case "A5" -> {
                jButtonE1.setIcon(img);
                break;
            }
            case "A6" -> {
                jButtonF1.setIcon(img);
                break;
            }
            case "A7" -> {
                jButtonG1.setIcon(img);
                break;
            }
            case "A8" -> {
                jButtonH1.setIcon(img);
                break;
            }
            case "B1" -> {
                jButtonA2.setIcon(img);
                break;
            }
            case "B2" -> {
                jButtonB2.setIcon(img);
                break;
            }
            case "B3" -> {
                jButtonC2.setIcon(img);
                break;
            }
            case "B4" -> {
                jButtonD2.setIcon(img);
                break;
            }
            case "B5" -> {
                jButtonE2.setIcon(img);
                break;
            }
            case "B6" -> {
                jButtonF2.setIcon(img);
                break;
            }
            case "B7" -> {
                jButtonG2.setIcon(img);
                break;
            }
            case "B8" -> {
                jButtonH2.setIcon(img);
                break;
            }
            case "C1" -> {
                jButtonA3.setIcon(img);
                break;
            }
            case "C2" -> {
                jButtonB3.setIcon(img);
                break;
            }
            case "C3" -> {
                jButtonC3.setIcon(img);
                break;
            }
            case "C4" -> {
                jButtonD3.setIcon(img);
                break;
            }
            case "C5" -> {
                jButtonE3.setIcon(img);
                break;
            }
            case "C6" -> {
                jButtonF3.setIcon(img);
                break;
            }
            case "C7" -> {
                jButtonG3.setIcon(img);
                break;
            }
            case "C8" -> {
                jButtonH3.setIcon(img);
                break;
            }
            case "D1" -> {
                jButtonA4.setIcon(img);
                break;
            }
            case "D2" -> {
                jButtonB4.setIcon(img);
                break;
            }
            case "D3" -> {
                jButtonC4.setIcon(img);
                break;
            }
            case "D4" -> {
                jButtonD4.setIcon(img);
                break;
            }
            case "D5" -> {
                jButtonE4.setIcon(img);
                break;
            }
            case "D6" -> {
                jButtonF4.setIcon(img);
                break;
            }
            case "D7" -> {
                jButtonG4.setIcon(img);
                break;
            }
            case "D8" -> {
                jButtonH4.setIcon(img);
                break;
            }
            case "E1" -> {
                jButtonA5.setIcon(img);
                break;
            }
            case "E2" -> {
                jButtonB5.setIcon(img);
                break;
            }
            case "E3" -> {
                jButtonC5.setIcon(img);
                break;
            }
            case "E4" -> {
                jButtonD5.setIcon(img);
                break;
            }
            case "E5" -> {
                jButtonE5.setIcon(img);
                break;
            }
            case "E6" -> {
                jButtonF5.setIcon(img);
                break;
            }
            case "E7" -> {
                jButtonG5.setIcon(img);
                break;
            }
            case "E8" -> {
                jButtonH5.setIcon(img);
                break;
            }
            case "F1" -> {
                jButtonA6.setIcon(img);
                break;
            }
            case "F2" -> {
                jButtonB6.setIcon(img);
                break;
            }
            case "F3" -> {
                jButtonC6.setIcon(img);
                break;
            }
            case "F4" -> {
                jButtonD6.setIcon(img);
                break;
            }
            case "F5" -> {
                jButtonE6.setIcon(img);
                break;
            }
            case "F6" -> {
                jButtonF6.setIcon(img);
                break;
            }
            case "F7" -> {
                jButtonG6.setIcon(img);
                break;
            }
            case "F8" -> {
                jButtonH6.setIcon(img);
                break;
            }
            case "G1" -> {
                jButtonA7.setIcon(img);
                break;
            }
            case "G2" -> {
                jButtonB7.setIcon(img);
                break;
            }
            case "G3" -> {
                jButtonC7.setIcon(img);
                break;
            }
            case "G4" -> {
                jButtonD7.setIcon(img);
                break;
            }
            case "G5" -> {
                jButtonE7.setIcon(img);
                break;
            }
            case "G6" -> {
                jButtonF7.setIcon(img);
                break;
            }
            case "G7" -> {
                jButtonG7.setIcon(img);
                break;
            }
            case "G8" -> {
                jButtonH7.setIcon(img);
                break;
            }
            case "H1" -> {
                jButtonA8.setIcon(img);
                break;
            }
            case "H2" -> {
                jButtonB8.setIcon(img);
                break;
            }
            case "H3" -> {
                jButtonC8.setIcon(img);
                break;
            }
            case "H4" -> {
                jButtonD8.setIcon(img);
                break;
            }
            case "H5" -> {
                jButtonE8.setIcon(img);
                break;
            }
            case "H6" -> {
                jButtonF8.setIcon(img);
                break;
            }
            case "H7" -> {
                jButtonG8.setIcon(img);
                break;
            }
            case "H8" -> {
                jButtonH8.setIcon(img);
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Posição (" + posicao + ") não encontrada !");
            }
        }
    }

    private void voltandoBackground() {
        jButtonA1.setBackground(java.awt.Color.white);
        jButtonA2.setBackground(java.awt.Color.lightGray);
        jButtonA3.setBackground(java.awt.Color.white);
        jButtonA4.setBackground(java.awt.Color.lightGray);
        jButtonA5.setBackground(java.awt.Color.white);
        jButtonA6.setBackground(java.awt.Color.lightGray);
        jButtonA7.setBackground(java.awt.Color.white);
        jButtonA8.setBackground(java.awt.Color.lightGray);

        jButtonB1.setBackground(java.awt.Color.lightGray);
        jButtonB2.setBackground(java.awt.Color.white);
        jButtonB3.setBackground(java.awt.Color.lightGray);
        jButtonB4.setBackground(java.awt.Color.white);
        jButtonB5.setBackground(java.awt.Color.lightGray);
        jButtonB6.setBackground(java.awt.Color.white);
        jButtonB7.setBackground(java.awt.Color.lightGray);
        jButtonB8.setBackground(java.awt.Color.white);

        jButtonC1.setBackground(java.awt.Color.white);
        jButtonC2.setBackground(java.awt.Color.lightGray);
        jButtonC3.setBackground(java.awt.Color.white);
        jButtonC4.setBackground(java.awt.Color.lightGray);
        jButtonC5.setBackground(java.awt.Color.white);
        jButtonC6.setBackground(java.awt.Color.lightGray);
        jButtonC7.setBackground(java.awt.Color.white);
        jButtonC8.setBackground(java.awt.Color.lightGray);

        jButtonD1.setBackground(java.awt.Color.lightGray);
        jButtonD2.setBackground(java.awt.Color.white);
        jButtonD3.setBackground(java.awt.Color.lightGray);
        jButtonD4.setBackground(java.awt.Color.white);
        jButtonD5.setBackground(java.awt.Color.lightGray);
        jButtonD6.setBackground(java.awt.Color.white);
        jButtonD7.setBackground(java.awt.Color.lightGray);
        jButtonD8.setBackground(java.awt.Color.white);

        jButtonE1.setBackground(java.awt.Color.white);
        jButtonE2.setBackground(java.awt.Color.lightGray);
        jButtonE3.setBackground(java.awt.Color.white);
        jButtonE4.setBackground(java.awt.Color.lightGray);
        jButtonE5.setBackground(java.awt.Color.white);
        jButtonE6.setBackground(java.awt.Color.lightGray);
        jButtonE7.setBackground(java.awt.Color.white);
        jButtonE8.setBackground(java.awt.Color.lightGray);

        jButtonF1.setBackground(java.awt.Color.lightGray);
        jButtonF2.setBackground(java.awt.Color.white);
        jButtonF3.setBackground(java.awt.Color.lightGray);
        jButtonF4.setBackground(java.awt.Color.white);
        jButtonF5.setBackground(java.awt.Color.lightGray);
        jButtonF6.setBackground(java.awt.Color.white);
        jButtonF7.setBackground(java.awt.Color.lightGray);
        jButtonF8.setBackground(java.awt.Color.white);

        jButtonG1.setBackground(java.awt.Color.white);
        jButtonG2.setBackground(java.awt.Color.lightGray);
        jButtonG3.setBackground(java.awt.Color.white);
        jButtonG4.setBackground(java.awt.Color.lightGray);
        jButtonG5.setBackground(java.awt.Color.white);
        jButtonG6.setBackground(java.awt.Color.lightGray);
        jButtonG7.setBackground(java.awt.Color.white);
        jButtonG8.setBackground(java.awt.Color.lightGray);

        jButtonH1.setBackground(java.awt.Color.lightGray);
        jButtonH2.setBackground(java.awt.Color.white);
        jButtonH3.setBackground(java.awt.Color.lightGray);
        jButtonH4.setBackground(java.awt.Color.white);
        jButtonH5.setBackground(java.awt.Color.lightGray);
        jButtonH6.setBackground(java.awt.Color.white);
        jButtonH7.setBackground(java.awt.Color.lightGray);
        jButtonH8.setBackground(java.awt.Color.white);
    }

    private void setandoBackBotao(String posicao) {

        posicao = posicao.toUpperCase();

        System.out.println(posicao);

        switch (posicao) {
            case "A1" -> {
                jButtonA1.setBackground(java.awt.Color.blue);
                break;
            }
            case "A2" -> {
                jButtonA2.setBackground(java.awt.Color.blue);
                break;
            }
            case "A3" -> {
                jButtonA3.setBackground(java.awt.Color.blue);
                break;
            }
            case "A4" -> {
                jButtonA4.setBackground(java.awt.Color.blue);
                break;
            }
            case "A5" -> {
                jButtonA5.setBackground(java.awt.Color.blue);
                break;
            }
            case "A6" -> {
                jButtonA6.setBackground(java.awt.Color.blue);
                break;
            }
            case "A7" -> {
                jButtonA7.setBackground(java.awt.Color.blue);
                break;
            }
            case "A8" -> {
                jButtonA8.setBackground(java.awt.Color.blue);
                break;
            }
            case "B1" -> {
                jButtonB1.setBackground(java.awt.Color.blue);
            }
            case "B2" -> {
                jButtonB2.setBackground(java.awt.Color.blue);
            }
            case "B3" -> {
                jButtonB3.setBackground(java.awt.Color.blue);
            }
            case "B4" -> {
                jButtonB4.setBackground(java.awt.Color.blue);
            }
            case "B5" -> {
                jButtonB5.setBackground(java.awt.Color.blue);
            }
            case "B6" -> {
                jButtonB6.setBackground(java.awt.Color.blue);
            }
            case "B7" -> {
                jButtonB7.setBackground(java.awt.Color.blue);
            }
            case "B8" -> {
                jButtonB8.setBackground(java.awt.Color.blue);
            }
            case "C1" -> {
                jButtonC1.setBackground(java.awt.Color.blue);
            }
            case "C2" -> {
                jButtonC2.setBackground(java.awt.Color.blue);
            }
            case "C3" -> {
                jButtonC3.setBackground(java.awt.Color.blue);
            }
            case "C4" -> {
                jButtonC4.setBackground(java.awt.Color.blue);
            }
            case "C5" -> {
                jButtonC5.setBackground(java.awt.Color.blue);
            }
            case "C6" -> {
                jButtonC6.setBackground(java.awt.Color.blue);
            }
            case "C7" -> {
                jButtonC7.setBackground(java.awt.Color.blue);
            }
            case "C8" -> {
                jButtonC8.setBackground(java.awt.Color.blue);
            }
            case "D1" -> {
                jButtonD1.setBackground(java.awt.Color.blue);
            }
            case "D2" -> {
                jButtonD2.setBackground(java.awt.Color.blue);
            }
            case "D3" -> {
                jButtonD3.setBackground(java.awt.Color.blue);
            }
            case "D4" -> {
                jButtonD4.setBackground(java.awt.Color.blue);
            }
            case "D5" -> {
                jButtonD5.setBackground(java.awt.Color.blue);
            }
            case "D6" -> {
                jButtonD6.setBackground(java.awt.Color.blue);
            }
            case "D7" -> {
                jButtonD7.setBackground(java.awt.Color.blue);
            }
            case "D8" -> {
                jButtonD8.setBackground(java.awt.Color.blue);
            }
            case "E1" -> {
                jButtonE1.setBackground(java.awt.Color.blue);
            }
            case "E2" -> {
                jButtonE2.setBackground(java.awt.Color.blue);
            }
            case "E3" -> {
                jButtonE3.setBackground(java.awt.Color.blue);
            }
            case "E4" -> {
                jButtonE4.setBackground(java.awt.Color.blue);
            }
            case "E5" -> {
                jButtonE5.setBackground(java.awt.Color.blue);
            }
            case "E6" -> {
                jButtonE6.setBackground(java.awt.Color.blue);
            }
            case "E7" -> {
                jButtonE7.setBackground(java.awt.Color.blue);
            }
            case "E8" -> {
                jButtonE8.setBackground(java.awt.Color.blue);
            }
            case "F1" -> {
                jButtonF1.setBackground(java.awt.Color.blue);
            }
            case "F2" -> {
                jButtonF2.setBackground(java.awt.Color.blue);
            }
            case "F3" -> {
                jButtonF3.setBackground(java.awt.Color.blue);
            }
            case "F4" -> {
                jButtonF4.setBackground(java.awt.Color.blue);
            }
            case "F5" -> {
                jButtonF5.setBackground(java.awt.Color.blue);
            }
            case "F6" -> {
                jButtonF6.setBackground(java.awt.Color.blue);
            }
            case "F7" -> {
                jButtonF7.setBackground(java.awt.Color.blue);
            }
            case "F8" -> {
                jButtonF8.setBackground(java.awt.Color.blue);
            }
            case "G1" -> {
                jButtonG1.setBackground(java.awt.Color.blue);
            }
            case "G2" -> {
                jButtonG2.setBackground(java.awt.Color.blue);
            }
            case "G3" -> {
                jButtonG3.setBackground(java.awt.Color.blue);
            }
            case "G4" -> {
                jButtonG4.setBackground(java.awt.Color.blue);
            }
            case "G5" -> {
                jButtonG5.setBackground(java.awt.Color.blue);
            }
            case "G6" -> {
                jButtonG6.setBackground(java.awt.Color.blue);
            }
            case "G7" -> {
                jButtonG7.setBackground(java.awt.Color.blue);
            }
            case "G8" -> {
                jButtonG8.setBackground(java.awt.Color.blue);
            }
            case "H1" -> {
                jButtonH1.setBackground(java.awt.Color.blue);
            }
            case "H2" -> {
                jButtonH2.setBackground(java.awt.Color.blue);
            }
            case "H3" -> {
                jButtonH3.setBackground(java.awt.Color.blue);
            }
            case "H4" -> {
                jButtonH4.setBackground(java.awt.Color.blue);
            }
            case "H5" -> {
                jButtonH5.setBackground(java.awt.Color.blue);
            }
            case "H6" -> {
                jButtonH6.setBackground(java.awt.Color.blue);
            }
            case "H7" -> {
                jButtonH7.setBackground(java.awt.Color.blue);
            }
            case "H8" -> {
                jButtonH8.setBackground(java.awt.Color.blue);
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Posição (" + posicao + ") não encontrada !");
            }
        }
    }

    public static XadrezPosicao lendoPosicao(String pos) {

        pos = pos.toLowerCase();

        char col = pos.charAt(0);
        int lin = Integer.parseInt(pos.substring(1));
        return new XadrezPosicao(col, lin);

    }

    private void imprirPeca(PecaXadrez peca, boolean background, int i, int j) {

        if (background) {
            setandoBackBotao(retornandoPosicaoXadrez(j + 1, i - 1).toUpperCase());
        }

        if (peca != null) {

            try {
                if (peca.getColor() == Color.WHITE) {
                    setandoImgBotao(criandoImagem(peca.toString().toLowerCase() + "B"), retornandoPosicaoTabuleiro(peca.getXadrezPosicao().getLinha(), String.valueOf(peca.getXadrezPosicao().getColuna())));
                } else {
                    setandoImgBotao(criandoImagem(peca.toString().toLowerCase() + "P"), retornandoPosicaoTabuleiro(peca.getXadrezPosicao().getLinha(), String.valueOf(peca.getXadrezPosicao().getColuna())));
                }
            } catch (IOException ie) {
                JOptionPane.showMessageDialog(null, peca + " " + ie.getMessage());
            }
        }
    }

    public void imprimirTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                imprirPeca(pecas[i][j], false, i, j);
            }
        }
    }

    public void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] movPos) {
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                imprirPeca(pecas[i][j], movPos[i][j], i, j);
            }
        }

    }

    public void imprimindoPatida(PartidaXadrez partida, List<PecaXadrez> caps) {

        this.partida = partida;

        imprimirTabuleiro(partida.getPecas());
        //imprimirPecasCapturadas(caps);

        jLabelMensagem1.setText("Turno: " + partida.getTurno());

        if (!partida.isCheckMate()) {
            jLabelMensagem2.setText("Aguardando Jogador: " + (partida.getJogadorAtual() == Color.WHITE ? "BRANCO" : "PRETO"));

            if (partida.isCheck()) {
                jLabelMensagem3.setText("CHECK !");
            } else {
                jLabelMensagem3.setText("");
            }
        } else {
            jLabelMensagem1.setText("CHECK MATE!");
            jLabelMensagem2.setText("VENCEDOR: " + (partida.getJogadorAtual() == Color.WHITE ? "BRANCO" : "PRETO"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jButtonA8 = new javax.swing.JButton();
        jButtonB8 = new javax.swing.JButton();
        jButtonH7 = new javax.swing.JButton();
        jButtonD8 = new javax.swing.JButton();
        jButtonE8 = new javax.swing.JButton();
        jButtonF8 = new javax.swing.JButton();
        jButtonG8 = new javax.swing.JButton();
        jButtonG7 = new javax.swing.JButton();
        jButtonC8 = new javax.swing.JButton();
        jButtonH8 = new javax.swing.JButton();
        jButtonF7 = new javax.swing.JButton();
        jButtonE7 = new javax.swing.JButton();
        jButtonD7 = new javax.swing.JButton();
        jButtonC7 = new javax.swing.JButton();
        jButtonB7 = new javax.swing.JButton();
        jButtonA7 = new javax.swing.JButton();
        jButtonA6 = new javax.swing.JButton();
        jButtonB6 = new javax.swing.JButton();
        jButtonH5 = new javax.swing.JButton();
        jButtonD6 = new javax.swing.JButton();
        jButtonE6 = new javax.swing.JButton();
        jButtonF6 = new javax.swing.JButton();
        jButtonG6 = new javax.swing.JButton();
        jButtonG5 = new javax.swing.JButton();
        jButtonC6 = new javax.swing.JButton();
        jButtonH6 = new javax.swing.JButton();
        jButtonF5 = new javax.swing.JButton();
        jButtonE5 = new javax.swing.JButton();
        jButtonD5 = new javax.swing.JButton();
        jButtonC5 = new javax.swing.JButton();
        jButtonB5 = new javax.swing.JButton();
        jButtonA5 = new javax.swing.JButton();
        jButtonH4 = new javax.swing.JButton();
        jButtonA4 = new javax.swing.JButton();
        jButtonG3 = new javax.swing.JButton();
        jButtonD4 = new javax.swing.JButton();
        jButtonC3 = new javax.swing.JButton();
        jButtonF3 = new javax.swing.JButton();
        jButtonB4 = new javax.swing.JButton();
        jButtonF4 = new javax.swing.JButton();
        jButtonG4 = new javax.swing.JButton();
        jButtonB3 = new javax.swing.JButton();
        jButtonH3 = new javax.swing.JButton();
        jButtonD3 = new javax.swing.JButton();
        jButtonE3 = new javax.swing.JButton();
        jButtonE4 = new javax.swing.JButton();
        jButtonC4 = new javax.swing.JButton();
        jButtonA3 = new javax.swing.JButton();
        jButtonG1 = new javax.swing.JButton();
        jButtonC2 = new javax.swing.JButton();
        jButtonH2 = new javax.swing.JButton();
        jButtonF1 = new javax.swing.JButton();
        jButtonE1 = new javax.swing.JButton();
        jButtonD1 = new javax.swing.JButton();
        jButtonC1 = new javax.swing.JButton();
        jButtonB1 = new javax.swing.JButton();
        jButtonA1 = new javax.swing.JButton();
        jButtonA2 = new javax.swing.JButton();
        jButtonB2 = new javax.swing.JButton();
        jButtonH1 = new javax.swing.JButton();
        jButtonD2 = new javax.swing.JButton();
        jButtonE2 = new javax.swing.JButton();
        jButtonF2 = new javax.swing.JButton();
        jButtonG2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelMensagem1 = new javax.swing.JLabel();
        jLabelMensagem2 = new javax.swing.JLabel();
        jLabelMensagem3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAFÉ COM XADREZ");
        setResizable(false);

        jButtonA8.setToolTipText("");

        jButtonB8.setBackground(new java.awt.Color(204, 204, 204));

        jButtonH7.setToolTipText("");

        jButtonD8.setBackground(new java.awt.Color(204, 204, 204));

        jButtonE8.setToolTipText("");

        jButtonF8.setBackground(new java.awt.Color(204, 204, 204));

        jButtonG8.setToolTipText("");

        jButtonG7.setBackground(new java.awt.Color(204, 204, 204));

        jButtonC8.setToolTipText("");

        jButtonH8.setBackground(new java.awt.Color(204, 204, 204));

        jButtonF7.setToolTipText("");

        jButtonE7.setBackground(new java.awt.Color(204, 204, 204));

        jButtonD7.setToolTipText("");

        jButtonC7.setBackground(new java.awt.Color(204, 204, 204));

        jButtonB7.setToolTipText("");

        jButtonA7.setBackground(new java.awt.Color(204, 204, 204));

        jButtonA6.setToolTipText("");

        jButtonB6.setBackground(new java.awt.Color(204, 204, 204));

        jButtonH5.setToolTipText("");

        jButtonD6.setBackground(new java.awt.Color(204, 204, 204));

        jButtonE6.setToolTipText("");

        jButtonF6.setBackground(new java.awt.Color(204, 204, 204));

        jButtonG6.setToolTipText("");

        jButtonG5.setBackground(new java.awt.Color(204, 204, 204));

        jButtonC6.setToolTipText("");

        jButtonH6.setBackground(new java.awt.Color(204, 204, 204));

        jButtonF5.setToolTipText("");

        jButtonE5.setBackground(new java.awt.Color(204, 204, 204));

        jButtonD5.setToolTipText("");

        jButtonC5.setBackground(new java.awt.Color(204, 204, 204));

        jButtonB5.setToolTipText("");

        jButtonA5.setBackground(new java.awt.Color(204, 204, 204));

        jButtonH4.setBackground(new java.awt.Color(204, 204, 204));

        jButtonA4.setToolTipText("");

        jButtonG3.setBackground(new java.awt.Color(204, 204, 204));

        jButtonD4.setBackground(new java.awt.Color(204, 204, 204));

        jButtonC3.setBackground(new java.awt.Color(204, 204, 204));

        jButtonF3.setToolTipText("");

        jButtonB4.setBackground(new java.awt.Color(204, 204, 204));

        jButtonF4.setBackground(new java.awt.Color(204, 204, 204));

        jButtonG4.setToolTipText("");

        jButtonB3.setToolTipText("");

        jButtonH3.setToolTipText("");

        jButtonD3.setToolTipText("");

        jButtonE3.setBackground(new java.awt.Color(204, 204, 204));

        jButtonE4.setToolTipText("");

        jButtonC4.setToolTipText("");

        jButtonA3.setBackground(new java.awt.Color(204, 204, 204));
        jButtonA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA3MouseClicked(evt);
            }
        });

        jButtonG1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonC2.setToolTipText("");

        jButtonH2.setBackground(new java.awt.Color(204, 204, 204));

        jButtonF1.setToolTipText("");

        jButtonE1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonD1.setToolTipText("");

        jButtonC1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonB1.setToolTipText("");

        jButtonA1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA1MouseClicked(evt);
            }
        });

        jButtonA2.setToolTipText("");
        jButtonA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA2MouseClicked(evt);
            }
        });

        jButtonB2.setBackground(new java.awt.Color(204, 204, 204));

        jButtonH1.setToolTipText("");

        jButtonD2.setBackground(new java.awt.Color(204, 204, 204));

        jButtonE2.setToolTipText("");

        jButtonF2.setBackground(new java.awt.Color(204, 204, 204));

        jButtonG2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("B");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("C");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("D");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("F");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("E");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("G");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("H");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("3");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("5");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("2");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("4");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("6");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("7");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("8");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelMensagem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMensagem1.setText("TESTE PRIMEIRA MENSAGEM TESTANDO MENSAGENS ");

        jLabelMensagem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMensagem2.setText("TESTE PRIMEIRA MENSAGEM TESTANDO MENSAGENS ");

        jLabelMensagem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMensagem3.setText("TESTE PRIMEIRA MENSAGEM TESTANDO MENSAGENS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMensagem2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelMensagem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabelMensagem3, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMensagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMensagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMensagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonA7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonB7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonD7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonF7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonH7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonA6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonB6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonD6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonF6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonH6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonA8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonB8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonD8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonF8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonH8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(265, 265, 265))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonA2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonB2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonD2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonF2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonH2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButtonA4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonB4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonC4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonD4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonE4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonF4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(87, 87, 87)
                                    .addComponent(jButtonH4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonG4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonA5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonB5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonC5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonD5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonE5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonF5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonG5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonH5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonA3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonB3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonC3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonD3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonE3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonF3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonG3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonH3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonA1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonB1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonD1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonE1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButtonF1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonG1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonH1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonG8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonB8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonH8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonH7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonG7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonF7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonE7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonD7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonC7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonB7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonA7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonD6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonB6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonA6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonC6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonE6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonF6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonG6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonH6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonH5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonG5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonF5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonE5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonD5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonC5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonB5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonA5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonG4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonF4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonE4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonD4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonB4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonA4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonC4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonH4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonH3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonG3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonF3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonE3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonD3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonC3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonB3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonA3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButtonD2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonB2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonA2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonC2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonF2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonG2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonH2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButtonH1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonG1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonF1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonE1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonD1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonB1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonA1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))))
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificandoJogadas(String pos) {
        if (jogadas) {
            origem = this.lendoPosicao(pos);
            boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
            imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);
            jogadas = false;
        }else{
            this.movendoPeca(pos);
        }
    }

    private void movendoPeca(String pos) {
        if (!jogadas) {
            XadrezPosicao destino = this.lendoPosicao(pos);
            PecaXadrez cap = partida.movendoPeca(origem, destino);
            jogadas = true;
            this.voltandoBackground();
        }
    }

    private void jButtonA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA1MouseClicked
        this.verificandoJogadas("a1");
    }//GEN-LAST:event_jButtonA1MouseClicked

    private void jButtonA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA2MouseClicked
        this.verificandoJogadas("a2");
    }//GEN-LAST:event_jButtonA2MouseClicked

    private void jButtonA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA3MouseClicked
       this.verificandoJogadas("a3");
    }//GEN-LAST:event_jButtonA3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA1;
    private javax.swing.JButton jButtonA2;
    private javax.swing.JButton jButtonA3;
    private javax.swing.JButton jButtonA4;
    private javax.swing.JButton jButtonA5;
    private javax.swing.JButton jButtonA6;
    private javax.swing.JButton jButtonA7;
    private javax.swing.JButton jButtonA8;
    private javax.swing.JButton jButtonB1;
    private javax.swing.JButton jButtonB2;
    private javax.swing.JButton jButtonB3;
    private javax.swing.JButton jButtonB4;
    private javax.swing.JButton jButtonB5;
    private javax.swing.JButton jButtonB6;
    private javax.swing.JButton jButtonB7;
    private javax.swing.JButton jButtonB8;
    private javax.swing.JButton jButtonC1;
    private javax.swing.JButton jButtonC2;
    private javax.swing.JButton jButtonC3;
    private javax.swing.JButton jButtonC4;
    private javax.swing.JButton jButtonC5;
    private javax.swing.JButton jButtonC6;
    private javax.swing.JButton jButtonC7;
    private javax.swing.JButton jButtonC8;
    private javax.swing.JButton jButtonD1;
    private javax.swing.JButton jButtonD2;
    private javax.swing.JButton jButtonD3;
    private javax.swing.JButton jButtonD4;
    private javax.swing.JButton jButtonD5;
    private javax.swing.JButton jButtonD6;
    private javax.swing.JButton jButtonD7;
    private javax.swing.JButton jButtonD8;
    private javax.swing.JButton jButtonE1;
    private javax.swing.JButton jButtonE2;
    private javax.swing.JButton jButtonE3;
    private javax.swing.JButton jButtonE4;
    private javax.swing.JButton jButtonE5;
    private javax.swing.JButton jButtonE6;
    private javax.swing.JButton jButtonE7;
    private javax.swing.JButton jButtonE8;
    private javax.swing.JButton jButtonF1;
    private javax.swing.JButton jButtonF2;
    private javax.swing.JButton jButtonF3;
    private javax.swing.JButton jButtonF4;
    private javax.swing.JButton jButtonF5;
    private javax.swing.JButton jButtonF6;
    private javax.swing.JButton jButtonF7;
    private javax.swing.JButton jButtonF8;
    private javax.swing.JButton jButtonG1;
    private javax.swing.JButton jButtonG2;
    private javax.swing.JButton jButtonG3;
    private javax.swing.JButton jButtonG4;
    private javax.swing.JButton jButtonG5;
    private javax.swing.JButton jButtonG6;
    private javax.swing.JButton jButtonG7;
    private javax.swing.JButton jButtonG8;
    private javax.swing.JButton jButtonH1;
    private javax.swing.JButton jButtonH2;
    private javax.swing.JButton jButtonH3;
    private javax.swing.JButton jButtonH4;
    private javax.swing.JButton jButtonH5;
    private javax.swing.JButton jButtonH6;
    private javax.swing.JButton jButtonH7;
    private javax.swing.JButton jButtonH8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMensagem1;
    private javax.swing.JLabel jLabelMensagem2;
    private javax.swing.JLabel jLabelMensagem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the origem
     */
    public XadrezPosicao getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(XadrezPosicao origem) {
        this.origem = origem;
    }
}
