package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pojo.Kind;

public class KindDao {
	public Vector<Kind> getKind() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Kind order by kid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Kind> temp = new Vector<Kind>();
			while (resultSet.next()) {
				Kind kind = new Kind();
				kind.setKid(resultSet.getInt(1));
				kind.setKname(resultSet.getString(2));
				temp.add(kind);
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
	
	public Kind getOneKind(int kid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Kind where kid=" + kid;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Kind kind = new Kind();
				kind.setKid(resultSet.getInt(1));
				kind.setKname(resultSet.getString(2));
				return kind;
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
	
	public void setKind(Kind ki) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Kind values(null,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ki.getKname());
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
	
	public void updateKind(Kind ki) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "update Kind set kname=? where kid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ki.getKname());
			statement.setInt(2, ki.getKid());
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
	public void delKind(int kid){
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "delete from Kind where kid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, kid);
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
