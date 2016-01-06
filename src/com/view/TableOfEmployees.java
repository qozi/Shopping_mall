package com.view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pojo.Employees;
import com.view.TableOfSale.mymouceListener;

public class TableOfEmployees extends DefaultTableModel {
	private Vector<String> names = new Vector<String>();// 定义动态集合存放列名
	// private Vector<Object> rows; // 定义动态集合存放每一行的数据，定义为Object类，因为里面存放的不止一个类型
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// 定义动态集合存放行数据
	private MainFrame tempFrame;

	public TableOfEmployees() {
		super.setDataVector(data, names);// 调用父类的构造函数，构造DefaultTableModel实例
	}

	JTable table;// new一个表格组件

	public void TableInit(TableOfEmployees tof, int x, int y, JPanel tempPanel) {// 初始化表格，并把表格add到p中，并定义表格的大小
		table = new JTable(tof);// Table构造方法中传入DefaultTableModel实例
		// table.addMouseListener(new mymouceListener());// 为表格添加鼠标监听事件
		JScrollPane scrollpane = new JScrollPane(table);// 为表格添加滚动条
		scrollpane.setSize(x, y);// 设置表格大小
		tempPanel.add(scrollpane).setBounds(180, 50, x, y);// 将表格添加到p中
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
	public void addData(Vector<Employees> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Employees e : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(e.getPid());
			tempv.add(e.getPname());
			tempv.add(e.getPsex());
			tempv.add(e.getPphone());
			tempv.add(e.getPposition());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	@Override
	public boolean isCellEditable(int row, int column) {// 让表格不可被编辑
		// TODO Auto-generated method stub
		return false;
	}

	public void addData(Object[] objects) {// 设置行数据的方法，每次添加到表格的末尾
		Vector<Object> rows = new Vector<Object>();// 由于Vector是线程同步的，所以每次都要新new一个Vector来储存新的数据
		Collection<Object> c = new Vector<Object>(Arrays.asList(objects));
		rows.addAll(c);
		data.add(rows);
	}
}
