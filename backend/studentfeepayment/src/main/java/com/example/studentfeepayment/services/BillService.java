package com.example.studentfeepayment.services;

import com.example.studentfeepayment.Bean.Bills;
import com.example.studentfeepayment.Bean.Receipt;
import com.example.studentfeepayment.DAO.BillsDAO;
import com.example.studentfeepayment.DAO.DAOImplementation.BillDAOImpl;

import java.util.HashMap;
import java.util.Map;

public class BillService {
    public int payBills(HashMap<Integer, Receipt> paymentDictionary) {
        int successfulPayments = 0;
        BillsDAO billsDAO = new BillDAOImpl();

        for (Map.Entry<Integer, Receipt> keyValuePair: paymentDictionary.entrySet()) {
            Integer billId = keyValuePair.getKey();
            Receipt receipt = keyValuePair.getValue();

            successfulPayments=successfulPayments + billsDAO.paybills(billId, receipt);
        }

        return successfulPayments;
    }
}
