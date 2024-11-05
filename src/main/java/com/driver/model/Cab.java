public class Cab {
    private double perKmRate;
    private boolean available;

    public Cab(double perKmRate) {
        this.perKmRate = perKmRate;
        this.available = true;
    }

    // Getters and Setters
    public double getPerKmRate() { return perKmRate; }
    public void setPerKmRate(double perKmRate) { this.perKmRate = perKmRate; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
