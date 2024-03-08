package InterfaceGrafica;

import static Principal.UI.ANSI_RESET;
import static Principal.UI.ANSI_WHITE;
import static Principal.UI.ANSI_YELLOW;
import Xadrez.Color;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezPosicao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    
    List<PecaXadrez> capturadas = new ArrayList<>();
    
    private boolean jogadas = true;
    
    public TabuleiroIG() throws IOException, URISyntaxException {
        initComponents();
        this.voltandoBackground();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.limpandoJLabels();
    }
    
    private void limpandoJLabels() throws IOException, URISyntaxException {
        jLabel19.setText("");
        jLabel17.setText("");
        jLabel18.setText("");
        jLabel20.setText("");
        jLabel21.setText("");
        jLabel22.setText("");
        jLabel23.setText("");
        jLabel24.setText("");
        jLabel25.setText("");
        jLabel26.setText("");
        jLabel27.setText("");
        jLabel28.setText("");
        jLabel29.setText("");
        jLabel30.setText("");
        jLabel31.setText("");
        jLabel32.setText("");
        jLabelP1.setText("");
        jLabelP16.setText("");
        jLabelP15.setText("");
        jLabelP14.setText("");
        jLabelP13.setText("");
        jLabelP9.setText("");
        jLabelP10.setText("");
        jLabelP11.setText("");
        jLabelP12.setText("");
        jLabelP8.setText("");
        jLabelP7.setText("");
        jLabelP6.setText("");
        jLabelP5.setText("");
        jLabelP2.setText("");
        jLabelP3.setText("");
        jLabelP4.setText("");
        
        jLabel19.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel17.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel18.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel20.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel21.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel22.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel23.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel24.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel25.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel26.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel27.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel28.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel29.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel30.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel31.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabel32.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP1.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP16.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP15.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP14.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP13.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP9.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP10.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP11.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP12.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP8.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP7.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP6.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP5.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP2.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP3.setIcon(criandoImagemLabelsCapturadas("Z"));
        jLabelP4.setIcon(criandoImagemLabelsCapturadas("Z"));
        
    }
    
    private Icon criandoImagemLabelsCapturadas(String tipo) throws IOException, URISyntaxException {
        
        Icon img = null;
        
        BufferedImage bImg;
        
        switch (tipo) {
            case "bB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/bispoBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "bP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/bispoPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "tB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/torreBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "tP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/torrePreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "cB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/cavaloBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "cP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/cavaloPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "kB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/reiBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "kP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/reiPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "qB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/rainhaBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "qP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/rainhaPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "pB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/peaoBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            case "pP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/peaoPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
            default -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/zerando_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            }
        }
        
        return img;
    }
    
    private void imprimirPecasCapturadas(List<PecaXadrez> capturadas) throws URISyntaxException, IOException {
        List<PecaXadrez> brancas = capturadas.stream().filter(x -> x.getColor() == Color.WHITE)
                .collect(Collectors.toList());
        List<PecaXadrez> pretas = capturadas.stream().filter(x -> x.getColor() == Color.BLACK)
                .collect(Collectors.toList());
        
        int branca = 17;
        int preta = 37;
        for (PecaXadrez pecaBraca : brancas) {
            switch (branca) {
                case 17 -> jLabel17.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 18 -> jLabel18.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 19 -> jLabel19.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 20 -> jLabel20.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 21 -> jLabel21.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 22 -> jLabel22.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 23 -> jLabel23.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 24 -> jLabel24.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 25 -> jLabel25.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 26 -> jLabel26.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 27 -> jLabel27.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 28 -> jLabel28.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 29 -> jLabel29.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 30 -> jLabel30.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 31 -> jLabel31.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                case 32 -> jLabel32.setIcon(criandoImagemLabelsCapturadas(pecaBraca.toString().toLowerCase() + "B"));
                default -> throw new AssertionError();
            }
            branca++;
        }
        
        for(PecaXadrez pecaPreta : pretas){
            switch (preta) {
                case 37 -> jLabelP1.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 38 -> jLabelP2.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 39 -> jLabelP3.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 40 -> jLabelP4.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 41 -> jLabelP5.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 42 -> jLabelP6.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 43 -> jLabelP7.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 44 -> jLabelP8.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 45 -> jLabelP9.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 46 -> jLabelP10.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 47 -> jLabelP11.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 48 -> jLabelP11.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 49 -> jLabelP13.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 50 -> jLabelP14.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 51 -> jLabelP15.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                case 52 -> jLabelP16.setIcon(criandoImagemLabelsCapturadas(pecaPreta.toString().toLowerCase() + "P"));
                default -> throw new AssertionError();
            }
            preta++;
        }
    }
    
    private Icon criandoImagem(String tipo) throws IOException, URISyntaxException {
        
        Icon img = null;
        
        BufferedImage bImg;
        
        switch (tipo) {
            case "bB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/bispoBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "bP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/bispoPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "tB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/torreBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "tP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/torrePreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "cB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/cavaloBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "cP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/cavaloPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "kB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/reiBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "kP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/reiPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "qB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/rainhaBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "qP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/rainhaPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "pB" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/peaoBranco_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            case "pP" -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/peaoPreto_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
            default -> {
                bImg = ImageIO.read(new File(getClass().getResource("/Imagens/zerando_vetor.png").toURI()));
                img = new ImageIcon(bImg.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
            }
        }
        
        return img;
    }
    
    private String retornandoPosicaoXadrez(int lin, int col) {
        String retorno;
        
        switch (col) {
            case 0 ->
                retorno = "8";
            case 1 ->
                retorno = "7";
            case 2 ->
                retorno = "6";
            case 3 ->
                retorno = "5";
            case 4 ->
                retorno = "4";
            case 5 ->
                retorno = "3";
            case 6 ->
                retorno = "2";
            case 7 ->
                retorno = "1";
            default ->
                retorno = "";
        }
        
        switch (lin) {
            case 0 ->
                retorno = "A" + retorno;
            case 1 ->
                retorno = "B" + retorno;
            case 2 ->
                retorno = "C" + retorno;
            case 3 ->
                retorno = "D" + retorno;
            case 4 ->
                retorno = "E" + retorno;
            case 5 ->
                retorno = "F" + retorno;
            case 6 ->
                retorno = "G" + retorno;
            case 7 ->
                retorno = "H" + retorno;
            default ->
                retorno += "";
        }
        
        return retorno;
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
    
    private void voltandoIconButtons() throws URISyntaxException {
        try {
            jButtonA1.setIcon(this.criandoImagem("Z"));
            jButtonA2.setIcon(this.criandoImagem("Z"));
            jButtonA3.setIcon(this.criandoImagem("Z"));
            jButtonA4.setIcon(this.criandoImagem("Z"));
            jButtonA5.setIcon(this.criandoImagem("Z"));
            jButtonA6.setIcon(this.criandoImagem("Z"));
            jButtonA7.setIcon(this.criandoImagem("Z"));
            jButtonA8.setIcon(this.criandoImagem("Z"));
            
            jButtonB1.setIcon(this.criandoImagem("Z"));
            jButtonB2.setIcon(this.criandoImagem("Z"));
            jButtonB3.setIcon(this.criandoImagem("Z"));
            jButtonB4.setIcon(this.criandoImagem("Z"));
            jButtonB5.setIcon(this.criandoImagem("Z"));
            jButtonB6.setIcon(this.criandoImagem("Z"));
            jButtonB7.setIcon(this.criandoImagem("Z"));
            jButtonB8.setIcon(this.criandoImagem("Z"));
            
            jButtonC1.setIcon(this.criandoImagem("Z"));
            jButtonC2.setIcon(this.criandoImagem("Z"));
            jButtonC3.setIcon(this.criandoImagem("Z"));
            jButtonC4.setIcon(this.criandoImagem("Z"));
            jButtonC5.setIcon(this.criandoImagem("Z"));
            jButtonC6.setIcon(this.criandoImagem("Z"));
            jButtonC7.setIcon(this.criandoImagem("Z"));
            jButtonC8.setIcon(this.criandoImagem("Z"));
            
            jButtonD1.setIcon(this.criandoImagem("Z"));
            jButtonD2.setIcon(this.criandoImagem("Z"));
            jButtonD3.setIcon(this.criandoImagem("Z"));
            jButtonD4.setIcon(this.criandoImagem("Z"));
            jButtonD5.setIcon(this.criandoImagem("Z"));
            jButtonD6.setIcon(this.criandoImagem("Z"));
            jButtonD7.setIcon(this.criandoImagem("Z"));
            jButtonD8.setIcon(this.criandoImagem("Z"));
            
            jButtonE1.setIcon(this.criandoImagem("Z"));
            jButtonE2.setIcon(this.criandoImagem("Z"));
            jButtonE3.setIcon(this.criandoImagem("Z"));
            jButtonE4.setIcon(this.criandoImagem("Z"));
            jButtonE5.setIcon(this.criandoImagem("Z"));
            jButtonE6.setIcon(this.criandoImagem("Z"));
            jButtonE7.setIcon(this.criandoImagem("Z"));
            jButtonE8.setIcon(this.criandoImagem("Z"));
            
            jButtonF1.setIcon(this.criandoImagem("Z"));
            jButtonF2.setIcon(this.criandoImagem("Z"));
            jButtonF3.setIcon(this.criandoImagem("Z"));
            jButtonF4.setIcon(this.criandoImagem("Z"));
            jButtonF5.setIcon(this.criandoImagem("Z"));
            jButtonF6.setIcon(this.criandoImagem("Z"));
            jButtonF7.setIcon(this.criandoImagem("Z"));
            jButtonF8.setIcon(this.criandoImagem("Z"));
            
            jButtonG1.setIcon(this.criandoImagem("Z"));
            jButtonG2.setIcon(this.criandoImagem("Z"));
            jButtonG3.setIcon(this.criandoImagem("Z"));
            jButtonG4.setIcon(this.criandoImagem("Z"));
            jButtonG5.setIcon(this.criandoImagem("Z"));
            jButtonG6.setIcon(this.criandoImagem("Z"));
            jButtonG7.setIcon(this.criandoImagem("Z"));
            jButtonG8.setIcon(this.criandoImagem("Z"));
            
            jButtonH1.setIcon(this.criandoImagem("Z"));
            jButtonH2.setIcon(this.criandoImagem("Z"));
            jButtonH3.setIcon(this.criandoImagem("Z"));
            jButtonH4.setIcon(this.criandoImagem("Z"));
            jButtonH5.setIcon(this.criandoImagem("Z"));
            jButtonH6.setIcon(this.criandoImagem("Z"));
            jButtonH7.setIcon(this.criandoImagem("Z"));
            jButtonH8.setIcon(this.criandoImagem("Z"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void setandoBackBotao(String posicao) {
        
        posicao = posicao.toUpperCase();
        
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
    
    private void imprirPeca(PecaXadrez peca, boolean background, int i, int j) throws URISyntaxException {
        
        if (background) {
            setandoBackBotao(retornandoPosicaoXadrez(j, i).toUpperCase());
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
    
    public void imprimirTabuleiro(PecaXadrez[][] pecas) throws URISyntaxException {
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                imprirPeca(pecas[i][j], false, i, j);
            }
        }
    }
    
    public void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] movPos) throws URISyntaxException {
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                imprirPeca(pecas[i][j], movPos[i][j], i, j);
            }
        }
        
    }
    
    public void imprimindoPatida(PartidaXadrez partida, List<PecaXadrez> caps) throws URISyntaxException, IOException {
        
        this.partida = partida;
        
        imprimirTabuleiro(partida.getPecas());
        imprimirPecasCapturadas(caps);

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
    
    private void verificandoJogadas(String pos) throws URISyntaxException, IOException {
        if (jogadas) {
            origem = this.lendoPosicao(pos);
            boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
            imprimirTabuleiro(partida.getPecas(), movimentosPossiveis);
            jogadas = false;
        } else {
            this.movendoPeca(pos);
        }
    }
    
    private void movendoPeca(String pos) throws URISyntaxException, IOException {
        if (!jogadas) {
            XadrezPosicao destino = this.lendoPosicao(pos);
            PecaXadrez cap = partida.movendoPeca(origem, destino);
            jogadas = true;
            this.voltandoBackground();
            
            if (cap != null) {
                capturadas.add(cap);
            }
            
            if (partida.getPromoted() != null) {
                
                String tipo = JOptionPane.showInputDialog("Entre com a peca promovida (C {cavalo}, Q {rainha}, T {torre}, B {bispo}): ");
                
                while (!tipo.equals("B") && !tipo.equals("T") && !tipo.equals("C") && !tipo.equals("Q")) {
                    tipo = JOptionPane.showInputDialog("Atenção, valor inválido, digite novamente!");
                }
                
                partida.trocandoPecaPromovida(tipo);
            }
            
            this.voltandoIconButtons();
            this.imprimindoPatida(partida, capturadas);
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
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        capBrancas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        capPretas = new javax.swing.JPanel();
        jLabelP13 = new javax.swing.JLabel();
        jLabelP9 = new javax.swing.JLabel();
        jLabelP1 = new javax.swing.JLabel();
        jLabelP7 = new javax.swing.JLabel();
        jLabelP14 = new javax.swing.JLabel();
        jLabelP11 = new javax.swing.JLabel();
        jLabelP4 = new javax.swing.JLabel();
        jLabelP10 = new javax.swing.JLabel();
        jLabelP5 = new javax.swing.JLabel();
        jLabelP6 = new javax.swing.JLabel();
        jLabelP3 = new javax.swing.JLabel();
        jLabelP12 = new javax.swing.JLabel();
        jLabelP8 = new javax.swing.JLabel();
        jLabelP16 = new javax.swing.JLabel();
        jLabelP15 = new javax.swing.JLabel();
        jLabelP2 = new javax.swing.JLabel();

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
        jButtonA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA8MouseClicked(evt);
            }
        });

        jButtonB8.setBackground(new java.awt.Color(204, 204, 204));
        jButtonB8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB8MouseClicked(evt);
            }
        });

        jButtonH7.setToolTipText("");
        jButtonH7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH7MouseClicked(evt);
            }
        });

        jButtonD8.setBackground(new java.awt.Color(204, 204, 204));
        jButtonD8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD8MouseClicked(evt);
            }
        });

        jButtonE8.setToolTipText("");
        jButtonE8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE8MouseClicked(evt);
            }
        });

        jButtonF8.setBackground(new java.awt.Color(204, 204, 204));
        jButtonF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF8MouseClicked(evt);
            }
        });

        jButtonG8.setToolTipText("");
        jButtonG8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG8MouseClicked(evt);
            }
        });

        jButtonG7.setBackground(new java.awt.Color(204, 204, 204));
        jButtonG7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG7MouseClicked(evt);
            }
        });

        jButtonC8.setToolTipText("");
        jButtonC8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC8MouseClicked(evt);
            }
        });

        jButtonH8.setBackground(new java.awt.Color(204, 204, 204));
        jButtonH8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH8MouseClicked(evt);
            }
        });

        jButtonF7.setToolTipText("");
        jButtonF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF7MouseClicked(evt);
            }
        });

        jButtonE7.setBackground(new java.awt.Color(204, 204, 204));
        jButtonE7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE7MouseClicked(evt);
            }
        });

        jButtonD7.setToolTipText("");
        jButtonD7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD7MouseClicked(evt);
            }
        });

        jButtonC7.setBackground(new java.awt.Color(204, 204, 204));
        jButtonC7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC7MouseClicked(evt);
            }
        });

        jButtonB7.setToolTipText("");
        jButtonB7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB7MouseClicked(evt);
            }
        });

        jButtonA7.setBackground(new java.awt.Color(204, 204, 204));
        jButtonA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA7MouseClicked(evt);
            }
        });

        jButtonA6.setToolTipText("");
        jButtonA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA6MouseClicked(evt);
            }
        });

        jButtonB6.setBackground(new java.awt.Color(204, 204, 204));
        jButtonB6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB6MouseClicked(evt);
            }
        });

        jButtonH5.setToolTipText("");
        jButtonH5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH5MouseClicked(evt);
            }
        });

        jButtonD6.setBackground(new java.awt.Color(204, 204, 204));
        jButtonD6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD6MouseClicked(evt);
            }
        });

        jButtonE6.setToolTipText("");
        jButtonE6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE6MouseClicked(evt);
            }
        });

        jButtonF6.setBackground(new java.awt.Color(204, 204, 204));
        jButtonF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF6MouseClicked(evt);
            }
        });

        jButtonG6.setToolTipText("");
        jButtonG6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG6MouseClicked(evt);
            }
        });

        jButtonG5.setBackground(new java.awt.Color(204, 204, 204));
        jButtonG5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG5MouseClicked(evt);
            }
        });

        jButtonC6.setToolTipText("");
        jButtonC6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC6MouseClicked(evt);
            }
        });

        jButtonH6.setBackground(new java.awt.Color(204, 204, 204));
        jButtonH6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH6MouseClicked(evt);
            }
        });

        jButtonF5.setToolTipText("");
        jButtonF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF5MouseClicked(evt);
            }
        });

        jButtonE5.setBackground(new java.awt.Color(204, 204, 204));
        jButtonE5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE5MouseClicked(evt);
            }
        });

        jButtonD5.setToolTipText("");
        jButtonD5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD5MouseClicked(evt);
            }
        });

        jButtonC5.setBackground(new java.awt.Color(204, 204, 204));
        jButtonC5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC5MouseClicked(evt);
            }
        });

        jButtonB5.setToolTipText("");
        jButtonB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB5MouseClicked(evt);
            }
        });

        jButtonA5.setBackground(new java.awt.Color(204, 204, 204));
        jButtonA5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA5MouseClicked(evt);
            }
        });

        jButtonH4.setBackground(new java.awt.Color(204, 204, 204));
        jButtonH4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH4MouseClicked(evt);
            }
        });

        jButtonA4.setToolTipText("");
        jButtonA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA4MouseClicked(evt);
            }
        });

        jButtonG3.setBackground(new java.awt.Color(204, 204, 204));
        jButtonG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG3MouseClicked(evt);
            }
        });

        jButtonD4.setBackground(new java.awt.Color(204, 204, 204));
        jButtonD4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD4MouseClicked(evt);
            }
        });

        jButtonC3.setBackground(new java.awt.Color(204, 204, 204));
        jButtonC3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC3MouseClicked(evt);
            }
        });

        jButtonF3.setToolTipText("");
        jButtonF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF3MouseClicked(evt);
            }
        });

        jButtonB4.setBackground(new java.awt.Color(204, 204, 204));
        jButtonB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonB4MouseEntered(evt);
            }
        });

        jButtonF4.setBackground(new java.awt.Color(204, 204, 204));
        jButtonF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF4MouseClicked(evt);
            }
        });

        jButtonG4.setToolTipText("");
        jButtonG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG4MouseClicked(evt);
            }
        });

        jButtonB3.setToolTipText("");
        jButtonB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB3MouseClicked(evt);
            }
        });

        jButtonH3.setToolTipText("");
        jButtonH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH3MouseClicked(evt);
            }
        });

        jButtonD3.setToolTipText("");
        jButtonD3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD3MouseClicked(evt);
            }
        });

        jButtonE3.setBackground(new java.awt.Color(204, 204, 204));
        jButtonE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE3MouseClicked(evt);
            }
        });

        jButtonE4.setToolTipText("");
        jButtonE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE4MouseClicked(evt);
            }
        });

        jButtonC4.setToolTipText("");
        jButtonC4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonC4MouseEntered(evt);
            }
        });

        jButtonA3.setBackground(new java.awt.Color(204, 204, 204));
        jButtonA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonA3MouseClicked(evt);
            }
        });

        jButtonG1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG1MouseClicked(evt);
            }
        });

        jButtonC2.setToolTipText("");
        jButtonC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC2MouseClicked(evt);
            }
        });

        jButtonH2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH2MouseClicked(evt);
            }
        });

        jButtonF1.setToolTipText("");
        jButtonF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF1MouseClicked(evt);
            }
        });

        jButtonE1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE1MouseClicked(evt);
            }
        });

        jButtonD1.setToolTipText("");
        jButtonD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD1MouseClicked(evt);
            }
        });

        jButtonC1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonC1MouseClicked(evt);
            }
        });

        jButtonB1.setToolTipText("");
        jButtonB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB1MouseClicked(evt);
            }
        });

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
        jButtonA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonA2ActionPerformed(evt);
            }
        });

        jButtonB2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonB2MouseClicked(evt);
            }
        });

        jButtonH1.setToolTipText("");
        jButtonH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonH1MouseClicked(evt);
            }
        });

        jButtonD2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonD2MouseClicked(evt);
            }
        });

        jButtonE2.setToolTipText("");
        jButtonE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonE2MouseClicked(evt);
            }
        });

        jButtonF2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonF2MouseClicked(evt);
            }
        });

        jButtonG2.setToolTipText("");
        jButtonG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonG2MouseClicked(evt);
            }
        });

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

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Peças Capturadas"));

        capBrancas.setBorder(javax.swing.BorderFactory.createTitledBorder("Brancas"));

        jLabel19.setText("jLabel17");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel17");

        jLabel20.setText("jLabel17");

        jLabel21.setText("jLabel17");

        jLabel22.setText("jLabel17");

        jLabel23.setText("jLabel17");

        jLabel24.setText("jLabel17");

        jLabel25.setText("jLabel17");

        jLabel26.setText("jLabel17");

        jLabel27.setText("jLabel17");

        jLabel28.setText("jLabel17");

        jLabel29.setText("jLabel17");

        jLabel30.setText("jLabel17");

        jLabel31.setText("jLabel17");

        jLabel32.setText("jLabel17");

        javax.swing.GroupLayout capBrancasLayout = new javax.swing.GroupLayout(capBrancas);
        capBrancas.setLayout(capBrancasLayout);
        capBrancasLayout.setHorizontalGroup(
            capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capBrancasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capBrancasLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capBrancasLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capBrancasLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28))
                    .addGroup(capBrancasLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32)))
                .addContainerGap())
        );
        capBrancasLayout.setVerticalGroup(
            capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capBrancasLayout.createSequentialGroup()
                .addGroup(capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capBrancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 111, Short.MAX_VALUE))
        );

        capPretas.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretas"));

        jLabelP13.setText("jLabel17");

        jLabelP9.setText("jLabel17");

        jLabelP1.setText("jLabel17");

        jLabelP7.setText("jLabel17");

        jLabelP14.setText("jLabel17");

        jLabelP11.setText("jLabel17");

        jLabelP4.setText("jLabel17");

        jLabelP10.setText("jLabel17");

        jLabelP5.setText("jLabel17");

        jLabelP6.setText("jLabel17");

        jLabelP3.setText("jLabel17");

        jLabelP12.setText("jLabel17");

        jLabelP8.setText("jLabel17");

        jLabelP16.setText("jLabel17");

        jLabelP15.setText("jLabel17");

        jLabelP2.setText("jLabel17");

        javax.swing.GroupLayout capPretasLayout = new javax.swing.GroupLayout(capPretas);
        capPretas.setLayout(capPretasLayout);
        capPretasLayout.setHorizontalGroup(
            capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capPretasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capPretasLayout.createSequentialGroup()
                        .addComponent(jLabelP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelP4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capPretasLayout.createSequentialGroup()
                        .addComponent(jLabelP5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelP8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capPretasLayout.createSequentialGroup()
                        .addComponent(jLabelP9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelP12))
                    .addGroup(capPretasLayout.createSequentialGroup()
                        .addComponent(jLabelP13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelP16)))
                .addContainerGap())
        );
        capPretasLayout.setVerticalGroup(
            capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capPretasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(capPretasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(capBrancas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capPretas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(capBrancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(capPretas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonF8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonH8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonA7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonB7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonD7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonF7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonG7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonH7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                            .addComponent(jButtonH1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonG8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonE8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonF8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonD8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonB8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonA8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonH8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonC8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA1MouseClicked
        try {
            this.verificandoJogadas("a1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA1MouseClicked

    private void jButtonA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA2MouseClicked
        try {
            this.verificandoJogadas("a2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA2MouseClicked

    private void jButtonA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA3MouseClicked
        try {
            this.verificandoJogadas("a3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA3MouseClicked

    private void jButtonA4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA4MouseClicked
        try {
            this.verificandoJogadas("a4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA4MouseClicked

    private void jButtonA5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA5MouseClicked
        try {
            this.verificandoJogadas("a5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA5MouseClicked

    private void jButtonA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA6MouseClicked
        try {
            this.verificandoJogadas("a6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA6MouseClicked

    private void jButtonA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA7MouseClicked
        try {
            this.verificandoJogadas("a7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA7MouseClicked

    private void jButtonA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonA8MouseClicked
        try {
            this.verificandoJogadas("a8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonA8MouseClicked

    private void jButtonB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB1MouseClicked
        try {
            this.verificandoJogadas("b1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB1MouseClicked

    private void jButtonB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB2MouseClicked
        try {
            this.verificandoJogadas("b2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB2MouseClicked

    private void jButtonB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB3MouseClicked
        try {
            this.verificandoJogadas("b3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB3MouseClicked

    private void jButtonB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB4MouseEntered
        // Não inserir código até momento
    }//GEN-LAST:event_jButtonB4MouseEntered

    private void jButtonB5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB5MouseClicked
        try {
            this.verificandoJogadas("b5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB5MouseClicked

    private void jButtonB6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB6MouseClicked
        try {
            this.verificandoJogadas("b6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB6MouseClicked

    private void jButtonB7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB7MouseClicked
        try {
            this.verificandoJogadas("b7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB7MouseClicked

    private void jButtonB8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB8MouseClicked
        try {
            this.verificandoJogadas("b8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB8MouseClicked

    private void jButtonC4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC4MouseClicked
        try {
            this.verificandoJogadas("c4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC4MouseClicked

    private void jButtonC4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC4MouseEntered
        // Não inserir código até momento
    }//GEN-LAST:event_jButtonC4MouseEntered

    private void jButtonB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonB4MouseClicked
        try {
            this.verificandoJogadas("b4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonB4MouseClicked

    private void jButtonC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC1MouseClicked
        try {
            this.verificandoJogadas("c1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC1MouseClicked

    private void jButtonC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC2MouseClicked
        try {
            this.verificandoJogadas("c2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC2MouseClicked

    private void jButtonC3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC3MouseClicked
        try {
            this.verificandoJogadas("c3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC3MouseClicked

    private void jButtonC5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC5MouseClicked
        try {
            this.verificandoJogadas("c5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC5MouseClicked

    private void jButtonC6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC6MouseClicked
        try {
            this.verificandoJogadas("c6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC6MouseClicked

    private void jButtonC7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC7MouseClicked
        try {
            this.verificandoJogadas("c7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC7MouseClicked

    private void jButtonC8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonC8MouseClicked
        try {
            this.verificandoJogadas("c8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC8MouseClicked

    private void jButtonD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD1MouseClicked
        try {
            this.verificandoJogadas("d1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD1MouseClicked

    private void jButtonD2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD2MouseClicked
        try {
            this.verificandoJogadas("d2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD2MouseClicked

    private void jButtonD3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD3MouseClicked
        try {
            this.verificandoJogadas("d3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD3MouseClicked

    private void jButtonD4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD4MouseClicked
        try {
            this.verificandoJogadas("d4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD4MouseClicked

    private void jButtonD5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD5MouseClicked
        try {
            this.verificandoJogadas("d5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD5MouseClicked

    private void jButtonD6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD6MouseClicked
        try {
            this.verificandoJogadas("d6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD6MouseClicked

    private void jButtonD7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD7MouseClicked
        try {
            this.verificandoJogadas("d7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD7MouseClicked

    private void jButtonD8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonD8MouseClicked
        try {
            this.verificandoJogadas("d8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonD8MouseClicked

    private void jButtonE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE1MouseClicked
        try {
            this.verificandoJogadas("e1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE1MouseClicked

    private void jButtonE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE2MouseClicked
        try {
            this.verificandoJogadas("e2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE2MouseClicked

    private void jButtonE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE3MouseClicked
        try {
            this.verificandoJogadas("e3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE3MouseClicked

    private void jButtonE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE4MouseClicked
        try {
            this.verificandoJogadas("e4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE4MouseClicked

    private void jButtonE5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE5MouseClicked
        try {
            this.verificandoJogadas("e5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE5MouseClicked

    private void jButtonE6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE6MouseClicked
        try {
            this.verificandoJogadas("e6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE6MouseClicked

    private void jButtonE7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE7MouseClicked
        try {
            this.verificandoJogadas("e7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE7MouseClicked

    private void jButtonE8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonE8MouseClicked
        try {
            this.verificandoJogadas("e8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonE8MouseClicked

    private void jButtonF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF1MouseClicked
        try {
            this.verificandoJogadas("f1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF1MouseClicked

    private void jButtonF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF2MouseClicked
        try {
            this.verificandoJogadas("f2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF2MouseClicked

    private void jButtonF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF3MouseClicked
        try {
            this.verificandoJogadas("f3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF3MouseClicked

    private void jButtonF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF4MouseClicked
        try {
            this.verificandoJogadas("f4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF4MouseClicked

    private void jButtonF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF5MouseClicked
        try {
            this.verificandoJogadas("f5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF5MouseClicked

    private void jButtonF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF6MouseClicked
        try {
            this.verificandoJogadas("f6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF6MouseClicked

    private void jButtonF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF7MouseClicked
        try {
            this.verificandoJogadas("f7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF7MouseClicked

    private void jButtonF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonF8MouseClicked
        try {
            this.verificandoJogadas("f8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonF8MouseClicked

    private void jButtonG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG1MouseClicked
        try {
            this.verificandoJogadas("g1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG1MouseClicked

    private void jButtonG2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG2MouseClicked
        try {
            this.verificandoJogadas("g2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG2MouseClicked

    private void jButtonG3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG3MouseClicked
        try {
            this.verificandoJogadas("g3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG3MouseClicked

    private void jButtonG4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG4MouseClicked
        try {
            this.verificandoJogadas("g4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG4MouseClicked

    private void jButtonG5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG5MouseClicked
        try {
            this.verificandoJogadas("g5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG5MouseClicked

    private void jButtonG6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG6MouseClicked
        try {
            this.verificandoJogadas("g6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG6MouseClicked

    private void jButtonG7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG7MouseClicked
        try {
            this.verificandoJogadas("g7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG7MouseClicked

    private void jButtonG8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonG8MouseClicked
        try {
            this.verificandoJogadas("g8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonG8MouseClicked

    private void jButtonH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH1MouseClicked
        try {
            this.verificandoJogadas("h1");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH1MouseClicked

    private void jButtonH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH2MouseClicked
        try {
            this.verificandoJogadas("h2");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH2MouseClicked

    private void jButtonH3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH3MouseClicked
        try {
            this.verificandoJogadas("h3");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH3MouseClicked

    private void jButtonH4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH4MouseClicked
        try {
            this.verificandoJogadas("h4");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH4MouseClicked

    private void jButtonH5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH5MouseClicked
        try {
            this.verificandoJogadas("h5");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH5MouseClicked

    private void jButtonH6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH6MouseClicked
        try {
            this.verificandoJogadas("h6");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH6MouseClicked

    private void jButtonH7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH7MouseClicked
        try {
            this.verificandoJogadas("h7");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH7MouseClicked

    private void jButtonH8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonH8MouseClicked
        try {
            this.verificandoJogadas("h8");
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem capturada: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonH8MouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void jButtonA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonA2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel capBrancas;
    private javax.swing.JPanel capPretas;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMensagem1;
    private javax.swing.JLabel jLabelMensagem2;
    private javax.swing.JLabel jLabelMensagem3;
    private javax.swing.JLabel jLabelP1;
    private javax.swing.JLabel jLabelP10;
    private javax.swing.JLabel jLabelP11;
    private javax.swing.JLabel jLabelP12;
    private javax.swing.JLabel jLabelP13;
    private javax.swing.JLabel jLabelP14;
    private javax.swing.JLabel jLabelP15;
    private javax.swing.JLabel jLabelP16;
    private javax.swing.JLabel jLabelP2;
    private javax.swing.JLabel jLabelP3;
    private javax.swing.JLabel jLabelP4;
    private javax.swing.JLabel jLabelP5;
    private javax.swing.JLabel jLabelP6;
    private javax.swing.JLabel jLabelP7;
    private javax.swing.JLabel jLabelP8;
    private javax.swing.JLabel jLabelP9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
