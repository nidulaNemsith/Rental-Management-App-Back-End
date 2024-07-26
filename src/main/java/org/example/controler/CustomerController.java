package org.example.controler;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-controller")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @PostMapping("add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
    @GetMapping("get-all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
    @DeleteMapping("/delete-customer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable Long id){
        customerService.deleteById(id);
        return "Deleted..!";
    }
    @PutMapping("update-customer")
    public String update(@RequestBody Customer customer){
        customerService.update(customer);
        return "Updated..!";
    }
    @GetMapping("get-by-Id/{id}")
    public Customer getById(@PathVariable Long id){
       return customerService.getCustomerById(id);
    }
    @GetMapping("get-by-first-name/{firstName}")
    public Customer getByFirstName(String firstName){
        return customerService.getCustomerByFirstName(firstName);
    }










}
