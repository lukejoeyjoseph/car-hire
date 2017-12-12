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
@Table(name = "RENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rent extends BaseEntity{
    //A kölcsönző személy neve:
    @Column(nullable = false)
    private String customerName;      

    //A kölcsönzött autó márkája:
    @Column(nullable = false)
    private String carMake;
    
    //A kölcsönzött autó típusa:
    @Column(nullable = false)
    private String carModel;
    
    //Az üzlet, ahol kölcsönöztünk:
    @Column(nullable = false)
    private String storeName;  
    
    //A kölcsönzést lebonyolító dolgozó:
    @Column(nullable = false)
    private String employeeName;  
    
    //A kölcsönzés dátuma:
    @Column(nullable = false)
    private String rentDate;  
    
    //A kölcsönzéshez tartozó megjegyzés:
    @Column(nullable = false)
    private String note;  
}
