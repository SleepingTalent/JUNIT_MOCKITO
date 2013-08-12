package com.fs.humanResources.model.employee.dao;

import com.fs.humanResources.model.common.dao.BaseDAO;
import com.fs.humanResources.model.employee.entities.Employee;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class EmployeeDAO extends BaseDAO<Employee> {

    private static final String FIND_EMPLOYEE_DETAILS = "select employee from Employee employee where employee.employeeId=:thisEmployeeId";

    public EmployeeDAO() {
        super(Employee.class);
    }

    public Employee getEmployeeDetails(Long employeeId) throws NoResultException {
        Query query = entityManager.createQuery(FIND_EMPLOYEE_DETAILS);
        query.setParameter("thisEmployeeId",employeeId);
        return (Employee) query.getSingleResult();
    }
}
