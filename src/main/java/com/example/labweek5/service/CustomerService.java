package com.example.labweek5.service;

import com.example.labweek5.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customerList = new ArrayList<>();

    public Customer addNewCustomer (Customer customer){
        customerList.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers(){
        return customerList;
    }

    public Customer getCustomerByEmail(String email){
        for (Customer customer : customerList){
            if( customer.getEmail().equalsIgnoreCase(email)){
                return customer;
            }
        }
        return null;
    }

    public Customer updateCustomer (String email, Customer updatedCustomer){
        for (Customer customer : customerList){
            if(customer.getEmail().equalsIgnoreCase(email)){
                customer.setAddress(updatedCustomer.getAddress());
                customer.setAge(updatedCustomer.getAge());
                customer.setEmail(updatedCustomer.getEmail());
                return customer;
            }
        } return null;
    }

    public void deleteCustomer(String email){
        customerList.remove(email);
    }

}
