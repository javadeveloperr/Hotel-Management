package org.example.service;

import org.example.entity.RoomEntity;
import org.example.mapper.RoomMapper;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public void addRoom(RoomEntity room){
        RoomEntity room1 = roomRepository.getRoom(room);
        if (room1!=null){
            System.out.println("Room already exists");
            return;
        }
        roomRepository.saveRoom(room);
    }

    public List<RoomMapper> roomList() {
        List<RoomMapper> list=roomRepository.getRoomList();
        return list;
    }

    public void deleteRoom(Integer id) {
        RoomEntity room = roomRepository.getRoomById(id);
        if (room==null){
            System.out.println("Room Not exists. Check id");
            return;
        }
        roomRepository.deleteRoomById(id);
    }
}
