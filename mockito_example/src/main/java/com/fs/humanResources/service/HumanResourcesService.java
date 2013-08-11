package com.fs.humanResources.service;

import com.fs.humanResources.model.employee.dao.EmployeeDAO;
import com.fs.humanResources.model.employee.entities.Employee;
import com.fs.humanResources.model.exception.NoResultsException;
import com.fs.humanResources.service.exception.EmployeeNotFoundException;
import com.fs.humanResources.view.employee.EmployeeViewBean;

public class HumanResourcesService {

    EmployeeDAO employeeDAO;

    public HumanResourcesService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeViewBean getEmployeeDetails(Long employeeId) throws EmployeeNotFoundException {
        try {

            Employee employee = employeeDAO.getEmployeeDetails(employeeId);
            return new EmployeeViewBean(employee);

        } catch (NoResultsException e) {
            throw new EmployeeNotFoundException(e);
        }
    }
}
