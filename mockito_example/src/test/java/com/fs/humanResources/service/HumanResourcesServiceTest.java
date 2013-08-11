package com.fs.humanResources.service;

import com.fs.common.BaseUnitTest;
import com.fs.humanResources.model.employee.dao.EmployeeDAO;
import com.fs.humanResources.view.address.AddressViewBean;
import com.fs.humanResources.view.employee.EmployeeViewBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Date;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class HumanResourcesServiceTest extends BaseUnitTest {

    @InjectMocks
    HumanResourcesService humanResourcesService;

    @Mock
    EmployeeDAO employeeDAO;

    EmployeeViewBean employeeViewBean;

    @Before
    public void setUp() {
        super.setUp();
        employeeViewBean = createEmployeeViewBean();
    }

    @Test
    public void getEmployeeDetails_verify_expected_methods_called() {
        when(employeeDAO.getEmployeeDetails(anyLong())).thenReturn(employeeViewBean);

        humanResourcesService.getEmployeeDetails(12345L);

        verify(employeeDAO,times(1)).getEmployeeDetails(anyLong());
    }

    private EmployeeViewBean createEmployeeViewBean() {
        String firstName = "Joe";
        String lastName = "Smith";
        Date dataOfBirth = new Date();
        Long employeeId = 12345l;

        String houseNumber = "50";;
        String addressFirstLine = "Test Driven Way";
        String addressSecondLine = "Domain Court";
        String townCity = "Progammer City";
        String postCode = "AB1 CDXY";

        AddressViewBean address = new AddressViewBean(houseNumber, addressFirstLine, addressSecondLine, townCity, postCode);
        return new EmployeeViewBean(firstName,lastName,dataOfBirth,employeeId,address);
    }

}
