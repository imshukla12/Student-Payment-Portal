package com.example.studentfeepayment.Bean;


import jakarta.persistence.*;


@Entity
@Table
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiptId;

    @ManyToOne
    @JoinColumn(name="billId", nullable = false)
    private Bills bill;

    @Column(nullable = false)
    private Integer amountPaid;

    @Column(nullable = false)
    private String dateOfPayment;

    public Receipt() {
    }

    public Receipt(Bills bill, Integer amountPaid, String dateOfPayment) {
        this.bill = bill;
        this.amountPaid = amountPaid;
        this.dateOfPayment = dateOfPayment;
    }


    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}
