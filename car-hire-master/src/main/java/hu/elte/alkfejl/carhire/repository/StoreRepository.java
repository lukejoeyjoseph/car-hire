/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.repository;


import hu.elte.alkfejl.carhire.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
    //Kölcsönző megkeresése név alapján:
    Optional<Store> findByName(String name);

    //Kölcsönző megkeresése cím alapján:
    Optional<Store> findByAddress(String address);
}