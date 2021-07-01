package com.kolesnyk.controller;

import com.kolesnyk.excel.ExcelEmployeeList;
import com.kolesnyk.model.Employee;
import com.kolesnyk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/report")
    public ModelAndView report() {
        List<Employee> list = employeeService.getEmployees();
        return new ModelAndView(new ExcelEmployeeList(), "list", list);
    }
}
