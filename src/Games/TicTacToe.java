package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TicTacToe extends JFrame {
    private BoxLayout layoutMain;
    private GridBagLayout layoutInput;
    private Font font;
    private JPanel panelMain,panelInput;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem themes,close;
    private GridBagConstraints constraints;
    private JLabel panjang,lebar,blok,pemain;
    private JComboBox fieldPanjang,fieldLebar,fieldBlok,fieldPemain;
    private String pilihan[]={"3","4","5","6","7","8","9","10"};
    private String pilihan1[]={"Player 1 : X , Player 2 : O","Player 1 : O , Player 2 : X"};
    private String pemain1,pemain2;
    private Integer index;
    private JButton buttonOk;
    private int selectedPanjang,selectedLebar,selectedBlok;

    public TicTacToe()
    {
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

        ActionListener actionButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPanjang = Integer.valueOf(String.valueOf(fieldPanjang.getSelectedItem()));

                selectedLebar = Integer.valueOf(String.valueOf(fieldLebar.getSelectedItem()));

                selectedBlok = Integer.valueOf(String.valueOf(fieldBlok.getSelectedItem()));

                int selectedIndex = fieldPemain.getSelectedIndex();

                if(selectedIndex == 0) {
                    pemain1 = "X";
                    pemain2 = "O";
                }
                else if(selectedIndex == 1){
                    pemain1 = "O";
                    pemain2 = "X";
                }

                ArenaGame arenaGame = new ArenaGame(selectedPanjang, selectedLebar,selectedBlok,pemain1,pemain2);
                TicTacToe.this.setVisible(false);
            }
        };

        font = new Font("Consolas", Font.PLAIN ,15);

        //panelMain
        panelMain = (JPanel) this.getContentPane();
        layoutMain = new BoxLayout(panelMain, BoxLayout.Y_AXIS);
        panelMain.setLayout(layoutMain);


        //menubar
        menuBar = new JMenuBar();
        file = new JMenu("File");

        themes = new JMenuItem("Change Themes");
        themes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                File background = file.getSelectedFile();
            }
        });

        close = new JMenuItem("Exit");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(themes);
        file.add(close);

        menuBar.add(file);

        setJMenuBar(menuBar);

        //panel Input
        panelInput = new JPanel();
        layoutInput = new GridBagLayout();
        panelInput.setLayout(layoutInput);

        //constraints ,label,field,button
        constraints = new GridBagConstraints();

        constraints.weightx = 1;
        constraints.weighty=1;

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=1;
        constraints.gridx=0;

        panjang = new JLabel("Panjang :");
        panjang.setPreferredSize(new Dimension(180,20));
        panjang.setFont(font);
        panelInput.add(panjang,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=1;
        constraints.gridx=2;

        fieldPanjang = new JComboBox(pilihan);
        fieldPanjang.setPreferredSize(new Dimension(250,20));
        fieldPanjang.setFont(font);
        panelInput.add(fieldPanjang,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=2;
        constraints.gridx=0;

        lebar = new JLabel("Lebar :");
        lebar.setPreferredSize(new Dimension(180,20));
        lebar.setFont(font);
        panelInput.add(lebar,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=2;
        constraints.gridx=2;

        fieldLebar = new JComboBox(pilihan);
        fieldLebar.setPreferredSize(new Dimension(250,20));
        fieldLebar.setFont(font);
        panelInput.add(fieldLebar,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=3;
        constraints.gridx=0;

        blok = new JLabel("Blok untuk menang:");
        blok.setPreferredSize(new Dimension(180,20));
        blok.setFont(font);
        panelInput.add(blok,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=3;
        constraints.gridx=2;

        fieldBlok = new JComboBox(pilihan);
        fieldBlok.setPreferredSize(new Dimension(250,20));
        fieldBlok.setFont(font);
        panelInput.add(fieldBlok,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=4;
        constraints.gridx=0;

        pemain = new JLabel("Pemain :");
        pemain.setPreferredSize(new Dimension(180,20));
        pemain.setFont(font);
        panelInput.add(pemain,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=4;
        constraints.gridx=2;

        fieldPemain = new JComboBox(pilihan1);
        fieldPemain.setPreferredSize(new Dimension(250,20));
        fieldPemain.setFont(font);
        panelInput.add(fieldPemain,constraints);


        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=7;
        constraints.gridx=3;

        buttonOk = new JButton("Play");
        buttonOk.setPreferredSize(new Dimension(80,25));
        buttonOk.setFont(font);
        buttonOk.addActionListener(actionButton);
        panelInput.add(buttonOk,constraints);


        panelInput.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelMain.add(panelInput);

        this.setTitle("Tic Tac Toe");
        this.setSize(500,250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
      new TicTacToe();
    }
}
