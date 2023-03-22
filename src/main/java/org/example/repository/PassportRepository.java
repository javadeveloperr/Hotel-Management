package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PassportRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public PassportEntity getPassportByPassportNumber(String passportNumber) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(GuestEntity.class);
        PassportEntity yourObject = (PassportEntity) criteria.add(Restrictions.eq("passport_number", passportNumber))
                .uniqueResult();
        return yourObject;
    }
    public Integer getPassportIdByPassportNumber(String passportNumber) {
        Session session = sessionFactory.openSession();
//        PassportEntity passport= session.find(PassportEntity.class, passportNumber);
        Criteria criteria = session.createCriteria(GuestEntity.class);
        PassportEntity yourObject = (PassportEntity) criteria.add(Restrictions.eq("passport_number", passportNumber))
                .uniqueResult();
        return yourObject.getId();
    }
    public void addPassport(PassportEntity passportEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passportEntity);
        transaction.commit();
        session.close();
        System.out.println("Passport added");
    }
}
