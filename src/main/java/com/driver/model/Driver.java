public class Driver {
    private String name;
    private String licenseNumber;
    private boolean available;

    public Driver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.available = true;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    // Driver Functions
    public void updateAvailability(boolean available) {
        this.available = available;
    }

    public void deleteDriver() {
        // Logic to delete driver, e.g., remove from database
    }
}
