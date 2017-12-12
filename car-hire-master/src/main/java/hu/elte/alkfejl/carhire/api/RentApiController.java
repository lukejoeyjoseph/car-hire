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
@RequestMapping("/api/rents")
public class RentApiController {

    @Autowired
    private RentService rentService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Rent>> visitor() {
        Iterable<Rent> rents = rentService.listAll();
        return ResponseEntity.ok(rents);
    }
    
    @GetMapping("/dates")
    private ResponseEntity<Iterable<String>> dates() {
        Iterable<String> dates = rentService.listDates();
        return ResponseEntity.ok(dates);
    }
    
    @GetMapping("list/customerName/{value}")
    private ResponseEntity<Iterable<Rent>> customerName(@PathVariable String value) {
        Iterable<Rent> rents = rentService.listByCustomerName(value);
        return ResponseEntity.ok(rents);
    }
    
    @GetMapping("list/storeName/{value}")
    private ResponseEntity<Iterable<Rent>> storeName(@PathVariable String value) {
        Iterable<Rent> rents = rentService.listByStoreName(value);
        return ResponseEntity.ok(rents);
    }
    
    @GetMapping("list/carMake/{value}")
    private ResponseEntity<Iterable<Rent>> carMake(@PathVariable String value) {
        Iterable<Rent> rents = rentService.listByMake(value);
        return ResponseEntity.ok(rents);
    }
    
    @GetMapping("list/carModel/{value}")
    private ResponseEntity<Iterable<Rent>> carModel(@PathVariable String value) {
        Iterable<Rent> rents = rentService.listByModel(value);
        return ResponseEntity.ok(rents);
    }
    
    @GetMapping("list/rentDate/{value}")
    private ResponseEntity<Iterable<Rent>> rentDate(@PathVariable String value) {
        Iterable<Rent> rents = rentService.listByRentDate(value);
        return ResponseEntity.ok(rents);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    private ResponseEntity<Rent> add(@RequestBody Rent rent) {
        if ( rentService.isValid(rent) ) {
            Rent saved = rentService.addRent(rent);
            return ResponseEntity.ok(saved);
        }
        else {
            return null;
        }
    }
}