import Model.SeatingPlan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
    public void testForBookingManagerClass(){
        BookingManager bookingManager = new BookingManager(3, 5);
    }


}
