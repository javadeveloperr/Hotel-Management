package org.example.repository;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.mapper.EmployeeMapper;
import org.example.mapper.GuestMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public GuestEntity getGuestByPhone(String phone) {
        Session session = sessionFactory.openSession();
//        GuestEntity guest= session.find(GuestEntity.class, Integer.getInteger(phone));
//        Query<GuestMapper> query = session.createQuery("select new org.example.mapper.GuestMapper(g.id,g.name,g.surname,g.phone,g.passportId) from GuestEntity as g");
//        GuestMapper guest=query.getSingleResult();
        Criteria criteria = session.createCriteria(GuestEntity.class);
        GuestEntity yourObject = (GuestEntity) criteria.add(Restrictions.eq("phone", phone))
                .uniqueResult();
        return yourObject;
    }
    public void addGuest(GuestEntity guestEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(guestEntity);
        transaction.commit();
        session.close();
        System.out.println("Guest added");
    }

    public List<GuestMapper> getGuestList() {
        Session session = sessionFactory.openSession();
        Query<GuestMapper> query = session.createQuery("select new org.example.mapper.GuestMapper(g.id,g.name,g.surname,g.phone,g.passportId) from GuestEntity as g");
        List<GuestMapper> guestList = query.getResultList();
        session.close();
        return guestList;
    }
}
