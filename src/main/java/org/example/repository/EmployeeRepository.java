package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.RoomEntity;
import org.example.mapper.EmployeeMapper;
import org.example.mapper.RoomMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeEntity getEmployeeByPhone(String phone) {
        Session session = sessionFactory.openSession();
        EmployeeEntity employee = session.find(EmployeeEntity.class, phone);
        return employee;
    }

    public EmployeeEntity getEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        EmployeeEntity employee = session.find(EmployeeEntity.class, id);
        return employee;
    }

    public void addEmployee(EmployeeEntity employeeEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employeeEntity);
        transaction.commit();
        session.close();
        System.out.println("Employee added");
    }

    public List<EmployeeMapper> getEmployeeList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeMapper> query = session.createQuery("select new org.example.mapper.EmployeeMapper(e.id,e.name,e.surname,e.phoneNumber,e.birthDate,e.status,e.type) from EmployeeEntity as e", EmployeeMapper.class);
        List<EmployeeMapper> employeeList = query.getResultList();
        session.close();
        return employeeList;
    }

    public void deleteRoomById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM EmployeeEntity WHERE id = :id");
        query.setParameter("id", id);
        int rowCount = query.executeUpdate();
        tx.commit();
        if (rowCount == 1) {
            System.out.println("deleted");
            return;
        }
    }
}
