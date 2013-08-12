package com.fs.humanResources.model.employee.dao;

import com.fs.common.BaseUnitTest;
import com.fs.humanResources.model.address.dao.AddressDAO;
import com.fs.humanResources.model.address.entities.Address;
import com.fs.humanResources.model.employee.entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddressDAOTest extends BaseUnitTest {

    @InjectMocks
    AddressDAO addressDAO;

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
        Long actualCount = addressDAO.countAll();

        Assert.assertEquals(expectedCount, actualCount);

        verify(entityManager, times(1)).createQuery(eq("SELECT count(o) from Address o "));
        verify(query,times(1)).getSingleResult();
    }

    @Test
    public void create_persits_expected_employee() {
        Address address = new Address();
        addressDAO.create(address);

        verify(entityManager, times(1)).persist(eq(address));
    }

    @Test
    public void delete_removes_expected_employee() {
        Address address = new Address();
        addressDAO.delete(address);

        verify(entityManager, times(1)).merge(eq(address));
        verify(entityManager, times(1)).remove(Matchers.<Address>anyObject());
    }

    @Test
    public void delete_merges_expected_employee() {
        Address address = new Address();
        addressDAO.update(address);

        verify(entityManager, times(1)).merge(eq(address));
    }
}
