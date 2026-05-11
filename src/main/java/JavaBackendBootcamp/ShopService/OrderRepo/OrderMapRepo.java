package JavaBackendBootcamp.ShopService.OrderRepo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class OrderMapRepo implements OrderRepo {
private HashMap<String, Order> orderMap;

    public OrderMapRepo(HashMap<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public OrderMapRepo(Order order) {
        orderMap.put(order.ID(),  order);
    }


    @Override
    public void addOrder(Order order) {
        if (!orderMap.containsKey(order.ID())){
            orderMap.put(order.ID(), order);
        }
        else {
            System.out.println("Order with ID: " + order.ID() + " already exists");
        }
    }

    @Override
    public Order getOrderByID(String ID) {
        if (orderMap.containsKey(ID)) {
            return orderMap.get(ID);
        }
        else {
            System.out.println("Order with ID: " + ID + " not Found");
            return null;
        }
    }

    @Override
    public HashMap<String, Order> getOrders() {
        return orderMap;
    }

    @Override
    public void removeOrderByID(String ID) {
        if (orderMap.containsKey(ID)) {
            orderMap.remove(ID);
        }
        else {
            System.out.println("Order with ID: " + ID + " not Found");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(getOrders(), that.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrders());
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orderMap=" + orderMap +
                '}';
    }
}
