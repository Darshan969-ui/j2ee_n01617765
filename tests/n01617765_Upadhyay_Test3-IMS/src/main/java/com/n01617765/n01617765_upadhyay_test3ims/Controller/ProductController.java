package com.n01617765.n01617765_upadhyay_test3ims.Controller;

import com.n01617765.n01617765_upadhyay_test3ims.Model.Product;
import com.n01617765.n01617765_upadhyay_test3ims.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // This is to  Display the main product page
    @GetMapping("/")
    public String dashboard(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("addoneProduct", new Product());
        return "addProduct"; // ✅
    }

    // This is to  Show add product form
    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("addoneProduct", new Product());
        return "addProduct"; // ✅
    }

    //  This is to  Handle product addition
    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("addoneProduct") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            return "addProduct"; // ✅
        }
        productService.addProduct(product);
        return "redirect:/";
    }


    // This is to  Handle product update
    @PostMapping("/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "updateProduct"; // ✅
        }
        productService.updateProduct(product.getId(), product);
        return "redirect:/";
    }

    // This is to Handle product deletion
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
