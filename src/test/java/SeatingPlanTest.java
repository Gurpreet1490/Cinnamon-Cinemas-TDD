import Model.BookingManager;
import Model.InvalidSeat;
import Model.SeatingPlan;
import Model.Status;
import org.junit.Test;

import java.util.List;

import static Model.Status.Reserved;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class SeatingPlanTest {

    @Test
    public void practice(){
        new SeatingPlan(3, 5);
    }

    //Testing row sequence
    @Test
    public void stringTest(){
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVW", SeatingPlan.ROW_SEQUENCE_ORDER);
    }

    @Test
    public void checkingValidNumberOfSeatEmpty(){
        SeatingPlan seatingPlan = new SeatingPlan(4, 5);
        assertEquals(20, seatingPlan.getEmptySeatCount());
    }

    @Test
    public void throwExceptionForInvalidSeatCount(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> new SeatingPlan('-', 2));
    }

    @Test
    public void checkingSeatStatus() throws InvalidSeat {
        SeatingPlan seatingPlan = new SeatingPlan(2,2);
        assertEquals(Status.Empty, seatingPlan.getSeatStatus(2, 1));
    }



    @Test
    public void testForBookingManagerClass(){
        BookingManager bookingManager = new BookingManager();
    }


}
