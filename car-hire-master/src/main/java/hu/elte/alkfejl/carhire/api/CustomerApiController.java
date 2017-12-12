/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.model.*;
import hu.elte.alkfejl.carhire.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerApiController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Customer>> visitor() {
        Iterable<Customer> customers = customerService.listAll();
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/names")
    private ResponseEntity<Iterable<String>> names() {
        Iterable<String> names = customerService.listNames();
        return ResponseEntity.ok(names);
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    private ResponseEntity<Customer> add(@RequestBody Customer customer) {
        if (customerService.isValid(customer)) {
            Customer saved = customerService.addCustomer(customer);
            return ResponseEntity.ok(saved);
        }
        else {
            return null;
        }
    }
}