/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.repository;


import hu.elte.alkfejl.carhire.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //Keresés név alapján:
    Optional<Customer> findByName(String name);
    
    //Keresés személyi alapján:
    Optional<Customer> findByIdNumber(String idNumber);
    
    //Listázás tagság kezdete alapján:
    Iterable<Customer> findByJoined(int joined);

}