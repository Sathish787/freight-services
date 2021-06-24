import implementation.OrderDetails;
import implementation.OrderScheduleInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserStoryTwoTest {

    @Test
    public void assertOrderScheduleInfo() {
        List<OrderDetails> ordersInfo = new ArrayList<>();
        ordersInfo.add(new OrderDetails("order-100", "YYZ"));
        ordersInfo.add(new OrderDetails("order-101", "YYC"));
        List<OrderScheduleInfo> orderInfoList = UserStoryTwo.orderScheduleInfoService(ordersInfo, 1, 10);
        Collections.sort(orderInfoList);
        for(OrderScheduleInfo orders : orderInfoList) {
            assertEquals(orders.toString(), "order: " + orders.getOrder() + ", flightNumber: "
                    + orders.getFlightInfo().getFlight() + ", departure: " + orders.getFlightInfo().getDeparture()
                    + ", arrival: " + orders.getFlightInfo().getArrival() + ", day: " + orders.getFlightInfo().getDay());
            System.out.println(orders.toString());
        }
    }

    @Test
    public void assertOrderInfoForNonExistDestination() {
        List<OrderDetails> ordersInfo = new ArrayList<>();
        ordersInfo.add(new OrderDetails("order-200", "XYZ"));
        ordersInfo.add(new OrderDetails("order-201", "ABC"));
        List<OrderScheduleInfo> orderInfoList = UserStoryTwo.orderScheduleInfoService(ordersInfo, 1, 10);
        Collections.sort(orderInfoList);
        for(OrderScheduleInfo orders : orderInfoList) {
            assertEquals(orders.toString(), "order: " + orders.getOrder() + ", flightNumber: not scheduled");
            System.out.println(orders.toString());
        }
    }
}
