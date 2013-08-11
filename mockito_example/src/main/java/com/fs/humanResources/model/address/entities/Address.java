package com.fs.humanResources.model.address.entities;


import com.fs.humanResources.model.common.BaseEntity;

public class Address extends BaseEntity {

    private String houseNumber;
    private String addressFirstLine;
    private String addressSecondLine;
    private String townCity;
    private String postCode;

    public Address(String houseNumber, String addressFirstLine, String addressSecondLine, String townCity, String postCode) {
        this.houseNumber = houseNumber;
        this.addressFirstLine = addressFirstLine;
        this.addressSecondLine = addressSecondLine;
        this.townCity = townCity;
        this.postCode = postCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getAddressFirstLine() {
        return addressFirstLine;
    }

    public String getAddressSecondLine() {
        return addressSecondLine;
    }

    public String getTownCity() {
        return townCity;
    }

    public String getPostCode() {
        return postCode;
    }
}
