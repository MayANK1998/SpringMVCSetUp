package com.API.service;

import com.API.model.EmployeeVO;

import java.sql.SQLException;

public interface EmployeeDetail {
    public EmployeeVO getEmployeeDetail(final int id) throws SQLException;
}
