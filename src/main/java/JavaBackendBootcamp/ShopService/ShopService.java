package JavaBackendBootcamp.ShopService;

import JavaBackendBootcamp.ShopService.OrderRepo.Order;
import JavaBackendBootcamp.ShopService.OrderRepo.OrderListRepo;
import JavaBackendBootcamp.ShopService.OrderRepo.OrderMapRepo;
import JavaBackendBootcamp.ShopService.ProductRepo.Product;
import JavaBackendBootcamp.ShopService.ProductRepo.ProductRepo;

import java.util.Collection;
import java.util.HashMap;

public class ShopService {
    private HashMap<String, Order> orderMap;
    private ProductRepo productRepo;

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
        orderListRepo.getOrders().forEach(order -> {orderMap.put(order.ID(),  order);});
        this.productRepo = productRepo;
    }

    public ShopService(OrderMapRepo orderMapRepo, ProductRepo productRepo) {
        orderMap = (HashMap<String, Order>) orderMapRepo.getOrders();
        this.productRepo = productRepo;
    }

    private boolean allProductsAvailable() {
        // Check if all ordered products exist
        for (Order order : orderMap.values()) {
            for(Product product: order.products()){
                if (!productRepo.getProducts().contains(product)) {
                    return false;
                }
            }
        }
        return true;
    }
/*
    private boolean productsAvailable() {
        return orderMap.values().forEach(order -> {order.products().forEach(product -> {productRepo.getProducts().contains(product);});});
    }

 */

    public void placeOrder() {
        if (allProductsAvailable()) {
            System.out.println("Order placed for " + productRepo);
            System.out.println("Order placed for " + productRepo.getProducts().size() + " products");
        }
    else {
        System.out.println("Some products not available");
    }

        // If yes, place order and sout

        // If not, sout
    }
}
