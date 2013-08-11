package com.fs.humanResources.service;

import com.fs.humanResources.model.employee.dao.EmployeeDAO;
import com.fs.humanResources.view.employee.EmployeeViewBean;

public class HumanResourcesService {

    EmployeeDAO employeeDAO;

    public HumanResourcesService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeViewBean getEmployeeDetails(Long employeeId) {
        return employeeDAO.getEmployeeDetails(employeeId);
    }
}
