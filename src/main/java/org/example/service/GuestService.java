package org.example.service;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.mapper.GuestMapper;
import org.example.repository.GuestRepository;
import org.example.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private PassportRepository passportRepository;
    public void addGuest(GuestEntity guest, PassportEntity passport) {
        GuestEntity guestEntity = guestRepository.getGuestByPhone(guest.getPhone());
        if (guestEntity!=null){
            System.out.println("Guest already registered");
            return;
        }
        PassportEntity passportEntity = passportRepository.getPassportByPassportNumber(passport.getPassportNumber());
        if (passportEntity!=null){
            System.out.println("Passport's info is false");
            return;
        }
        passportRepository.addPassport(passport);
        Integer passportIdByPassportNumber = passportRepository.getPassportIdByPassportNumber(passport.getPassportNumber());
        guest.setPassportId(passportIdByPassportNumber);
        guestRepository.addGuest(guest);
    }

    public List<GuestMapper> guestList() {
        List<GuestMapper> list=guestRepository.getGuestList();
        return list;
    }
}
