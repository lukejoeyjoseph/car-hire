/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Employee;
import hu.elte.alkfejl.carhire.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /*
        Új alkalmazott felvétele a rendszerbe:
    */
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    /*
        ÚAlkalmazott eltávolítása a rendszerből:
    */
    public void removeEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
    
    /*
        Minden alkalmazott kilistázása:
    */
    public Iterable<Employee> listAll() {
        return employeeRepository.findAll();
    }

}