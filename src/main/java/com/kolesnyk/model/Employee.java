package com.kolesnyk.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, max =  32, message = "Name should contain from 2 to 32 charachters")
    private String name;
    @NotEmpty
    @Size(min = 2, max =  32, message = "Surname should contain from 2 to 32 charachters")
    private String surname;
    @NotEmpty
    @Size(min = 2, max =  32, message = "Surname should contain from 2 to 32 charachters")
    private String position;
    @Min(value = 0, message = "Salary should be more than 0")
    private int salary;

    public Employee() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
