package JavaBackendBootcamp.ProductRepo;

import JavaBackendBootcamp.ShopService.ProductRepo.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testEquals() {
        Product p1 = new Product("1", "test");
        Product p2 = new Product("2", "test");
        assertNotEquals(p1, p2);
    }

    @Test
    void testHashCode() {
        Product p1 = new Product("1", "test");
        Product p2 = new Product("2", "test");
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}