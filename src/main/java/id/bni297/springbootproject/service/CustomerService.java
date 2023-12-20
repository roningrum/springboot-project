package id.bni297.springbootproject.service;

import id.bni297.springbootproject.model.Customer;
import id.bni297.springbootproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer createCustomer(Customer newCustomer){
        return customerRepository.createCustomer(newCustomer);
    }

    public List<Customer> getAllCustomer(){return customerRepository.findAll();}
    public Optional<Customer> checkBalanceCust(Long id){
        return customerRepository.getBalanceById(id);
    }

    public Optional<Customer> updateBalance(Long id, Customer customer){return customerRepository.updateBalance(id, customer);}
}
