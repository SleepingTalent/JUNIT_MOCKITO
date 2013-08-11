package com.fs.humanResources.controller;


import com.fs.humanResources.service.HumanResourcesService;
import com.fs.humanResources.view.employee.EmployeeViewBean;

public class HumanResourcesController {

    HumanResourcesService humanResourcesService;

    public HumanResourcesController(HumanResourcesService humanResourcesService) {
        this.humanResourcesService = humanResourcesService;
    }

    public EmployeeViewBean getEmployeeDetails(Long employeeId) {
        return humanResourcesService.getEmployeeDetails(employeeId);
    }

}
