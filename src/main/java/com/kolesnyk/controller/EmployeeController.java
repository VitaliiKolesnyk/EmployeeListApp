package com.kolesnyk.controller;

import com.kolesnyk.model.Employee;
import com.kolesnyk.service.EmployeeService;
import com.kolesnyk.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String allEmployees(Model model) {
        List<Employee> list = employeeService.getEmployees();
        model.addAttribute("employees", list);
        return "employees";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "new";
    }

    @PostMapping("/new")
    public String newEmp(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        employeeService.save(employee);

        return "redirect: /";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "edit";
    }

    @PatchMapping("/{id}/edit")
    public String editEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,@PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        employeeService.update(employee);
        return "redirect: /";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect: /";
    }
}
