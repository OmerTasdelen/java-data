package data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private Long id;

    @Column(name = "companyName")
    private String companyName;

    @Column (name = "location")
    private String location;

    @Column (name = "company_type")
    private String companyType;

    @Column (name = "priority")
    private String priority;

    @Column (name = "tax_number")
    private String taxNumber;

}
