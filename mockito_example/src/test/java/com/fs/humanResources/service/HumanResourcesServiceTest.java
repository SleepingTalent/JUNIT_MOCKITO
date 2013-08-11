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
import org.junit.Assert;
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

    Long foundEmployeeId;

    Long notFoundEmployeeId;

    @Before
    public void setUp() throws NoResultsException {
        foundEmployeeId = 12345l;
        notFoundEmployeeId = 4567l;

        MockitoAnnotations.initMocks(this);
        employee = createEmployee();

        when(employeeDAO.getEmployeeDetails(eq(foundEmployeeId))).thenReturn(employee);
        when(employeeDAO.getEmployeeDetails(eq(notFoundEmployeeId))).thenThrow(new NoResultsException());
    }

    @Test
    public void getEmployeeDetails_verify_expected_methods_called() throws NoResultsException, EmployeeNotFoundException {
        humanResourcesService.getEmployeeDetails(foundEmployeeId);
        verify(employeeDAO,times(1)).getEmployeeDetails(anyLong());
    }

    @Test
    public void getEmployeeDetails_returns_expected_employee() throws NoResultsException, EmployeeNotFoundException {
        EmployeeViewBean actual = humanResourcesService.getEmployeeDetails(foundEmployeeId);

        Assert.assertEquals(employee.getFirstName(), actual.getFirstName());
        Assert.assertEquals(employee.getLastName(), actual.getLastName());
        Assert.assertEquals(employee.getEmpolyeeId(), actual.getEmpolyeeId());
        Assert.assertEquals(employee.getDateOfDirth(), actual.getDateOfDirth());

        Address expectedAddress = employee.getAddress();
        AddressViewBean actualAddress = actual.getAddress();

        Assert.assertEquals(expectedAddress.getHouseNumber(), actualAddress.getHouseNumber());
        Assert.assertEquals(expectedAddress.getAddressFirstLine(), actualAddress.getAddressFirstLine());
        Assert.assertEquals(expectedAddress.getAddressSecondLine(), actualAddress.getAddressSecondLine());
        Assert.assertEquals(expectedAddress.getTownCity(), actualAddress.getTownCity());
        Assert.assertEquals(expectedAddress.getPostCode(), actualAddress.getPostCode());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void getEmployeeDetails_throws_exception_when_employee_not_found() throws NoResultsException, EmployeeNotFoundException {
        humanResourcesService.getEmployeeDetails(notFoundEmployeeId);
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
