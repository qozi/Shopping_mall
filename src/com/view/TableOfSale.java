package com.view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dao.GoodsDao;
import com.pojo.Employees;
import com.pojo.Goods;

public class TableOfSale extends DefaultTableModel {// 从DefaultTableModel继承
	private Vector<String> names = new Vector<String>();// 定义动态集合存放列名
	// private Vector<Object> rows; // 定义动态集合存放每一行的数据，定义为Object类，因为里面存放的不止一个类型
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// 定义动态集合存放行数据

	public TableOfSale() {
		super.setDataVector(data, names);// 调用父类的构造函数，构造DefaultTableModel实例
	}

	JTable table;// new一个表格组件

	public void TableInit(TableOfSale tof, int x, int y, JPanel tempPanel) {// 初始化表格，并把表格add到p中，并定义表格的大小
		table = new JTable(tof);// Table构造方法中传入DefaultTableModel实例
		table.addMouseListener(new mymouceListener());// 为表格添加鼠标监听事件
		JScrollPane scrollpane = new JScrollPane(table);// 为表格添加滚动条
		scrollpane.setSize(x, y);// 设置表格大小
		tempPanel.add(scrollpane).setBounds(0, 0, x, y);// 将表格添加到p中
	}

	public void setNames(String[] strings) {// 设置表头名称的方法，传入一个String的数组
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// 设置表头名称的方法（重载），传入一个String
		names.add(string);
	}

	// public void addData(Vector<Vector<Object>> data) {// 设置行数据的方法，每次添加到表格的末尾
	// this.data.addAll(data);
	// }
	public void addData(Vector<Goods> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Goods g : v) {
			Vector<Object> tempv = new Vector<Object>();
			// tempv.add(g.getGid());
			tempv.add(g.getGname());
			tempv.add(g.getGkind());
			tempv.add(g.getGnum());
			// tempv.add(g.getGdatein());
			// tempv.add(g.getGklong());
			// tempv.add(g.getGfrom());
			// tempv.add(g.getGcode());
			// tempv.add(g.getGpricein());
			tempv.add(g.getGpriceout());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void addData(Object[] objects) {// 设置行数据的方法，每次添加到表格的末尾
		Vector<Object> rows = new Vector<Object>();// 由于Vector是线程同步的，所以每次都要新new一个Vector来储存新的数据
		Collection<Object> c = new Vector<Object>(Arrays.asList(objects));
		rows.addAll(c);
		data.add(rows);
	}

	class mymouceListener extends MyMouceListener {// 继承自鼠标监听接口的实现类，重写鼠标点击事件的方法

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = new Point();// 定义一个点（Point）对象
			p.x = e.getX();// 获得鼠标的X坐标
			p.y = e.getY();// 获得鼠标的Y坐标
			int col = table.columnAtPoint(p);// 调用table的方法获得鼠标点击单元格的column值
			int row = table.rowAtPoint(p);// 调用table的方法获得鼠标点击单元格的row值
		}

	}
}
