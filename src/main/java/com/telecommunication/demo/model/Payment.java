package com.telecommunication.demo.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {


    public Payment(String currency, String amount, String employeeName, String senderName, int senderPhone, int senderId) {
        this.currency = currency;
        this.amount = amount;
        this.employeeName = employeeName;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderId = senderId;
    }

    public Payment() {

    }
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDateTimeOfTransactions() {
        return dateTimeOfTransactions;
    }

    public void setDateTimeOfTransactions(Date dateTimeOfTransactions) {
        this.dateTimeOfTransactions = dateTimeOfTransactions;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(int senderPhone) {
        this.senderPhone = senderPhone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "currency",nullable = false)
    private String currency;

    @Column(name = "amount",nullable = false)
    private String amount;

    @Column(name = "employeeName",nullable = false)
    private String employeeName;

    @Column(name = "dateOfTransactions",nullable = true)
    @CreatedDate
    private Date dateTimeOfTransactions;

    @Column(name = "senderName",nullable = false)
    @CreatedBy
    private String senderName;

    @Column(name = "senderPhone",nullable = false)
    private int senderPhone;

    @Column(name = "senderId",nullable = false)
    private int senderId;


}
