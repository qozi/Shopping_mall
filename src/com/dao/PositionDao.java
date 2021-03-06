package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pojo.Employees;
import com.pojo.Position;

public class PositionDao {
	public Vector<Position> getPosition() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Position order by poid";
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
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Position getOnePosition(int poid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Position where poid=" + poid;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Position position = new Position();
				position.setPoid(resultSet.getInt(1));
				position.setPoname(resultSet.getString(2));
				return position;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void setPosition(Position po) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Position values(null,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, po.getPoname());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updatePosition(Position po) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "update Position set poname=? where poid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, po.getPoname());
			statement.setInt(2, po.getPoid());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
