package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(
                new ObjectMapper().convertValue(customer, CustomerEntity.class)
        );
    }
    @Override
    public List<Customer> getAll() {
        List<Customer> customerList= new ArrayList<>();
        List<CustomerEntity> all = customerRepository.findAll();
        all.forEach(customerEntity -> {
            customerList.add(
                    new ObjectMapper().convertValue(customerEntity, Customer.class)
            );
        });
        return customerList;
    }
    @Override
    public void deleteById(Long id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
    }
    @Override
    public void update(Customer customer) {
        if(customerRepository.findById(customer.getCustomerId()).isPresent()){
            customerRepository.save(
                    new ObjectMapper().convertValue(customer, CustomerEntity.class)
            );
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        if (customerRepository.findById(id).isPresent()){
            Optional<CustomerEntity> byId = customerRepository.findById(id);
             return new ObjectMapper().convertValue(byId.get(), Customer.class);
        }
        return new Customer();
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        CustomerEntity byFirstName = customerRepository.findByFirstName(firstName);
         return new ObjectMapper().convertValue(byFirstName, Customer.class);
    }
}
