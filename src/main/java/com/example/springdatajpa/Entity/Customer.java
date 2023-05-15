package com.example.springdatajpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
/* To remove unwanted _ always remove Camel notation in table field*/
@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Customer",schema = "Saleslt")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)


public class Customer implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Customerid")
    private int customerId;
    @Basic
    @Column(name = "Namestyle")
    private String nameStyle;
    @Basic
    @Column(name = "Title")
    private String title;
    @Basic
    @Column(name = "Firstname")
    private String firstName;
    @Basic
    @Column(name = "Middlename")
    private String middleName;
    @Basic
    @Column(name = "Lastname")
    private String lastName;
    @Basic
    @Column(name = "Suffix")
    private String suffix;
    @Basic
    @Column(name = "Companyname")
    private String companyName;
    @Basic
    @Column(name = "Salesperson")
    private String salesPerson;
    @Basic
    @Column(name = "Emailaddress")
    private String emailAddress;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @Basic
    @Column(name = "Passwordhash")
    private String passwordHash;
    @Basic
    @Column(name = "Passwordsalt")
    private String passwordSalt;
    @Basic
    @Column(name = "rowguid")
    private String rowguid;
    @Basic
    @Column(name = "Modifieddate")
    private Date modifiedDate;

    @OneToMany(targetEntity = SalesOrderHeader.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Customerid",referencedColumnName = "Customerid")
    private List<SalesOrderHeader> salesOrderHeaderList;
}
