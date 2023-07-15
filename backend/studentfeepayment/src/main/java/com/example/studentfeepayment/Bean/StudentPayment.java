package com.example.studentfeepayment.Bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "StudentPayment")
public class StudentPayment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Students student;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "billId")
    private Bills bill;

    public StudentPayment(String description, Integer amount, String paymentDate) {
        this.description = description;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public StudentPayment() {
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }


    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

   }
