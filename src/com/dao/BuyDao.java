package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.pojo.Buy;
import com.pojo.Employees;
import com.pojo.Goods;

public class BuyDao {
	public Vector<Buy> getBuy() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from BuyAndGoods order by bdatetime desc";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Buy> temp = new Vector<Buy>();
			while (resultSet.next()) {
				Buy b = new Buy();
				b.setBid(resultSet.getInt(1));
				b.setBprice(resultSet.getFloat(2));
				Date tempdate = null;
				try {
					tempdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(resultSet.getString(3));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				b.setBdatetime(tempdate);
				b.setBnum(resultSet.getInt(4));
				b.setBgname(resultSet.getString(5));
				temp.add(b);
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

	public void setBuy(Buy bu) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Buy values(null,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, bu.getBprice());
			String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(bu.getBdatetime());
			statement.setString(2, datetime);
			statement.setInt(3, bu.getBnum());
			statement.setInt(4, bu.getBgid());
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

	public int getOneBuy(int bid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Buy where bid=" + bid;
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

	public Vector<Buy> serchBuy(String s) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			StringBuffer sql = new StringBuffer(
					"select * from BuyAndGoods where ");
			sql.append("gname like '%" + s + "%' order by bdatetime desc");
			// sql.append("or pname like '%" + s + "%' ");
			// sql.append("or psex like '%" + s + "%' ");
			// sql.append("or pphone like '%" + s + "%' ");
			// sql.append("or poname like '%" + s + "%' order by pid");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql.toString());
			Vector<Buy> temp = new Vector<Buy>();
			while (resultSet.next()) {
				Buy b = new Buy();
				b.setBid(resultSet.getInt(1));
				b.setBprice(resultSet.getFloat(2));
				Date tempdate = null;
				try {
					tempdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(resultSet.getString(3));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				b.setBdatetime(tempdate);
				b.setBnum(resultSet.getInt(4));
				b.setBgname(resultSet.getString(5));
				temp.add(b);
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
}
