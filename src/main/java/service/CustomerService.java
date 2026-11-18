package service;


import entity.Customer;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

     CustomerRepository customerRepository ;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer  customerCreate(Customer customer) {
       return customerRepository.save( customer) ;

    }

    public Customer getCustomer(int id) {
         return customerRepository.findByID(id) ;

    }

    public List<Customer>  getsCustomer() {
       return customerRepository.findAll();

    }
}
