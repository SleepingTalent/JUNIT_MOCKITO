package com.fs.humanResources.model.employee.dao;

import com.fs.humanResources.model.exception.NoResultsException;
import com.fs.humanResources.model.employee.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Employee getEmployeeDetails(Long employeeId) throws NoResultsException {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
