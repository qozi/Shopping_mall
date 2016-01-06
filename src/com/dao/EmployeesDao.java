package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pojo.Employees;

public class EmployeesDao {
	public Vector<Employees> getEmployees() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from EmployeeAndPosition order by pid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Employees> temp = new Vector<Employees>();
			while (resultSet.next()) {
				Employees employees = new Employees();
				employees.setPid(resultSet.getInt(1));
				employees.setPname(resultSet.getString(3));
				employees.setPsex(resultSet.getString(4));
				employees.setPphone(resultSet.getString(5));
				employees.setPposition(resultSet.getString(2));
				temp.add(employees);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
