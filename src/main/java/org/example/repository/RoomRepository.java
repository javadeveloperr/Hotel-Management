package org.example.repository;

import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public RoomEntity getRoom(RoomEntity room) {
        Session session = sessionFactory.openSession();
        RoomEntity entity = session.find(RoomEntity.class, room.getNumber());
        return entity;
    }

    public void saveRoom(RoomEntity room) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
        System.out.println("Room added");
    }
}
