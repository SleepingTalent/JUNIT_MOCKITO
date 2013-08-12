package com.fs.humanResources.model.employee.dao;

import com.fs.humanResources.model.common.dao.BaseDAO;
import com.fs.humanResources.model.employee.entities.Employee;

import javax.persistence.NoResultException;


public class EmployeeDAO extends BaseDAO<Employee> {

    public EmployeeDAO() {
        super(Employee.class);
    }

    public Employee getEmployeeDetails(Long employeeId) throws NoResultException {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
