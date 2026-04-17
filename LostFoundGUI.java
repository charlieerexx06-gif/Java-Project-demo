import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class LostFoundGUI extends JFrame {

    ArrayList<Item> itemList = new ArrayList<>();

    JTextField nameField, contactField;
    JTextArea descArea;
    JComboBox<String> categoryBox;
    JTable table;
    DefaultTableModel model;

    public LostFoundGUI() {

        setTitle("Lost & Found Management System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        // ===== Form Panel =====
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Post Lost / Found Item"));

        nameField = new JTextField();
        contactField = new JTextField();
        descArea = new JTextArea();
        categoryBox = new JComboBox<>(new String[]{
                "Phone", "ID Card", "Wallet", "Others"
        });

        nameField.setFont(font);
        contactField.setFont(font);
        descArea.setFont(font);
        categoryBox.setFont(font);

        formPanel.add(new JLabel("Item Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Category"));
        formPanel.add(categoryBox);

        formPanel.add(new JLabel("Description"));
        formPanel.add(new JScrollPane(descArea));

        formPanel.add(new JLabel("Contact Info"));
        formPanel.add(contactField);

        JButton addBtn = new JButton("Add Post");
        formPanel.add(addBtn);

        add(formPanel, BorderLayout.NORTH);

        // ===== Table =====
        model = new DefaultTableModel(
                new String[]{"Item", "Category", "Description", "Contact"},
                0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== Bottom Panel =====
        JPanel bottomPanel = new JPanel();
        JButton deleteBtn = new JButton("Confirm & Delete");
        bottomPanel.add(deleteBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // ===== Actions =====
        addBtn.addActionListener(e -> addItem());
        deleteBtn.addActionListener(e -> deleteItem());

        setVisible(true);
    }

    // CREATE
    void addItem() {
        Item item = new FoundItem(
            nameField.getText(),
            categoryBox.getSelectedItem().toString(),
            descArea.getText(),
            contactField.getText()
        );

        itemList.add(item);
        model.addRow(item.getRowData());

        nameField.setText("");
        descArea.setText("");
        contactField.setText("");
    }

    // DELETE
    void deleteItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            itemList.remove(row);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first!");
        }
    }

    public static void main(String[] args) {
        new LostFoundGUI();
    }
}