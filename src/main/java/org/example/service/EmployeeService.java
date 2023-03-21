package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmp(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = employeeRepository.getEmployeeByPhone(employeeEntity.getPhoneNumber());
        if (employee!=null){
            System.out.println("Employee already registered");
            return;
        }
        employeeRepository.addEmployee(employeeEntity);
    }
}
