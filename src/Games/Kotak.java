package Games;

import javax.swing.*;
import java.awt.*;

public class Kotak extends JLabel {
    private String symbol;

    public Kotak(){
        this.symbol = "";

        this.setOpaque(true);
        this.setBackground(Color.BLUE);
        this.setBorder(BorderFactory.createLineBorder(Color.black,1));
    }

    public String getSymbol() {
        return symbol;
    }

    private void setSymbol(String symbol) {
        this.symbol = symbol;

        this.setText(symbol);
    }
}
