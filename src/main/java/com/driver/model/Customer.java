public class Customer {
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Customer Functions
    public void bookTrip(TripBooking tripBooking) {
        // Logic to book a trip
    }

    public void deleteCustomer() {
        // Logic to delete customer, e.g., remove from database
    }
}
