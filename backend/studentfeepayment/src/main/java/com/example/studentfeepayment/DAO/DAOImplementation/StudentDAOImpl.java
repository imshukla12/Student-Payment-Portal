package com.example.studentfeepayment.DAO.DAOImplementation;

import com.example.studentfeepayment.DAO.StudentDAO;
import com.example.studentfeepayment.Bean.Students;
import com.example.studentfeepayment.Util.HibernateSessionUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public List<Students> show() {
//        List<Students> studentsList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            String query_string="FROM Students ";
            Query query=session.createQuery(query_string, Students.class);
            List<Students> list = query.getResultList();
//            query.setParameter("billId", billId);
//            query.executeUpdate();
            transaction.commit();
            return list;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;

    }

    @Override
    public Students login(Students student) {
        try (Session session = HibernateSessionUtil.getSession();){
            String studentEmail = student.getEmail();
            String studentPassword = student.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Students WHERE email = :studentEmail and password = :studentPassword"
                            )
                            .setParameter("studentEmail", studentEmail)
                            .setParameter("studentPassword", studentPassword)
                            .list()
            );

            // Invalid Credentials
            if (result.size() == 0)
                return null;
            else
                return (Students) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public void createStudent(Students student) {
        try (Session session = (Session) HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

    }
}

