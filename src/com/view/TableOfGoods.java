package com.view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.omg.CosNaming.IstringHelper;

import com.dao.GoodsDao;
import com.pojo.Employees;
import com.pojo.Goods;

public class TableOfGoods extends DefaultTableModel {// 从DefaultTableModel继承
	private Vector<String> names = new Vector<String>();// 定义动态集合存放列名
	// private Vector<Object> rows; // 定义动态集合存放每一行的数据，定义为Object类，因为里面存放的不止一个类型
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// 定义动态集合存放行数据

	public TableOfGoods() {
		super.setDataVector(data, names);// 调用父类的构造函数，构造DefaultTableModel实例
	}

	JPanel tempPanel;
	JTable table;// new一个表格组件

	public void TableInit(TableOfGoods tof, int x, int y, int p, int q, JPanel tempPanel) {// 初始化表格，并把表格add到p中，并定义表格的大小
		this.tempPanel = tempPanel;
		table = new JTable(tof);// Table构造方法中传入DefaultTableModel实例
		setColumnLook();
		JScrollPane scrollpane = new JScrollPane(table);// 为表格添加滚动条
		scrollpane.setSize(x, y);// 设置表格大小
		tempPanel.add(scrollpane).setBounds(p, q, x, y);// 将表格添加到p中
		table.setRowHeight(50);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, renderer);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = new Point();
				p.x = e.getX();
				p.y = e.getY();
				PanelOfGoods pog = (PanelOfGoods) tempPanel;
				pog.setSelectRow((int) table.getValueAt(table.rowAtPoint(p), 0));
			}

		});
	}

	public void setColumnLook() {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		TableColumn column;
		column = table.getColumnModel().getColumn(0);
		column.setResizable(false);
		column.setPreferredWidth(0);
		column.setMaxWidth(0);
		column.setMinWidth(0);
		column = table.getColumnModel().getColumn(1);
		column.setPreferredWidth(130);
		column.setMaxWidth(130);
		column.setMinWidth(130);
		column = table.getColumnModel().getColumn(2);
		column.setPreferredWidth(130);
		column.setMaxWidth(130);
		column.setMinWidth(130);
		column = table.getColumnModel().getColumn(3);
		column.setPreferredWidth(55);
		column.setMaxWidth(55);
		column.setMinWidth(55);
	}

	public void setNames(String[] strings) {// 设置表头名称的方法，传入一个String的数组
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// 设置表头名称的方法（重载），传入一个String
		names.add(string);
	}

	public void addData(Vector<Goods> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Goods g : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(g.getGid());
			tempv.add(g.getGname());
			tempv.add(g.getGkindname());
			tempv.add(g.getGnum());
			tempv.add(g.getGpriceout());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void updateTable(Vector<Goods> v) {
		data.removeAllElements();
		addData(v);
		table.updateUI();
	}

	@Override
	public boolean isCellEditable(int row, int column) {// 让表格不可被编辑
		// TODO Auto-generated method stub
		return false;
	}
}
