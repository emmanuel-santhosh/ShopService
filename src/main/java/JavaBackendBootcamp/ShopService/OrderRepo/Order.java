package JavaBackendBootcamp.ShopService.OrderRepo;

import JavaBackendBootcamp.ShopService.ProductRepo.Product;

import java.util.List;

public record Order(String ID, List<Product> products) {
}
