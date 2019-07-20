package com.API.dao.IDao;

import java.sql.SQLException;
import java.util.List;

import com.API.model.EmployeeVO;

public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();

	public EmployeeVO getEmployee(Integer id) throws SQLException;
}