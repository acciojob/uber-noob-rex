public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Admin Functions
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void deleteAdmin() {
        // Logic to delete admin, e.g., remove from database
    }
}
