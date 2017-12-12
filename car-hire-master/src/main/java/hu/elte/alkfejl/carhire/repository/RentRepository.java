/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.repository;

import hu.elte.alkfejl.carhire.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    Iterable<Rent> findByCustomerName(String customerName);

    Iterable<Rent> findByCarMake(String carMake);

    Iterable<Rent> findByCarModel(String carModel);

    Iterable<Rent> findByEmployeeName(String employeeName);
    
    Iterable<Rent> findByRentDate(String rentDate);
    
    Iterable<Rent> findByStoreName(String storeName);
}