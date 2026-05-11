package JavaBackendBootcamp;

import JavaBackendBootcamp.ShopService.ProductRepo.Product;
import JavaBackendBootcamp.ShopService.ProductRepo.ProductRepo;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
    Product p1 = new Product("1", "test");
    Product p2 = new Product("2", "test");

    Product p3 = new Product("3", "test");

    ArrayList<Product> products = new ArrayList<Product>();
    products.add(p1);
    products.add(p2);
    products.add(p3);

    ProductRepo productRepo = new ProductRepo(products);

    Product p4 = new Product("4", "test");
    productRepo.addProduct(p4);

        System.out.println(productRepo.getProductByID("3"));
        System.out.println(productRepo.getProductByID("7"));

        productRepo.removeProductByID("5");


    }
}
