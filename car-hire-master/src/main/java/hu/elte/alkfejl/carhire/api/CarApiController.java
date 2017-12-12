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
@RequestMapping("/api/cars")
public class CarApiController {

    @Autowired
    private CarService carService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Car>> visitor() {
        Iterable<Car> cars = carService.listAll();
        return ResponseEntity.ok(cars);
    }
    
    @GetMapping("/makes")
    private ResponseEntity<Iterable<String>> makes() {
        Iterable<String> makes = carService.listMakes();
        return ResponseEntity.ok(makes);
    }
    
    @GetMapping("/models/{make}")
    private ResponseEntity<Iterable<String>> modelsByMake(@PathVariable String make) {
        Iterable<String> models = carService.listModelsByMake(make);
        return ResponseEntity.ok(models);
    }    
  
    @GetMapping("/models")
    private ResponseEntity<Iterable<String>> models() {
        Iterable<String> models = carService.listModels();
        return ResponseEntity.ok(models);
    }   
}