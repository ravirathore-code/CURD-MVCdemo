package repository;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepository {


  HashMap<Integer , Customer> map ;

    public CustomerRepository() {
        map = new HashMap<>() ;
    }

    public Customer save(Customer customer) {
        map.put(customer.getId() , customer) ;
        return customer ;
    }

    public Customer findByID(int id) {
       return map.get(id) ;

    }

    public List<Customer> findAll() {
        return new ArrayList<>(map.values()) ;
    }
}
