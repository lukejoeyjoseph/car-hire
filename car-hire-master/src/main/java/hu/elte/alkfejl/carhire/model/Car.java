/*
Car Hire Application
Author: Szabó Dániel , Fodor Levente
ELTE IK
*/
package hu.elte.alkfejl.carhire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {

    //Rendszám:
    @Column(nullable = false, unique = true)
    private String plateNumber;
    
    //Márka:
    @Column(nullable = false)
    private String make;

    //Típus:
    @Column(nullable = false)
    private String model;

    //Évjárat:
    @Column(nullable = false)
    private int year;
    
    //Szín:
    @Column(nullable = false)
    private String color;
    
    //Ajtók száma:
    @Column(nullable = false)
    private int doors;

    //Ülések száma:
    @Column(nullable = false)
    private int seats;
    
    //Ár/óra:
    @Column(nullable = false)
    private int price;
}