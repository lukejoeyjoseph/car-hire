/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.api;

import hu.elte.alkfejl.carhire.model.Store;
import hu.elte.alkfejl.carhire.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/stores")
public class StoreApiController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Store>> visitor() {
        Iterable<Store> stores = storeService.listAll();
        return ResponseEntity.ok(stores);
    }

    @GetMapping("/names")
    private ResponseEntity<Iterable<String>> names() {
        Iterable<String> names = storeService.listNames();
        return ResponseEntity.ok(names);
    }
}