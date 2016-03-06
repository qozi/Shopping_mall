package com.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.pojo.Employees;
import com.pojo.Position;

public class TableOfDepartment extends DefaultTableModel{
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������
	int col, row;

	public TableOfDepartment() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������

	public void TableInit(TableOfDepartment tod, int x, int y, JPanel tempPanel) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		table = new JTable(tod);// Table���췽���д���DefaultTableModelʵ��
//		table.addMouseListener(new mymouceListener(this));// Ϊ�������������¼�
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempPanel.add(scrollpane).setBounds(600, 60, x, y);// �������ӵ�p��
		table.setRowHeight(50);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	// public void addData(Vector<Vector<Object>> data) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
	// this.data.addAll(data);
	// }
	public void addData(Vector<Position> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Position p : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(p.getPoid());
			tempv.add(p.getPoname());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void updateTable(Vector<Position> v) {
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

	public void delData() {
		
	}
}
