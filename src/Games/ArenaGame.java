package Games;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ArenaGame extends JFrame {
    private JLabel panelArena;
    private JPanel panelGame,panelMenu,panelPemain;
    private BorderLayout layoutArena,layoutMenu;
    private GridLayout layoutGame;
    private GridBagLayout layoutPemain;
    private GridBagConstraints constraints;
    private JLabel label;
    private Font fontText,fontButton;
    private int panjang,lebar,blok,counter = 0;
    private String pemain1, pemain2,pemenang,pathFile;
    private boolean giliran1=true,giliran2=false,cek,win;
    private ImageIcon image,imageIcon,imageX,imageIconX,imageO,imageIconO ;
    private Image image1,imageX1,imageO1 ;


    public ArenaGame(int p, int l,int b,String p1,String p2,String path) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.panjang = p;
        this.lebar = l;
        this.blok = b;
        this.pemain1 = p1;
        this.pemain2 = p2;
        this.pathFile = path;

        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layoutArena = new BorderLayout();

        if(pathFile == null || pathFile.isEmpty() || pathFile.equals("")) {
            panelArena = new JLabel();
            panelArena.setLayout(layoutArena);
            this.setContentPane(panelArena);
        }
        else{
            ImageIcon background = new ImageIcon(pathFile);
            Image backgroundImage = background.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            ImageIcon panelBackground = new ImageIcon(backgroundImage);

            panelArena = new JLabel(panelBackground);
            panelArena.setLayout(layoutArena);
            this.setContentPane(panelArena);
        }


        fontText = new Font("Arial",Font.PLAIN,24);

        panelMenu = new JPanel();
        panelMenu.setOpaque(false);
        layoutMenu = new BorderLayout();
        panelMenu.setLayout(layoutMenu);

        fontButton = new Font("Arial",Font.BOLD,24);

        image = new ImageIcon("img/back.png");
        image1 = image.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);

        JButton button = new JButton(imageIcon);

        button.addActionListener(e -> {
            if (ArenaGame.this.isVisible()) {
                new TicTacToe();
                ArenaGame.this.setVisible(false);
            }
        });

        panelMenu.add(button,BorderLayout.WEST);

        panelPemain = new JPanel();
        panelPemain.setOpaque(false);
        layoutPemain = new GridBagLayout();
        panelPemain.setLayout(layoutPemain);

        constraints = new GridBagConstraints();

        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=1;
        constraints.gridy = 1;

        //Panel penunjuk pemain
        label = new JLabel("Pemain 1 ");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=2;
        constraints.gridy = 1;

        if(p1.equals("X")) {
            imageX = new ImageIcon("img/x.png");
            imageX1 = imageX.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            imageIconX = new ImageIcon(imageX1);

            label = new JLabel(imageIconX);
            label.setSize(10,10);
            label.setFont(fontText);
            panelPemain.add(label,constraints);
        }
        else{
            imageO = new ImageIcon("img/o.png");
            imageO1 = imageO.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
            imageIconO = new ImageIcon(imageO1);

            label = new JLabel(imageIconO);
            label.setSize(10,10);
            label.setFont(fontText);
            panelPemain.add(label,constraints);
        }


        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=1;
        constraints.gridy = 2;

        label = new JLabel("Pemain 2 ");
        label.setSize(10,10);
        label.setFont(fontText);
        panelPemain.add(label,constraints);

        constraints.gridwidth= 1;
        constraints.gridheight = 1;
        constraints.gridx=2;
        constraints.gridy = 2;

        if(p2.equals("X")) {
            imageX = new ImageIcon("img/x.png");
            imageX1 = imageX.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            imageIconX = new ImageIcon(imageX1);

            label = new JLabel(imageIconX);
            label.setSize(10,10);
            label.setFont(fontText);
            panelPemain.add(label,constraints);
        }
        else{
            imageO = new ImageIcon("img/o.png");
            imageO1 = imageO.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
            imageIconO = new ImageIcon(imageO1);

            label = new JLabel(imageIconO);
            label.setSize(10,10);
            label.setFont(fontText);
            panelPemain.add(label,constraints);
        }

        panelPemain.setBorder(BorderFactory.createEmptyBorder(5,0,0,10));

        panelGame = new JPanel();
        panelGame.setOpaque(false);
        layoutGame = new GridLayout(lebar,panjang);
        panelGame.setLayout(layoutGame);

        Kotak[][] kotak = new Kotak[lebar][panjang];
        for(int i = 0;i<lebar;i++) {
            for (int j = 0;j<panjang;j++){
                kotak[i][j] = new Kotak(panjang,lebar);

                int posY = j;
                int posX = i;

                kotak[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(kotak[posX][posY].getSymbol() == "") {
                            counter++;
                            String symbolSekarang = "";

                            if (giliran1) {
                                kotak[posX][posY].setSymbol(p1);
                                giliran1 = false;
                                giliran2 = true;
                                symbolSekarang = kotak[posX][posY].getSymbol();
                            } else {
                                kotak[posX][posY].setSymbol(p2);
                                giliran2 = false;
                                giliran1 = true;
                                symbolSekarang = kotak[posX][posY].getSymbol();
                            }

                            //cek horizontal
                            for (int k = posY - blok + 1; k <= posY; k++) {
                                win = true;
                                for (int m = k; m <= k + blok - 1; m++) {
                                    if (m < 0 || m >= panjang) {
                                        win = false;
                                    } else {
                                        String symbolKotak = kotak[posX][m].getSymbol();
                                        if (symbolKotak == null || symbolKotak.isEmpty() || !symbolKotak.equals(symbolSekarang)) {
                                            win = false;
                                        }
                                    }
                                }

                                if (win) {
                                    menang();
                                    return;
                                }
                            }

                            //cek vertical
                            for (int k = posX - blok + 1; k <= posX; k++) {
                                win = true;
                                for (int m = k; m <= k + blok - 1; m++) {
                                    if (m < 0 || m >= lebar) {
                                        win = false;
                                    } else {
                                        String symbolKotak = kotak[m][posY].getSymbol();
                                        if (symbolKotak == null || symbolKotak.isEmpty() || !symbolKotak.equals(symbolSekarang)) {
                                            win = false;
                                        }
                                    }
                                }

                                if (win) {
                                    menang();
                                    return;
                                }
                            }

                            //diagonal kiri
                            for (int k = 1- blok  ; k <= 0 ; k++) {
                                win = true;
                                for (int m = 0 ; m < blok; m++) {
                                    int y = posY + k + m;
                                    int x = posX + k + m;

                                    if (x < 0 || x >= lebar || y <0 || y >= panjang) {
                                        win = false;
                                    } else {
                                        String symbolKotak = kotak[x][y].getSymbol();
                                        if (symbolKotak == null || symbolKotak.isEmpty() || !symbolKotak.equals(symbolSekarang)) {
                                            win = false;
                                        }
                                    }
                                }

                                if (win) {
                                    menang();
                                    return;
                                }
                            }


                            //cek diagonal sebelah kanan
                            for (int k = 1- blok  ; k <= 0 ; k++) {
                                win = true;
                                for (int m = 0 ; m < blok; m++) {
                                    int y = posY-k-m;
                                    int x = posX+k+m;

                                    if (x < 0 || x >= lebar || y <0 || y >= panjang) {
                                        win = false;
                                    } else {
                                        String symbolKotak = kotak[x][y].getSymbol();
                                        if (symbolKotak == null || symbolKotak.isEmpty() || !symbolKotak.equals(symbolSekarang)) {
                                            win = false;
                                        }
                                    }
                                }

                                if (win) {
                                    menang();
                                    return;
                                }
                            }

                            if(!win && (counter == (panjang*lebar))){
                                JOptionPane.showMessageDialog(panelArena ,"Permainan seri");
                                if (ArenaGame.this.isVisible()) {
                                    new TicTacToe();
                                    ArenaGame.this.setVisible(false);
                                }
                            }
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

        this.setVisible(true);

    }

    public void menang(){
        if(giliran1){
            pemenang = "Pemain 2";
        }
        else{
            pemenang = "Pemain 1";
        }
        JOptionPane.showMessageDialog(panelArena ,pemenang+" menang");
        if (ArenaGame.this.isVisible()) {
            new TicTacToe();
            ArenaGame.this.setVisible(false);
        }
    }

}
