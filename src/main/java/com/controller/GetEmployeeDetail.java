package com.controller;

import com.API.model.EmployeeVO;
import com.API.service.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class GetEmployeeDetail {
    @Autowired
    private EmployeeDetail employeeDetail;
    @RequestMapping(value = "/getEmployees")
    public @ResponseBody
    EmployeeVO getEmployeeDetail(@RequestParam(name = "empid")int id) throws SQLException {
        return employeeDetail.getEmployeeDetail(id);
    }
}
