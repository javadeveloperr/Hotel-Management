package org.example.service;

import org.example.entity.RoomEntity;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
