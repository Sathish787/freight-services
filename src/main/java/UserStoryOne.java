import implementation.FlightInfo;
import service.Destinations;
import service.ServiceUtils;

import java.util.ArrayList;
import java.util.List;

public class UserStoryOne {

    public static void main(String[] args) {
        int scheduledDays = 2;
        int days = 1;
        List<FlightInfo> flightInfoList = FlightInfoService(scheduledDays, days);
        for(FlightInfo flight : flightInfoList) {
            System.out.println(flight.toString());
        }
    }

    public static List<FlightInfo> FlightInfoService(int scheduledDays, int day) {
        List<FlightInfo> flightInfoList = new ArrayList<>();
        int flightNumber = 1;
        while(scheduledDays>0) {
            for(Destinations cityCode : Destinations.values()) {
                flightInfoList.add(new FlightInfo(flightNumber, cityCode.toString(), day));
                flightNumber++;
            }
            day++;
            scheduledDays--;
        }
        return flightInfoList;
    }
}
