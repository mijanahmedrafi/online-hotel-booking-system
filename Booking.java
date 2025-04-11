public class Booking {
    private int bookingID;
    private int userID;
    private int roomID;
    private String checkIn;
    private String checkOut;

    public Booking(int bookingID, int userID, int roomID, String checkIn, String checkOut) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.roomID = roomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters, Setters, and other methods
}