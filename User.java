import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    private String role;

    private static Map<String, User> usersDatabase = new HashMap<>();

    public User(int userID, String name, String email, String password, String role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
        this.role = role;
        usersDatabase.put(email, this);
    }

    public int getUserID() { return userID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }

    public static User registerUser(int userID, String name, String email, String password, String role) {
        if (usersDatabase.containsKey(email)) {
            System.out.println("❌ Registration failed: Email already exists.");
            return null;
        }
        return new User(userID, name, email, password, role);
    }

    public static boolean loginUser(String email, String password) {
        User user = usersDatabase.get(email);
        if (user != null && user.password.equals(user.hashPassword(password))) {
            System.out.println("✅ Login Successful! Welcome, " + user.getName());
            return true;
        } else {
            System.out.println("❌ Login Failed: Incorrect email or password.");
            return false;
        }
    }

    public void displayUserInfo() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }
}