package JavaBackendBootcamp.ShopService.OrderRepo;

import java.util.HashMap;

public interface OrderRepo {

    // All methods from OrderListRepo

    public HashMap<String, Order> getOrders(); // Just Map or List interface - flexibility
    public Order getOrderByID(String ID);
    public void removeOrderByID(String ID);
    public void addOrder(Order order);
}
