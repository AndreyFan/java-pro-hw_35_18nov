package de.telran.onlineshop.service;

import de.telran.onlineshop.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductsService {

    private List<Product> productList;

    @PostConstruct
    void initProducts() {
        productList = new ArrayList<>();
        LocalDate dateCr = LocalDate.now();
        LocalDate dateUp = LocalDate.now();

        productList.add(new Product(1, "Milk", "Fresh liter of milk", 1.2, 1, "https://example.com/milk.jpg", 0.0, dateCr, dateUp));
        productList.add(new Product(2, "Bread", "Fresh loaf of bread", 0.8, 1, "https://example.com/bread.jpg", 10.0, dateCr, dateUp));

        productList.add(new Product(3, "Dishwashing Liquid", "For cleaning dishes", 2.5, 2, "https://example.com/detergent.jpg", 5.0, dateCr, dateUp));
        productList.add(new Product(4, "Glass Cleaner", "Effective glass cleaner", 3.0, 2, "https://example.com/glass_cleaner.jpg", 0.0, dateCr, dateUp));

        productList.add(new Product(5, "Television", "LED TV", 150.0, 3, "https://example.com/tv.jpg", 3.5, dateCr, dateUp));
        productList.add(new Product(6, "Radio", "FM radio receiver", 30.0, 3, "https://example.com/radio.jpg", 3.5, dateCr, dateUp));

        productList.add(new Product(7, "Teddy Bear", "Plush teddy bear", 10.0, 4, "https://example.com/teddy_bear.jpg", 0.0, dateCr, dateUp));
        productList.add(new Product(8, "Building Blocks", "Kids' building blocks set", 15.0, 4, "https://example.com/blocks.jpg", 0.0, dateCr, dateUp));

        productList.add(new Product(9, "T-Shirt", "Graphic T-shirt", 12.0, 5, "https://example.com/tshirt.jpg", 10.0, dateCr, dateUp));
        productList.add(new Product(10, "Jeans", "Stylish jeans", 25.0, 5, "https://example.com/jeans.jpg", 20.0, dateCr, dateUp));

        productList.add(new Product(11, "Notebook", "School notebook", 1.5, 6, "https://example.com/notebook.jpg", 0.0, dateCr, dateUp));
        productList.add(new Product(12, "Pen", "Gel pen", 0.5, 6, "https://example.com/pen.jpg", 0.0, dateCr, dateUp));

        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());
    }
    @GetMapping
        //select
    public List<Product> getAllProducts() {
        return productList;
    }

    @GetMapping(value = "/find/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productList.stream()
                .filter(product -> product.getProductID() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping(value = "/get")
    public Product getProductByName(@RequestParam String name) {
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping()
    public boolean createProduct(@RequestBody Product newProduct) {
        return productList.add(newProduct);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product updProduct) {
        Product result = productList.stream()
                .filter(product -> product.getProductID() == updProduct.getProductID())
                .findFirst()
                .orElse(null);
        if (result != null) {
            result.setProductID(updProduct.getProductID());
            result.setName(updProduct.getName());
            result.setDescription(updProduct.getDescription());
            result.setPrice(updProduct.getPrice());
            result.setCategoryID(updProduct.getCategoryID());
            result.setImageURL(updProduct.getImageURL());
            result.setDiscountPrice(updProduct.getDiscountPrice());
            result.setCreatedAt(LocalDate.now());
            result.setUpdatedAt(LocalDate.now());
        }
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductID() == id) {
                iterator.remove();
            }
        }
    }

    @PreDestroy
    void destroy() {
        productList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }

}
