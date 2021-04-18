package com.thales.dataproject.restservice.services;

import java.util.ArrayList;

import com.thales.dataproject.restservice.DTO.EmployeeCreationDTO;
import com.thales.dataproject.restservice.models.EmployeeModel;
import com.thales.dataproject.restservice.models.HelloModel;

public class HelloService {
    private HelloModel helloModel;
    private ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();

    public HelloService() {
    }

    public HelloService setHelloEmployeeModel(long id, EmployeeModel employee) {
        String content = String.format("Hello employee %s", employee.getName());

        this.helloModel = new HelloModel(id, content);

        return this;
    }

    public HelloService setHelloModel(long id, String content) {
        this.helloModel = new HelloModel(id, content);

        return this;
    }

    public EmployeeModel addEmployee(EmployeeCreationDTO employeeCreationDTO) {
        EmployeeModel employee = new EmployeeModel(employeeCreationDTO);
        employees.add(employee);

        return employee;
    }

    public HelloModel getHelloModel() {
        return this.helloModel;
    }

    public EmployeeModel findEmployee(String name) {
        return this.employees.stream().filter(employee -> name.equals(employee.getName())).findAny().orElse(null);
    }

    public ArrayList<EmployeeModel> getEmployees() {
        return this.employees;
    }
}
