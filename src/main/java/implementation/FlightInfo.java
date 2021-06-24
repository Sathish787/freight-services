package implementation;

public class FlightInfo {
    private final int flight;
    private final String departure = "YUL";
    private final String arrival;
    private final int day;

    public FlightInfo(int flight, String arrival, int day) {
        this.flight = flight;
        this.arrival = arrival;
        this.day = day;
    }

    public int getFlight() {
        return flight;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return  "Flight: " + flight +
                ", departure: " + departure +
                ", arrival: " + arrival +
                ", day: " + day ;
    }
}
