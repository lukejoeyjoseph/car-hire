/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.repository;


import hu.elte.alkfejl.carhire.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    //Autó keresése rendszám alapján:
    Optional<Car> findByPlateNumber(String plateNumber);

    //Autók listázása márka alapján:
    Iterable<Car> findByMake(String make);
    
    //Autók listázása márka és típus alapján:
    Iterable<Car> findByMakeAndModel(String make, String model);
    
    //Autók listázása évjárat alapján:
    Iterable<Car> findByYear(int year);
    
    //Autók listázása szín alapján:
    Iterable<Car> findByColor(String color);
}