package com.API.service;

import java.util.List;

import com.API.dao.IDao.EmployeeDAO;
import com.API.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	EmployeeDAO dao;
	
	public List<EmployeeVO> getAllEmployees()
	{
		return dao.getAllEmployees();
	}
}
