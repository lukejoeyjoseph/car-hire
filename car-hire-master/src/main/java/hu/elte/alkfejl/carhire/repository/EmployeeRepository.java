/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.repository;


import hu.elte.alkfejl.carhire.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //Keresés név alapján:
    Optional<Employee> findByName(String name);
    
    //Keresés személyi alapján:
    Optional<Employee> findByIdNumber(String idNumber);
    
    //Listázás kölcsönző szerint:
    Iterable<Employee> findByStoreName(String storeName);
    
    

}