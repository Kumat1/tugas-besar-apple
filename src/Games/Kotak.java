package Games;

import javax.swing.*;
import java.awt.*;

public class Kotak extends JLabel {
    private String symbol;

    public Kotak(){
        this.symbol = "";

        Font font = new Font("Arial",Font.BOLD,50);
        this.setOpaque(true);
        this.setBackground(Color.BLUE);
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
