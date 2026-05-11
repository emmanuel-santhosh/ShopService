package JavaBackendBootcamp.ShopService.ProductRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class ProductRepo {
    ArrayList<Product> products;

    public ProductRepo(ArrayList<Product> products) {
        HashSet productSet = new HashSet(products);
        this.products = new ArrayList<>(productSet);
    }

    public ProductRepo(Product product) {
        this.products = new ArrayList<>();
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductByID(String ID) {
       Product found = products.stream()
               .filter(product -> product.ID().equals(ID))
               .findFirst()
               .orElse(null);
       if (found == null) {
           System.out.println("No product with the ID " + ID + " found");
       }
       return found;

    }

    public void removeProductByID(String ID) {
        Product found = getProductByID(ID);
        if (found != null) {
            products.remove(found);
        }
    }

    public void addProduct(Product product) {
        if(product != null && !products.contains(product)) {
            products.add(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getProducts());
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
