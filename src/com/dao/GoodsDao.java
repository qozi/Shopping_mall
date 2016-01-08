package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import com.pojo.Employees;
import com.pojo.Goods;

public class GoodsDao {
	public Vector<Goods> getGoods() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from GoodsAndFactoryAndKind order by gid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Goods> temp = new Vector<Goods>();
			while (resultSet.next()) {
				Goods goods = new Goods();
				goods.setGid(resultSet.getInt(1));
				goods.setGname(resultSet.getString(2));
				goods.setGkindname(resultSet.getString(3));
				goods.setGnum(resultSet.getInt(4));
				Date tempdate = null;
				try {
					tempdate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(resultSet.getString(5));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				goods.setGdatein(tempdate);
				goods.setGklong(resultSet.getInt(6));
				goods.setGfromname(resultSet.getString(7));
				goods.setGcode(resultSet.getInt(8));
				goods.setGpricein(resultSet.getFloat(9));
				goods.setGpriceout(resultSet.getFloat(10));
				temp.add(goods);
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

	public Goods getOneGoods(int gid) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Goods where gid=" + gid;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Goods goods = new Goods();
				goods.setGid(resultSet.getInt(1));
				goods.setGname(resultSet.getString(2));
				goods.setGkind(resultSet.getInt(3));
				goods.setGnum(resultSet.getInt(4));
				Date tempdate = null;
				try {
					tempdate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(resultSet.getString(5));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				goods.setGdatein(tempdate);
				goods.setGklong(resultSet.getInt(6));
				goods.setGfrom(resultSet.getInt(7));
				goods.setGcode(resultSet.getInt(8));
				goods.setGpricein(resultSet.getFloat(9));
				goods.setGpriceout(resultSet.getFloat(10));
				return goods;
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
		return null;
	}

	public int getOneGoods(String gname) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Goods where gname='" + gname + "'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return resultSet.getInt(1);
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

	public void setGoods(Goods go) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "insert into Goods values(null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, go.getGname());
			statement.setInt(2, go.getGkind());
			statement.setInt(3, go.getGnum());
			String tempdate = new SimpleDateFormat("yyyy-MM-dd").format(go
					.getGdatein());
			statement.setString(4, tempdate);
			statement.setInt(5, go.getGnum());
			statement.setInt(6, go.getGfrom());
			statement.setInt(7, go.getGcode());
			statement.setDouble(8, go.getGpricein());
			statement.setDouble(9, go.getGpriceout());
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

	public void updateGoods(Goods go) {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "update Goods set gname=?,gkind=?,gnum=?,gdatein=?,gklong=?,gfrom=?,gcode=?,gpricein=?,gpriceout=? where gid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, go.getGname());
			statement.setInt(2, go.getGkind());
			statement.setInt(3, go.getGnum());
			statement.setString(4,
					new SimpleDateFormat("yyyy-MM-dd").format(go.getGdatein()));
			statement.setInt(5, go.getGklong());
			statement.setInt(6, go.getGfrom());
			statement.setInt(7, go.getGcode());
			statement.setDouble(8, go.getGpricein());
			statement.setDouble(9, go.getGpriceout());
			statement.setInt(10, go.getGid());
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
	//
	// public void delEmployees(int pid) {
	// Connection connection = null;
	// try {
	// connection = SqliteConnection.getConnection();
	// String sql = "delete from Employees where pid=?";
	// PreparedStatement statement = connection.prepareStatement(sql);
	// statement.setInt(1, pid);
	// statement.executeUpdate();
	// statement.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// public Vector<Employees> serchEmployees(String s) {
	// Connection connection = null;
	// try {
	// connection = SqliteConnection.getConnection();
	// StringBuffer sql = new StringBuffer(
	// "select * from EmployeeAndPosition where ");
	// sql.append("pid like '%" + s + "%' ");
	// sql.append("or pname like '%" + s + "%' ");
	// sql.append("or psex like '%" + s + "%' ");
	// sql.append("or pphone like '%" + s + "%' ");
	// sql.append("or poname like '%" + s + "%' order by pid");
	// Statement statement = connection.createStatement();
	// ResultSet resultSet = statement.executeQuery(sql.toString());
	// Vector<Employees> temp = new Vector<Employees>();
	// while (resultSet.next()) {
	// Employees employees = new Employees();
	// employees.setPid(resultSet.getInt(1));
	// employees.setPname(resultSet.getString(3));
	// employees.setPsex(resultSet.getString(4));
	// employees.setPphone(resultSet.getString(5));
	// employees.setPposition(resultSet.getString(2));
	// temp.add(employees);
	// }
	// return temp;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return null;
	// }
}
