package com.fs.humanResources.model.employee.entities;

import com.fs.humanResources.model.address.entities.Address;
import com.fs.humanResources.model.common.BaseEntity;

import java.util.Date;

public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private Date dateOfDirth;
    private Long empolyeeId;
    private Address address;

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

    public Address getAddress() {
        return address;
    }
}
