package com.example.studentfeepayment.DAO.DAOImplementation;

import com.example.studentfeepayment.Bean.StudentPayment;
import com.example.studentfeepayment.DAO.StudentPaymentDAO;
import com.example.studentfeepayment.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentPaymentDAOImpl implements StudentPaymentDAO {

    public void createStudentPayment(StudentPayment studentPayment) {
        try (Session session = (Session) HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(studentPayment);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

    }
}
