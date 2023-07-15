package com.example.studentfeepayment.DAO;

import com.example.studentfeepayment.Bean.Bills;
import com.example.studentfeepayment.Bean.Receipt;

import java.util.List;

public interface BillsDAO {
    List<Bills> getBills(Integer student_id);

    Boolean payBill(Integer billId);
    Integer paybills(Integer billId, Receipt receipt);
    void createBill(Bills bills);
}
