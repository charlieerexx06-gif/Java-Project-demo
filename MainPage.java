import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame {

    static PostManager pm = new PostManager();

    JLabel l0, l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2, b3, b4, b5, b6;
    JTextArea ta;

    User loginUser;

    MainPage(User u) {
        loginUser = u;

        setTitle("AIUB Lost and Found System");
        setSize(600, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l0 = new JLabel("Logged in: " + loginUser.name + " (" + loginUser.studentId + ")");
        l1 = new JLabel("Item Name:");
        l2 = new JLabel("Category:");
        l3 = new JLabel("Location:");
        l4 = new JLabel("Description:");
        l5 = new JLabel("Finder Contact:");
        l6 = new JLabel("Finder Name:");
        l7 = new JLabel("Index / Search:");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);
        t7 = new JTextField(20);

        b1 = new JButton("Create");
        b2 = new JButton("Read");
        b3 = new JButton("Update");
        b4 = new JButton("Delete");
        b5 = new JButton("Search");
        b6 = new JButton("Clear");

        ta = new JTextArea(20, 45);
        ta.setEditable(false);

        add(l0);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(l5); add(t5);
        add(l6); add(t6);
        add(l7); add(t7);

        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);
        add(new JScrollPane(ta));

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = t1.getText();
                String category = t2.getText();
                String location = t3.getText();
                String description = t4.getText();
                String contact = t5.getText();
                String finderName = t6.getText();

                LostItem p = new LostItem(itemName, category, location, description,
                                          contact, finderName, loginUser.studentId);

                pm.addPost(p);
                ta.setText("Post Added Successfully");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.setText(pm.showAllPost());
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(t7.getText());

                    String itemName = t1.getText();
                    String category = t2.getText();
                    String location = t3.getText();
                    String description = t4.getText();
                    String contact = t5.getText();
                    String finderName = t6.getText();

                    boolean x = pm.updatePost(index, itemName, category, location,
                                              description, contact, finderName, loginUser.studentId);

                    if (x == true) {
                        ta.setText("Post Updated Successfully");
                    } else {
                        ta.setText("Update Failed");
                    }

                } catch (Exception ex) {
                    ta.setText("Invalid Input");
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(t7.getText());

                    boolean x = pm.deletePost(index, loginUser.studentId);

                    if (x == true) {
                        ta.setText("Post Deleted Successfully");
                    } else {
                        ta.setText("Delete Failed");
                    }

                } catch (Exception ex) {
                    ta.setText("Invalid Input");
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = t7.getText();
                ta.setText(pm.searchPost(item));
            }
        });

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                ta.setText("");
            }
        });

        setVisible(true);
    }
}