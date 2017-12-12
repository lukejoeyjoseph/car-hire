package hu.elte.alkfejl.carhire.model;

import java.util.Date;
import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public class Person extends BaseEntity { 
    //Név:
    @Column(nullable = false, unique = true)
    private String name;
    
    //Személyi szám:
    @Column(nullable = false, unique = true)
    private String idNumber;

    //Születési dátum:
    @Column(nullable = false)
    private String birth;

    //Nem (f/n):
    @Column(nullable = false)
    private String gender;

    //Lakcím:
    @Column(nullable = false)
    private String address;
}
