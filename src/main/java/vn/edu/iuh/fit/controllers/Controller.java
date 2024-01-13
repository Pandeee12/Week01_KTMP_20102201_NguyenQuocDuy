package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.ProductRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
@RestController

@RequestMapping("/controller")
public class Controller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userRepository.findById(id);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductByID(@PathVariable long id){
        return productRepository.findById(id);
    }

}
