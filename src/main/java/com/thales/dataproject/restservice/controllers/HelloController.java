package com.thales.dataproject.restservice.controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.thales.dataproject.restservice.DTO.EmployeeCreationDTO;
import com.thales.dataproject.restservice.models.EmployeeModel;
import com.thales.dataproject.restservice.models.HelloModel;
import com.thales.dataproject.restservice.services.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public HelloModel hello(@RequestParam(defaultValue = "World", required = false) String name,
            @RequestParam(defaultValue = "false", required = false) Boolean isEmployee) {
        if (isEmployee && name != null) {
            helloService.setHelloEmployeeModel(counter.incrementAndGet(), helloService.findEmployee(name));

            return helloService.getHelloModel();
        }

        helloService.setHelloModel(counter.incrementAndGet(), String.format(template, name));

        return helloService.getHelloModel();
    }

    @PostMapping("/hello/employee")
    @ResponseBody
    public EmployeeModel addEmployee(@RequestBody EmployeeCreationDTO employeeCreationDTO) {
        EmployeeModel employeeModel = helloService.addEmployee(employeeCreationDTO);

        return employeeModel;
    }

    @GetMapping("/hello/employee/{employeeName}")
    public EmployeeModel findEmployee(@PathVariable(value = "employeeName") String employeeName) {
        return helloService.findEmployee(employeeName);
    }

    @GetMapping("/hello/employees")
    public ArrayList<EmployeeModel> getEmployees() {
        return helloService.getEmployees();
    }

}
