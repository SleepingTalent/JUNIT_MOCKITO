package com.fs.humanResources.model.employee.dao;

import com.fs.common.BaseUnitTest;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeDAOTest extends BaseUnitTest {

    @InjectMocks
    EmployeeDAO employeeDAO;

    @Mock
    EntityManager entityManager;

    @Mock
    Query query;

    Long expectedCount;

    @Before
    public void setUp() {
        expectedCount = new Long(1234l);

        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(expectedCount);
    }

    @Test
    public void countAll_uses_expected_query() {
        Long actualCount = employeeDAO.countAll();

        Assert.assertEquals(expectedCount,actualCount);

        verify(entityManager, times(1)).createQuery(eq("SELECT count(o) from Employee o "));
        verify(query,times(1)).getSingleResult();
    }
}
