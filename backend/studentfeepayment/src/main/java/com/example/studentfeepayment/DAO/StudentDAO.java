package com.example.studentfeepayment.DAO;

import com.example.studentfeepayment.Bean.Students;

import java.util.List;

public interface StudentDAO {
    List<Students> show();
    Students login(Students student);
    void createStudent(Students student);

}
