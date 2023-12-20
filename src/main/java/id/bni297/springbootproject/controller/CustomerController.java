package id.bni297.springbootproject.controller;

import id.bni297.springbootproject.model.Customer;
import id.bni297.springbootproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer( @RequestBody Customer customer){ return customerService.createCustomer(customer);}

    @GetMapping
    public List<Customer> getAllCustomer(){return customerService.getAllCustomer();}

    @GetMapping("/{id}/balance")
    public Optional<Customer> getCustomerBalancebyId(@PathVariable Long id){
        return customerService.checkBalanceCust(id);
    }

    @PutMapping("/{id}/update-balance")
    public Optional<Customer> updateCustomerBalance(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateBalance(id,customer);
    }

}
