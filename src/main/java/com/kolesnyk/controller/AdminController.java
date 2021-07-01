package com.kolesnyk.controller;

import com.kolesnyk.model.Employee;
import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String admin(Model model) {
        List<User> list = userService.getUsers();
        model.addAttribute("users", list);
        return "admin";
    }
    @DeleteMapping("/admin/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect: /admin";
    }
}
