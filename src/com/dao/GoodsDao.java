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
	public Vector<Vector<Object>> getGoods() {
		Connection connection = null;
		Vector<Vector<Object>> data;
		try {
			data = new Vector<Vector<Object>>();
			Object[] objects = new Object[11];
			connection = SqliteConnection.getConnection();
			String sql = "select * from Goods order by gid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				objects[0] = resultSet.getString(2);
				objects[1] = resultSet.getString(3);
				objects[2] = resultSet.getInt(10);
				objects[3] = resultSet.getInt(4);
				Vector<Object> rows = new Vector<Object>();
				Collection<Object> c = new Vector<Object>(
						Arrays.asList(objects));
				rows.addAll(c);
				data.add(rows);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
