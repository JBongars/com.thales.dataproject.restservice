package com.thales.dataproject.restservice.models;

import com.thales.dataproject.restservice.DTO.EmployeeCreationDTO;

public class EmployeeModel {
    String name;

    public EmployeeModel(EmployeeCreationDTO employee) {
        this.name = employee.getName();
    }

    public String getName() {
        return this.name;
    }
}
