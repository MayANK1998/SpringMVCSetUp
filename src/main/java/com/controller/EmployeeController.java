package com.controller;

import com.API.model.EmployeeVO;
import com.API.service.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.API.service.EmployeeManager;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/employee-module")
public class EmployeeController 
{
	@Autowired
	EmployeeManager manager;
	@Autowired
	EmployeeDetail employeeDetail;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public @ResponseBody
	List<EmployeeVO> getAllEmployees()
	{
		return manager.getAllEmployees();
	}
	@RequestMapping(value = "/getEmployees")
	public @ResponseBody EmployeeVO getEmployeeDetail(@RequestParam(name = "empid")int id) throws SQLException {
		return employeeDetail.getEmployeeDetail(id);
	}
}