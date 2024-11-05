public class TripBooking {
    private String source;
    private String destination;
    private double distance;
    private String status;
    private double bill;

    public TripBooking(String source, String destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getBill() { return bill; }
    public void setBill(double bill) { this.bill = bill; }

    // TripBooking Functions
    public void calculateBill(double perKmRate) {
        this.bill = perKmRate * distance;
    }
}
