package JavaBackendBootcamp.ShopService.OrderRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class OrderListRepo {
    ArrayList<Order> orders; // List instead of ArrayList

    public OrderListRepo(ArrayList<Order> orders) {
        HashSet<Order> orderSet = new HashSet<>();
        this.orders = new ArrayList<>(orderSet);
    }

    public OrderListRepo(Order order) {
        orders = new ArrayList<>();
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order getOrderByID(String ID) {
        Order found = orders.stream().filter(order -> order.ID().equals(ID)).findFirst().orElse(null);
        if (found == null) {
            System.out.println("No order found with ID: " + ID);
        }
        return found;
    }

    public void addOrder(Order order) {
        if(order != null && !orders.contains(order) ) {
            orders.add(order);
        }
    }

    public void removeOrderByID(String ID) {
        Order found = getOrderByID(ID);
        if (found != null) {
            orders.remove(found);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(getOrders(), that.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrders());
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
