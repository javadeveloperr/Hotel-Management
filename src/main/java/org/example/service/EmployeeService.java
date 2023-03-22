package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.mapper.EmployeeMapper;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EmployeeMapper> employeeList() {
        List<EmployeeMapper> list=employeeRepository.getEmployeeList();
        return list;
    }

    public void deleteRoom(Integer id) {
        EmployeeEntity employee = employeeRepository.getEmployeeById(id);
        if (employee==null) {
            System.out.println("Room Not exists. Check id");
            return;
        }
        employeeRepository.deleteRoomById(id);
    }
}
