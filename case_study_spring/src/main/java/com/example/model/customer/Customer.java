package com.example.model.customer;

import com.example.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerBirthday;
    private Integer customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;

    @ManyToOne
    @JoinColumn(name= "customer_type_id",referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerMail) {
        this.customerEmail = customerMail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
