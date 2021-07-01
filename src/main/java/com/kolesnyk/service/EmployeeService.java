package com.kolesnyk.service;

import com.kolesnyk.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(long id);

    List<Employee> getEmployees();

    void save(Employee employee);

    void update(Employee employee);

    void delete(long id);
}
