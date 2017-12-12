/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STORES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Store extends BaseEntity { 
    
    //Név:
    @Column(nullable = false, unique = true)
    private String name;
    
    //Cím:
    @Column(nullable = false, unique = true)
    private String address;
    
    //Telefonszám:
    @Column(nullable = false, unique = true)
    private String phoneNumber;
}