/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Store;
import hu.elte.alkfejl.carhire.repository.StoreRepository;
import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    /*
        Új kölcsönző felvétele a rendszerbe:
    */
    public void addStore(Store store) {
        storeRepository.save(store);
    }
    /*
        Kölcsönző eltávolítása a rendszerből:
    */
    public void removeStore(Store store) {
        storeRepository.delete(store);
    }
    /*
        Minden kölcsönző kilistázása:
    */
    public Iterable<Store> listAll() {
        return storeRepository.findAll();
    }
    /*
        Minden kölcsönző nevének kilistázása:
    */
    public Iterable<String> listNames() {
        ArrayList<String> names = new ArrayList<String>();
        
        Iterable<Store> stores = storeRepository.findAll();
        
        for (Store s : stores) {
            names.add(s.getName());
        }
        return names;
    }
    
}