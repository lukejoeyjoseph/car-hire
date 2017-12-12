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
@RequestMapping("/api/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/visitor")
    private ResponseEntity<Iterable<Employee>> visitor() {
        Iterable<Employee> employees = employeeService.listAll();
        return ResponseEntity.ok(employees);
    }
}