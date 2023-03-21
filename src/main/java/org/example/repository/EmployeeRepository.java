package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public EmployeeEntity getEmployeeByPhone(String phone) {
        Session session = sessionFactory.openSession();
        EmployeeEntity employee = session.find(EmployeeEntity.class, phone);
        return employee;
    }

    public void addEmployee(EmployeeEntity employeeEntity) {
        Session session= sessionFactory.openSession();
        session.i
    }
}
