package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void setEmployees(Employees em) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Employees(pid,pname,psex,pphone,pposition) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, em.getPid());
			statement.setString(2, em.getPname());
			statement.setString(3, em.getPsex());
			statement.setString(4, em.getPphone());
			statement.setInt(5, em.getPpositionid());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delEmployees(Employees em) {

	}

	public Vector<Employees> serchEmployees(String s) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			StringBuffer sql = new StringBuffer(
					"select * from EmployeeAndPosition where ");
			sql.append("pid like '%" + s + "%' ");
			sql.append("or pname like '%" + s + "%' ");
			sql.append("or psex like '%" + s + "%' ");
			sql.append("or pphone like '%" + s + "%' ");
			sql.append("or poname like '%" + s + "%' order by pid");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql.toString());
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
