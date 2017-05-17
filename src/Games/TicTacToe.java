package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private BoxLayout layoutMain;
    private GridBagLayout layoutInput;
    private Font font;
    private JPanel panelMain,panelInput;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem themes,close;
    private GridBagConstraints constraints;
    private JLabel panjang,lebar,blok,pemain1,pemain2;
    private JComboBox fieldPanjang,fieldLebar,fieldBlok,fieldPemain1,fieldPemain2;
    private String pilihan[]={"3","4","5","6","7","8","9","10"};
    private String pilihan1[]={"X","O"};
    private JButton buttonOk;

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

        this.setJMenuBar(menuBar);

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
        fieldPanjang.setPreferredSize(new Dimension(200,20));
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
        fieldLebar.setPreferredSize(new Dimension(200,20));
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
        fieldBlok.setPreferredSize(new Dimension(200,20));
        fieldBlok.setFont(font);
        panelInput.add(fieldBlok,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=4;
        constraints.gridx=0;

        pemain1 = new JLabel("Pemain 1:");
        pemain1.setPreferredSize(new Dimension(180,20));
        pemain1.setFont(font);
        panelInput.add(pemain1,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=4;
        constraints.gridx=2;

        fieldPemain1 = new JComboBox(pilihan1);
        fieldPemain1.setPreferredSize(new Dimension(200,20));
        fieldPemain1.setFont(font);
        panelInput.add(fieldPemain1,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=5;
        constraints.gridx=0;

        pemain2 = new JLabel("Pemain 2:");
        pemain2.setPreferredSize(new Dimension(180,20));
        pemain2.setFont(font);
        panelInput.add(pemain2,constraints);

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=5;
        constraints.gridx=2;

        fieldPemain2 = new JComboBox(pilihan1);
        fieldPemain2.setPreferredSize(new Dimension(200,20));
        fieldPemain2.setFont(font);
        panelInput.add(fieldPemain2,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=7;
        constraints.gridx=3;

        buttonOk = new JButton("Ok");
        buttonOk.setPreferredSize(new Dimension(80,25));
        buttonOk.setFont(font);
        panelInput.add(buttonOk,constraints);

        panelInput.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelMain.add(panelInput);

        this.setTitle("Tic Tac Toe");
        this.setSize(450,250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
      new TicTacToe();
    }
}
