import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PersonalityClientGUI extends JFrame {
    private JTextField answerField1, answerField2, answerField3;
    private JButton submitButton;

    public PersonalityClientGUI() {
        super("Test licnosti");

        answerField1 = new JTextField(10);
        answerField2 = new JTextField(10);
        answerField3 = new JTextField(10);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer1 = Integer.parseInt(answerField1.getText());
                int answer2 = Integer.parseInt(answerField2.getText());
                int answer3 = Integer.parseInt(answerField3.getText());

                try {
                    Registry registry = LocateRegistry.getRegistry("localhost"); // Use the server's hostname or IP
                    PersonalityTest test = (PersonalityTest) registry.lookup("PersonalityServer");

                    String personalityType = test.submitAnswers(answer1, answer2, answer3);
                    JOptionPane.showMessageDialog(null, "Vas tip licnosti je: " + personalityType);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Greska prilikom obrade forme. Pokusajte ponovo.");
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Question 1: How outgoing are you? (1-5)"));
        panel.add(answerField1);
        panel.add(new JLabel("Question 2: How social are you? (1-5)"));
        panel.add(answerField2);
        panel.add(new JLabel("Question 3: How talkative are you? (1-5)"));
        panel.add(answerField3);
        panel.add(new JLabel(""));
        panel.add(submitButton);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonalityClientGUI().setVisible(true);
            }
        });
    }
}
