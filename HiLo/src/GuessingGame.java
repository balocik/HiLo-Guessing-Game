/**
 * Created by wojciechkuczer on 03/09/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame {
    private JTextField txtGuess;
    private JLabel lblOutput;
    private int theNumber;
    private int numberOfTries = 7;

    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";
        // check user guess

        try {

            int guess = Integer.parseInt(guessText);

            if (guess > theNumber) {
                message = guess + " was too high.You have " + --numberOfTries + " guesies left";
                lblOutput.setText(message);
            } else if (guess < theNumber) {
                message = guess + " was too low. You have " + --numberOfTries + " guesies left";
                lblOutput.setText(message);
            } else {
                message = guess + " is correct. You are a WINNER";
                txtGuess.setText("WINNER");
                lblOutput.setText(message);

            }


        } catch (Exception e) {
            lblOutput.setText("Enter whole number between 1 and 30");
        } finally {
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
        if(numberOfTries == 0) {
            txtGuess.setText("LOST");
            txtGuess.selectAll();
            lblOutput.setText("The number was " + theNumber);
            numberOfTries = 7;
        }
    }


    public void newGame() {
        theNumber = (int) (Math.random() * 30 + 1);
    }

    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblGuessingGameBy = new JLabel("Guessing Game by Wojtek Allmighty");
        lblGuessingGameBy.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblGuessingGameBy.setBounds(0, 22, 450, 26);
        lblGuessingGameBy.setForeground(new Color(34, 139, 34));
        lblGuessingGameBy.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblGuessingGameBy);

        JPanel panel = new JPanel();
        panel.setBounds(43, 70, 364, 46);
        getContentPane().add(panel);
        panel.setLayout(null);

        txtGuess = new JTextField();
        txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(253, 6, 72, 26);
        panel.add(txtGuess);
        txtGuess.setColumns(10);

        JLabel lblGuessNumberBetween = new JLabel("Guess number between 1 and 30");
        lblGuessNumberBetween.setBounds(19, 11, 205, 16);
        panel.add(lblGuessNumberBetween);

        JButton btnGuess = new JButton("Guess");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnGuess.setBounds(167, 138, 117, 29);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Enter the number above and click Guess");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(6, 189, 438, 16);
        getContentPane().add(lblOutput);

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
                numberOfTries = 7;
                txtGuess.setText("START");
                txtGuess.requestFocus();
                txtGuess.selectAll();
                lblOutput.setText("You have " + numberOfTries + " guessies left");
            }
        });
        btnNewGame.setBounds(167, 227, 117, 29);
        getContentPane().add(btnNewGame);
    }

    public static void main(String[] args) {

        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(430, 330));
        theGame.setVisible(true);

    }
}