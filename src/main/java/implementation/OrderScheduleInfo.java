package implementation;

public class OrderScheduleInfo implements Comparable<OrderScheduleInfo> {
    private final String order;
    FlightInfo flightInfo;

    public OrderScheduleInfo(String order, FlightInfo flightInfo) {
        this.order = order;
        this.flightInfo = flightInfo;
    }

    public String getOrder() {
        return order;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    @Override
    public int compareTo(OrderScheduleInfo orderScheduleInfo) {
        return this.order.compareTo(orderScheduleInfo.getOrder());
    }

    @Override
    public String toString() {
        String flights = flightInfo.getFlight() != 0? String.valueOf(flightInfo.getFlight()) : "not scheduled";
        if(flights.equals("not scheduled")) {
            return  "order: " + order +
                    ", flightNumber: " + flights;
        } else {
            return  "order: " + order +
                    ", flightNumber: " + flights +
                    ", departure: " + flightInfo.getDeparture() +
                    ", arrival: " + flightInfo.getArrival() +
                    ", day: " + flightInfo.getDay();
        }
    }
}
