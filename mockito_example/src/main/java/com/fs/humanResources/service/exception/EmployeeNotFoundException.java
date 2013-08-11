package com.fs.humanResources.service.exception;

import com.fs.humanResources.model.exception.NoResultsException;

public class EmployeeNotFoundException extends Throwable {

    public EmployeeNotFoundException(NoResultsException e) {
        super(e);
    }
}
