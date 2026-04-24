package com.example.labweek5.controller;


import com.example.labweek5.models.Customer;
import com.example.labweek5.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createNewCustomer(@Valid @RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{email}")
    public Customer getCustomerByEmail (@Valid @PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

    @PutMapping("/{email}")
    public Customer updateCustomer (@Valid @PathVariable String email, @Valid @RequestBody Customer updatedCustomer){
        return customerService.updateCustomer(email, updatedCustomer);
    }

    @DeleteMapping("/{email}")
    public void deleteCustomer (@Valid @PathVariable String email){
        customerService.deleteCustomer(email);
    }

}
