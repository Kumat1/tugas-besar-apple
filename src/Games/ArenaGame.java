package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArenaGame extends JFrame {
    private JPanel panelArena,panelGame,panelMenu,panelPemain;
    private BorderLayout layoutArena,layoutMenu;
    private GridLayout layoutGame;
    private GridBagLayout layoutPemain;
    private GridBagConstraints constraints;
    private JLabel label;
    private Font fontText,fontButton;
    private int panjang,lebar,blok;
    private String pemain1, pemain2;
    private boolean giliran1=true,giliran2=false;

    public ArenaGame(int p, int l,int b,String p1,String p2) {
        this.panjang = p;
        this.lebar = l;
        this.blok = b;
        this.pemain1 = p1;
        this.pemain2 = p2;

        panelArena = (JPanel) this.getContentPane();
        layoutArena = new BorderLayout(2,1);
        panelArena.setLayout(layoutArena);

        fontText = new Font("Arial",Font.PLAIN,24);

        panelMenu = new JPanel();
        layoutMenu = new BorderLayout();
        panelMenu.setLayout(layoutMenu);

        fontButton = new Font("Arial",Font.BOLD,24);

        JButton button = new JButton("←");
        button.setFont(fontButton);
//        ImageIcon image = new ImageIcon(getClass().getResource("arrow.png"));
//        button.setIcon(image);
        button.addActionListener(e -> {
            new TicTacToe();
            ArenaGame.this.setVisible(false);
        });
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        panelMenu.add(button,BorderLayout.WEST);

        panelPemain = new JPanel();
        layoutPemain = new GridBagLayout();
        panelPemain.setLayout(layoutPemain);

        constraints = new GridBagConstraints();

        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=1;
        constraints.gridy = 1;

        label = new JLabel("O");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=2;
        constraints.gridy = 1;

        label = new JLabel("Pemain1");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=1;
        constraints.gridy = 2;

        label = new JLabel("X");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=2;
        constraints.gridy = 2;

        label = new JLabel("Pemain2");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        panelPemain.setBorder(BorderFactory.createEmptyBorder(5,0,0,10));

        panelGame = new JPanel();
        layoutGame = new GridLayout(panjang,lebar);
        panelGame.setLayout(layoutGame);

        Kotak[][] kotak = new Kotak[lebar][panjang];

        for(int i = 0;i<lebar;i++) {
            for (int j = 0;j<panjang;j++){
                kotak[i][j] = new Kotak();
                int posX = i;
                int posY = j;

                kotak[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(giliran1==true)
                        {
                            kotak[posX][posY].setSymbol(p1);
                            giliran1 = false;
                            giliran2 = true;
                        }
                        else{
                            kotak[posX][posY].setSymbol(p2);
                            giliran2 = false;
                            giliran1 = true;
                        }
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

        panelMenu.add(panelPemain,BorderLayout.EAST);
        panelArena.add(panelMenu,BorderLayout.NORTH);
        panelArena.add(panelGame,BorderLayout.CENTER);

        setVisible(true);
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
