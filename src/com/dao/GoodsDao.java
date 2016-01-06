package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import com.pojo.Goods;

public class GoodsDao {
	public Vector<Goods> getGoods() {
		Connection connection = null;
		try {
			connection = SqliteConnection.getConnection();
			String sql = "select * from Goods order by gid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<Goods> temp = new Vector<Goods>();
			while (resultSet.next()) {
				Goods goods = new Goods();
				goods.setGid(resultSet.getInt(1));
				goods.setGname(resultSet.getString(2));
				goods.setGkind(resultSet.getString(3));
				goods.setGnum(resultSet.getInt(4));
				goods.setGdatein(resultSet.getString(5));
				goods.setGklong(resultSet.getInt(6));
				goods.setGfrom(resultSet.getString(7));
				goods.setGcode(resultSet.getInt(8));
				goods.setGpricein(resultSet.getFloat(9));
				goods.setGpriceout(resultSet.getFloat(10));
				temp.add(goods);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
