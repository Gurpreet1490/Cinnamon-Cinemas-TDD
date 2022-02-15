package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatingPlan {

    public static final String ROW_SEQUENCE_ORDER = "ABCDEFGHIJKLMNOPQRSTUVW";

    private Map<Character, List<Status>> seats = new HashMap<>();

    public SeatingPlan(int maxRow, int rowSize) {
        for(int i =0; i < maxRow; i++){
            addRow(ROW_SEQUENCE_ORDER.charAt(i), rowSize);
        }
    }

    public void updateStatus(int rowNumber, int seatNumber, Status status){
        seats.get(ROW_SEQUENCE_ORDER.charAt(rowNumber-1)).set(seatNumber-1, status);
    }

    public Status getSeatStatus(int rowNumber, int seatNumber) throws InvalidSeat {
        try {
            return seats.get(ROW_SEQUENCE_ORDER.charAt(rowNumber-1)).get(seatNumber - 1);
        } catch (Exception e) {
            throw new InvalidSeat("Seat with row " + ROW_SEQUENCE_ORDER.charAt(rowNumber-1) + " and number " + seatNumber + " does not exist");
        }
    }

    private void addRow(Character row, int rowSize) {
        seats.put(row, initialiseRow(rowSize));
    }

    private List<Status> initialiseRow(int rowSize) {
        List<Status> newRow = new ArrayList<>();
        for(int i=0; i<rowSize; i++) {
            newRow.add(Status.Empty);
        }
        return newRow;
    }

    public int getEmptySeatCount() {
        int emptySeatCount = 0;
        for(int i=0; i <seats.keySet().size(); i++) {
            List<Status> row = seats.get(ROW_SEQUENCE_ORDER.charAt(i));
            emptySeatCount += row.stream().filter(status -> status.equals(Status.Empty)).count();
        }
        return emptySeatCount;
    }

}
