import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Event {
    String name;
    String city;
    String time;
    int capacity;

    public Event(String name, String city, String time, int capacity) {
        this.name = name;
        this.city = city;
        this.time = time;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Event Name: " + name + "\nCity: " + city + "\nTime: " + time + "\nCapacity: " + capacity;
    }
}

public class AddEventForm extends JFrame {
    private JTextField txtEventName;
    private JTextField txtEventCity;
    private JTextField txtEventTime;
    private JTextField txtEventCapacity;
    private JButton btnAddEvent;
    private ArrayList<Event> events;

    public AddEventForm(ArrayList<Event> events) {
        this.events = events; // Reference to the shared events list
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Event");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel lblTitle = new JLabel("Add New Event");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblTitle, gbc);

        // Event Name
        JLabel lblEventName = new JLabel("Event Name:");
        txtEventName = new JTextField(15);
        gbc.gridwidth = 1; // Reset to default
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblEventName, gbc);
        gbc.gridx = 1;
        add(txtEventName, gbc);

        // Event City
        JLabel lblEventCity = new JLabel("Event City:");
        txtEventCity = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblEventCity, gbc);
        gbc.gridx = 1;
        add(txtEventCity, gbc);

        // Event Time
        JLabel lblEventTime = new JLabel("Event Time:");
        txtEventTime = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblEventTime, gbc);
        gbc.gridx = 1;
        add(txtEventTime, gbc);

        // Event Capacity
        JLabel lblEventCapacity = new JLabel("Event Capacity:");
        txtEventCapacity = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblEventCapacity, gbc);
        gbc.gridx = 1;
        add(txtEventCapacity, gbc);

        // Add Event Button
        btnAddEvent = new JButton("Add Event");
        btnAddEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtEventName.getText();
                String city = txtEventCity.getText();
                String time = txtEventTime.getText();
                int capacity;

                try {
                    capacity = Integer.parseInt(txtEventCapacity.getText());
                    Event event = new Event(name, city, time, capacity);
                    events.add(event);
                    JOptionPane.showMessageDialog(null, "Event added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Clear fields for new entry
                    txtEventName.setText("");
                    txtEventCity.setText("");
                    txtEventTime.setText("");
                    txtEventCapacity.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Capacity must be a number", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span across two columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnAddEvent, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddEventForm(new ArrayList<>()).setVisible(true));
    }
}