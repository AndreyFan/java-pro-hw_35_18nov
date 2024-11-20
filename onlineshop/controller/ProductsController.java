package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.model.Product;
import de.telran.onlineshop.model.User;
import de.telran.onlineshop.service.ProductsService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping  //select
    public  List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping(value = "/find/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productsService.getProductByID(id);
    }

    @GetMapping(value = "/get")
    public Product getProductByName(@RequestParam String name) {
        return productsService.getProductByName(name);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public boolean createProduct(@RequestBody Product newProduct) {
        return productsService.createProduct(newProduct);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping()
    public Product updateProduct(@RequestBody Product updProduct) {
        return productsService.updateProduct(updProduct);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
       productsService.deleteProduct(id);
    }

    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler({IllegalArgumentException.class, FileNotFoundException.class})
    public ResponseEntity handleTwoException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Извините, что-то пошло не так. Попробуйте позже!");
    }
}
