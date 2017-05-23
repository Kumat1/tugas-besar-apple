package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArenaGame extends JFrame {
    private JPanel panelArena,panelGame;
    private BorderLayout layoutArena;
    private GridLayout layoutGame;
    private Kotak kotak1, kotak2,kotak3;
    private int panjang,lebar,blok;
    private String pemain1, pemain2;

    public ArenaGame(int p, int l,int b,String p1,String p2) {
        this.panjang = p;
        this.lebar = l;
        this.blok = b;
        this.pemain1 = p1;
        this.pemain2 = p2;

        panelArena = (JPanel) this.getContentPane();
        layoutArena = new BorderLayout(2,1);
        panelArena.setLayout(layoutArena);

        panelGame = new JPanel();
        layoutGame = new GridLayout(panjang,lebar);
        panelGame.setLayout(layoutGame);
        panelGame.setBackground(Color.yellow);

        Kotak[][] kotak = new Kotak[lebar][panjang];

        for(int i = 0;i<lebar;i++) {
            for (int j = 0;j<panjang;j++){
                kotak[i][j] = new Kotak();
                int posX = i;
                int posY = j;

                kotak[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(null, "Klik: " + posX + ", " + posY);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                panelGame.add(kotak[i][j]);
            }
        }

        panelArena.add(panelGame,BorderLayout.CENTER);
        setVisible(true);
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}