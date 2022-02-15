package Model;

public class BookingManager {
    private int maxRows;
    private int rowSize;
    private SeatingPlan seatingPlan;

    public BookingManager(int maxRows, int rowSize) {
        this.maxRows = maxRows;
        this.rowSize = rowSize;
        this.seatingPlan = new SeatingPlan(maxRows, rowSize);
    }

    public String bookSeats(int seatCount) throws InvalidSeat {
        int bookedSeatCount = 0;
        if(seatingPlan.getEmptySeatCount() >= seatCount) {
            for(int rowNumber = 1; rowNumber <= maxRows; rowNumber++) {
                for(int seatNumber=1; seatNumber<=rowSize; seatNumber++) {
                    if (seatingPlan.getSeatStatus(rowNumber, seatNumber).equals(Status.Empty)) {
                        seatingPlan.updateStatus(rowNumber, seatNumber, Status.Reserved);
                        bookedSeatCount++;
                    }
                    if(bookedSeatCount >= seatCount) {
                        return "Successfully booked";
                    }
                }
            }
        }
        return "seats not available";
    }
}
