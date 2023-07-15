package com.example.studentfeepayment.Bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Bills")
public class Bills{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @Column(nullable = false)
    private Integer totalAmount;
    @Column(nullable = false)
    private Integer paidAmount;
    @Column(nullable = false)
    private Integer remainingAmount;
    @Column(nullable = false)
    private String billDate;
    private String deadline;


    public Bills() {
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Bills(String description, Integer totalAmount, Integer paidAmount, Integer remainingAmount, String billDate, String deadline) {
        this.description = description;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.remainingAmount = remainingAmount;
        this.billDate = billDate;
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer amount) {
        this.totalAmount = amount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
    }


}