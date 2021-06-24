import implementation.FlightInfo;
import implementation.OrderDetails;
import implementation.OrderScheduleInfo;
import service.ServiceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserStoryTwo {

    public static void main(String[] args) {
        int days = 1;
        int maxCapacity = 20;
        ServiceUtils service = new ServiceUtils();
        List<OrderDetails> ordersInfo = service.getOrderInfo(new File("src/main/resources/orders.json"));
        List<OrderScheduleInfo> orderInfoList = orderScheduleInfoService(ordersInfo, days, maxCapacity);
        Collections.sort(orderInfoList);
        for(OrderScheduleInfo orders : orderInfoList) {
            System.out.println(orders.toString());
        }
    }

    public static List<OrderScheduleInfo> orderScheduleInfoService(List<OrderDetails> ordersInfo, int days,
                                                                   int maxCapacity) {
        ServiceUtils service = new ServiceUtils();
        LinkedHashSet<String> uniqueDestinationSet = service.getUniqueDestinations(ordersInfo);
        Map<String, ArrayList<String>> ordersByDestination = service.getOrdersByDestination(ordersInfo,
                uniqueDestinationSet);

        List<OrderScheduleInfo> orderInfoList = new ArrayList<>();
        List<String> subOrderList;
        int totalOrders = ordersInfo.size();
        int flightNumber = 1;

        while(totalOrders>0) {
            for(String cityCode : uniqueDestinationSet) {
                if(service.existInDestinationEnum(cityCode)) {
                    int arrayLength = Math.min(ordersByDestination.get(cityCode).size(), maxCapacity);
                    if(arrayLength>0) {
                        subOrderList = ordersByDestination.get(cityCode).subList(0, arrayLength);
                        for(String order : subOrderList) {
                            orderInfoList.add(new OrderScheduleInfo(order, new FlightInfo(flightNumber, cityCode, days)));
                        }
                        ordersByDestination.get(cityCode).subList(0, arrayLength).clear();
                        totalOrders = totalOrders - arrayLength;
                        flightNumber++;
                    }
                } else {
                    for(String order : ordersByDestination.get(cityCode)) {
                        orderInfoList.add(new OrderScheduleInfo(order, new FlightInfo(0, cityCode, days)));
                    }
                    totalOrders = totalOrders - ordersByDestination.get(cityCode).size();
                    ordersByDestination.get(cityCode).clear();
                }
            }
            days ++;
        }
        return orderInfoList;
    }
}
