package com.kolesnyk.service;

import com.kolesnyk.model.Employee;
import com.kolesnyk.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.equals(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
