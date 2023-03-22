package org.example.repository;

import org.example.entity.ComfortEntity;
import org.example.entity.RoomEntity;
import org.example.mapper.RoomMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<RoomMapper> getRoomList() {
        Session session = sessionFactory.openSession();
        Query<RoomMapper> query = session.createQuery("select new org.example.mapper.RoomMapper(r.id,r.number,r.floor,r.type,r.price,r.area,r.comfortId.id) from RoomEntity as r", RoomMapper.class);
        List<RoomMapper> roomList = query.getResultList();
//        session.getTransaction().commit();
        session.close();
        return roomList;
    }

    public RoomEntity getRoomById(Integer id) {
        Session session = sessionFactory.openSession();
        RoomEntity entity = session.find(RoomEntity.class, id);
        return entity;
    }

    public void deleteRoomById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM RoomEntity WHERE id = :id");
        query.setParameter("id", id);
        int rowCount = query.executeUpdate();
        tx.commit();
        if (rowCount == 1) {
            System.out.println("deleted");
            return;
        }
    }

    public void updateRoomById(RoomEntity room1) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RoomEntity room = session.get(RoomEntity.class, room1.getId());
        room.setNumber(room1.getNumber());
        room.setType(room1.getType());
        room.setArea(room1.getArea());
        room.setPrice(room1.getPrice());
        room.setFloor(room1.getFloor());
        session.update(room);
        transaction.commit();
//        Query query = session.createQuery("update room r set r.number=: WHERE id = :id");
//        query.setParameter("id", roomm.getId());
//        int rowCount = query.executeUpdate();
//        tx.commit();
//        if (rowCount==1){
//            System.out.println("deleted");
//            return;
//        }
    }

    public void updateRoomConId(Integer roomId, Integer conId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RoomEntity room = session.get(RoomEntity.class, roomId);
        ComfortEntity comfort = getComfort(conId);
        room.setComfortId(comfort);
        session.update(room);
        transaction.commit();
    }
    public ComfortEntity getComfort(Integer id) {
        Session session = sessionFactory.openSession();
        ComfortEntity entity = session.find(ComfortEntity.class, id);
        return entity;
    }
}
