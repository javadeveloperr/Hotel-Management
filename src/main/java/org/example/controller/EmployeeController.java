package org.example.controller;

import org.example.entity.EmployeeEntity;
import org.example.service.EmployeeService;
import org.example.stuatus.EmployeeStatus;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public void addEmployee() {
        System.out.println("Enter name :");
        String name = ScannerUtil.StringScanner.next();
        System.out.println("Enter surname :");
        String surname = ScannerUtil.StringScanner.next();
        System.out.println("Enter phone :");
        String phone = ScannerUtil.StringScanner.next();
        System.out.println("Enter birthdate :");
        LocalDate date = LocalDate.parse(ScannerUtil.LocalDateScanner.next());
        System.out.println("Enter type id:");
        Integer typeId = ScannerUtil.IntScanner.nextInt();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        employeeEntity.setPhoneNumber(phone);
        employeeEntity.setBirthDate(date);
        EmployeeStatus[] employeeStatuses = EmployeeStatus.values();
        employeeEntity.setType(String.valueOf(employeeStatuses[typeId]));
        employeeService.addEmp(employeeEntity);
    }

    public void getEmployeeList() {
        System.out.println("Employee List : ");
        System.out.println(employeeService.employeeList());
    }

    public void delete() {
        System.out.println("Enter room id : ");
        Integer id=ScannerUtil.IntScanner.nextInt();
        employeeService.deleteRoom(id);
    }
}
