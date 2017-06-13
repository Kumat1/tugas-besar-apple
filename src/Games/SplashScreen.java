package Games;

import javax.swing.*;

public class SplashScreen extends JFrame {
    JFrame home;
    public SplashScreen() {
        home = new JFrame();
        home.add(new JLabel(new ImageIcon("img/tictactoe1.gif")));
        home.setSize(500, 500);
        home.setLocationRelativeTo(null);
        home.setVisible(true);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startGame();
            }
        }).start();

    }

    public static void main(String[] args) {
        new SplashScreen();
    }

    private void startGame() {
        home.setVisible(false);

        new TicTacToe();

        home.dispose();
    }
}
