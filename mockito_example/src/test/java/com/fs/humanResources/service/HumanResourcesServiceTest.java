package com.fs.humanResources.service;

import com.fs.common.BaseUnitTest;
import com.fs.humanResources.model.address.entities.Address;
import com.fs.humanResources.model.employee.dao.EmployeeDAO;
import com.fs.humanResources.model.employee.entities.Employee;
import com.fs.humanResources.model.exception.NoResultsException;
import com.fs.humanResources.service.exception.EmployeeNotFoundException;
import com.fs.humanResources.view.address.AddressViewBean;
import com.fs.humanResources.view.employee.EmployeeViewBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class HumanResourcesServiceTest extends BaseUnitTest {

    @InjectMocks
    HumanResourcesService humanResourcesService;

    @Mock
    EmployeeDAO employeeDAO;

    Employee employee;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employee = createEmployee();
    }

    @Test
    public void getEmployeeDetails_verify_expected_methods_called() throws NoResultsException, EmployeeNotFoundException {
        when(employeeDAO.getEmployeeDetails(anyLong())).thenReturn(employee);

        humanResourcesService.getEmployeeDetails(12345L);

        verify(employeeDAO,times(1)).getEmployeeDetails(anyLong());
    }

    private Employee createEmployee() {
        String firstName = "Joe";
        String lastName = "Smith";
        Date dataOfBirth = new Date();
        Long employeeId = 12345l;

        String houseNumber = "50";;
        String addressFirstLine = "Test Driven Way";
        String addressSecondLine = "Domain Court";
        String townCity = "Progammer City";
        String postCode = "AB1 CDXY";

        Address address = new Address(houseNumber, addressFirstLine, addressSecondLine, townCity, postCode);
        return new Employee(firstName,lastName,dataOfBirth,employeeId,address);
    }

}
