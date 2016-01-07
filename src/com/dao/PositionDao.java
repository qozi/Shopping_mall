package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pojo.Employees;
import com.pojo.Position;

public class PositionDao {
	public Vector<Position> getPosition(){
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from EmployeeAndPosition order by pid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Position> temp = new Vector<Position>();
			while (resultSet.next()) {
				Position position = new Position();
				position.setPoid(resultSet.getInt(1));
				position.setPoname(resultSet.getString(2));
				temp.add(position);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
