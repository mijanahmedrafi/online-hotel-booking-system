import javax.swing.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Booking - Login");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passLabel = new JLabel("Password:");
        JTextField emailField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        emailLabel.setBounds(30, 30, 80, 25);
        emailField.setBounds(120, 30, 150, 25);
        passLabel.setBounds(30, 70, 80, 25);
        passField.setBounds(120, 70, 150, 25);
        loginBtn.setBounds(100, 110, 80, 30);

        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginBtn);

        frame.setSize(320, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}