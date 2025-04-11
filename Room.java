public class Room {
    private int roomID;
    private String roomType;
    private double price;
    private boolean available;

    public Room(int roomID, String roomType, double price, boolean available) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.price = price;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean status) {
        this.available = status;
    }

    // Getters and Setters
}