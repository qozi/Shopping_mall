package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import com.pojo.Sale;

public class SaleDao {
	public Vector<Sale> getSale() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from SaleAndGoods order by sdatetime desc";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Sale> temp = new Vector<Sale>();
			while (resultSet.next()) {
				Sale s = new Sale();
				s.setSid(resultSet.getInt(1));
				s.setSprice(resultSet.getFloat(2));
				Date tempdate = null;
				try {
					tempdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(resultSet.getString(3));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				s.setSdatetime(tempdate);
				s.setSnum(resultSet.getInt(4));
				s.setSgname(resultSet.getString(5));
				temp.add(s);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setSale(Sale sa) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Sale values(null,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, sa.getSprice());
			String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(sa.getSdatetime());
			statement.setString(2, datetime);
			statement.setInt(3, sa.getSnum());
			statement.setInt(4, sa.getSgid());
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

	public int getOneSale(int sid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Sale where bid=" + sid;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return resultSet.getInt(5);
			}
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
		return 0;
	}
}
