import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    LoginPage() {
        setTitle("Login Page");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Name:");
        l2 = new JLabel("Student ID:");

        t1 = new JTextField(20);
        t2 = new JTextField(20);

        b1 = new JButton("Login as Finder");
        b2 = new JButton("Login as Owner");

        add(l1); add(t1);
        add(l2); add(t2);
        add(b1); add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String id = t2.getText();

                Finder f = new Finder(name, id);
                new MainPage(f);
                dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String id = t2.getText();

                Owner o = new Owner(name, id);
                new MainPage(o);
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}