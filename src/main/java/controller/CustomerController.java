package controller;


import entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService ;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/c")
    public ResponseEntity<Customer> Create ( @RequestBody Customer customer) {
       Customer created = customerService.customerCreate(customer) ;

       return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable int id) {
        Customer got = customerService.getCustomer(id) ;

        return ResponseEntity.ok().body(got) ;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> gets() {
        List<Customer> getsAll = customerService.getsCustomer() ;

        return ResponseEntity.ok().body(getsAll)  ;
    }



}
