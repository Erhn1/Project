package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSlipPanelExample implements ActionListener {
    private JPanel orderSlipPanel;
    private JPanel orderPanel;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JLabel studentIDLabel;
    private JLabel departmentLabel;
    private JLabel yearLabel;
    private JTextField nameTextField;
    private JTextField dateTextField;
    private JTextField studentIDTextField;
    private JTextField departmentTextField;
    private JTextField yearTextField;
    private JButton submitOrderButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                OrderSlipPanelExample example = new OrderSlipPanelExample();
                example.orderFrame();
            }
        });
    }

    private void orderFrame() {
        JFrame frame = new JFrame("Order Slip");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        orderPanel();

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.ORANGE);
        contentPane.setPreferredSize(new Dimension(800, 600));

        // Add details in order slip panel
        orderPanel();

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.ORANGE);
        centerPanel.add(orderPanel);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private void orderPanel() {
      orderSlipPanel = new JPanel(new BorderLayout());
      orderSlipPanel.setBackground(Color.ORANGE);
      orderSlipPanel.setPreferredSize(new Dimension(800, 600));

      // Add details in order slip panel
      orderPanel = new JPanel(new GridLayout(10, 2, 3, 3)); // Reduce the gap to 5 pixels
      orderPanel.setBackground(Color.ORANGE); // Set the background color of the orderPanel

      nameLabel = new JLabel("Name:");
      nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
      orderPanel.add(nameLabel);

      nameTextField = new JTextField(20);
      orderPanel.add(nameTextField);

      dateLabel = new JLabel("Date:");
      dateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
      orderPanel.add(dateLabel);

      dateTextField = new JTextField(20);
      orderPanel.add(dateTextField);

      studentIDLabel = new JLabel("Student ID:");
      studentIDLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
      orderPanel.add(studentIDLabel);

      studentIDTextField = new JTextField(20);
      orderPanel.add(studentIDTextField);

      departmentLabel = new JLabel("Department:");
      departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
      orderPanel.add(departmentLabel);

      departmentTextField = new JTextField(20);
      orderPanel.add(departmentTextField);

      yearLabel = new JLabel("Year:");
      yearLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
      orderPanel.add(yearLabel);

      yearTextField = new JTextField(20);
      orderPanel.add(yearTextField);

      orderSlipPanel.add(orderPanel, BorderLayout.CENTER);
    }

    // Helper method to create a panel that centers the given component
    private JPanel createCenteredPanel(Component component) {
        JPanel centeredPanel = new JPanel();
        centeredPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centeredPanel.setBackground(Color.ORANGE);
        centeredPanel.add(component);
        return centeredPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event here
    }
}
