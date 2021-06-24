import implementation.FlightInfo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserStoryOneTest {

    @Test
    public void assertFlightSchedule() {
        List<FlightInfo> flightInfoList = UserStoryOne.FlightInfoService(3, 1);
        for(FlightInfo flight : flightInfoList) {
            assertEquals(flight.toString(), "Flight: " + flight.getFlight() + ", departure: "
                    + flight.getDeparture() + ", arrival: " + flight.getArrival() + ", day: " + flight.getDay());
            System.out.println(flight.toString());
        }
    }
}
