import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ManagerLoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private ArrayList<Event> events; // Reference to the events list

    public ManagerLoginForm(ArrayList<Event> events) {
        this.events = events; // Get reference to the events list
        initComponents();
    }

    private void initComponents() {
        // Set the frame properties
        setTitle("Manager Login");
        setSize(400, 250); // Increased size for better visibility
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel with GridBagLayout for better organization
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel lblTitle = new JLabel("Manager Login");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24)); // Bold font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        panel.add(lblTitle, gbc);

        // Username label and text field
        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset grid width
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        panel.add(lblUsername, gbc);

        txtUsername = new JTextField(20); // Increased width
        gbc.gridx = 1;
        panel.add(txtUsername, gbc);

        // Password label and text field
        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(20); // Increased width
        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        // Login button
        btnLogin = new JButton("Log In");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        panel.add(btnLogin, gbc);

        // Add action listener for the login button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("manager") && password.equals("manager123")) {
                    // Successful login, show events
                    StringBuilder eventList = new StringBuilder("Events:\n");
                    for (Event event : events) {
                        eventList.append(event.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, eventList.toString(), "Event List", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminLoginForm adminLoginForm = new AdminLoginForm();
            adminLoginForm.setVisible(true);
            // After the admin form is visible, create the manager form
            ManagerLoginForm managerLoginForm = new ManagerLoginForm(adminLoginForm.getEvents());
            managerLoginForm.setVisible(true);
        });
    }
}