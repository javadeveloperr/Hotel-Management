package org.example.controller;

import org.example.entity.RoomEntity;
import org.example.service.RoomService;
import org.example.stuatus.RoomType;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    public void addRoom(){
        System.out.println("Enter number:");
        Integer number= ScannerUtil.IntScanner.nextInt();
        System.out.println("Enter folder:");
        Integer folder= ScannerUtil.IntScanner.nextInt();
        System.out.println("Enter type:");
        String type=ScannerUtil.StringScanner.next();
        System.out.println("Enter price:");
        Double price=ScannerUtil.LocalDateScanner.nextDouble();
        System.out.println("Enter area:");
        Double area=ScannerUtil.LocalDateScanner.nextDouble();
        RoomEntity room=new RoomEntity();
        room.setNumber(number);
        room.setFloor(folder);
        room.setType(RoomType.valueOf(type));
        room.setPrice(price);
        room.setArea(area);
        roomService.addRoom(room);
    }

    public void getRoomList() {
        System.out.println("Room List : ");
        System.out.println(roomService.roomList());
    }

    public void delete() {
        System.out.println("Enter room id : ");
        Integer id=ScannerUtil.IntScanner.nextInt();
        roomService.deleteRoom(id);
    }
}
