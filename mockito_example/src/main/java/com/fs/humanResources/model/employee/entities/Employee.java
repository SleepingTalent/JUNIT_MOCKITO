package com.fs.humanResources.model.employee.entities;

import com.fs.humanResources.model.address.entities.Address;
import com.fs.humanResources.model.common.entities.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    private String firstName;
    private String lastName;
    private Date dateOfDirth;
    private Long empolyeeId;

    @OneToMany(mappedBy="employee",cascade=CascadeType.PERSIST)
    private List<Address> addressList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfDirth(Date dateOfDirth) {
        this.dateOfDirth = dateOfDirth;
    }

    public void setEmpolyeeId(Long empolyeeId) {
        this.empolyeeId = empolyeeId;
    }

    public void setAddressList(List<Address> address) {
        this.addressList = address;
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

    public List<Address> getAddressList() {
        return addressList;
    }
}
