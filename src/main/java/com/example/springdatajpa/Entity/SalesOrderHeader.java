package com.example.springdatajpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "salesorderheader",schema = "saleslt")
public class SalesOrderHeader implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SalesorderiD")
    private int salesOrderId;
    @Basic
    @Column(name = "Revisionnumber")
    private byte revisionNumber;
    @Basic
    @Column(name = "Orderdate")
    private Date orderDate;
    @Basic
    @Column(name = "Duedate")
    private Date dueDate;
    @Basic
    @Column(name = "Shipdate")
    private Date shipDate;
    @Basic
    @Column(name = "Status")
    private byte status;
    @Basic
    @Column(name = "Onlineorderflag")
    private boolean onlineOrderFlag;
    @Basic
    @Column(name = "Salesordernumber")
    private String salesOrderNumber;
    @Basic
    @Column(name = "Purchaseordernumber")
    private String purchaseordernumber;
    @Basic
    @Column(name = "Accountnumber")
    private String accountNumber;
    @Basic
    @Column(name = "Customerid")
    private int customerId;
    @Basic
    @Column(name = "Shiptoaddressid")
    private Integer shipToAddressId;
    @Basic
    @Column(name = "billtoaddressid")
    private Integer billToAddressId;
    @Basic
    @Column(name = "Shipmethod")
    private String shipMethod;
    @Basic
    @Column(name = "creditcardapprovalcode")
    private String creditCardApprovalCode;
    @Basic
    @Column(name = "subtotal")
    private float subTotal;
    @Basic
    @Column(name = "taxamt")
    private float taxAmt;
    @Basic
    @Column(name = "freight")
    private float freight;
    @Basic
    @Column(name = "totaldue")
    private float totalDue;
    @Basic
    @Column(name = "Comment")
    private String comment;
    @Basic
    @Column(name = "rowguid")
    private String rowguid;
    @Basic
    @Column(name = "modifieddate")
    private Date modifiedDate;



}
