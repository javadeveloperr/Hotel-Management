package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {
    @Autowired
    private RoomController roomController;
    public static Integer action() {
        System.out.println("Select menu : ");
        return ScannerUtil.IntScanner.nextInt();
    }

    public void mainMenu() {
        System.out.println("***   Menu   ***");
        System.out.println("1. Log In");
        System.out.println("0. Exit");
        boolean b = true;
        while (b) {
            int action = action();
            switch (action) {
                case 1 -> adminMenu();
                case 0 -> {
                    b = false;
                    break;
                }
                default -> System.out.println("Mazgi  select menu");
            }
        }
    }
    public void adminMenu() {
        System.out.println("1. Room\n+" +
                "2. Convenient (qulayliklar)\n" +
                "3. Employee Type:\n" +
                "4. Employee\n" +
                "5.  Guest\n" +
                "6. Booking\n" +
                "7. OutCome\n+" +
                "8. Tozalanan\n" +
                "9. Arznomalar");
        Boolean b = true;
        while (b) {
            int action;
            action = action();
            switch (action) {
                case 1 -> room();
                case 2 -> convenient();
                case 3 -> employeeType();
                case 4 -> employee();
                case 5 -> guest();
                case 6 -> booking();
                case 7 -> outcome();
                case 8 -> tozalangan();
                case 9 -> arz();
                case 0 -> b = false;
            }
        }
    }
    public void room(){
        System.out.println("1. Add room\n" +
                "2. List rooms\n" +
                "3. Delete room\n" +
                "4. Update room\n" +
                "5. Find room\n" +
                "6. Room convenient\n");
        Boolean b = true;
        while (b) {
            int action;
            action = action();
            switch (action) {
                case 1 -> roomController.addRoom();
                case 2 -> convenient();
                case 3 -> employeeType();
                case 4 -> employee();
                case 5 -> guest();
                case 6 -> booking();
                case 7 -> outcome();
                case 8 -> tozalangan();
                case 9 -> arz();
                case 0 -> b = false;
            }
        }
    }
    public void convenient(){
        System.out.println("1. Add\n" +
                "2. List\n" +
                "3. Delete\n");
    }
    public void employeeType(){
        System.out.println("1. Add\n" +
                "2. List\n" +
                "3. Delete\n");
    }
    public void employee(){
        System.out.println("1. Add\n" +
                "2. List\n" +
                "3. Delete\n");}
    public void guest(){
        System.out.println("1. Add \n" +
                "2. List");

    }
    public void booking(){
        System.out.println("1. Make booking\n" +
                "2. List\n" +
                "3. List by room\n" +
                "4. List by guest\n");
    }
    public void outcome(){

    }
    public void tozalangan(){

    }
    public void arz(){

    }
}
