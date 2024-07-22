import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddressBookGUI {
    private AddressBook addressBook;
    private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextArea contactListArea;

    public AddressBookGUI() {
        addressBook = new AddressBook();
        frame = new JFrame("Address Book Demo");
        
        // İkon dosyasını doğru yoldan yükleme
        URL iconURL = getClass().getResource("C:/Users/FromSTAR/eclipse-workspace/Learn_Java_1/AdressBookDemo/src/icon.png");  // "/icon.png" yolunu kullanıyoruz
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        } else {
            System.err.println("Icon resource not found.");
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
        inputPanel.add(addButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        contactListArea = new JTextArea();
        contactListArea.setEditable(false);
        frame.add(new JScrollPane(contactListArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        Contacts contact = new Contacts(name, phone, email);
        addressBook.addContact(contact);
        updateContactList();
        clearFields();
    }

    private void updateContactList() {
        contactListArea.setText("");
        for (Contacts contact : addressBook.getContacts()) {
            contactListArea.append(contact.toString() + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new AddressBookGUI();
    }
}

