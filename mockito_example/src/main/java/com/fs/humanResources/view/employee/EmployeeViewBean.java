package com.fs.humanResources.view.employee;
import com.fs.humanResources.view.address.AddressViewBean;

import java.util.Date;

public class EmployeeViewBean {

    private String firstName;
    private String lastName;
    private Date dateOfDirth;
    private Long empolyeeId;
    private AddressViewBean address;

    public EmployeeViewBean(String firstName, String lastName, Date dateOfDirth, Long empolyeeId, AddressViewBean address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfDirth = dateOfDirth;
        this.empolyeeId = empolyeeId;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfDirth() {
        return dateOfDirth;
    }

    public Long getEmpolyeeId() {
        return empolyeeId;
    }

    public AddressViewBean getAddress() {
        return address;
    }
}
