package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pojo.Factory;

public class FactoryDao {
	public Vector<Factory> getFactory() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Factory order by fid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Factory> temp = new Vector<Factory>();
			while (resultSet.next()) {
				Factory factory = new Factory();
				factory.setFid(resultSet.getInt(1));
				factory.setFname(resultSet.getString(2));
				factory.setFphone(resultSet.getString(3));
				temp.add(factory);
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
	
	public Factory getOneFactory(int fid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Factory where fid=" + fid;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Factory factory = new Factory();
				factory.setFid(resultSet.getInt(1));
				factory.setFname(resultSet.getString(2));
				factory.setFphone(resultSet.getString(3));
				return factory;
			}
			statement.close();
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
	
	public void setFactory(Factory fa) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Factory values(null,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fa.getFname());
			statement.setString(2, fa.getFphone());
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
	
	public void updateFactory(Factory fa) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "update Factory set fname=?,fphone=? where fid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fa.getFname());
			statement.setString(2, fa.getFphone());
			statement.setInt(3, fa.getFid());
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
	public void delKind(int fid){
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "delete from Factory where fid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, fid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
