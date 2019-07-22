package com.API.dao.DaoImpl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.API.dao.IDao.EmployeeDAO;
import com.API.model.EmployeeVO;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private Statement createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/udaanTest", "root", "root");
			Statement stmt = con.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertEmployee(final EmployeeVO employeeVO) {
		try{
			Statement stmt = createConnection();
			stmt.executeQuery("insert into emp (fistName , surname) value ("+employeeVO.getFirstName()+
					","+employeeVO.getLastName()+")");
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public List<EmployeeVO> getAllEmployees() {
		List<EmployeeVO> employeeVOList = new ArrayList<EmployeeVO>();
		try {
			Statement stmt = createConnection();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next())
			{
				final EmployeeVO employeeVO = EmployeeVO.builder().id(rs.getInt(1))
						.firstName(rs.getString(2))
						.lastName(rs.getString(3))
						.build();
				employeeVOList.add(employeeVO);
			}
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		} catch (Exception e) {
			System.out.println(e);
		}
		return employeeVOList;
	}

	public EmployeeVO getEmployee(final Integer id) throws SQLException {

			Statement stmt = createConnection();
			ResultSet rs = stmt.executeQuery("select * from emp where empid = " +id.toString());
			EmployeeVO employeeVO=null;
			if (rs.next())
			{
				employeeVO = EmployeeVO.builder().id(rs.getInt(1))
						.firstName(rs.getString(2))
						.lastName(rs.getString(3))
						.build();

			}
		return employeeVO;

	}
}