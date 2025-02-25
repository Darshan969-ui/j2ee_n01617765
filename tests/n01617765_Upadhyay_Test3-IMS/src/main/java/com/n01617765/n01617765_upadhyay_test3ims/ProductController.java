package com.n01617765.n01617765_upadhyay_test3ims;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Display all products
    @GetMapping("/")
    public String dashboard(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("product", products);
        model.addAttribute("addoneProduct", new Product());  // Form model for adding a new product
        return "addProduct";
    }

    // Add a new product
    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("addoneProdcut") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            return "addProduct";
        }
        productService.addProduct(product);
        return "redirect:/";
    }

//    // Showing  edit form for a specific product
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable int id, Model model) {
//        Product product = productService.updateProduct(id, new Product());
//        model.addAttribute("product", product);
//        return "addProduct";
//    }

    // Updating product details
    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam int price,
                                @RequestParam int stock) {
        Product updatedProduct = new Product(id, name, description, price, stock);
        productService.updateProduct(id, updatedProduct);
        return "redirect:/";
    }

    // Here i am Deleting a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}


