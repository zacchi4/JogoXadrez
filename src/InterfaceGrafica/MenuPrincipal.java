package InterfaceGrafica;

import Principal.UI;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.XadrezException;
import Xadrez.XadrezPosicao;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPrincipal extends javax.swing.JFrame {

    Scanner sc = new Scanner(System.in);
    PartidaXadrez partida = new PartidaXadrez();
    TabuleiroIG tab;
    List<PecaXadrez> capturadas = new ArrayList<>();

    public MenuPrincipal() throws IOException, URISyntaxException {
        this.tab = new TabuleiroIG();
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnIG = new javax.swing.JButton();
        btnTerminal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAFÉ COM XADREZ");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Entrada.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 100));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnIG.setText("Interface Gráfica");
        btnIG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIGActionPerformed(evt);
            }
        });

        btnTerminal.setText("Terminal");
        btnTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnIG, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIG, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnIGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIGActionPerformed
        this.setVisible(false);
        try {
            tab.imprimindoPatida(partida, capturadas);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        tab.setVisible(true);

    }//GEN-LAST:event_btnIGActionPerformed

    private void btnTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminalActionPerformed

        this.setVisible(false);

        while (!partida.isCheckMate()) {
            try {
                UI.limpandoTela();
                UI.imprimindoPatida(partida, capturadas);
                System.out.println();
                System.out.print("Origem: ");
                XadrezPosicao origem = UI.lendoPosicao(sc);

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

        UI.limpandoTela();
        UI.imprimindoPatida(partida, capturadas);
    }//GEN-LAST:event_btnTerminalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIG;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTerminal;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
