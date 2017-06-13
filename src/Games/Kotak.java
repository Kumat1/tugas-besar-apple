package Games;

import javax.swing.*;
import java.awt.*;

public class Kotak extends JLabel {
    private String symbol;
    private int panjang,lebar;
    private Font font;
    public Kotak(int p,int l){
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

        this.symbol = "";
        this.panjang = p;
        this.lebar = l;

        if(panjang <= 3 && lebar<=4){
            font = new Font("Arial",Font.BOLD,120);
        }else if(panjang <= 4 && lebar<=5){
            font = new Font("Arial",Font.BOLD,100);
        }else if(panjang <= 5 && lebar<=5){
            font = new Font("Arial",Font.BOLD,80);
        }else if(panjang <= 6 && lebar<=6){
            font = new Font("Arial",Font.BOLD,70);
        }else if(panjang <= 7 && lebar<=7){
            font = new Font("Arial",Font.BOLD,60);
        }else if(panjang <= 8 && lebar<=8){
            font = new Font("Arial",Font.BOLD,50);
        }else if(panjang <= 9 && lebar<=9){
            font = new Font("Arial",Font.BOLD,40);
        }else{
            font = new Font("Arial",Font.BOLD,30);
        }

        this.setOpaque(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black,1));
        this.setFont(font);
        this.setHorizontalAlignment(CENTER);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;

        this.setText(symbol);
    }
}
