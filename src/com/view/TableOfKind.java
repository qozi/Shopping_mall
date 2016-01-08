package com.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pojo.Kind;
import com.pojo.Position;

public class TableOfKind extends DefaultTableModel{
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������
	int col, row;

	public TableOfKind() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������

	public void TableInit(TableOfKind tok, int x, int y, JDialog tempdialog) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		table = new JTable(tok);// Table���췽���д���DefaultTableModelʵ��
//		table.addMouseListener(new mymouceListener(this));// Ϊ�������������¼�
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempdialog.add(scrollpane).setBounds(0, 0, x, y);// �������ӵ�p��
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	// public void addData(Vector<Vector<Object>> data) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
	// this.data.addAll(data);
	// }
	public void addData(Vector<Kind> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Kind k : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(k.getKid());
			tempv.add(k.getKname());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void updateTable(Vector<Kind> v) {
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
