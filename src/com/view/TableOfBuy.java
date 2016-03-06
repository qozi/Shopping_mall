package com.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.SimpleFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.pojo.Buy;
import com.pojo.Employees;
import com.pojo.Goods;

public class TableOfBuy extends DefaultTableModel {
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������

	public TableOfBuy() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������

	public void TableInit(TableOfBuy tob, int x, int y, JPanel tempPanel) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		table = new JTable(tob);// Table���췽���д���DefaultTableModelʵ��
		// table.addMouseListener(new mymouceListener());// Ϊ�������������¼�
		setColumnLook();
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempPanel.add(scrollpane).setBounds(-15, 60, x, y);// �������ӵ�p��

		table.setRowHeight(50);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = new Point();
				p.x = e.getX();
				p.y = e.getY();
				PanelOfBuy pob = (PanelOfBuy)tempPanel;
				pob.setSelectRow((int)table.getValueAt(table.rowAtPoint(p), 0));
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

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	public void addData(Vector<Buy> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Buy b : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(b.getBid());
			tempv.add(b.getBgname());
			tempv.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(b
					.getBdatetime()));
			tempv.add(b.getBnum());
			tempv.add(b.getBprice());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void updateTable(Vector<Buy> v) {
		data.removeAllElements();
		addData(v);
		table.updateUI();
	}

	@Override
	public boolean isCellEditable(int row, int column) {// �ñ�񲻿ɱ��༭
		// TODO Auto-generated method stub
		return false;
	}

	public void addData(Object[] objects) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
		Vector<Object> rows = new Vector<Object>();// ����Vector���߳�ͬ���ģ�����ÿ�ζ�Ҫ��newһ��Vector�������µ�����
		Collection<Object> c = new Vector<Object>(Arrays.asList(objects));
		rows.addAll(c);
		data.add(rows);
	}
}
