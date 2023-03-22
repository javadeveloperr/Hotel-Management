package org.example.controller;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.service.GuestService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class GuestController {
    @Autowired
    private GuestService guestService;
    public void addGuest() {
        System.out.println("Enter name :");
        String name = ScannerUtil.StringScanner.next();
        System.out.println("Enter surname :");
        String surname = ScannerUtil.StringScanner.next();
        System.out.println("Enter phone :");
        String phone = ScannerUtil.StringScanner.next();
        GuestEntity guest=new GuestEntity();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setPhone(phone);

        System.out.println("Enter passport number :");
        String passportNumber = ScannerUtil.StringScanner.next();
        System.out.println(" Enter passport given date:");
        LocalDate passportGivenDate = LocalDate.parse(ScannerUtil.LocalDateScanner.next());
        System.out.println("Enter passport expired date:");
        LocalDate passportExpiredDate = LocalDate.parse(ScannerUtil.LocalDateScanner.next());

        System.out.println("Enter passport  given by:");
        String givenBy = ScannerUtil.StringScanner.next();

        System.out.println("Enter passport region :");
        String passportRegion = ScannerUtil.StringScanner.next();
        PassportEntity passport=new PassportEntity();
        passport.setPassportNumber(passportNumber);
        passport.setPassportGivenDate(passportGivenDate);
        passport.setValidityPeriod(passportExpiredDate);
        passport.setGivenFrom(givenBy);
        passport.setRegion(passportRegion);
        guestService.addGuest(guest,passport);
    }

    public void getGuestList() {
        System.out.println("Guest List : ");
        System.out.println(guestService.guestList());
    }
}
