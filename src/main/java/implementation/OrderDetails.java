package implementation;

public class OrderDetails {
    private final String orderNumber;
    private final String destinations;

    public OrderDetails(String key, String destination) {
        this.orderNumber = key;
        this.destinations = destination;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getDestinations() {
        return destinations;
    }
}
