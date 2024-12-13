import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminLoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private ArrayList<Event> events; // Store events

    public AdminLoginForm() {
        events = new ArrayList<>(); // Initialize the events list
        initComponents();
    }

    private void initComponents() {
        // Set the frame properties
        setTitle("Admin Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        // Create GridBagConstraints for layout management
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel lblTitle = new JLabel("Admin Login");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblTitle, gbc);

        // Username and Password Labels and Fields
        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15);
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);
        
        // Add components to layout
        gbc.gridwidth = 1; // Reset to default
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblUsername, gbc);
        gbc.gridx = 1;
        add(txtUsername, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPassword, gbc);
        gbc.gridx = 1;
        add(txtPassword, gbc);
        
        // Login Button
        btnLogin = new JButton("Log In");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    // Successful login, open AddEventForm
                    new AddEventForm(events).setVisible(true);
                    dispose(); // Close admin login form
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnLogin, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLoginForm().setVisible(true));
    }
    
    public ArrayList<Event> getEvents() {
        return events; // Return the list of events
    }
}