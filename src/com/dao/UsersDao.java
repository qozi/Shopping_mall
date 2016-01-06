package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.Users;

public class UsersDao {
	public Users getUsers(String tempUsername) {
		Connection connection = null;
		try {
			Users users = new Users();
			connection = SqliteConnection.getConnection();
			String sql = "select password from Users where username='"
					+ tempUsername + "'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				users.setUsername(tempUsername);
				users.setPassword(resultSet.getString("password"));
				return users;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
