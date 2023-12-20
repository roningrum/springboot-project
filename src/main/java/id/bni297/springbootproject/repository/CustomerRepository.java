package id.bni297.springbootproject.repository;

import id.bni297.springbootproject.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    private Long generateNewId(){
        return (long) (customers.size()+1);
    }
    public Customer createCustomer(Customer customer){
        if(getBalanceById(customer.getId()).isPresent()){
            customers.remove(customer);
            customers.add(customer);

        }
        else{
            customer.setId(generateNewId());
            customers.add(customer);
        }

        return customer;
    }

    public List<Customer> findAll(){return customers;}

    public Optional<Customer> getBalanceById(Long id){
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Optional<Customer> updateBalance(Long id, Customer customer){
       return getBalanceById(id).map(data ->{
           if(Objects.equals(data.getNama(), customer.getNama())){
               data.setBalance(customer.getBalance());
           }
           else{
               data.setNama(customer.getNama());
               data.setBalance(customer.getBalance());
           }

            return data;
        });
    }
}
