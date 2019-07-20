package com.API.service;

import com.API.dao.IDao.EmployeeDAO;
import com.API.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmployeeDetailImpl implements EmployeeDetail {

    @Autowired
    EmployeeDAO dao;

    @Override
    public EmployeeVO getEmployeeDetail(int id) throws SQLException {

        return dao.getEmployee(id);
    }
}
