package com.example.studentfeepayment.DAO.DAOImplementation;

import com.example.studentfeepayment.Bean.Bills;
import com.example.studentfeepayment.Bean.Receipt;
import com.example.studentfeepayment.Bean.StudentPayment;
import com.example.studentfeepayment.DAO.BillsDAO;
import com.example.studentfeepayment.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillsDAO {

    @Override
    public List<Bills> getBills(Integer s_id) {
        List<Bills> billList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final StudentPayment sp : session
                    .createQuery("FROM StudentPayment WHERE student.id="+s_id+" AND amount > 0", StudentPayment.class)
                    .list()
            ) {
                billList.add(sp.getBill());
            }
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return billList;
    }
    @Override
    public Boolean payBill(Integer billId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String query_string="DELETE FROM Bills WHERE id=:billId";
            Query query=session.createQuery(query_string);
            query.setParameter("billId", billId);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

//    @Override
//    public Integer paybills(Integer billId, Receipt receipt) {
//        return null;
//    }

    @Override
    public Integer paybills(Integer billId, Receipt receipt){

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            String query_string1 = "UPDATE Bills b SET b.remainingAmount = b.remainingAmount - :amountToPay where id=:billId";
            String query_string2= "UPDATE Bills c SET c.paidAmount = c.paidAmount + :amountToPay where c.id=:billId";

            Query query1 = session.createQuery(query_string1);
            Query query2 = session.createQuery(query_string2);

            query1.setParameter("amountToPay", receipt.getAmountPaid());
            query1.setParameter("billId", billId);

            query2.setParameter("amountToPay", receipt.getAmountPaid());
            query2.setParameter("billId", billId);

            int result = query1.executeUpdate();
            query2.executeUpdate();

            // Get Bill associated with given billId
            String query_string = "FROM Bills WHERE id=:billId";
            Query query = session.createQuery(query_string);
            query.setParameter("billId", billId);
            Bills bill = (Bills) query.list().get(0);

            // Set Bill associated with given receipt
            receipt.setBill(bill);

            // Insert new Receipt into the Receipt table
            session.save(receipt);

            transaction.commit();

            return result;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public void createBill(Bills bills) {
        try (Session session = (Session) HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(bills);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

    }
}
