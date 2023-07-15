package com.example.studentfeepayment.Driver;

import com.example.studentfeepayment.Bean.Bills;
import com.example.studentfeepayment.Bean.StudentPayment;
import com.example.studentfeepayment.Bean.Students;
import com.example.studentfeepayment.DAO.BillsDAO;
import com.example.studentfeepayment.DAO.DAOImplementation.BillDAOImpl;
import com.example.studentfeepayment.DAO.DAOImplementation.StudentDAOImpl;
import com.example.studentfeepayment.DAO.DAOImplementation.StudentPaymentDAOImpl;
import com.example.studentfeepayment.DAO.StudentDAO;
import com.example.studentfeepayment.DAO.StudentPaymentDAO;

public class Application {
    public static void main(String args[]){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }
    private static void runApplication() {
        Students s1= new Students();
        s1.setRollNumber("MT2022001");
        s1.setFirstName("Akanksha");
        s1.setLastName("Shukla");
        s1.setEmail("akanksha@a");
        s1.setPhotographPath("xxx");
        s1.setCgpa(3.9);
        s1.setTotalCredits(16);
        s1.setGraduationYear(2022);
        s1.setPassword("abc");
        StudentDAO studentDAO= new StudentDAOImpl();
        studentDAO.createStudent(s1);

        Bills b1=new Bills();
        b1.setBillDate("2022-05-02");
        b1.setDeadline("2022-12-31");
        b1.setDescription("Registration");
        b1.setPaidAmount(1000);
        b1.setTotalAmount(1000);
        b1.setRemainingAmount(0);
        BillsDAO billsDAO= new BillDAOImpl();
        billsDAO.createBill(b1);

        StudentPayment sp1=new StudentPayment();
        sp1.setDescription("Registration");
        sp1.setAmount(1000);
        sp1.setPaymentDate("2022-05-02");
        sp1.setBill(b1);
        sp1.setStudent(s1);
        StudentPaymentDAO studentPaymentDAO= new StudentPaymentDAOImpl();
        studentPaymentDAO.createStudentPayment(sp1);


    }
}
