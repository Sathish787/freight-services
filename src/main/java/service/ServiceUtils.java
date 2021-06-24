package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import implementation.OrderDetails;

import java.io.File;
import java.util.*;

public class ServiceUtils {

    public List<OrderDetails> getOrderInfo(File file) {
        List<OrderDetails> orderInfo = new ArrayList<>();
        try {
            Map<String, HashMap<String, String>> treeMap = new ObjectMapper().readValue(file, TreeMap.class);
            for (Map.Entry<String, HashMap<String, String>> dest : treeMap.entrySet()) {
                orderInfo.add(new OrderDetails(dest.getKey(), dest.getValue().get("destination")));
            }

        } catch (Exception e) {
            System.out.println("There are no orders in given Json file" + e.getMessage());
            throw new Error("There are no orders in given Json file");
        }
        return orderInfo;
    }

    public LinkedHashSet<String> getUniqueDestinations(List<OrderDetails> orderInfo) {
        LinkedHashSet<String> uniqueDest = new LinkedHashSet<>();
        for (OrderDetails order : orderInfo) {
            uniqueDest.add(order.getDestinations());
        }
        return uniqueDest;
    }

    public boolean existInDestinationEnum(String city) {
        for(Destinations dest : Destinations.values()) {
            if (city.equals(dest.toString())) {
                return true;
            }
        }
        return false;
    }

    public Map<String, ArrayList<String>> getOrdersByDestination(List<OrderDetails> ordersInfo,
                                                                 LinkedHashSet<String> uniqueDestinationSet) {
        ArrayList<String> orderList;
        Map<String, ArrayList<String>> ordersByDest = new TreeMap<>();
        for (String city : uniqueDestinationSet) {
            orderList = new ArrayList<>();
            for (OrderDetails orders : ordersInfo) {
                if (city.equals(orders.getDestinations())) {
                    orderList.add(orders.getOrderNumber());
                }
            }
            ordersByDest.put(city, orderList);
        }
        return ordersByDest;
    }
}
