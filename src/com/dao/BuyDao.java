package com.dao;

import java.sql.Connection;
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
import com.pojo.Goods;

public class BuyDao {
	public Vector<Buy> getBuy(){
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
					tempdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(resultSet.getString(3));
				} catch (ParseException e) {
					e.printStackTrace();
				}
//				System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d));
				b.setBdatetime(tempdate);
				b.setBnum(resultSet.getInt(4));
				b.setBgname(resultSet.getString(5));
				temp.add(b);
			}
			return temp;
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
}
