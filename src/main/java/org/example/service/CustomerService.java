package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
     void addCustomer(Customer customer);
     List<Customer>getAll();
     void deleteById(Long id);
     void update(Customer customer);
     Customer getCustomerById(Long id);
     Customer getCustomerByFirstName(String firstName);


}
