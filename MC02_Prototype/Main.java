import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ELDEN ROGUE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        MainPanel mainPanel = new MainPanel();
        mainPanel.setOpaque(true);
        frame.setContentPane(mainPanel);

        frame.setVisible(true);
    }
}

/**
 * The MainPanel class represents the main panel of the game.
 * It extends the JPanel class and contains buttons for starting and ending the game.
 */
class MainPanel extends JPanel {
    private boolean GAMESTATE = true;

    /**
     * Constructs a new MainPanel object.
     * Initializes the panel with a BorderLayout and adds start and end buttons.
     */
    public MainPanel() {
        super(new BorderLayout());
        JButton startButton = new JButton("Start Game");
        JButton endButton = new JButton("End Game");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GAMESTATE) {
                    util.startGame();
                }
            }
        });

        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("byebye");
                GAMESTATE = false;
                System.exit(0);
            }
        });

        add(startButton, BorderLayout.NORTH);
        add(endButton, BorderLayout.SOUTH);
    }
}