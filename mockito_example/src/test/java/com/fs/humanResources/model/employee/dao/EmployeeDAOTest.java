package com.fs.humanResources.model.employee.dao;

import com.fs.common.BaseUnitTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityManager;

public class EmployeeDAOTest extends BaseUnitTest {

    @InjectMocks
    EmployeeDAO employeeDAO;

    @Mock
    EntityManager entityManager;
}
