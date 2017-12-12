/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.model.Customer;
import hu.elte.alkfejl.carhire.repository.CustomerRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /*
        Új vásárló felvétele:
    */
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    /*
        Vásárló eltávolítása a rendszerből:
    */
    public void removeCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
    /*
        Minden ügyfél kilistázása:
    */
    public Iterable<Customer> listAll() {
        return customerRepository.findAll();
    }
    
    /*
        Ügyfelek neveinek kilistázása:
    */
    public Iterable<String> listNames() {
        ArrayList<String> names = new ArrayList<String>();
        Iterable<Customer> customers = customerRepository.findAll();
        
        for (Customer c : customers) {
            names.add(c.getName());
        }
        
        return names;
    }
    
    /*
        Validalas:
    */
    public boolean isValid(Customer customer) {
        boolean l = true;
        
        //Név ellenőrzése:
        l = l && customer.getName().matches("^[A-Z][a-z]{2,15} [A-Z][a-z]{2,15}( [A-Z][a-z]{2,15}){0,3}");
        //Dátum ellenőrzése:
        l = l && customer.getBirth().matches("(19[0-9]{2}. [01][0-9]. [0-3][0-9].)|(20[0-1][0-9]. [01][0-9]. [0-3][0-9].)");
        //Cím ellenőrzése:
        l = l && customer.getAddress().matches("[0-9]{4},([ A-Za-z0-9,.]{2,15}){1,10}");
        //Személy ellenőrzése:
        l = l && customer.getIdNumber().matches("[0-9]{6}[A-Z]{2}");
        //Nem ellenőrzése:
        l = l && (customer.getGender().equals("Férfi") || customer.getGender().equals("Nő"));
        
        
        return l;
    }
}