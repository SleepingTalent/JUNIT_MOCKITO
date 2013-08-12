package com.fs.humanResources.model.address.dao;

import com.fs.humanResources.model.address.entities.Address;
import com.fs.humanResources.model.common.dao.BaseDAO;

public class AddressDAO extends BaseDAO<Address>{

    public AddressDAO() {
        super(Address.class);
    }
}
