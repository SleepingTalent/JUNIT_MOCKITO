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

import static org.mockito.Matchers.*;
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

    Address address;

    Employee employee;

    Long addressId = 1234l;

    Long employeeId = 5678l;

    @Before
    public void setUp() {
        expectedCount = new Long(1234l);

        address = new Address();
        address.setId(addressId);

        employee = new Employee();
        employee.setId(employeeId);

        address.setEmployee(employee);

        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(expectedCount);

        when(entityManager.find(any(Class.class), anyLong())).thenReturn(address);
    }

    @Test
    public void countAll_uses_expected_query() {
        Long actualCount = addressDAO.countAll();

        Assert.assertEquals(expectedCount, actualCount);

        verify(entityManager, times(1)).createQuery(eq("SELECT count(o) from Address o "));
        verify(query,times(1)).getSingleResult();
    }

    @Test
    public void create_persits_expected_address() {
        addressDAO.create(address);

        verify(entityManager, times(1)).persist(eq(address));
    }

    @Test
    public void delete_removes_expected_address() {
        addressDAO.delete(address);

        verify(entityManager, times(1)).merge(eq(address));
        verify(entityManager, times(1)).remove(Matchers.<Address>anyObject());
    }

    @Test
    public void delete_merges_expected_address() {
        addressDAO.update(address);

        verify(entityManager, times(1)).merge(eq(address));
    }

    @Test
    public void findById_looksfor_expected_address() {
        Long addressId = 1234l;

        Address actualAddress = addressDAO.findById(addressId);

        Assert.assertEquals(address.getId(), actualAddress.getId());
        Assert.assertEquals(employee.getId(), actualAddress.getEmployee().getId());

        verify(entityManager, times(1)).find(any(Class.class),eq(addressId));
    }
}
